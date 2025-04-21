package org.afterlike.slumber.util

import gg.essential.elementa.UIComponent
import gg.essential.elementa.constraints.ConstraintType
import gg.essential.elementa.constraints.resolution.ConstraintVisitor
import gg.essential.elementa.font.FontProvider
import gg.essential.elementa.font.data.Font
import gg.essential.elementa.font.data.Glyph
import gg.essential.universal.UGraphics
import gg.essential.universal.UMatrixStack
import gg.essential.universal.UResolution
import gg.essential.universal.render.URenderPipeline
import gg.essential.universal.shader.*
import org.lwjgl.opengl.GL11
import java.awt.Color
import kotlin.math.floor
import kotlin.math.max

/**
 * Replacement MSDF font renderer with a single, consistent baseline snap
 * (no per‑glyph ceil/floor → no jitter).
 */
class SlumberFontRenderer(
    private val regularFont: Font,
    private val boldFont: Font = regularFont
) : FontProvider {

    // Style/state flags
    private var underline = false
    private var strikethrough = false
    private var bold = false
    private var italics = false
    private var obfuscated = false

    // Colors
    private var textColor: Color? = null
    private var shadowColor: Color? = null
    private var drawingShadow = false

    // Which atlas we're sampling from right now
    private var activeFont: Font = regularFont

    // FontProvider plumbing
    override var cachedValue: FontProvider = this
    override var recalculate: Boolean = false
    override var constrainTo: UIComponent? = null

    override fun visitImpl(visitor: ConstraintVisitor, type: ConstraintType) {
        // no constraints here
    }

    override fun getStringWidth(text: String, pointSize: Float) =
        measure(text, pointSize).first

    override fun getStringHeight(text: String, pointSize: Float) =
        measure(text, pointSize).second

    private fun measure(text: String, pointSize: Float): Pair<Float, Float> {
        var w = 0f
        var h = 0f
        var font = regularFont
        var size = pointSize

        var i = 0
        while (i < text.length) {
            // §l = bold, §r = reset
            if (text[i] == '§' && i + 1 < text.length) {
                font = if (text[i + 1].lowercaseChar() == 'l') boldFont else regularFont
                i += 2
                continue
            }
            val g = font.fontInfo.glyphs[text[i].code]
            if (g != null) {
                g.planeBounds?.let { pb ->
                    h = max(h, (pb.top - pb.bottom) * size)
                }
                w += g.advance * size
            }
            i++
        }
        return w to h
    }

    override fun drawString(
        ms: UMatrixStack,
        text: String,
        color: Color,
        x: Float,
        y: Float,
        origPointSize: Float,
        scale: Float,
        shadow: Boolean,
        shadowColorOverride: Color?
    ) {
        val size = origPointSize * scale
        // shift up a bit so our baseline math lines up more naturally
        val y0 = y - size * 0.2f

        if (shadow) {
            drawingShadow = true
            shadowColor = shadowColorOverride ?: deriveShadow(color)
            val off = (size * 0.1f).toDouble()
            ms.translate(off, off, 0.0)
            drawNow(ms, text, shadowColor!!, x, y0, size)
            ms.translate(-off, -off, 0.0)
        }

        drawingShadow = false
        drawNow(ms, text, color, x, y0, size)
    }

    override fun getBaseLineHeight(): Float =
        regularFont.fontInfo.atlas.baseCharHeight

    override fun getBelowLineHeight(): Float =
        regularFont.fontInfo.atlas.belowLineHeight

    override fun getShadowHeight(): Float =
        regularFont.fontInfo.atlas.shadowHeight

    private fun deriveShadow(c: Color): Color {
        var rgb = c.rgb
        if (rgb and -0x4000000 == 0) rgb = rgb or -0x1000000
        return Color((rgb and 0xFCFCFC shr 2) or (rgb and -0x1000000))
    }

    private fun drawNow(
        ms: UMatrixStack,
        text: String,
        color: Color,
        startX: Float,
        startY: Float,
        pointSize: Float
    ) {
        if (!initShadersIfNeeded()) return

        shader.bind()
        switchFont(isRegular = true)
        doffset.setValue(3.5f / pointSize)

        textColor = color
        refreshColor()

        // compute one global baseline and snap *once* to screen pixels
        val metrics = activeFont.fontInfo.metrics
        val guiScale = UResolution.scaleFactor.toFloat()
        val rawBase = startY + (metrics.lineHeight + metrics.descender) * pointSize
        val basePx = floor(rawBase * guiScale) / guiScale

        var penX = startX
        var i = 0
        while (i < text.length) {
            if (text[i] == '§' && i + 1 < text.length) {
                // formatting codes
                when (text[i + 1].lowercaseChar()) {
                    'l' -> switchFont(isRegular = false)
                    else -> switchFont(isRegular = true)
                }
                i += 2
                continue
            }

            var g = activeFont.fontInfo.glyphs[text[i].code]
            if (obfuscated && text[i] != ' ') {
                // find a random glyph with the same advance
                val adv = g?.advance
                if (adv != null) {
                    for (cand in activeFont.fontInfo.glyphs.values) {
                        if (cand.advance == adv) {
                            g = cand
                            break
                        }
                    }
                }
            }

            g?.planeBounds?.let { pb ->
                val x0 = penX + pb.left * pointSize
                val y0 = basePx - pb.top * pointSize
                val w = (pb.right - pb.left) * pointSize
                val h = (pb.top - pb.bottom) * pointSize
                drawGlyph(ms, g, x0.toDouble(), y0.toDouble(), w, h)
            }
            penX += (g?.advance ?: 0f) * pointSize
            i++
        }

        shader.unbind()
        activeFont = boldFont
    }

    private fun drawGlyph(
        ms: UMatrixStack,
        glyph: Glyph,
        x: Double,
        y: Double,
        w: Float,
        h: Float
    ) {
        val atlas = activeFont.fontInfo.atlas
        val ab = glyph.atlasBounds ?: return

        val tTop = 1.0 - (ab.top / atlas.height)
        val tBot = 1.0 - (ab.bottom / atlas.height)
        val tLeft = (ab.left / atlas.width).toDouble()
        val tRight = (ab.right / atlas.width).toDouble()

        val c = if (drawingShadow) shadowColor!! else textColor!!
        fgColor.setValue(c.red / 255f, c.green / 255f, c.blue / 255f, 1f)

        val tess = UGraphics.getFromTessellator()
        tess.beginWithActiveShader(
            UGraphics.DrawMode.QUADS,
            UGraphics.CommonVertexFormats.POSITION_TEXTURE
        )
        tess.pos(ms, x, y + h.toDouble(), 0.0).tex(tLeft, tBot).endVertex()
        tess.pos(ms, x + w.toDouble(), y + h.toDouble(), 0.0).tex(tRight, tBot).endVertex()
        tess.pos(ms, x + w.toDouble(), y, 0.0).tex(tRight, tTop).endVertex()
        tess.pos(ms, x, y, 0.0).tex(tLeft, tTop).endVertex()
        tess.drawDirect()
    }

    private fun switchFont(isRegular: Boolean) {
        activeFont = if (isRegular) regularFont else boldFont

        sampler.setValue(activeFont.getTexture().dynamicGlId)
        UGraphics.configureTexture(activeFont.getTexture().dynamicGlId) {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR)
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR)
        }
        sdfTexel.setValue(
            1f / activeFont.fontInfo.atlas.width,
            1f / activeFont.fontInfo.atlas.height
        )
    }

    private fun refreshColor() {
        hintAmount.setValue(0f)
    }

    companion object {
        private lateinit var shader: UShader
        private lateinit var sampler: SamplerUniform
        private lateinit var doffset: FloatUniform
        private lateinit var hintAmount: FloatUniform
        private lateinit var sdfTexel: Float2Uniform
        private lateinit var fgColor: Float4Uniform

        fun initShaders() {
            if (URenderPipeline.isRequired) return
            if (::shader.isInitialized) return

            // 1) read from the classpath instead of the resource manager
            val cl = SlumberFontRenderer::class.java.classLoader
            val vs = cl.getResourceAsStream("assets/slumber/shaders/font/font.vsh")
                ?: throw IllegalStateException("font.vsh not on classpath!")
            val fs = cl.getResourceAsStream("assets/slumber/shaders/font/font.fsh")
                ?: throw IllegalStateException("font.fsh not on classpath!")

            val vertSrc = vs.bufferedReader().use { it.readText() }
            val fragSrc = fs.bufferedReader().use { it.readText() }

            // 2) compile exactly as Elementa did
            shader = UShader.fromLegacyShader(
                vertSrc,
                fragSrc,
                BlendState.NORMAL,
                UGraphics.CommonVertexFormats.POSITION_TEXTURE
            )
            if (!shader.usable) throw IllegalStateException("Could not load font shader")

            sampler = shader.getSamplerUniform("msdf")
            doffset = shader.getFloatUniform("doffset")
            hintAmount = shader.getFloatUniform("hint_amount")
            sdfTexel = shader.getFloat2Uniform("sdf_texel")
            fgColor = shader.getFloat4Uniform("fgColor")
        }

        private fun initShadersIfNeeded(): Boolean {
            if (!::shader.isInitialized) initShaders()
            return ::shader.isInitialized && shader.usable
        }
    }

}
package org.afterlike.slumber.util

import gg.essential.elementa.font.data.Font

object SlumberFonts {
    private val INTER_FONT = Font.fromResource("/fonts/Inter-Regular")
    private val INTER_MEDIUM_FONT = Font.fromResource("/fonts/Inter-Medium")
    private val INTER_SEMIBOLD_FONT = Font.fromResource("/fonts/Inter-SemiBold")
    private val INTER_BOLD_FONT = Font.fromResource("/fonts/Inter-Bold")
    private val INTER_EXTRABOLD_FONT = Font.fromResource("/fonts/Inter-ExtraBold")

    @JvmStatic
    val INTER = SlumberFontRenderer(INTER_FONT, INTER_BOLD_FONT)

    @JvmStatic
    val INTER_MEDIUM = SlumberFontRenderer(INTER_MEDIUM_FONT)

    @JvmStatic
    val INTER_SEMIBOLD = SlumberFontRenderer(INTER_SEMIBOLD_FONT)

    @JvmStatic
    val INTER_BOLD = SlumberFontRenderer(INTER_BOLD_FONT)

    @JvmStatic
    val INTER_EXTRABOLD = SlumberFontRenderer(INTER_EXTRABOLD_FONT)
}
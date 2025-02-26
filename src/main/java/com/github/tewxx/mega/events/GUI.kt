package com.github.tewxx.mega.events

import gg.essential.elementa.ElementaVersion
import gg.essential.elementa.WindowScreen
import gg.essential.elementa.components.UIBlock
import gg.essential.elementa.components.UIImage
import gg.essential.elementa.components.UIRoundedRectangle
import gg.essential.elementa.components.UIText
import gg.essential.elementa.components.inspector.Inspector
import gg.essential.elementa.constraints.CenterConstraint
import gg.essential.elementa.constraints.SiblingConstraint
import gg.essential.elementa.dsl.*
import gg.essential.universal.UMatrixStack
import java.awt.Color
import java.net.URL

class GUI : WindowScreen(ElementaVersion.V2, newGuiScale = 2, drawDefaultBackground = false) {
    override fun onDrawScreen(matrixStack: UMatrixStack, mouseX: Int, mouseY: Int, partialTicks: Float) {
        drawDefaultBackground()
        super.onDrawScreen(matrixStack, mouseX, mouseY, partialTicks)
    }

    override fun afterInitialization() {
        super.afterInitialization()
    }

    override fun onScreenClose() {
        super.onScreenClose()
    }

    init {
        // Main Elementa Stuff
        Inspector(window) childOf window
        //Home
        val HomeBack = UIRoundedRectangle(3f).constrain {
            color = Color(0x1A191A).constraint
            x = (50/2.5).pixels(alignOpposite = false)
            y = (50/2.5).pixels(alignOpposite = false)
            width = (290 / 2.5).pixels()
            height = (582 / 2.5).pixels()
        } childOf window

        val HomeTopBarUNRounded = UIBlock().constrain {
            color = Color(0x141414).constraint
            x = (50/2.5).pixels(alignOpposite = false)
            y = (78/2.5).pixels(alignOpposite = false)
            width = (290 / 2.5).pixels()
            height = (19 / 2.5).pixels()
        } childOf window

        val HomeTopBarRounded = UIRoundedRectangle(3f).constrain {
            color = Color(0x141414).constraint
            x = (50/2.5).pixels(alignOpposite = false)
            y = (50/2.5).pixels(alignOpposite = false)
            width = (290 / 2.5).pixels()
            height = (47 / 2.5).pixels()
        } childOf window

        val HomeMiddleBar = UIBlock().constrain {
            color = Color(0x141414).constraint
            x = (50/2.5).pixels(alignOpposite = false)
            y = (409/2.5).pixels(alignOpposite = false)
            width = (290 / 2.5).pixels()
            height = (33 / 2.5).pixels()
        } childOf window

        val HomeBottomRounded = UIRoundedRectangle(3f).constrain {
            color = Color(0x141414).constraint
            x = (50/2.5).pixels(alignOpposite = false)
            y = (600/2.5).pixels(alignOpposite = false)
            width = (290 / 2.5).pixels()
            height = (32 / 2.5).pixels()
        } childOf window

        val HomeVapeImage = UIImage.ofURL(URL("https://raw.githubusercontent.com/Tewxx/Mega/refs/heads/master/src/main/resources/assets/tewxx/8x.png")).constrain {
            x = (59/2.5).pixels(alignOpposite = false)
            y = (62/2.5).pixels(alignOpposite = false)
            width = (82 / 2.5).pixels()
            height = (22 / 2.5).pixels()
        } childOf window

        val HomeV4Image = UIImage.ofURL(URL("https://raw.githubusercontent.com/7GrandDadPGN/VapeV4ForRoblox/refs/heads/main/assets/new/textv4.png")).constrain {
            x = (141/2.5).pixels(alignOpposite = false)
            y = (62/2.5).pixels(alignOpposite = false)
            width = (29 / 2.5).pixels()
            height = (16 / 2.5).pixels()
        } childOf window

        val HomeSettingsImage = UIImage.ofURL(URL("https://raw.githubusercontent.com/7GrandDadPGN/VapeV4ForRoblox/refs/heads/main/assets/new/customsettings.png")).constrain {
            color = Color(255,255,255,127).constraint // Makes it half transparent
            x = (306/2.5).pixels(alignOpposite = false)
            y = (62/2.5).pixels(alignOpposite = false)
            width = (22 / 2.5).pixels()
            height = (22 / 2.5).pixels()
        } childOf window

        UIText("Hello World").constrain {
            textScale = 1.pixels()
            x = CenterConstraint()
            y = CenterConstraint()
        } childOf HomeBack

        UIText("Sibling").constrain {
            textScale = 1.pixels()
            x = CenterConstraint()
            y = SiblingConstraint(4f, alignOpposite = true)
        } childOf HomeBack

    }
}
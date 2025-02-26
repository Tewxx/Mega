package com.github.tewxx.mega.events

import gg.essential.elementa.ElementaVersion
import gg.essential.elementa.WindowScreen
import gg.essential.elementa.components.UIBlock
import gg.essential.elementa.components.UIRoundedRectangle
import gg.essential.elementa.components.UIText
import gg.essential.elementa.components.inspector.Inspector
import gg.essential.elementa.constraints.CenterConstraint
import gg.essential.elementa.constraints.SiblingConstraint
import gg.essential.elementa.dsl.*
import gg.essential.universal.UMatrixStack
import java.awt.Color

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
        // Press tab for blur
        val button = UIRoundedRectangle(3f).constrain {
            color = Color(0x141414).constraint
            x = 20.pixels(alignOpposite = false)
            y = 20.pixels(alignOpposite = false)
            //y = CenterConstraint()

            //Actual is 220x 465 but its scaled down 2.5x
            width = 110.pixels()
            height = 232.pixels()
        } childOf window

        button.onMouseDrag { mouseX, mouseY, mouseButton ->
            button.setX(mouseX.pixels)
            button.setY(mouseY.pixels)
        }

        UIText("Hello World").constrain {
            textScale = 1.pixels()
            x = CenterConstraint()
            y = CenterConstraint()
        } childOf button

        UIText("Sibling").constrain {
            textScale = 1.pixels()
            x = CenterConstraint()
            y = SiblingConstraint(4f,alignOpposite = true)
        } childOf button

    }
}
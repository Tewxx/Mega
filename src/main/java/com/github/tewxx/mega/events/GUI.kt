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
    private var isTransparent = true
    private var isCombatTabVisible = false

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

            val HomeVapeImage = UIImage.ofResource("/assets/tewxx/logo.png").constrain {
            x = (59/2.5).pixels(alignOpposite = false)
                y = (62/2.5).pixels(alignOpposite = false)
                width = (82 / 2.5).pixels()
                height = (22 / 2.5).pixels()
            } childOf window

            val HomeV4Image = UIImage.ofResource("/assets/tewxx/v4.png").constrain {
                x = (141/2.5).pixels(alignOpposite = false)
                y = (62/2.5).pixels(alignOpposite = false)
                width = (29 / 2.5).pixels()
                height = (16 / 2.5).pixels()
            } childOf window

            val HomeSettingsImage = UIImage.ofResource("/assets/tewxx/settings.png").constrain {
                color = Color(255,255,255,100).constraint // Makes it half transparent
                x = (306/2.5).pixels(alignOpposite = false)
                y = (62/2.5).pixels(alignOpposite = false)
                width = (22 / 2.5).pixels()
                height = (22 / 2.5).pixels()
            } childOf window

            // Home - Color Changes Clicks

            val HomeCombatColorChangeArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / 2.5).pixels(alignOpposite = false)
                y = (97 / 2.5).pixels(alignOpposite = false)
                width = (290 / 2.5).pixels()
                height = (52 / 2.5).pixels()
            } childOf window

            val HomeBlatantColorChangeArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / 2.5).pixels(alignOpposite = false)
                y = (149 / 2.5).pixels(alignOpposite = false)
                width = (290 / 2.5).pixels()
                height = (52 / 2.5).pixels()
            } childOf window

            val HomeRenderColorChangeArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / 2.5).pixels(alignOpposite = false)
                y = (201 / 2.5).pixels(alignOpposite = false)
                width = (290 / 2.5).pixels()
                height = (52 / 2.5).pixels()
            } childOf window

            val HomeUtilityColorChangeArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / 2.5).pixels(alignOpposite = false)
                y = (253 / 2.5).pixels(alignOpposite = false)
                width = (290 / 2.5).pixels()
                height = (52 / 2.5).pixels()
            } childOf window

            val HomeWorldColorChangeArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / 2.5).pixels(alignOpposite = false)
                y = (305 / 2.5).pixels(alignOpposite = false)
                width = (290 / 2.5).pixels()
                height = (52 / 2.5).pixels()
            } childOf window

            val HomeInventoryColorChangeArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / 2.5).pixels(alignOpposite = false)
                y = (357 / 2.5).pixels(alignOpposite = false)
                width = (290 / 2.5).pixels()
                height = (52 / 2.5).pixels()
            } childOf window

            // Home - Left icons

            val HomeCombatIcon = UIImage.ofResource("/assets/tewxx/combaticon.png").constrain {
                x = (67/2.5).pixels(alignOpposite = false)
                y = (112/2.5).pixels(alignOpposite = false)
                width = (20 / 2.5).pixels()
                height = (22 / 2.5).pixels()
            } childOf window

            val HomeBlatantIcon = UIImage.ofResource("/assets/tewxx/blatanticon.png").constrain {
                x = (67/2.5).pixels(alignOpposite = false)
                y = (165/2.5).pixels(alignOpposite = false)
                width = (20 / 2.5).pixels()
                height = (20 / 2.5).pixels()
            } childOf window

            val HomeRenderIcon = UIImage.ofResource("/assets/tewxx/rendericon.png").constrain {
                x = (67/2.5).pixels(alignOpposite = false)
                y = (216/2.5).pixels(alignOpposite = false)
                width = (20 / 2.5).pixels()
                height = (19 / 2.5).pixels()
            } childOf window

            val HomeUtilityIcon = UIImage.ofResource("/assets/tewxx/utilityicon.png").constrain {
                x = (67/2.5).pixels(alignOpposite = false)
                y = (270/2.5).pixels(alignOpposite = false)
                width = (19 / 2.5).pixels()
                height = (18 / 2.5).pixels()
            } childOf window

            val HomeWorldIcon = UIImage.ofResource("/assets/tewxx/worldicon.png").constrain {
                x = (67/2.5).pixels(alignOpposite = false)
                y = (321/2.5).pixels(alignOpposite = false)
                width = (20 / 2.5).pixels()
                height = (20 / 2.5).pixels()
            } childOf window

            val HomeInventoryIcon = UIImage.ofResource("/assets/tewxx/inventoryicon.png").constrain {
                x = (67/2.5).pixels(alignOpposite = false)
                y = (374/2.5).pixels(alignOpposite = false)
                width = (20 / 2.5).pixels()
                height = (19 / 2.5).pixels()
            } childOf window

            // Home - text

            UIText("Combat").constrain {
                textScale = 1.pixels()
                x = (97/2.5).pixels(alignOpposite = false)
                y = (112/2.5).pixels(alignOpposite = false)
            } childOf window

            UIText("Blatant").constrain {
                textScale = 1.pixels()
                x = (97/2.5).pixels(alignOpposite = false)
                y = (165/2.5).pixels(alignOpposite = false)
            } childOf window

            UIText("Render").constrain {
                textScale = 1.pixels()
                x = (97/2.5).pixels(alignOpposite = false)
                y = (216/2.5).pixels(alignOpposite = false)
            } childOf window

            UIText("Utility").constrain {
                textScale = 1.pixels()
                x = (97/2.5).pixels(alignOpposite = false)
                y = (270/2.5).pixels(alignOpposite = false)
            } childOf window

            UIText("World").constrain {
                textScale = 1.pixels()
                x = (97/2.5).pixels(alignOpposite = false)
                y = (321/2.5).pixels(alignOpposite = false)
            } childOf window

            UIText("Inventory").constrain {
                textScale = 1.pixels()
                x = (97/2.5).pixels(alignOpposite = false)
                y = (374/2.5).pixels(alignOpposite = false)
            } childOf window

            UIText("Misc").constrain {
                textScale = 0.95.pixels()
                x = (60 / 2.5).pixels(alignOpposite = false)
                y = (415 / 2.5).pixels(alignOpposite = false)
            } childOf window

            UIText("Friends").constrain {
                textScale = 0.95.pixels()
                x = (60 / 2.5).pixels(alignOpposite = false)
                y = (458 / 2.5).pixels(alignOpposite = false)
            } childOf window

            UIText("Profiles").constrain {
                textScale = 0.95.pixels()
                x = (60 / 2.5).pixels(alignOpposite = false)
                y = (508 / 2.5).pixels(alignOpposite = false)
            } childOf window

            UIText("Macros").constrain {
                textScale = 0.95.pixels()
                x = (60 / 2.5).pixels(alignOpposite = false)
                y = (558 / 2.5).pixels(alignOpposite = false)
            } childOf window

            UIText("Recreated by Mega").constrain {
                color = Color(255,255,255,100).constraint // Makes it half transparent
                textScale = 0.50.pixels()
                x = (60 / 2.5).pixels(alignOpposite = false)
                y = (612 / 2.5).pixels(alignOpposite = false)
            } childOf window

            UIText("Myau 4.17").constrain {
                color = Color(255,255,255,100).constraint // Makes it half transparent
                textScale = 0.50.pixels()
                x = (275 / 2.5).pixels(alignOpposite = false)
                y = (612 / 2.5).pixels(alignOpposite = false)
            } childOf window

            // Home - arrows

            val ArrowCombat = UIImage.ofResource("/assets/tewxx/arrowhome.png").constrain {
                x = (233/2.5).pixels(alignOpposite = false)
                y = (73/2.5).pixels(alignOpposite = false)
                width = (100 / 2.5).pixels()
                height = (100 / 2.5).pixels()
            } childOf window

            val ArrowBlatant = UIImage.ofResource("/assets/tewxx/arrowhome.png").constrain {
                x = (233/2.5).pixels(alignOpposite = false)
                y = (125/2.5).pixels(alignOpposite = false)
                width = (100 / 2.5).pixels()
                height = (100 / 2.5).pixels()
            } childOf window

            val ArrowRender = UIImage.ofResource("/assets/tewxx/arrowhome.png").constrain {
                x = (233/2.5).pixels(alignOpposite = false)
                y = (175/2.5).pixels(alignOpposite = false)
                width = (100 / 2.5).pixels()
                height = (100 / 2.5).pixels()
            } childOf window

            val ArrowUtility = UIImage.ofResource("/assets/tewxx/arrowhome.png").constrain {
                x = (233/2.5).pixels(alignOpposite = false)
                y = (229/2.5).pixels(alignOpposite = false)
                width = (100 / 2.5).pixels()
                height = (100 / 2.5).pixels()
            } childOf window

            val ArrowWorld = UIImage.ofResource("/assets/tewxx/arrowhome.png").constrain {
                x = (233/2.5).pixels(alignOpposite = false)
                y = (281/2.5).pixels(alignOpposite = false)
                width = (100 / 2.5).pixels()
                height = (100 / 2.5).pixels()
            } childOf window

            val ArrowInventory = UIImage.ofResource("/assets/tewxx/arrowhome.png").constrain {
                x = (233/2.5).pixels(alignOpposite = false)
                y = (333/2.5).pixels(alignOpposite = false)
                width = (100 / 2.5).pixels()
                height = (100 / 2.5).pixels()
            } childOf window

            val ArrowFriends = UIImage.ofResource("/assets/tewxx/arrowhome.png").constrain {
                x = (233/2.5).pixels(alignOpposite = false)
                y = (418/2.5).pixels(alignOpposite = false)
                width = (100 / 2.5).pixels()
                height = (100 / 2.5).pixels()
            } childOf window

            val ArrowProfiles = UIImage.ofResource("/assets/tewxx/arrowhome.png").constrain {
                x = (233/2.5).pixels(alignOpposite = false)
                y = (468/2.5).pixels(alignOpposite = false)
                width = (100 / 2.5).pixels()
                height = (100 / 2.5).pixels()
            } childOf window

            val ArrowMacros = UIImage.ofResource("/assets/tewxx/arrowhome.png").constrain {
                x = (233/2.5).pixels(alignOpposite = false)
                y = (522/2.5).pixels(alignOpposite = false)
                width = (100 / 2.5).pixels()
                height = (100 / 2.5).pixels()
            } childOf window

            // Home Click Detectors (Not actual thing that changes color)

            val HomeCombatClickArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / 2.5).pixels(alignOpposite = false)
                y = (97 / 2.5).pixels(alignOpposite = false)
                width = (290 / 2.5).pixels()
                height = (52 / 2.5).pixels()
            } childOf window

            HomeCombatClickArea.onMouseClick {
                isTransparent = !isTransparent
                HomeCombatColorChangeArea.setColor(if (isTransparent) Color(31, 30, 31, 0) else Color(31, 30, 31, 255))
                println("Combat Clicked")
            }

            val HomeBlatantClickArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / 2.5).pixels(alignOpposite = false)
                y = (149 / 2.5).pixels(alignOpposite = false)
                width = (290 / 2.5).pixels()
                height = (52 / 2.5).pixels()
            } childOf window

            HomeBlatantClickArea.onMouseClick {
                isTransparent = !isTransparent
                HomeBlatantColorChangeArea.setColor(if (isTransparent) Color(31, 30, 31, 0) else Color(31, 30, 31, 255))
                println("Blatant Clicked")
            }

            val HomeRenderClickArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / 2.5).pixels(alignOpposite = false)
                y = (201 / 2.5).pixels(alignOpposite = false)
                width = (290 / 2.5).pixels()
                height = (52 / 2.5).pixels()
            } childOf window

            HomeRenderClickArea.onMouseClick {
                isTransparent = !isTransparent
                HomeRenderColorChangeArea.setColor(if (isTransparent) Color(31, 30, 31, 0) else Color(31, 30, 31, 255))
                println("Render Clicked")
            }

            val HomeUtilityClickArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / 2.5).pixels(alignOpposite = false)
                y = (253 / 2.5).pixels(alignOpposite = false)
                width = (290 / 2.5).pixels()
                height = (52 / 2.5).pixels()
            } childOf window

            HomeUtilityClickArea.onMouseClick {
                isTransparent = !isTransparent
                HomeUtilityColorChangeArea.setColor(if (isTransparent) Color(31, 30, 31, 0) else Color(31, 30, 31, 255))
                println("Utility Clicked")
            }

            val HomeWorldClickArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / 2.5).pixels(alignOpposite = false)
                y = (305 / 2.5).pixels(alignOpposite = false)
                width = (290 / 2.5).pixels()
                height = (52 / 2.5).pixels()
            } childOf window

            HomeWorldClickArea.onMouseClick {
                isTransparent = !isTransparent
                HomeWorldColorChangeArea.setColor(if (isTransparent) Color(31, 30, 31, 0) else Color(31, 30, 31, 255))
                println("World Clicked")
            }

            val HomeInventoryClickArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / 2.5).pixels(alignOpposite = false)
                y = (357 / 2.5).pixels(alignOpposite = false)
                width = (290 / 2.5).pixels()
                height = (52 / 2.5).pixels()
            } childOf window

            HomeInventoryClickArea.onMouseClick {
                isTransparent = !isTransparent
                HomeInventoryColorChangeArea.setColor(if (isTransparent) Color(31, 30, 31, 0) else Color(31, 30, 31, 255))
                println("Inventory Clicked")
            }

        }
}
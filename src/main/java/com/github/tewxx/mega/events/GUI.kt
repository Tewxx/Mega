package com.github.tewxx.mega.events

import gg.essential.elementa.ElementaVersion
import gg.essential.elementa.WindowScreen
import gg.essential.elementa.components.UIBlock
import gg.essential.elementa.components.UIImage
import gg.essential.elementa.components.UIRoundedRectangle
import gg.essential.elementa.components.UIText
import gg.essential.elementa.components.inspector.Inspector
import gg.essential.elementa.dsl.*
import gg.essential.universal.UMatrixStack
import java.awt.Color
import java.util.Timer
import java.util.TimerTask
import kotlin.math.sin
import kotlin.math.PI

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
            val scalefactor = 2.5;
            //Home

            val HomeBack = UIRoundedRectangle(3f).constrain {
                color = Color(0x1A191A).constraint
                x = (50/scalefactor).pixels(alignOpposite = false)
                y = (50/scalefactor).pixels(alignOpposite = false)
                width = (290 / scalefactor).pixels()
                height = (582 / scalefactor).pixels()
            } childOf window

            val HomeTopBarUNRounded = UIBlock().constrain {
                color = Color(0x141414).constraint
                x = (50/scalefactor).pixels(alignOpposite = false)
                y = (78/scalefactor).pixels(alignOpposite = false)
                width = (290 / scalefactor).pixels()
                height = (19 / scalefactor).pixels()
            } childOf window

            val HomeTopBarRounded = UIRoundedRectangle(3f).constrain {
                color = Color(0x141414).constraint
                x = (50/scalefactor).pixels(alignOpposite = false)
                y = (50/scalefactor).pixels(alignOpposite = false)
                width = (290 / scalefactor).pixels()
                height = (47 / scalefactor).pixels()
            } childOf window

            val HomeMiddleBar = UIBlock().constrain {
                color = Color(0x141414).constraint
                x = (50/scalefactor).pixels(alignOpposite = false)
                y = (409/scalefactor).pixels(alignOpposite = false)
                width = (290 / scalefactor).pixels()
                height = (33 / scalefactor).pixels()
            } childOf window

            val HomeBottomRounded = UIRoundedRectangle(3f).constrain {
                color = Color(0x141414).constraint
                x = (50/scalefactor).pixels(alignOpposite = false)
                y = (600/scalefactor).pixels(alignOpposite = false)
                width = (290 / scalefactor).pixels()
                height = (32 / scalefactor).pixels()
            } childOf window

            val HomeVapeImage = UIImage.ofResource("/assets/tewxx/logo.png").constrain {
            x = (59/scalefactor).pixels(alignOpposite = false)
                y = (62/scalefactor).pixels(alignOpposite = false)
                width = (82 / scalefactor).pixels()
                height = (22 / scalefactor).pixels()
            } childOf window

            val HomeV4Image = UIImage.ofResource("/assets/tewxx/v4.png").constrain {
                x = (141/scalefactor).pixels(alignOpposite = false)
                y = (62/scalefactor).pixels(alignOpposite = false)
                width = (33 / scalefactor).pixels()
                height = (19 / scalefactor).pixels()
            } childOf window

            val HomeSettingsImage = UIImage.ofResource("/assets/tewxx/settings.png").constrain {
                color = Color(255,255,255,100).constraint // Makes it half transparent
                x = (306/scalefactor).pixels(alignOpposite = false)
                y = (62/scalefactor).pixels(alignOpposite = false)
                width = (22 / scalefactor).pixels()
                height = (22 / scalefactor).pixels()
            } childOf window

            // Home - Color Changes Clicks

            val HomeCombatColorChangeArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / scalefactor).pixels(alignOpposite = false)
                y = (97 / scalefactor).pixels(alignOpposite = false)
                width = (290 / scalefactor).pixels()
                height = (52 / scalefactor).pixels()
            } childOf window

            val HomeBlatantColorChangeArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / scalefactor).pixels(alignOpposite = false)
                y = (149 / scalefactor).pixels(alignOpposite = false)
                width = (290 / scalefactor).pixels()
                height = (52 / scalefactor).pixels()
            } childOf window

            val HomeRenderColorChangeArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / scalefactor).pixels(alignOpposite = false)
                y = (201 / scalefactor).pixels(alignOpposite = false)
                width = (290 / scalefactor).pixels()
                height = (52 / scalefactor).pixels()
            } childOf window

            val HomeUtilityColorChangeArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / scalefactor).pixels(alignOpposite = false)
                y = (253 / scalefactor).pixels(alignOpposite = false)
                width = (290 / scalefactor).pixels()
                height = (52 / scalefactor).pixels()
            } childOf window

            val HomeWorldColorChangeArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / scalefactor).pixels(alignOpposite = false)
                y = (305 / scalefactor).pixels(alignOpposite = false)
                width = (290 / scalefactor).pixels()
                height = (52 / scalefactor).pixels()
            } childOf window

            val HomeInventoryColorChangeArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / scalefactor).pixels(alignOpposite = false)
                y = (357 / scalefactor).pixels(alignOpposite = false)
                width = (290 / scalefactor).pixels()
                height = (52 / scalefactor).pixels()
            } childOf window

            // Home - Left icons

            val HomeCombatIcon = UIImage.ofResource("/assets/tewxx/combaticon.png").constrain {
                x = (67/scalefactor).pixels(alignOpposite = false)
                y = (112/scalefactor).pixels(alignOpposite = false)
                width = (20 / scalefactor).pixels()
                height = (22 / scalefactor).pixels()
            } childOf window

            val HomeBlatantIcon = UIImage.ofResource("/assets/tewxx/blatanticon.png").constrain {
                x = (67/scalefactor).pixels(alignOpposite = false)
                y = (165/scalefactor).pixels(alignOpposite = false)
                width = (20 / scalefactor).pixels()
                height = (20 / scalefactor).pixels()
            } childOf window

            val HomeRenderIcon = UIImage.ofResource("/assets/tewxx/rendericon.png").constrain {
                x = (67/scalefactor).pixels(alignOpposite = false)
                y = (216/scalefactor).pixels(alignOpposite = false)
                width = (20 / scalefactor).pixels()
                height = (19 / scalefactor).pixels()
            } childOf window

            val HomeUtilityIcon = UIImage.ofResource("/assets/tewxx/utilityicon.png").constrain {
                x = (67/scalefactor).pixels(alignOpposite = false)
                y = (270/scalefactor).pixels(alignOpposite = false)
                width = (19 / scalefactor).pixels()
                height = (18 / scalefactor).pixels()
            } childOf window

            val HomeWorldIcon = UIImage.ofResource("/assets/tewxx/worldicon.png").constrain {
                x = (67/scalefactor).pixels(alignOpposite = false)
                y = (321/scalefactor).pixels(alignOpposite = false)
                width = (20 / scalefactor).pixels()
                height = (20 / scalefactor).pixels()
            } childOf window

            val HomeInventoryIcon = UIImage.ofResource("/assets/tewxx/inventoryicon.png").constrain {
                x = (67/scalefactor).pixels(alignOpposite = false)
                y = (374/scalefactor).pixels(alignOpposite = false)
                width = (20 / scalefactor).pixels()
                height = (19 / scalefactor).pixels()
            } childOf window

            // Home - text

            val CombatText = UIText("Combat").constrain {
                textScale = 1.pixels()
                x = (97/scalefactor).pixels(alignOpposite = false)
                y = (112/scalefactor).pixels(alignOpposite = false)
            } childOf window

            val BlatantText = UIText("Blatant").constrain {
                textScale = 1.pixels()
                x = (97/scalefactor).pixels(alignOpposite = false)
                y = (165/scalefactor).pixels(alignOpposite = false)
            } childOf window

            val RenderText = UIText("Render").constrain {
                textScale = 1.pixels()
                x = (97/scalefactor).pixels(alignOpposite = false)
                y = (216/scalefactor).pixels(alignOpposite = false)
            } childOf window

            val UtilityText = UIText("Utility").constrain {
                textScale = 1.pixels()
                x = (97/scalefactor).pixels(alignOpposite = false)
                y = (270/scalefactor).pixels(alignOpposite = false)
            } childOf window

            val WorldText = UIText("World").constrain {
                textScale = 1.pixels()
                x = (97/scalefactor).pixels(alignOpposite = false)
                y = (321/scalefactor).pixels(alignOpposite = false)
            } childOf window

            val InventoryText = UIText("Inventory").constrain {
                textScale = 1.pixels()
                x = (97/scalefactor).pixels(alignOpposite = false)
                y = (374/scalefactor).pixels(alignOpposite = false)
            } childOf window

            UIText("Misc").constrain {
                textScale = 0.95.pixels()
                x = (60 / scalefactor).pixels(alignOpposite = false)
                y = (415 / scalefactor).pixels(alignOpposite = false)
            } childOf window

            UIText("Friends").constrain {
                textScale = 0.95.pixels()
                x = (60 / scalefactor).pixels(alignOpposite = false)
                y = (458 / scalefactor).pixels(alignOpposite = false)
            } childOf window

            UIText("Profiles").constrain {
                textScale = 0.95.pixels()
                x = (60 / scalefactor).pixels(alignOpposite = false)
                y = (508 / scalefactor).pixels(alignOpposite = false)
            } childOf window

            UIText("Macros").constrain {
                textScale = 0.95.pixels()
                x = (60 / scalefactor).pixels(alignOpposite = false)
                y = (558 / scalefactor).pixels(alignOpposite = false)
            } childOf window

            UIText("Recreated by Mega").constrain {
                color = Color(255,255,255,100).constraint // Makes it half transparent
                textScale = 0.50.pixels()
                x = (60 / scalefactor).pixels(alignOpposite = false)
                y = (612 / scalefactor).pixels(alignOpposite = false)
            } childOf window

            UIText("Myau 4.17").constrain {
                color = Color(255,255,255,100).constraint // Makes it half transparent
                textScale = 0.50.pixels()
                x = (275 / scalefactor).pixels(alignOpposite = false)
                y = (612 / scalefactor).pixels(alignOpposite = false)
            } childOf window

            // Home - arrows

            val ArrowCombat = UIImage.ofResource("/assets/tewxx/arrowhome.png").constrain {
                x = (233/scalefactor).pixels(alignOpposite = false)
                y = (73/scalefactor).pixels(alignOpposite = false)
                width = (100 / scalefactor).pixels()
                height = (100 / scalefactor).pixels()
            } childOf window

            val ArrowBlatant = UIImage.ofResource("/assets/tewxx/arrowhome.png").constrain {
                x = (233/scalefactor).pixels(alignOpposite = false)
                y = (125/scalefactor).pixels(alignOpposite = false)
                width = (100 / scalefactor).pixels()
                height = (100 / scalefactor).pixels()
            } childOf window

            val ArrowRender = UIImage.ofResource("/assets/tewxx/arrowhome.png").constrain {
                x = (233/scalefactor).pixels(alignOpposite = false)
                y = (175/scalefactor).pixels(alignOpposite = false)
                width = (100 / scalefactor).pixels()
                height = (100 / scalefactor).pixels()
            } childOf window

            val ArrowUtility = UIImage.ofResource("/assets/tewxx/arrowhome.png").constrain {
                x = (233/scalefactor).pixels(alignOpposite = false)
                y = (229/scalefactor).pixels(alignOpposite = false)
                width = (100 / scalefactor).pixels()
                height = (100 / scalefactor).pixels()
            } childOf window

            val ArrowWorld = UIImage.ofResource("/assets/tewxx/arrowhome.png").constrain {
                x = (233/scalefactor).pixels(alignOpposite = false)
                y = (281/scalefactor).pixels(alignOpposite = false)
                width = (100 / scalefactor).pixels()
                height = (100 / scalefactor).pixels()
            } childOf window

            val ArrowInventory = UIImage.ofResource("/assets/tewxx/arrowhome.png").constrain {
                x = (233/scalefactor).pixels(alignOpposite = false)
                y = (333/scalefactor).pixels(alignOpposite = false)
                width = (100 / scalefactor).pixels()
                height = (100 / scalefactor).pixels()
            } childOf window

            val ArrowFriends = UIImage.ofResource("/assets/tewxx/arrowhome.png").constrain {
                x = (233/scalefactor).pixels(alignOpposite = false)
                y = (418/scalefactor).pixels(alignOpposite = false)
                width = (100 / scalefactor).pixels()
                height = (100 / scalefactor).pixels()
            } childOf window

            val ArrowProfiles = UIImage.ofResource("/assets/tewxx/arrowhome.png").constrain {
                x = (233/scalefactor).pixels(alignOpposite = false)
                y = (468/scalefactor).pixels(alignOpposite = false)
                width = (100 / scalefactor).pixels()
                height = (100 / scalefactor).pixels()
            } childOf window

            val ArrowMacros = UIImage.ofResource("/assets/tewxx/arrowhome.png").constrain {
                x = (233/scalefactor).pixels(alignOpposite = false)
                y = (522/scalefactor).pixels(alignOpposite = false)
                width = (100 / scalefactor).pixels()
                height = (100 / scalefactor).pixels()
            } childOf window

            // Home Click Detectors

            val HomeCombatClickArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / scalefactor).pixels(alignOpposite = false)
                y = (97 / scalefactor).pixels(alignOpposite = false)
                width = (290 / scalefactor).pixels()
                height = (52 / scalefactor).pixels()
            } childOf window

            HomeCombatClickArea.onMouseClick {
                isTransparent = !isTransparent
                HomeCombatColorChangeArea.setColor(if (isTransparent) Color(31, 30, 31, 0) else Color(31, 30, 31, 255))
                println("Combat Clicked")
                // RGB Changers
                if (isTransparent) {
                    CombatText.setColor(Color.WHITE)
                    HomeCombatIcon.setColor(Color.WHITE)
                } else {
                    // Start RGB color
                    Timer().scheduleAtFixedRate(object : TimerTask() {
                        override fun run() {
                            HomeCombatIcon.setColor(GuiUtils.rainbowColor.get())
                            CombatText.setColor(GuiUtils.rainbowColor.get())

                        }
                    }, 0, 100)
                }
            }

            val HomeBlatantClickArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / scalefactor).pixels(alignOpposite = false)
                y = (149 / scalefactor).pixels(alignOpposite = false)
                width = (290 / scalefactor).pixels()
                height = (52 / scalefactor).pixels()
            } childOf window

            HomeBlatantClickArea.onMouseClick {
                isTransparent = !isTransparent
                HomeBlatantColorChangeArea.setColor(if (isTransparent) Color(31, 30, 31, 0) else Color(31, 30, 31, 255))
                println("Blatant Clicked")
            }

            val HomeRenderClickArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / scalefactor).pixels(alignOpposite = false)
                y = (201 / scalefactor).pixels(alignOpposite = false)
                width = (290 / scalefactor).pixels()
                height = (52 / scalefactor).pixels()
            } childOf window

            HomeRenderClickArea.onMouseClick {
                isTransparent = !isTransparent
                HomeRenderColorChangeArea.setColor(if (isTransparent) Color(31, 30, 31, 0) else Color(31, 30, 31, 255))
                println("Render Clicked")
            }

            val HomeUtilityClickArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / scalefactor).pixels(alignOpposite = false)
                y = (253 / scalefactor).pixels(alignOpposite = false)
                width = (290 / scalefactor).pixels()
                height = (52 / scalefactor).pixels()
            } childOf window

            HomeUtilityClickArea.onMouseClick {
                isTransparent = !isTransparent
                HomeUtilityColorChangeArea.setColor(if (isTransparent) Color(31, 30, 31, 0) else Color(31, 30, 31, 255))
                println("Utility Clicked")
            }

            val HomeWorldClickArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / scalefactor).pixels(alignOpposite = false)
                y = (305 / scalefactor).pixels(alignOpposite = false)
                width = (290 / scalefactor).pixels()
                height = (52 / scalefactor).pixels()
            } childOf window

            HomeWorldClickArea.onMouseClick {
                isTransparent = !isTransparent
                HomeWorldColorChangeArea.setColor(if (isTransparent) Color(31, 30, 31, 0) else Color(31, 30, 31, 255))
                println("World Clicked")
            }

            val HomeInventoryClickArea = UIBlock().constrain {
                color = Color(31, 30, 31, 0).constraint
                x = (50 / scalefactor).pixels(alignOpposite = false)
                y = (357 / scalefactor).pixels(alignOpposite = false)
                width = (290 / scalefactor).pixels()
                height = (52 / scalefactor).pixels()
            } childOf window

            HomeInventoryClickArea.onMouseClick {
                isTransparent = !isTransparent
                HomeInventoryColorChangeArea.setColor(if (isTransparent) Color(31, 30, 31, 0) else Color(31, 30, 31, 255))
                println("Inventory Clicked")
            }

            // RGB

            Timer().scheduleAtFixedRate(object : TimerTask() {
                override fun run() {
                    HomeV4Image.setColor(GuiUtils.rainbowColor.get())
                }
            }, 0, 100)

        }
}
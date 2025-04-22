package com.github.tewxx.mega.events

import DraggableClass
import GuiUtils
import gg.essential.elementa.ElementaVersion
import gg.essential.elementa.UIComponent
import gg.essential.elementa.WindowScreen
import gg.essential.elementa.components.*
import gg.essential.elementa.constraints.animation.Animations
import gg.essential.elementa.dsl.*
import gg.essential.universal.UMatrixStack
import org.afterlike.slumber.util.SlumberFontRenderer
import org.afterlike.slumber.util.SlumberFonts
import java.awt.Color
import java.util.*

class GUI : WindowScreen(ElementaVersion.V7, newGuiScale = 2, drawDefaultBackground = false) {
    private var isTransparent = true
    private var isCombatTabVisible = false

    fun setupDraggableComponent(component: UIComponent) {
        DraggableClass.makeComponentDraggable(component)
    }

    init {
        // Main Elementa Stuff
        //Inspector(window) childOf window
        val scalefactor = 2.5;

        //Home
        val HomeBack = UIRoundedRectangle(3f).constrain {
            color = Color(0x1A191A).constraint
            x = (50/scalefactor).pixels(alignOpposite = false)
            y = (50/scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (510 / scalefactor).pixels()
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

        val HomeTopBarDraggable =  UIRoundedRectangle(3f).constrain {
            color = Color(31,30,31,0).constraint
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

        val HomeBottomUnRounded = UIRoundedRectangle(0f).constrain {
            color = Color(0x141414).constraint
            x = (50/scalefactor).pixels(alignOpposite = false)
            y = (546/scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (17 / scalefactor).pixels()
        } childOf window

        val HomeBottomRounded = UIRoundedRectangle(3f).constrain {
            color = Color(0x141414).constraint
            x = (50/scalefactor).pixels(alignOpposite = false)
            y = (546/scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (32 / scalefactor).pixels()
        } childOf window


        val HomeVapeImage = UIImage.ofResource("/assets/home/images/logo.png").constrain {
            x = (62/scalefactor).pixels(alignOpposite = false)
            y = (64/scalefactor).pixels(alignOpposite = false)
            width = (77 / scalefactor).pixels()
            height = (20 / scalefactor).pixels()
        } childOf window

        val HomeV4Image = UIImage.ofResource("/assets/home/images/v4.png").constrain {
            x = (140/scalefactor).pixels(alignOpposite = false)
            y = (64/scalefactor).pixels(alignOpposite = false)
            width = (29 / scalefactor).pixels()
            height = (17 / scalefactor).pixels()
        } childOf window

        val HomeSettingsImage = UIImage.ofResource("/assets/home/images/settings.png").constrain {
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

        val HomeCombatIcon = UIImage.ofResource("/assets/home/images/combaticon.png").constrain {
            x = (68/scalefactor).pixels(alignOpposite = false)
            y = (113/scalefactor).pixels(alignOpposite = false)
            width = (20 / scalefactor).pixels()
            height = (22 / scalefactor).pixels()
        } childOf window

        val HomeBlatantIcon = UIImage.ofResource("/assets/home/images/blatanticon.png").constrain {
            x = (68/scalefactor).pixels(alignOpposite = false)
            y = (164/scalefactor).pixels(alignOpposite = false)
            width = (20 / scalefactor).pixels()
            height = (20 / scalefactor).pixels()
        } childOf window

        val HomeRenderIcon = UIImage.ofResource("/assets/home/images/rendericon.png").constrain {
            x = (68/scalefactor).pixels(alignOpposite = false)
            y = (217/scalefactor).pixels(alignOpposite = false)
            width = (21 / scalefactor).pixels()
            height = (20 / scalefactor).pixels()
        } childOf window

        val HomeUtilityIcon = UIImage.ofResource("/assets/home/images/utilityicon.png").constrain {
            x = (69/scalefactor).pixels(alignOpposite = false)
            y = (269/scalefactor).pixels(alignOpposite = false)
            width = (20 / scalefactor).pixels()
            height = (19 / scalefactor).pixels()
        } childOf window

        val HomeWorldIcon = UIImage.ofResource("/assets/home/images/worldicon.png").constrain {
            x = (69/scalefactor).pixels(alignOpposite = false)
            y = (321/scalefactor).pixels(alignOpposite = false)
            width = (20 / scalefactor).pixels()
            height = (20 / scalefactor).pixels()
        } childOf window

        val HomeInventoryIcon = UIImage.ofResource("/assets/home/images/inventoryicon.png").constrain {
            x = (69/scalefactor).pixels(alignOpposite = false)
            y = (373/scalefactor).pixels(alignOpposite = false)
            width = (20 / scalefactor).pixels()
            height = (19 / scalefactor).pixels()
        } childOf window

        // Home - text
        // ALL TEXT FROM DESIGN -- Y+4
        val CombatText = UIText("Combat", shadow = false)
            .apply {
                setFontProvider(SlumberFonts.PROXIMA_NOVA)
            }
            .constrain {
                x = (93 / scalefactor).pixels(alignOpposite = false)
                y = (117/scalefactor).pixels(alignOpposite = false)
                color = Color.WHITE.constraint
                width = (64/ scalefactor).pixels()
                height = (19/ scalefactor).pixels()
            } childOf window

        val BlatantText = UIText("Blatant", shadow = false)
            .apply {
                setFontProvider(SlumberFonts.PROXIMA_NOVA)
            }
            .constrain {
                x = (95 / scalefactor).pixels(alignOpposite = false)
                y = (169 / scalefactor).pixels(alignOpposite = false)
                color = Color.WHITE.constraint
                width = (57 / scalefactor).pixels()
                height = (19 / scalefactor).pixels()
            } childOf window

        val RenderText = UIText("Render", shadow = false)
            .apply {
                setFontProvider(SlumberFonts.PROXIMA_NOVA)
            }
            .constrain {
                x = (95 / scalefactor).pixels(alignOpposite = false)
                y = (221 / scalefactor).pixels(alignOpposite = false)
                color = Color.WHITE.constraint
                width = (59 / scalefactor).pixels()
                height = (19 / scalefactor).pixels()
            } childOf window

        val UtilityText = UIText("Utility", shadow = false)
            .apply {
                setFontProvider(SlumberFonts.PROXIMA_NOVA)
            }
            .constrain {
                x = (95 / scalefactor).pixels(alignOpposite = false)
                y = (271 / scalefactor).pixels(alignOpposite = false)
                color = Color.WHITE.constraint
                width = (46 / scalefactor).pixels()
                height = (19 / scalefactor).pixels()
            } childOf window

        val WorldText = UIText("World", shadow = false)
            .apply {
                setFontProvider(SlumberFonts.PROXIMA_NOVA)
            }
            .constrain {
                x = (96 / scalefactor).pixels(alignOpposite = false)
                y = (324 / scalefactor).pixels(alignOpposite = false)
                color = Color.WHITE.constraint
                width = (48 / scalefactor).pixels()
                height = (19 / scalefactor).pixels()
            } childOf window

        val InventoryText = UIText("Inventory", shadow = false)
            .apply {
                setFontProvider(SlumberFonts.PROXIMA_NOVA)
            }
            .constrain {
                x = (95 / scalefactor).pixels(alignOpposite = false)
                y = (376 / scalefactor).pixels(alignOpposite = false)
                color = Color.WHITE.constraint
                width = (76 / scalefactor).pixels()
                height = (19 / scalefactor).pixels()
            } childOf window

        val MiscText = UIText("MISC", shadow = false)
            .apply {
                setFontProvider(SlumberFonts.PROXIMA_NOVA)
            }
            .constrain {
                x = (65/ scalefactor).pixels(alignOpposite = false)
                y = (420/scalefactor).pixels(alignOpposite = false)
                color = Color.darkGray.constraint
                width = (35/scalefactor).pixels()
                height = (16/scalefactor).pixels()
            } childOf window

        val FriendsText = UIText("Friends", shadow = false)
            .apply {
                setFontProvider(SlumberFonts.PROXIMA_NOVA)
            }
            .constrain {
                x = (69 / scalefactor).pixels(alignOpposite = false)
                y = (461 / scalefactor).pixels(alignOpposite = false)
                color = Color.WHITE.constraint
                width = (61 / scalefactor).pixels()
                height = (19 / scalefactor).pixels()
            } childOf window

        val ProfilesText = UIText("Profiles", shadow = false)
            .apply {
                setFontProvider(SlumberFonts.PROXIMA_NOVA)
            }
            .constrain {
                x = (69 / scalefactor).pixels(alignOpposite = false)
                y = (513 / scalefactor).pixels(alignOpposite = false)
                color = Color.WHITE.constraint
                width = (61 / scalefactor).pixels()
                height = (19 / scalefactor).pixels()
            } childOf window

        // Home - arrows

        val ArrowCombat = UIImage.ofResource("/assets/home/images/arrowhome.png").constrain {
            x = (221/scalefactor).pixels(alignOpposite = false)
            y = (73/scalefactor).pixels(alignOpposite = false)
            width = (100 / scalefactor).pixels()
            height = (100 / scalefactor).pixels()
        } childOf window

        val ArrowBlatant = UIImage.ofResource("/assets/home/images/arrowhome.png").constrain {
            x = (221/scalefactor).pixels(alignOpposite = false)
            y = (125/scalefactor).pixels(alignOpposite = false)
            width = (100 / scalefactor).pixels()
            height = (100 / scalefactor).pixels()
        } childOf window

        val ArrowRender = UIImage.ofResource("/assets/home/images/arrowhome.png").constrain {
            x = (221/scalefactor).pixels(alignOpposite = false)
            y = (175/scalefactor).pixels(alignOpposite = false)
            width = (100 / scalefactor).pixels()
            height = (100 / scalefactor).pixels()
        } childOf window

        val ArrowUtility = UIImage.ofResource("/assets/home/images/arrowhome.png").constrain {
            x = (221/scalefactor).pixels(alignOpposite = false)
            y = (229/scalefactor).pixels(alignOpposite = false)
            width = (100 / scalefactor).pixels()
            height = (100 / scalefactor).pixels()
        } childOf window

        val ArrowWorld = UIImage.ofResource("/assets/home/images/arrowhome.png").constrain {
            x = (221/scalefactor).pixels(alignOpposite = false)
            y = (281/scalefactor).pixels(alignOpposite = false)
            width = (100 / scalefactor).pixels()
            height = (100 / scalefactor).pixels()
        } childOf window

        val ArrowInventory = UIImage.ofResource("/assets/home/images/arrowhome.png").constrain {
            x = (221/scalefactor).pixels(alignOpposite = false)
            y = (333/scalefactor).pixels(alignOpposite = false)
            width = (100 / scalefactor).pixels()
            height = (100 / scalefactor).pixels()
        } childOf window

        val ArrowFriends = UIImage.ofResource("/assets/home/images/arrowhome.png").constrain {
            x = (221/scalefactor).pixels(alignOpposite = false)
            y = (420/scalefactor).pixels(alignOpposite = false)
            width = (100 / scalefactor).pixels()
            height = (100 / scalefactor).pixels()
        } childOf window

        val ArrowProfiles = UIImage.ofResource("/assets/home/images/arrowhome.png").constrain {
            x = (221/scalefactor).pixels(alignOpposite = false)
            y = (470/scalefactor).pixels(alignOpposite = false)
            width = (100 / scalefactor).pixels()
            height = (100 / scalefactor).pixels()
        } childOf window

        // RGB for Logo
        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                HomeV4Image.setColor(GuiUtils.rainbowColor.get())
            }
        }, 0, 50)

        // Combat

        val Combatcontainer = UIContainer().constrain {
            x = 0.pixels(alignOpposite = false)
            y = 0.pixels(alignOpposite = false)
            width = 1.pixels()
            height = 1.pixels()
        }.apply {
            hide()  // Hide it so it dosent appear for 1 frame if it were outside
        } childOf window
        val CombatBase = UIRoundedRectangle(3f).constrain {
            color = Color(0x1A191A).constraint
            x = (358 / scalefactor).pixels(alignOpposite = false)
            y = (50 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (412 / scalefactor).pixels()
        } childOf Combatcontainer

        val CombatTopBarRounded = UIRoundedRectangle(3f).constrain {
            color = Color(20,20,20,0).constraint
            x = (358 / scalefactor).pixels(alignOpposite = false)
            y = (50 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (47 / scalefactor).pixels()
        } childOf Combatcontainer

        val CombatBottomBarRounded = UIRoundedRectangle(3f).constrain {
            color = Color(0x141414).constraint
            x = (358 / scalefactor).pixels(alignOpposite = false)
            y = (456 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (8 / scalefactor).pixels()
        } childOf Combatcontainer

        val CombatBottomBarUnRounded = UIRoundedRectangle(0f).constrain {
            color = Color(0x141414).constraint
            x = (358 / scalefactor).pixels(alignOpposite = false)
            y = (454 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (6 / scalefactor).pixels()
        } childOf Combatcontainer

        val CombatArrowUp = UIImage.ofResource("/assets/moduleuparrow.png").constrain {
            x = (622/scalefactor).pixels(alignOpposite = false)
            y = (71/scalefactor).pixels(alignOpposite = false)
            width = (12 / scalefactor).pixels()
            height = (5 / scalefactor).pixels()
        } childOf Combatcontainer

        val CombatModuleIcon = UIImage.ofResource("/assets/home/images/combaticon.png").constrain {
            x = (374/scalefactor).pixels(alignOpposite = false)
            y = (65/scalefactor).pixels(alignOpposite = false)
            width = (19 / scalefactor).pixels()
            height = (20 / scalefactor).pixels()
        } childOf Combatcontainer

        val CombatModuleText = UIText("Combat", shadow = false)
            .apply {
                setFontProvider(SlumberFonts.PROXIMA_NOVA)
            }
            .constrain {
                x = (401 / scalefactor).pixels(alignOpposite = false)
                y = (69 / scalefactor).pixels(alignOpposite = false)
                color = Color.WHITE.constraint
                width = (64 / scalefactor).pixels()
                height = (19 / scalefactor).pixels()
            } childOf Combatcontainer


        // Blatant

        val Blatantcontainer = UIContainer().constrain {
            x = 0.pixels(alignOpposite = false)
            y = 0.pixels(alignOpposite = false)
            width = 1.pixels()
            height = 1.pixels()
        }.apply {
            hide()  // Hide it so it dosent appear for 1 frame if it were outside
        } childOf window
        val BlatantBase = UIRoundedRectangle(3f).constrain {
            color = Color(0x1a191a).constraint
            x = (669 / scalefactor).pixels(alignOpposite = false)
            y = (50 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (363 / scalefactor).pixels()
        } childOf Blatantcontainer

        val BlatantTopBarRounded = UIRoundedRectangle(3f).constrain {
            color = Color(20,20,20,0).constraint
            x = (669 / scalefactor).pixels(alignOpposite = false)
            y = (50 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (47 / scalefactor).pixels()
        } childOf Blatantcontainer

        val BlatantBottomBarRounded = UIRoundedRectangle(3f).constrain {
            color = Color(0x141414).constraint
            x = (669 / scalefactor).pixels(alignOpposite = false)
            y = (409 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (8 / scalefactor).pixels()
        } childOf Blatantcontainer

        val BlatantBottomBarUnRounded = UIRoundedRectangle(0f).constrain {
            color = Color(0x141414).constraint
            x = (669 / scalefactor).pixels(alignOpposite = false)
            y = (407 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (6 / scalefactor).pixels()
        } childOf Blatantcontainer

        val BlatantArrowUp = UIImage.ofResource("/assets/moduleuparrow.png").constrain {
            x = (933/scalefactor).pixels(alignOpposite = false)
            y = (71/scalefactor).pixels(alignOpposite = false)
            width = (12 / scalefactor).pixels()
            height = (5 / scalefactor).pixels()
        } childOf Blatantcontainer

        val BlatantModuleIcon = UIImage.ofResource("/assets/home/images/blatanticon.png").constrain {
            x = (685/scalefactor).pixels(alignOpposite = false)
            y = (65/scalefactor).pixels(alignOpposite = false)
            width = (20 / scalefactor).pixels()
            height = (20 / scalefactor).pixels()
        } childOf Blatantcontainer

        val BlatantModuleText = UIText("Blatant", shadow = false)
            .apply {
                setFontProvider(SlumberFonts.PROXIMA_NOVA)
            }
            .constrain {
                x = (711 / scalefactor).pixels(alignOpposite = false)
                y = (68 / scalefactor).pixels(alignOpposite = false)
                color = Color.WHITE.constraint
                width = (59 / scalefactor).pixels()
                height = (19 / scalefactor).pixels()
            } childOf Blatantcontainer

        // Render

        val Rendercontainer = UIContainer().constrain {
            x = 0.pixels(alignOpposite = false)
            y = 0.pixels(alignOpposite = false)
            width = 1.pixels()
            height = 1.pixels()
        }.apply {
            hide()  // Hide it so it doesn't appear for 1 frame if it were outside
        } childOf window

        val RenderBase = UIRoundedRectangle(3f).constrain {
            color = Color(0x1A191A).constraint
            x = (980 / scalefactor).pixels(alignOpposite = false)
            y = (50 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (363 / scalefactor).pixels()
        } childOf Rendercontainer

        val RenderTopBarRounded = UIRoundedRectangle(3f).constrain {
            color = Color(20,20,20,0).constraint
            x = (980 / scalefactor).pixels(alignOpposite = false)
            y = (50 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (47 / scalefactor).pixels()
        } childOf Rendercontainer

        val RenderBottomBarRounded = UIRoundedRectangle(3f).constrain {
            color = Color(0x141414).constraint
            x = (980 / scalefactor).pixels(alignOpposite = false)
            y = (409 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (8 / scalefactor).pixels()
        } childOf Rendercontainer

        val RenderBottomBarUnRounded = UIRoundedRectangle(0f).constrain {
            color = Color(0x141414).constraint
            x = (980 / scalefactor).pixels(alignOpposite = false)
            y = (407 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (6 / scalefactor).pixels()
        } childOf Rendercontainer

        val RenderArrowUp = UIImage.ofResource("/assets/moduleuparrow.png").constrain {
            x = (1244/scalefactor).pixels(alignOpposite = false)
            y = (71/scalefactor).pixels(alignOpposite = false)
            width = (12 / scalefactor).pixels()
            height = (5 / scalefactor).pixels()
        } childOf Rendercontainer

        val RenderModuleIcon = UIImage.ofResource("/assets/home/images/rendericon.png").constrain {
            x = (996/scalefactor).pixels(alignOpposite = false)
            y = (62/scalefactor).pixels(alignOpposite = false)
            width = (20 / scalefactor).pixels()
            height = (20 / scalefactor).pixels()
        } childOf Rendercontainer

        val RenderModuleText = UIText("Render", shadow = false)
            .apply {
                setFontProvider(SlumberFonts.PROXIMA_NOVA)
            }
            .constrain {
                x = (1021 / scalefactor).pixels(alignOpposite = false)
                y = (68 / scalefactor).pixels(alignOpposite = false)
                color = Color.WHITE.constraint
                width = (59 / scalefactor).pixels()
                height = (19 / scalefactor).pixels()
            } childOf Rendercontainer

        // Utility

        val Utilitycontainer = UIContainer().constrain {
            x = 0.pixels(alignOpposite = false)
            y = 0.pixels(alignOpposite = false)
            width = 1.pixels()
            height = 1.pixels()
        }.apply {
            hide()  // Hide it so it doesn't appear for 1 frame if it were outside
        } childOf window

        val UtilityBase = UIRoundedRectangle(3f).constrain {
            color = Color(0x1A191A).constraint
            x = (1291 / scalefactor).pixels(alignOpposite = false)
            y = (50 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (363 / scalefactor).pixels()
        } childOf Utilitycontainer

        val UtilityTopBarRounded = UIRoundedRectangle(3f).constrain {
            color = Color(20,20,20,0).constraint
            x = (1291 / scalefactor).pixels(alignOpposite = false)
            y = (50 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (47 / scalefactor).pixels()
        } childOf Utilitycontainer

        val UtilityBottomBarRounded = UIRoundedRectangle(3f).constrain {
            color = Color(0x141414).constraint
            x = (1291 / scalefactor).pixels(alignOpposite = false)
            y = (409 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (8 / scalefactor).pixels()
        } childOf Utilitycontainer

        val UtilityBottomBarUnRounded = UIRoundedRectangle(0f).constrain {
            color = Color(0x141414).constraint
            x = (1291 / scalefactor).pixels(alignOpposite = false)
            y = (407 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (6 / scalefactor).pixels()
        } childOf Utilitycontainer

        val UtilityArrowUp = UIImage.ofResource("/assets/moduleuparrow.png").constrain {
            x = (1555/scalefactor).pixels(alignOpposite = false)
            y = (71/scalefactor).pixels(alignOpposite = false)
            width = (12 / scalefactor).pixels()
            height = (5 / scalefactor).pixels()
        } childOf Utilitycontainer

        val UtilityModuleIcon = UIImage.ofResource("/assets/home/images/utilityicon.png").constrain {
            x = (1307/scalefactor).pixels(alignOpposite = false)
            y = (62/scalefactor).pixels(alignOpposite = false)
            width = (20 / scalefactor).pixels()
            height = (20 / scalefactor).pixels()
        } childOf Utilitycontainer

        val UtilityModuleText = UIText("Utility", shadow = false)
            .apply {
                setFontProvider(SlumberFonts.PROXIMA_NOVA)
            }
            .constrain {
                x = (1337 / scalefactor).pixels(alignOpposite = false)
                y = (67 / scalefactor).pixels(alignOpposite = false)
                color = Color.WHITE.constraint
                width = (46 / scalefactor).pixels()
                height = (19 / scalefactor).pixels()
            } childOf Utilitycontainer

        // World

        val Worldcontainer = UIContainer().constrain {
            x = 0.pixels(alignOpposite = false)
            y = 0.pixels(alignOpposite = false)
            width = 1.pixels()
            height = 1.pixels()
        }.apply {
            hide()  // Hide it so it doesn't appear for 1 frame if it were outside
        } childOf window

        val WorldBase = UIRoundedRectangle(3f).constrain {
            color = Color(0x1A191A).constraint
            x = (1602 / scalefactor).pixels(alignOpposite = false)
            y = (50 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (363 / scalefactor).pixels()
        } childOf Worldcontainer

        val WorldTopBarRounded = UIRoundedRectangle(3f).constrain {
            color = Color(20,20,20,0).constraint
            x = (1602 / scalefactor).pixels(alignOpposite = false)
            y = (50 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (47 / scalefactor).pixels()
        } childOf Worldcontainer

        val WorldBottomBarRounded = UIRoundedRectangle(3f).constrain {
            color = Color(0x141414).constraint
            x = (1602 / scalefactor).pixels(alignOpposite = false)
            y = (409 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (8 / scalefactor).pixels()
        } childOf Worldcontainer

        val WorldBottomBarUnRounded = UIRoundedRectangle(0f).constrain {
            color = Color(0x141414).constraint
            x = (1602 / scalefactor).pixels(alignOpposite = false)
            y = (407 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (6 / scalefactor).pixels()
        } childOf Worldcontainer

        val WorldArrowUp = UIImage.ofResource("/assets/moduleuparrow.png").constrain {
            x = (1866/scalefactor).pixels(alignOpposite = false)
            y = (71/scalefactor).pixels(alignOpposite = false)
            width = (12 / scalefactor).pixels()
            height = (5 / scalefactor).pixels()
        } childOf Worldcontainer

        val WorldModuleIcon = UIImage.ofResource("/assets/home/images/worldicon.png").constrain {
            x = (1611/scalefactor).pixels(alignOpposite = false)
            y = (65/scalefactor).pixels(alignOpposite = false)
            width = (20 / scalefactor).pixels()
            height = (20 / scalefactor).pixels()
        } childOf Worldcontainer

        val WorldModuleText = UIText("World", shadow = false)
            .apply {
                setFontProvider(SlumberFonts.PROXIMA_NOVA)
            }
            .constrain {
                x = (1639 / scalefactor).pixels(alignOpposite = false)
                y = (69 / scalefactor).pixels(alignOpposite = false)
                color = Color.WHITE.constraint
                width = (49 / scalefactor).pixels()
                height = (19 / scalefactor).pixels()
            } childOf Worldcontainer

        // Inventory

        val Inventorycontainer = UIContainer().constrain {
            x = 0.pixels(alignOpposite = false)
            y = 0.pixels(alignOpposite = false)
            width = 1.pixels()
            height = 1.pixels()
        }.apply {
            hide()  // Hide it so it doesn't appear for 1 frame if it were outside
        } childOf window

        val InventoryBase = UIRoundedRectangle(3f).constrain {
            color = Color(0x1A191A).constraint
            x = (1913 / scalefactor).pixels(alignOpposite = false)
            y = (50 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (363 / scalefactor).pixels()
        } childOf Inventorycontainer

        val InventoryTopBarRounded = UIRoundedRectangle(3f).constrain {
            color = Color(20,20,20,0).constraint
            x = (1913 / scalefactor).pixels(alignOpposite = false)
            y = (50 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (47 / scalefactor).pixels()
        } childOf Inventorycontainer

        val InventoryBottomBarRounded = UIRoundedRectangle(3f).constrain {
            color = Color(0x141414).constraint
            x = (1913 / scalefactor).pixels(alignOpposite = false)
            y = (409 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (8 / scalefactor).pixels()
        } childOf Inventorycontainer

        val InventoryBottomBarUnRounded = UIRoundedRectangle(0f).constrain {
            color = Color(0x141414).constraint
            x = (1913 / scalefactor).pixels(alignOpposite = false)
            y = (407 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (6 / scalefactor).pixels()
        } childOf Inventorycontainer

        val InventoryArrowUp = UIImage.ofResource("/assets/moduleuparrow.png").constrain {
            x = (2177/scalefactor).pixels(alignOpposite = false)
            y = (71/scalefactor).pixels(alignOpposite = false)
            width = (12 / scalefactor).pixels()
            height = (5 / scalefactor).pixels()
        } childOf Inventorycontainer

        val InventoryModuleIcon = UIImage.ofResource("/assets/home/images/inventoryicon.png").constrain {
            x = (1928/scalefactor).pixels(alignOpposite = false)
            y = (65/scalefactor).pixels(alignOpposite = false)
            width = (20 / scalefactor).pixels()
            height = (20 / scalefactor).pixels()
        } childOf Inventorycontainer

        val InventoryModuleText = UIText("Inventory", shadow = false)
            .apply {
                setFontProvider(SlumberFonts.PROXIMA_NOVA)
            }
            .constrain {
                x = (1954/scalefactor).pixels(alignOpposite = false)
                y = (68/scalefactor).pixels(alignOpposite = false)
                width = (77 / scalefactor).pixels()
                height = (19 / scalefactor).pixels()
            } childOf Inventorycontainer


        // Home Click Detectors (These have to be at bottom)
        //
        val HomeCombatClickArea = UIBlock().constrain {
            color = Color(31, 30, 31, 0).constraint
            x = (50 / scalefactor).pixels(alignOpposite = false)
            y = (97 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (52 / scalefactor).pixels()
        } childOf window
        var combatIsTransparent = true
        var combatTimer: Timer? = null
        HomeCombatClickArea.onMouseClick {
            combatIsTransparent = !combatIsTransparent
            HomeCombatColorChangeArea.setColor(if (combatIsTransparent) Color(31, 30, 31, 0) else Color(31, 30, 31, 255))
            println("Combat Clicked")
            if (combatIsTransparent) {
                CombatText.setColor(Color.WHITE)
                HomeCombatIcon.setColor(Color.WHITE)
                combatTimer?.cancel()
                combatTimer = null
                Combatcontainer.hide()
                ArrowCombat.animate {
                    setXAnimation(Animations.IN_OUT_CUBIC, 0.25f, 89.pixels)
                }
            } else {
                ArrowCombat.animate {
                    setXAnimation(Animations.IN_OUT_CUBIC, 0.25f, 83.pixels)
                }
                Combatcontainer.unhide()
                combatTimer = Timer().apply {
                    scheduleAtFixedRate(object : TimerTask() {
                        override fun run() {
                            HomeCombatIcon.setColor(GuiUtils.rainbowColor.get())
                            CombatText.setColor(GuiUtils.rainbowColor.get())
                        }
                    }, 0, 50)
                }
            }
        }
        //
        val HomeBlatantClickArea = UIBlock().constrain {
            color = Color(31, 30, 31, 0).constraint
            x = (50 / scalefactor).pixels(alignOpposite = false)
            y = (149 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (52 / scalefactor).pixels()
        } childOf window
        var blatantIsTransparent = true
        var blatantTimer: Timer? = null
        HomeBlatantClickArea.onMouseClick {
            blatantIsTransparent = !blatantIsTransparent
            HomeBlatantColorChangeArea.setColor(if (blatantIsTransparent) Color(31, 30, 31, 0) else Color(31, 30, 31, 255))
            println("Blatant Clicked")
            if (blatantIsTransparent) {
                BlatantText.setColor(Color.WHITE)
                HomeBlatantIcon.setColor(Color.WHITE)
                blatantTimer?.cancel()
                blatantTimer = null
                Blatantcontainer.hide()
                ArrowBlatant.animate {
                    setXAnimation(Animations.IN_OUT_CUBIC, 0.25f, 89.pixels)
                }
            } else {
                Blatantcontainer.unhide()
                ArrowBlatant.animate {
                    setXAnimation(Animations.IN_OUT_CUBIC, 0.25f, 83.pixels)
                }
                blatantTimer = Timer().apply {
                    scheduleAtFixedRate(object : TimerTask() {
                        override fun run() {
                            HomeBlatantIcon.setColor(GuiUtils.rainbowColor.get())
                            BlatantText.setColor(GuiUtils.rainbowColor.get())
                        }
                    }, 0, 50)
                }
            }
        }
        //
        val HomeRenderClickArea = UIBlock().constrain {
            color = Color(31, 30, 31, 0).constraint
            x = (50 / scalefactor).pixels(alignOpposite = false)
            y = (201 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (52 / scalefactor).pixels()
        } childOf window
        var renderIsTransparent = true
        var renderTimer: Timer? = null
        HomeRenderClickArea.onMouseClick {
            renderIsTransparent = !renderIsTransparent
            HomeRenderColorChangeArea.setColor(if (renderIsTransparent) Color(31, 30, 31, 0) else Color(31, 30, 31, 255))
            println("Render Clicked")
            if (renderIsTransparent) {
                RenderText.setColor(Color.WHITE)
                HomeRenderIcon.setColor(Color.WHITE)
                renderTimer?.cancel()
                renderTimer = null
                Rendercontainer.hide()
                ArrowRender.animate {
                    setXAnimation(Animations.IN_OUT_CUBIC, 0.25f, 89.pixels)
                }
            } else {
                Rendercontainer.unhide()
                ArrowRender.animate {
                    setXAnimation(Animations.IN_OUT_CUBIC, 0.25f, 83.pixels)
                }
                renderTimer = Timer().apply {
                    scheduleAtFixedRate(object : TimerTask() {
                        override fun run() {
                            HomeRenderIcon.setColor(GuiUtils.rainbowColor.get())
                            RenderText.setColor(GuiUtils.rainbowColor.get())
                        }
                    }, 0, 50)
                }
            }
        }
        //
        val HomeUtilityClickArea = UIBlock().constrain {
            color = Color(31, 30, 31, 0).constraint
            x = (50 / scalefactor).pixels(alignOpposite = false)
            y = (253 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (52 / scalefactor).pixels()
        } childOf window
        var utilityIsTransparent = true
        var utilityTimer: Timer? = null
        HomeUtilityClickArea.onMouseClick {
            utilityIsTransparent = !utilityIsTransparent
            HomeUtilityColorChangeArea.setColor(if (utilityIsTransparent) Color(31, 30, 31, 0) else Color(31, 30, 31, 255))
            println("Utility Clicked")
            if (utilityIsTransparent) {
                UtilityText.setColor(Color.WHITE)
                HomeUtilityIcon.setColor(Color.WHITE)
                utilityTimer?.cancel()
                utilityTimer = null
                Utilitycontainer.hide()
                ArrowUtility.animate {
                    setXAnimation(Animations.IN_OUT_CUBIC, 0.25f, 89.pixels)
                }
            } else {
                Utilitycontainer.unhide()
                ArrowUtility.animate {
                    setXAnimation(Animations.IN_OUT_CUBIC, 0.25f, 83.pixels)
                }
                utilityTimer = Timer().apply {
                    scheduleAtFixedRate(object : TimerTask() {
                        override fun run() {
                            HomeUtilityIcon.setColor(GuiUtils.rainbowColor.get())
                            UtilityText.setColor(GuiUtils.rainbowColor.get())
                        }
                    }, 0, 50)
                }
            }
        }
        //
        val HomeWorldClickArea = UIBlock().constrain {
            color = Color(31, 30, 31, 0).constraint
            x = (50 / scalefactor).pixels(alignOpposite = false)
            y = (305 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (52 / scalefactor).pixels()
        } childOf window
        var worldIsTransparent = true
        var worldTimer: Timer? = null
        HomeWorldClickArea.onMouseClick {
            worldIsTransparent = !worldIsTransparent
            HomeWorldColorChangeArea.setColor(if (worldIsTransparent) Color(31, 30, 31, 0) else Color(31, 30, 31, 255))
            println("World Clicked")
            if (worldIsTransparent) {
                WorldText.setColor(Color.WHITE)
                HomeWorldIcon.setColor(Color.WHITE)
                worldTimer?.cancel()
                worldTimer = null
                Worldcontainer.hide()
                ArrowWorld.animate {
                    setXAnimation(Animations.IN_OUT_CUBIC, 0.25f, 89.pixels)
                }
            } else {
                Worldcontainer.unhide()
                ArrowWorld.animate {
                    setXAnimation(Animations.IN_OUT_CUBIC, 0.25f, 83.pixels)
                }
                worldTimer = Timer().apply {
                    scheduleAtFixedRate(object : TimerTask() {
                        override fun run() {
                            HomeWorldIcon.setColor(GuiUtils.rainbowColor.get())
                            WorldText.setColor(GuiUtils.rainbowColor.get())
                        }
                    }, 0, 50)
                }
            }
        }
        //
        val HomeInventoryClickArea = UIBlock().constrain {
            color = Color(31, 30, 31, 0).constraint
            x = (50 / scalefactor).pixels(alignOpposite = false)
            y = (357 / scalefactor).pixels(alignOpposite = false)
            width = (290 / scalefactor).pixels()
            height = (52 / scalefactor).pixels()
        } childOf window
        var inventoryIsTransparent = true
        var inventoryTimer: Timer? = null
        HomeInventoryClickArea.onMouseClick {
            inventoryIsTransparent = !inventoryIsTransparent
            HomeInventoryColorChangeArea.setColor(if (inventoryIsTransparent) Color(31, 30, 31, 0) else Color(31, 30, 31, 255))
            println("Inventory Clicked")
            if (inventoryIsTransparent) {
                InventoryText.setColor(Color.WHITE)
                HomeInventoryIcon.setColor(Color.WHITE)
                inventoryTimer?.cancel()
                inventoryTimer = null
                Inventorycontainer.hide()
                ArrowInventory.animate {
                    setXAnimation(Animations.IN_OUT_CUBIC, 0.25f, 89.pixels)
                }
            } else {
                Inventorycontainer.unhide()
                ArrowInventory.animate {
                    setXAnimation(Animations.IN_OUT_CUBIC, 0.25f, 83.pixels)
                }
                inventoryTimer = Timer().apply {
                    scheduleAtFixedRate(object : TimerTask() {
                        override fun run() {
                            HomeInventoryIcon.setColor(GuiUtils.rainbowColor.get())
                            InventoryText.setColor(GuiUtils.rainbowColor.get())
                        }
                    }, 0, 50)
                }
            }
        }

    }
}
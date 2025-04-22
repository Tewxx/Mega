package com.github.tewxx.mega.events

import gg.essential.elementa.ElementaVersion
import gg.essential.elementa.components.*
import gg.essential.elementa.dsl.*
import org.afterlike.slumber.util.SlumberFonts
import java.awt.Color
import java.net.URL
import java.util.*

class TARGETHUD {
    val window = Window(ElementaVersion.V2)
    private val scalefactor = 2.5

    // Create a container to hold all HUD components
    private val hudContainer = UIContainer().constrain {
        x = (1345 / scalefactor).pixels()
        y = (803 / scalefactor).pixels()
        width = (288 / scalefactor).pixels()
        height = (105 / scalefactor).pixels()
    }.childOf(window)

    private val back = UIRoundedRectangle(4f).constrain {
        width = (288 / scalefactor).pixels()
        height = (105 / scalefactor).pixels()
        color = Color(38, 38, 38, 33).constraint
    }.childOf(hudContainer)

    private val progressBarBack = UIRoundedRectangle(3f).constrain {
        x = (24 / scalefactor).pixels()
        y = (67 / scalefactor).pixels()
        width = (240 / scalefactor).pixels()
        height = (9 / scalefactor).pixels()
        color = Color(27, 27, 27).constraint
    }.childOf(hudContainer)

    private val progressBarHealth = UIRoundedRectangle(3f).constrain {
        x = (24 / scalefactor).pixels()
        y = (67 / scalefactor).pixels()
        width = (240 / scalefactor).pixels()
        height = (9 / scalefactor).pixels()
        color = Color(0, 151, 117).constraint
    }.childOf(hudContainer)

    // Add text to display the player's name
    private val playerNameText = UIText("", shadow = false)
        .apply {
            setFontProvider(SlumberFonts.PROXIMA_NOVA)
        }
        .constrain {
            x = (70 / scalefactor).pixels(alignOpposite = false)
            y = (32 / scalefactor).pixels(alignOpposite = false)
            color = Color.WHITE.constraint
            width = (64 / scalefactor).pixels()
            height = (24 / scalefactor).pixels()
        } childOf hudContainer

    private val playerHeadImage = UIImage.ofURL(URL("https://minotar.net/avatar/PlayerName/29")).constrain {
            x = (1369/ scalefactor).pixels()
            y = (823 / scalefactor).pixels()
            width = (29 / scalefactor).pixels()
            height = (29 / scalefactor).pixels()
        } childOf hudContainer

    init {
        hideAll()
    }

    fun hideAll() {
        hudContainer.hide()
    }

    fun showAll() {
        hudContainer.unhide()
    }

    fun showForDuration(duration: Long, playerName: String) {
        val characterWidth = 14 // Width per character in pixels
        val calculatedWidth = (playerName.length * characterWidth) / scalefactor // Adjust for scale factor

        playerNameText.constrain {
            width = calculatedWidth.pixels() // Dynamically set the width
        }
        playerNameText.setText(playerName) // Update the text with the player's name
        showAll()
        Timer().schedule(object : TimerTask() {
            override fun run() {
                hideAll()
            }
        }, duration)
    }}
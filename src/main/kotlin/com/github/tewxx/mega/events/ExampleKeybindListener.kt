package com.github.tewxx.mega.events

import net.minecraft.client.Minecraft
import net.minecraft.client.settings.KeyBinding
import net.minecraftforge.fml.client.registry.ClientRegistry
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.InputEvent
import net.minecraftforge.fml.common.gameevent.TickEvent
import net.minecraftforge.common.MinecraftForge
import org.lwjgl.input.Keyboard
import net.minecraftforge.client.event.RenderGameOverlayEvent

class ExampleKeybindListener {
    private val exampleKeybind = KeyBinding("ClickGUI", Keyboard.KEY_RSHIFT, "ClickGUI").also {
        ClientRegistry.registerKeyBinding(it)
    }

    // Create instances of your GUI classes
    private val gui = GUI()
    private val targetHUD = TARGETHUD()

    // Set this to true to always show the Target HUD
    private var showTargetHUD = true // <-- Changed to true

    init {
        // Register this class to the Forge event bus
        MinecraftForge.EVENT_BUS.register(this)
    }

    @SubscribeEvent
    fun onKeyPress(event: InputEvent.KeyInputEvent) {
        if (exampleKeybind.isPressed) {
            val mc = Minecraft.getMinecraft()
            mc.displayGuiScreen(gui)
        }
    }

    @SubscribeEvent
    fun onClientTick(event: TickEvent.ClientTickEvent) {
        // You can add logic here to toggle the HUD if needed
        // For example, only when targeting an entity
    }

    @SubscribeEvent
    fun onRenderOverlay(event: RenderGameOverlayEvent.Post) {
        if (showTargetHUD) {
            targetHUD.window.draw()
        }
    }

    @SubscribeEvent
    fun onAttack(event: net.minecraftforge.event.entity.player.AttackEntityEvent) {
        if (event.target is net.minecraft.entity.player.EntityPlayer) {
            val playerName = event.target.name // Get the player's name
            println("Attacking player: $playerName") // Print the name to the console
            targetHUD.showForDuration(1000, playerName) // Pass the playerName to the method
        }
    }
}
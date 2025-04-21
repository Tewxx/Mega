package com.github.tewxx.mega.events

import net.minecraft.client.Minecraft
import net.minecraft.client.settings.KeyBinding
import net.minecraftforge.fml.client.registry.ClientRegistry
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.InputEvent
import org.lwjgl.input.Keyboard

class ExampleKeybindListener {

    private val exampleKeybind = KeyBinding("ClickGUI", Keyboard.KEY_RSHIFT, "ClickGUI").also {
        ClientRegistry.registerKeyBinding(it)
    }

    @SubscribeEvent
    fun onKeyPress(event: InputEvent.KeyInputEvent) {
        if (exampleKeybind.isPressed) {
            val mc = Minecraft.getMinecraft()
            mc.displayGuiScreen(GUI())
        }
    }
}
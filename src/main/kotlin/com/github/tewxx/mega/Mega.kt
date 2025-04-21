package com.github.tewxx.mega

import com.github.tewxx.mega.commands.ExampleCommand
import com.github.tewxx.mega.events.ExampleKeybindListener
import net.minecraftforge.client.ClientCommandHandler
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import org.afterlike.slumber.util.SlumberFontRenderer

@Mod(modid = "mega", useMetadata = true)
class Mega {
    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        // Register command
        ClientCommandHandler.instance.registerCommand(ExampleCommand())

        // Register keybind listener
        MinecraftForge.EVENT_BUS.register(ExampleKeybindListener())

        // Init custom renderer
        SlumberFontRenderer.initShaders()

        println("Mega mod initialized")
    }
}
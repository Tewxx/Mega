package com.github.tewxx.mega;

import com.github.tewxx.mega.commands.ExampleCommand;
import com.github.tewxx.mega.events.ExampleKeybindListener;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "mega", useMetadata=true)
public class ExampleMod {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new ExampleCommand());
        MinecraftForge.EVENT_BUS.register(new ExampleKeybindListener());
    }
}

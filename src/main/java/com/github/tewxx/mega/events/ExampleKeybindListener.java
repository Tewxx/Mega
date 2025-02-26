package com.github.tewxx.mega.events;

import gg.essential.api.utils.GuiUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;
import com.github.tewxx.mega.events.GUI;
import java.io.IOException;

public class ExampleKeybindListener {

    private final KeyBinding exampleKeybind = new KeyBinding("ClickGUI", Keyboard.KEY_RSHIFT, "ClickGUI");

    public ExampleKeybindListener() {
        ClientRegistry.registerKeyBinding(exampleKeybind);
    }

    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent event) {
        // this method runs everytime a key on the keyboard is pressed / unpressed

        if (exampleKeybind.isPressed()) {
            // Open GUI
            GuiUtil.open(new GUI());
            //Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Showing Color Selection GUI"));
        }
    }
}
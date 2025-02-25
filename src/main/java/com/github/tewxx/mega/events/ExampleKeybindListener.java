package com.github.tewxx.mega.events;

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

import java.io.IOException;
@SuppressWarnings("unused")

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
            Minecraft.getMinecraft().displayGuiScreen(new ColorSelectionGui());
            //Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Showing Color Selection GUI"));
        }
    }

    // Actual GUI
    public class ColorSelectionGui extends GuiScreen {
        private int lastClickedButton = 0;

        @Override
        public void initGui() {
            super.initGui();
            // Add buttons to the gui list during gui initialization
            this.buttonList.add(new GuiButton(0, width / 2 - 55, height / 2 - 10, 30, 20, "§cRED"));
            this.buttonList.add(new GuiButton(1, width / 2 - 15, height / 2 - 10, 30, 20, "§9BLUE"));
            this.buttonList.add(new GuiButton(2, width / 2 + 25, height / 2 - 10, 30, 20, "§2GREEN"));
        }

        @Override
        protected void actionPerformed(GuiButton button) throws IOException {
            // When a button is clicked saved that last id (or do something else based on the id)
            lastClickedButton = button.id;

            // Send a chat message showing which color was selected
            String colorName = "";
            switch (button.id) {
                case 0:
                    colorName = "§cRED";
                    break;
                case 1:
                    colorName = "§9BLUE";
                    break;
                case 2:
                    colorName = "§2GREEN";
                    break;
            }

            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Selected color: " + colorName));
        }

        @Override
        public void drawScreen(int mouseX, int mouseY, float partialTicks) {
            // Draw the background tint
            drawDefaultBackground();
            //VapeHud
            Minecraft minecraft = Minecraft.getMinecraft();
            minecraft.getTextureManager().bindTexture(new ResourceLocation("examplemod", "textures/gui/textvape.png"));
            drawModalRectWithCustomSizedTexture(
                    200, 20,
                    0, 0,
                    59, 16,
                    59, 16
            );
            // Find the last selected color
            int color = 0;
            if (lastClickedButton == 0) {
                color = 0xFFFF0000; // RED
            } else if (lastClickedButton == 1) {
                color = 0xFF0000FF; // BLUE
            } else if (lastClickedButton == 2) {
                color = 0xFF00FF00; // GREEN
            }

            // Draw a colorful rectangle
            drawGradientRect(width / 2 - 65, height / 2 - 20, width / 2 + 65, height / 2 + 20, color, color);

            // Draw buttons
            super.drawScreen(mouseX, mouseY, partialTicks);
        }

        // Allow closing the GUI with escape key
        @Override
        public boolean doesGuiPauseGame() {
            return false;
        }
    }
}
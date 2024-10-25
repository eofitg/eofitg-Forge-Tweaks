package com.eofitg.eofitgtweaks.event;

import com.eofitg.eofitgtweaks.service.AutoJump;
import com.eofitg.eofitgtweaks.service.AntiAntiAFK;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class KeyBindListener {

    private final KeyBinding autoJumpKeyBind = new KeyBinding("Auto Jump", Keyboard.KEY_T, "EofitgTweaks");
    private final KeyBinding antiAntiAFKKeyBind = new KeyBinding("Anti Anti-AFK", Keyboard.KEY_TAB, "EofitgTweaks");

    private final AutoJump autoJumpService = new AutoJump();
    private final AntiAntiAFK antiAntiAFKService = new AntiAntiAFK();

    public KeyBindListener() {
        // register key-bind for it to show up in the settings menu
        ClientRegistry.registerKeyBinding(autoJumpKeyBind);
        ClientRegistry.registerKeyBinding(antiAntiAFKKeyBind);
    }

    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent event) {
        // this method runs everytime a key on the keyboard is pressed / unpressed

        if (autoJumpKeyBind.isPressed()) { // using isPressed() will return true once when the key is pressed
            autoJumpService.toggle();
        }
        if (antiAntiAFKKeyBind.isPressed()) {
            antiAntiAFKService.toggle();
        }

    }
}

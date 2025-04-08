package com.guideal.guidclient.controllers;

import com.mojang.blaze3d.platform.InputConstants;
import com.guideal.guidclient.common.Events;
import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.configs.KeyBindingsConfig;
import com.guideal.guidclient.common.IKeyBindingRegistry;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;

public class KeyBindingsController {

    public static final KeyBindingsController instance = new KeyBindingsController();

    public final KeyMapping[] keys;

    private final Minecraft mc = Minecraft.getInstance();
    private final Runnable[] actions = new Runnable[KeyBindingsConfig.KeysCount];

    private KeyBindingsController() {
        keys = new KeyMapping[KeyBindingsConfig.KeysCount];
        for (int i = 0; i < keys.length; i++) {
            keys[i] = new KeyMapping("key.guideal.guidclient.reserved" + i, InputConstants.UNKNOWN.getValue(), "category.guideal.guidclient");
        }

        Events.RegisterKeyBindings.add(this::onRegisterKeyBindings);
        Events.AfterHandleKeyBindings.add(this::onHandleKeyBindings);
    }

    public void assign(int index, String name) {
        String[] bindings = ConfigStore.instance.getConfig().keyBindingsConfig.bindings;
        for (int i = 0; i < bindings.length; i++) {
            if (bindings[i] != null && bindings[i].equals(name)) {
                actions[i] = null;
                bindings[i] = null;
            }
        }

        if (0 <= index && index < KeyBindingsConfig.KeysCount) {
            Runnable compiled = ScriptController.instance.get(name);
            if (compiled == null) {
                actions[index] = null;
                bindings[index] = null;
            } else {
                actions[index] = compiled;
                bindings[index] = name;
            }
        }
    }

    private void onHandleKeyBindings() {
        if (mc.player == null) {
            return;
        }

        for (int i = 0; i < keys.length; i++) {
            KeyMapping key = keys[i];
            Runnable action = actions[i];
            while (key.consumeClick()) {
                if (action != null) {
                    action.run();
                }
            }
        }
    }

    private void onRegisterKeyBindings(IKeyBindingRegistry registry) {
        for (int i = 0; i < keys.length; i++) {
            registry.register(keys[i]);
        }
    }
}
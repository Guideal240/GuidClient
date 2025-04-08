package com.guideal.guidclient.modules.scripting;

import com.guideal.guidclient.common.Events;
import com.guideal.guidclient.common.events.SendChatEvent;
import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.controllers.ScriptController;
import com.guideal.guidclient.modules.Module;
import com.guideal.guidclient.scripting.compiler.ScriptCompileException;
import com.guideal.guidclient.scripting.generated.ParseException;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;

public class Exec implements Module {

    public static final Exec instance = new Exec();

    private Exec() {
        Events.SendChat.add(this::onSendChat);
    }

    private void onSendChat(SendChatEvent event) {
        if (!ConfigStore.instance.getConfig().execConfig.enabled) {
            return;
        }

        if (event.getMessage().startsWith(".")) {
            try {
                Runnable code = ScriptController.instance.compileKeys(event.getMessage().substring(1));
                code.run();
                systemMessage("OK", 0xFF80FF80);
            }
            catch (ScriptCompileException | ParseException e) {
                systemMessage(e.getMessage(), 0xFFFF8080);
            }

            event.cancel();
        }
    }

    private void systemMessage(String message, int color) {
        Minecraft.getInstance().getChatListener().handleSystemMessage(Component.literal(message).withStyle(Style.EMPTY.withColor(color)), false);
    }
}
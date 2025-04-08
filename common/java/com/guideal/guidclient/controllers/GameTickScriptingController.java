package com.guideal.guidclient.controllers;

import com.guideal.guidclient.common.Events;
import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.configs.GameTickScriptingConfig;

public class GameTickScriptingController {

    public static final GameTickScriptingController instance = new GameTickScriptingController();

    private Runnable script;

    private GameTickScriptingController() {
        Events.BeforeHandleKeyBindings.add(this::onHandleKeyBindings);
    }

    public void setScript(Runnable script) {
        this.script = script;
    }

    private void onHandleKeyBindings() {
        GameTickScriptingConfig config = ConfigStore.instance.getConfig().gameTickScriptingConfig;
        if (config.enabled && script != null) {
            script.run();
        }
    }
}
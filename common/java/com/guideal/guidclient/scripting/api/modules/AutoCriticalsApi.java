package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.configs.AutoCriticalsConfig;
import com.guideal.guidclient.configs.ConfigStore;

public class AutoCriticalsApi extends ModuleApi<AutoCriticalsConfig> {

    @Override
    protected AutoCriticalsConfig getConfig() {
        return ConfigStore.instance.getConfig().autoCriticalsConfig;
    }
}
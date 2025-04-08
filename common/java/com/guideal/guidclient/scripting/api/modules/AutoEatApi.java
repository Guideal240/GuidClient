package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.configs.AutoEatConfig;
import com.guideal.guidclient.configs.ConfigStore;

public class AutoEatApi extends ModuleApi<AutoEatConfig> {

    @Override
    protected AutoEatConfig getConfig() {
        return ConfigStore.instance.getConfig().autoEatConfig;
    }
}
package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.configs.NoFallConfig;

public class NoFallApi extends ModuleApi<NoFallConfig> {

    @Override
    protected NoFallConfig getConfig() {
        return ConfigStore.instance.getConfig().noFallConfig;
    }
}
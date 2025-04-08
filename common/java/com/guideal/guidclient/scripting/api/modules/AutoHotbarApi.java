package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.configs.AutoHotbarConfig;
import com.guideal.guidclient.configs.ConfigStore;

public class AutoHotbarApi extends ModuleApi<AutoHotbarConfig> {

    @Override
    protected AutoHotbarConfig getConfig() {
        return ConfigStore.instance.getConfig().autoHotbarConfig;
    }
}
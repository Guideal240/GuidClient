package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.configs.AutoCraftConfig;
import com.guideal.guidclient.configs.ConfigStore;

public class AutoCraftApi extends ModuleApi<AutoCraftConfig> {

    @Override
    protected AutoCraftConfig getConfig() {
        return ConfigStore.instance.getConfig().autoCraftConfig;
    }
}
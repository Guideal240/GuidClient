package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.configs.ScaffoldConfig;

public class ScaffoldApi extends ModuleApi<ScaffoldConfig> {

    @Override
    protected ScaffoldConfig getConfig() {
        return ConfigStore.instance.getConfig().scaffoldConfig;
    }
}
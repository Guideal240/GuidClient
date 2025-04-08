package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.configs.FastBreakConfig;

public class FastBreakApi extends ModuleApi<FastBreakConfig> {

    @Override
    protected FastBreakConfig getConfig() {
        return ConfigStore.instance.getConfig().fastBreakConfig;
    }
}
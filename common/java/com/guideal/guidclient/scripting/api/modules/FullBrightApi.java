package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.configs.FullBrightConfig;

public class FullBrightApi extends ModuleApi<FullBrightConfig> {

    @Override
    protected FullBrightConfig getConfig() {
        return ConfigStore.instance.getConfig().fullBrightConfig;
    }
}
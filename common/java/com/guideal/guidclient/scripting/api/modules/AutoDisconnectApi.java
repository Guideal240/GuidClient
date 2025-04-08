package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.configs.AutoDisconnectConfig;
import com.guideal.guidclient.configs.ConfigStore;

public class AutoDisconnectApi extends ModuleApi<AutoDisconnectConfig> {

    @Override
    protected AutoDisconnectConfig getConfig() {
        return ConfigStore.instance.getConfig().autoDisconnectConfig;
    }
}
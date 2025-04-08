package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.configs.ElytraHackConfig;

public class ElytraHackApi extends ModuleApi<ElytraHackConfig> {

    @Override
    protected ElytraHackConfig getConfig() {
        return ConfigStore.instance.getConfig().elytraHackConfig;
    }
}
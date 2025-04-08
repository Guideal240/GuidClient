package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.configs.FlyHackConfig;

public class FlyHackApi extends ModuleApi<FlyHackConfig> {

    @Override
    protected FlyHackConfig getConfig() {
        return ConfigStore.instance.getConfig().flyHackConfig;
    }
}
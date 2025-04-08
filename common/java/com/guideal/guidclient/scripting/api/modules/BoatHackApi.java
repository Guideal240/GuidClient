package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.configs.BoatHackConfig;
import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.scripting.api.ApiType;
import com.guideal.guidclient.scripting.api.ApiVisibility;

public class BoatHackApi {

    public boolean isFlyEnabled() {
        return getConfig().fly;
    }

    @ApiVisibility(ApiType.UPDATE)
    public void toggleFly() {
        BoatHackConfig config = getConfig();
        config.fly = !config.fly;
        ConfigStore.instance.requestWrite();
    }

    private BoatHackConfig getConfig() {
        return ConfigStore.instance.getConfig().boatHackConfig;
    }
}
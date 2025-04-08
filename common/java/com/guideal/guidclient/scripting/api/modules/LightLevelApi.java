package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.configs.LightLevelConfig;
import com.guideal.guidclient.modules.esp.LightLevel;

public class LightLevelApi extends ModuleApi<LightLevelConfig> {

    @Override
    protected LightLevelConfig getConfig() {
        return ConfigStore.instance.getConfig().lightLevelConfig;
    }

    @Override
    protected void onEnableChanged() {
        LightLevel.instance.onChanged();
    }
}
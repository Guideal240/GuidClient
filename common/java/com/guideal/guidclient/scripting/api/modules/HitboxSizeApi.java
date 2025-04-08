package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.configs.HitboxSizeConfig;

public class HitboxSizeApi extends ModuleApi<HitboxSizeConfig> {

    @Override
    protected HitboxSizeConfig getConfig() {
        return ConfigStore.instance.getConfig().hitboxSizeConfig;
    }
}
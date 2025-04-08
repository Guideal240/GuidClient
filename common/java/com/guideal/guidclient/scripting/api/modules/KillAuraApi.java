package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.configs.KillAuraConfig;

public class KillAuraApi extends ModuleApi<KillAuraConfig> {

    @Override
    protected KillAuraConfig getConfig() {
        return ConfigStore.instance.getConfig().killAuraConfig;
    }
}
package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.configs.ShulkerTooltipConfig;

public class ShulkerTooltipApi extends ModuleApi<ShulkerTooltipConfig> {

    @Override
    protected ShulkerTooltipConfig getConfig() {
        return ConfigStore.instance.getConfig().shulkerTooltipConfig;
    }
}
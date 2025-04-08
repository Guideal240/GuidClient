package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.configs.AutoBucketConfig;
import com.guideal.guidclient.configs.ConfigStore;

public class AutoBucketApi extends ModuleApi<AutoBucketConfig> {

    @Override
    protected AutoBucketConfig getConfig() {
        return ConfigStore.instance.getConfig().autoBucketConfig;
    }
}
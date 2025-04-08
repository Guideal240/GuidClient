package com.guideal.guidclient.configs;

import com.guideal.guidclient.collections.ImmutableList;

public class EntitiesConfig {

    public ImmutableList<EntityTracerConfig> configs = new ImmutableList<>();

    public void add(EntityTracerConfig config) {
        configs = configs.add(config);
    }

    public void remove(EntityTracerConfig config) {
        configs = configs.remove(config);
    }
}
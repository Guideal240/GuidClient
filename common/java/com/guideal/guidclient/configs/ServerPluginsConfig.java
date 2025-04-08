package com.guideal.guidclient.configs;

import com.guideal.guidclient.utils.MathUtils;

public class ServerPluginsConfig implements ValidatableConfig {

    public int waitTicks;
    public boolean autoPrint;

    public ServerPluginsConfig() {
        waitTicks = 20;
    }

    @Override
    public void validate() {
        waitTicks = MathUtils.clamp(waitTicks, 0, 60 * 20);
    }
}
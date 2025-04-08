package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.configs.ModuleConfig;
import com.guideal.guidclient.scripting.api.ApiVisibility;
import com.guideal.guidclient.scripting.api.ApiType;

public abstract class ModuleApi<T extends ModuleConfig> {

    public boolean isEnabled() {
        return getConfig().enabled;
    }

    @ApiVisibility(ApiType.UPDATE)
    public void enable() {
        var config = getConfig();
        if (!config.enabled) {
            config.enabled = true;
            onEnableChanged();
            ConfigStore.instance.requestWrite();
        }
    }

    @ApiVisibility(ApiType.UPDATE)
    public void disable() {
        var config = getConfig();
        if (config.enabled) {
            config.enabled = false;
            onEnableChanged();
            ConfigStore.instance.requestWrite();
        }
    }

    @ApiVisibility(ApiType.UPDATE)
    public void setEnabled(boolean value) {
        var config = getConfig();
        if (config.enabled != value) {
            config.enabled = value;
            onEnableChanged();
            ConfigStore.instance.requestWrite();
        }
    }

    @ApiVisibility(ApiType.UPDATE)
    public void toggle() {
        var config = getConfig();
        config.enabled = !config.enabled;
        onEnableChanged();
        ConfigStore.instance.requestWrite();
    }

    protected void onEnableChanged() {

    }

    protected abstract T getConfig();
}
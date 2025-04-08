package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.scripting.api.ApiVisibility;
import com.guideal.guidclient.scripting.api.ApiType;
import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.configs.MovementHackConfig;

import java.util.Locale;

public class MovementApi {

    public boolean isSpeedMultiplierEnabled() {
        var config = getConfig();
        return config.scaleInputVector;
    }

    public String getSpeedMultiplierFactor() {
        var config = getConfig();
        return String.format(Locale.ROOT, "%.3f", config.inputVectorFactor);
    }

    @ApiVisibility(ApiType.UPDATE)
    public void toggleSpeedMultiplier() {
        var config = getConfig();
        config.scaleInputVector = !config.scaleInputVector;
        ConfigStore.instance.requestWrite();
    }

    @ApiVisibility(ApiType.UPDATE)
    public void setSpeedMultiplierFactor(double value) {
        var config = getConfig();
        config.inputVectorFactor = value;
        config.validate();
        ConfigStore.instance.requestWrite();
    }

    public boolean isOverrideJumpHeightEnabled() {
        var config = getConfig();
        return config.scaleJumpHeight;
    }

    @ApiVisibility(ApiType.UPDATE)
    public void toggleOverrideJumpHeight() {
        var config = getConfig();
        config.scaleJumpHeight = !config.scaleJumpHeight;
        ConfigStore.instance.requestWrite();
    }

    public String getJumpFactor() {
        var config = getConfig();
        return String.format(Locale.ROOT, "%.3f", config.jumpHeightFactor);
    }

    @ApiVisibility(ApiType.UPDATE)
    public void setJumpFactor(double value) {
        var config = getConfig();
        config.jumpHeightFactor = value;
        config.validate();
        ConfigStore.instance.requestWrite();
    }

    private MovementHackConfig getConfig() {
        return ConfigStore.instance.getConfig().movementHackConfig;
    }
}
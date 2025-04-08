package com.guideal.guidclient.configs;

import com.guideal.guidclient.utils.MathUtils;

public class PerformanceConfig implements ValidatableConfig {

    public boolean limitBackgroundWindowFps;
    public int backgroundWindowFps;

    public PerformanceConfig() {
        backgroundWindowFps = 20;
    }

    @Override
    public void validate() {
        backgroundWindowFps = MathUtils.clamp(backgroundWindowFps, 1, 120);
    }
}
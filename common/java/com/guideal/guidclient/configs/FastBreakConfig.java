package com.guideal.guidclient.configs;

import com.guideal.guidclient.utils.MathUtils;

public class FastBreakConfig extends ModuleConfig implements ValidatableConfig {
    public double factor;

    public FastBreakConfig() {
        factor = 1.2;
    }

    public void validate() {
        factor = MathUtils.clamp(factor, 0.5, 10);
    }
}
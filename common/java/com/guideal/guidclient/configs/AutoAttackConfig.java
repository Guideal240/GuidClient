package com.guideal.guidclient.configs;

import com.guideal.guidclient.utils.MathUtils;

public class AutoAttackConfig extends ModuleConfig implements ValidatableConfig {
    public double extraTicks;

    @Override
    public void validate() {
        extraTicks = MathUtils.clamp( extraTicks, -10, 10);
    }
}
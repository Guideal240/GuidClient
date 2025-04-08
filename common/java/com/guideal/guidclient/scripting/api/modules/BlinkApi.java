package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.modules.hacks.Blink;
import com.guideal.guidclient.scripting.api.ApiType;
import com.guideal.guidclient.scripting.api.ApiVisibility;

public class BlinkApi {

    public boolean isEnabled() {
        return Blink.instance.isEnabled();
    }

    @ApiVisibility(ApiType.ACTION)
    public void enable() {
        Blink.instance.enable();
    }

    @ApiVisibility(ApiType.ACTION)
    public void disable() {
        Blink.instance.disable();
    }

    @ApiVisibility(ApiType.ACTION)
    public void apply() {
        Blink.instance.apply();
    }

    public double getDistance() {
        return Blink.instance.getDistance();
    }

    public int getPackets() {
        return Blink.instance.getPackets();
    }
}
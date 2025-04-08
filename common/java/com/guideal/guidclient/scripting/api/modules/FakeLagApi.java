package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.modules.hacks.FakeLag;
import com.guideal.guidclient.scripting.api.ApiVisibility;
import com.guideal.guidclient.scripting.api.ApiType;

public class FakeLagApi {

    @ApiVisibility(ApiType.UPDATE)
    public void enable() {
        if (!isEnabled()) {
            toggle();
        }
    }

    @ApiVisibility(ApiType.UPDATE)
    public void disable() {
        if (isEnabled()) {
            toggle();
        }
    }

    @ApiVisibility(ApiType.UPDATE)
    public void setEnabled(boolean value) {
        if (value) {
            enable();
        } else {
            disable();
        }
    }

    public boolean isEnabled() {
        return FakeLag.instance.isEnabled();
    }

    @ApiVisibility(ApiType.UPDATE)
    public void toggle() {
        FakeLag.instance.toggle();
    }
}
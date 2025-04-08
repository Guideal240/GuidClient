package com.guideal.guidclient.modules.visuals;

import com.guideal.guidclient.common.Events;
import com.guideal.guidclient.common.events.SetupFogEvent;
import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.configs.FogConfig;
import com.guideal.guidclient.modules.Module;

public class Fog implements Module {

    public static final Fog instance = new Fog();

    private Fog() {
        Events.SetupFog.add(this::onSetupFog);
    }

    public void onSetupFog(SetupFogEvent event) {
        FogConfig config = ConfigStore.instance.getConfig().fogConfig;
        if (config.disableFog && FogConfig.METHOD_MODIFY_FOG_DISTANCES.equals(config.method)) {
            event.setFogStart(10000);
            event.setFogEnd(1000000);
        }
    }
}
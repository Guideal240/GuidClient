package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.modules.visuals.Zoom;
import com.guideal.guidclient.scripting.api.ApiType;
import com.guideal.guidclient.scripting.api.ApiVisibility;

public class ZoomApi {

    @ApiVisibility(ApiType.UPDATE)
    public void start(double fov, double seconds) {
        if (fov < 0.01 || fov > 150) {
            return;
        }
        if (seconds > 10) {
            return;
        }
        Zoom.instance.startZooming(fov, seconds);
    }

    @ApiVisibility(ApiType.UPDATE)
    public void stop() {
        Zoom.instance.stopZooming();
    }
}
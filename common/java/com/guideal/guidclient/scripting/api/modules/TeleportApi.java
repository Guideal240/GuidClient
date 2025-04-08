package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.controllers.TeleportHackController;
import com.guideal.guidclient.scripting.api.ApiType;
import com.guideal.guidclient.scripting.api.ApiVisibility;
import com.guideal.guidclient.utils.MathUtils;

public class TeleportApi {

    @ApiVisibility(ApiType.ACTION)
    public boolean toCrosshair(double distance, int repeats) {
        distance = MathUtils.clamp(distance, 1, 1000);
        repeats = MathUtils.clamp(repeats, 0, 100);
        return TeleportHackController.instance.teleportToCrosshair(distance, repeats);
    }

    @ApiVisibility(ApiType.ACTION)
    public boolean vertical(double distance, int repeats) {
        distance = MathUtils.absClamp(distance, 1, 1000);
        repeats = MathUtils.clamp(repeats, 0, 100);
        return TeleportHackController.instance.verticalTeleport(distance, repeats);
    }

    @ApiVisibility(ApiType.ACTION)
    public boolean vertical(double fromDistance, double toDistance, boolean findSurface, int repeats) {
        fromDistance = MathUtils.absClamp(fromDistance, -1000, 1000);
        toDistance = MathUtils.absClamp(toDistance, -1000, 1000);
        repeats = MathUtils.clamp(repeats, 0, 100);
        return TeleportHackController.instance.verticalTeleport(fromDistance, toDistance, findSurface, repeats);
    }
}
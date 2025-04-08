package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.chunkoverlays.ExplorationMiniMapChunkOverlay;
import com.guideal.guidclient.controllers.ChunkOverlayController;
import com.guideal.guidclient.scripting.api.ApiType;
import com.guideal.guidclient.scripting.api.ApiVisibility;

public class ExplorationMiniMapApi {

    @ApiVisibility(ApiType.UPDATE)
    public void addMarker() {
        ChunkOverlayController.instance.ofType(ExplorationMiniMapChunkOverlay.class).addMarker();
    }
}
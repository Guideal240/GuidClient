package com.guideal.guidclient.controllers;

import com.guideal.guidclient.chunkoverlays.ExplorationMiniMapChunkOverlay;
import com.guideal.guidclient.chunkoverlays.NewChunksOverlay;
import com.guideal.guidclient.modules.esp.FreeCam;
import net.minecraft.client.Minecraft;

import java.text.DecimalFormat;
import java.util.List;

public class DebugScreenController {

    public static final DebugScreenController instance = new DebugScreenController();

    private final Minecraft mc = Minecraft.getInstance();
    private final DecimalFormat format = new DecimalFormat("0.00");

    private DebugScreenController() {

    }

    public void onGetGameInformation(List<String> list) {
        list.add("");
        list.add("GuidClient");
        list.add("Loaded chunks: " + ChunkController.instance.getLoadedChunksCount());
        list.add(String.format("BlockFinder scan thread: queue size=%s; load=%s; state=%s;",
                    BlockFinderController.instance.getScanningQueueCount(),
                    format.format(BlockFinderController.instance.getScanningThreadLoadPercent()) + "%",
                    BlockFinderController.instance.getThreadState()));

        ExplorationMiniMapChunkOverlay miniMapChunkOverlay = ChunkOverlayController.instance.ofType(ExplorationMiniMapChunkOverlay.class);
        list.add(String.format("ExplMiniMap scan thread: queue size=%s; state=%s;",
                miniMapChunkOverlay.getScanningQueueCount(),
                miniMapChunkOverlay.getThreadState()));

        NewChunksOverlay newChunksOverlay = ChunkOverlayController.instance.ofType(NewChunksOverlay.class);
        list.add(String.format("NewChunks scan thread: queue size=%s; state=%s;",
                newChunksOverlay.getScanningQueueCount(),
                newChunksOverlay.getThreadState()));

        FreeCam.instance.onRenderDebugScreenLeft(list);
    }

    public void onGetSystemInformation(List<String> list) {
        FreeCam.instance.onDebugScreenGetSystemInformation(list);
    }
}
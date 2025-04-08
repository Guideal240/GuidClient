package com.guideal.guidclient.modules.hacks;

import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.configs.FlyHackConfig;
import com.guideal.guidclient.controllers.NetworkPacketsController;
import com.guideal.guidclient.accessors.ServerboundMovePlayerPacketAccessor;
import com.guideal.guidclient.modules.Module;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket;

public class FlyHack implements Module {

    public static final FlyHack instance = new FlyHack();

    private FlyHack() {
        NetworkPacketsController.instance.addClientPacketHandler(this::onClientPacket);
    }

    private void onClientPacket(NetworkPacketsController.ClientPacketArgs args) {
        if (args.packet instanceof ServerboundMovePlayerPacket packet) {
            FlyHackConfig config = ConfigStore.instance.getConfig().flyHackConfig;
            if (config.enabled) {
                ((ServerboundMovePlayerPacketAccessor) packet).setOnGround_CU(config.onGroundFlag);
            }
        }
    }
}
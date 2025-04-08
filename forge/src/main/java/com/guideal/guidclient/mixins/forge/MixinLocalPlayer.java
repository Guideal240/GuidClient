package com.guideal.guidclient.mixins.forge;

import com.mojang.authlib.GameProfile;
import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.configs.ReachConfig;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LocalPlayer.class)
public abstract class MixinLocalPlayer extends AbstractClientPlayer {

    public MixinLocalPlayer(ClientLevel p_250460_, GameProfile p_249912_) {
        super(p_250460_, p_249912_);
    }

    @Override
    public double getBlockReach() {
        ReachConfig config = ConfigStore.instance.getConfig().reachConfig;
        if (config.overrideReachDistance) {
            return config.reachDistance;
        } else {
            return super.getBlockReach();
        }
    }

    @Override
    public double getEntityReach() {
        ReachConfig config = ConfigStore.instance.getConfig().reachConfig;
        if (config.overrideAttackRange) {
            return config.attackRange;
        } else {
            return super.getEntityReach();
        }
    }
}
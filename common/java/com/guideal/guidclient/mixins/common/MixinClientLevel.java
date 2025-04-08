package com.guideal.guidclient.mixins.common;

import com.guideal.guidclient.common.Events;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientLevel.class)
public abstract class MixinClientLevel {

    @Inject(at = @At("HEAD"), method = "addPlayer(ILnet/minecraft/client/player/AbstractClientPlayer;)V")
    private void onAddPlayer(int id, AbstractClientPlayer player, CallbackInfo info) {
        Events.PlayerAdded.trigger(player);
    }
}
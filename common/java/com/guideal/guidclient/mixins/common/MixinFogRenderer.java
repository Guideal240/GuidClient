package com.guideal.guidclient.mixins.common;

import com.mojang.blaze3d.systems.RenderSystem;
import com.guideal.guidclient.common.Events;
import com.guideal.guidclient.common.events.SetupFogEvent;
import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.configs.FogConfig;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.FogRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FogRenderer.class)
public abstract class MixinFogRenderer {

    @Inject(at = @At("HEAD"), method = "setupFog(Lnet/minecraft/client/Camera;Lnet/minecraft/client/renderer/FogRenderer$FogMode;FZF)V", cancellable = true)
    private static void onSetupFog(Camera livingentity, FogRenderer.FogMode mobeffectinstance, float localplayer, boolean holder, float f, CallbackInfo info) {
        FogConfig config = ConfigStore.instance.getConfig().fogConfig;
        if (config.disableFog && FogConfig.METHOD_SKIP_SETUP_FOG.equals(config.method)) {
            info.cancel();
        }
    }

    @Inject(at = @At("TAIL"), method = "setupFog(Lnet/minecraft/client/Camera;Lnet/minecraft/client/renderer/FogRenderer$FogMode;FZF)V")
    private static void onAfterSetupFog(Camera livingentity, FogRenderer.FogMode mobeffectinstance, float localplayer, boolean holder, float f, CallbackInfo info) {
        float start = RenderSystem.getShaderFogStart();
        float end = RenderSystem.getShaderFogEnd();
        SetupFogEvent event = new SetupFogEvent(start, end);
        Events.SetupFog.trigger(event);
        if (start != event.getFogStart()) {
            RenderSystem.setShaderFogStart(event.getFogStart());
        }
        if (end != event.getFogEnd()) {
            RenderSystem.setShaderFogEnd(event.getFogEnd());
        }
    }
}
package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.common.Registries;
import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.configs.FreeCamConfig;
import com.guideal.guidclient.modules.esp.FreeCam;
import com.guideal.guidclient.scripting.api.ApiVisibility;
import com.guideal.guidclient.scripting.api.ApiType;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.Locale;

public class FreeCamApi {

    private final Minecraft mc = Minecraft.getInstance();

    public boolean isEnabled() {
        return FreeCam.instance.isActive();
    }

    public String getCoordinates() {
        FreeCam fc = FreeCam.instance;
        if (fc.isActive()) {
            return String.format(Locale.ROOT, "%.3f / %.5f / %.3f", fc.getX(), fc.getY(), fc.getZ());
        } else {
            return "";
        }
    }

    public String getTargetBlockCoordinates() {
        if (mc.level == null || !FreeCam.instance.isActive()) {
            return "";
        }

        HitResult hitResult = FreeCam.instance.getHitResult();
        if (hitResult == null) {
            return "";
        }

        if (hitResult.getType() == HitResult.Type.BLOCK) {
            BlockPos blockPos = ((BlockHitResult) hitResult).getBlockPos();
            return blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ();
        } else {
            return "";
        }
    }

    public String getTargetBlockName() {
        if (mc.level == null || !FreeCam.instance.isActive()) {
            return "";
        }

        HitResult hitResult = FreeCam.instance.getHitResult();
        if (hitResult == null) {
            return "";
        }

        if (hitResult.getType() == HitResult.Type.BLOCK) {
            BlockPos blockPos = ((BlockHitResult) hitResult).getBlockPos();
            BlockState blockState = mc.level.getBlockState(blockPos);
            return Registries.BLOCKS.getKey(blockState.getBlock()).toString();
        } else {
            return "";
        }
    }

    @ApiVisibility(ApiType.UPDATE)
    public void toggle() {
        FreeCam.instance.toggle();
    }

    @ApiVisibility(ApiType.UPDATE)
    public void toggleRenderHands() {
        var config = getConfig();
        config.renderHands = !config.renderHands;
        ConfigStore.instance.requestWrite();
    }

    @ApiVisibility(ApiType.UPDATE)
    public void setRenderHands(boolean value) {
        var config = getConfig();
        config.renderHands = value;
        ConfigStore.instance.requestWrite();
    }

    @ApiVisibility(ApiType.UPDATE)
    public void startPath() {
        FreeCam.instance.startPath();
    }

    private FreeCamConfig getConfig() {
        return ConfigStore.instance.getConfig().freeCamConfig;
    }
}
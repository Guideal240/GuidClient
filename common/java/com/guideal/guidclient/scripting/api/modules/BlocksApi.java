package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.common.Registries;
import com.guideal.guidclient.configs.BlockTracerConfig;
import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.scripting.api.ApiType;
import com.guideal.guidclient.scripting.api.ApiVisibility;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class BlocksApi {

    public boolean isEnabled(String blockId) {
        var config = getConfig(blockId);
        if (config == null) {
            return false;
        }
        return config.enabled;
    }

    @ApiVisibility(ApiType.UPDATE)
    public void toggle(String blockId) {
        var config = getConfig(blockId);
        if (config == null) {
            return;
        }

        config.enabled = !config.enabled;
        ConfigStore.instance.requestWrite();
    }

    private BlockTracerConfig getConfig(String blockId) {
        ResourceLocation location = new ResourceLocation(blockId);
        Block block = Registries.BLOCKS.getValue(location);
        if (block == null) {
            return null;
        }

        return ConfigStore.instance.getConfig().blocks.configs.stream()
                .filter(c -> c.block == block)
                .findFirst()
                .orElse(null);
    }
}
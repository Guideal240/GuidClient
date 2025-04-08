package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.common.Registries;
import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.configs.EntityTracerConfig;
import com.guideal.guidclient.scripting.api.ApiVisibility;
import com.guideal.guidclient.scripting.api.ApiType;
import com.guideal.guidclient.utils.EntityUtils;
import com.guideal.guidclient.wrappers.ClassRemapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

public class EntitiesApi {

    public boolean isEnabled(String className) {
        var config = getConfig(className);
        if (config == null) {
            return false;
        }
        return config.enabled;
    }

    @ApiVisibility(ApiType.UPDATE)
    public void toggle(String className) {
        var config = getConfig(className);
        if (config == null) {
            return;
        }
        config.enabled = !config.enabled;
        ConfigStore.instance.requestWrite();
    }

    @SuppressWarnings("unchecked")
    public int getCount(String className) {
        EntityUtils.EntityInfo info = EntityUtils.getEntityClass(ClassRemapper.toObf(className));
        if (info == null) {
            return Integer.MIN_VALUE;
        }

        ClientLevel level = Minecraft.getInstance().level;
        if (level == null) {
            return 0;
        }

        int count = 0;
        for (Entity entity: level.entitiesForRendering()) {
            if (info.clazz.isAssignableFrom(entity.getClass())) {
                count++;
            }
        }

        return count;
    }

    public int getCountById(String id) {
        ResourceLocation location = new ResourceLocation(id);
        EntityType<?> type = Registries.ENTITY_TYPES.getValue(location);
        if (type == null) {
            return Integer.MIN_VALUE;
        }

        ClientLevel level = Minecraft.getInstance().level;
        if (level == null) {
            return 0;
        }

        int count = 0;
        for (Entity entity: level.entitiesForRendering()) {
            if (entity.getType() == type) {
                count++;
            }
        }

        return count;
    }

    private EntityTracerConfig getConfig(String className) {
        var list = ConfigStore.instance.getConfig().entities.configs;
        return list.stream()
                .filter(c -> c.clazz.getName().equals(ClassRemapper.toObf(className)))
                .findFirst()
                .orElse(null);
    }
}
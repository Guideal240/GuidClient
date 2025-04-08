package com.guideal.guidclient.utils;

import com.guideal.guidclient.mixins.common.accessors.KeyMappingAccessor;
import net.minecraft.client.KeyMapping;

public class KeyUtils {

    public static void click(KeyMapping mapping) {
        KeyMapping.click(((KeyMappingAccessor) mapping).getKey_CU());
    }
}
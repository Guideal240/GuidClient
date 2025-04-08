package com.guideal.guidclient.wrappers;

import net.minecraft.client.Minecraft;

public class PickRange {

    public static double get() {
        return Minecraft.getInstance().player.getBlockReach();
    }
}
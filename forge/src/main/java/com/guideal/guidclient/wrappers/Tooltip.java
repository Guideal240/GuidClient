package com.guideal.guidclient.wrappers;

import com.guideal.guidclient.mixins.forge.accessors.GuiGraphicsAccessor;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;

public class Tooltip {

    public static ItemStack getCurrentItemStack(GuiGraphics graphics) {
        return ((GuiGraphicsAccessor) graphics).getTooltipStack_CU();
    }
}
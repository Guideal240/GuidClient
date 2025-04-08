package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.scripting.api.ApiType;
import com.guideal.guidclient.scripting.api.ApiVisibility;
import com.guideal.guidclient.configs.AutoDropConfig;
import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.utils.InventorySlot;
import com.guideal.guidclient.utils.InventoryUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class AutoDropApi {

    @ApiVisibility(ApiType.ACTION)
    public void dropItems() {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player != null) {
            AutoDropConfig config = ConfigStore.instance.getConfig().autoDropConfig;
            List<InventorySlot> slots = new ArrayList<>();
            for (int i = 0; i < 36; i++) {
                ItemStack itemStack = mc.player.getInventory().getItem(i);
                if (!itemStack.isEmpty() && config.items.contains(itemStack.getItem())) {
                    slots.add(new InventorySlot(i));
                }
            }
            InventoryUtils.dropItemStacks(slots);
        }
    }
}
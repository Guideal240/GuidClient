package com.guideal.guidclient.configs;

import com.guideal.guidclient.collections.ImmutableList;
import net.minecraft.world.item.Item;

public class ContainerButtonsConfig {
    public boolean showTakeAll;
    public boolean showSmartPut;
    public boolean checkShulkerContent;
    public boolean showDropAll;
    public boolean autoTakeAll;
    public boolean autoDropAll;
    public boolean autoClose;
    public boolean useFilter;
    public ImmutableList<Item> items = new ImmutableList<>();
}
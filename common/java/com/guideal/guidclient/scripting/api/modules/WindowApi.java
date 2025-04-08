package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.scripting.api.HelpText;
import net.minecraft.client.Minecraft;

public class WindowApi {

    @HelpText("Width of Minecraft window drawing area, in Minecraft pixels, not real pixels")
    public int getGuiWidth() {
        return Minecraft.getInstance().getWindow().getGuiScaledWidth();
    }

    @HelpText("Height of Minecraft window drawing area, in Minecraft pixels, not real pixels")
    public int getGuiHeight() {
        return Minecraft.getInstance().getWindow().getGuiScaledHeight();
    }
}
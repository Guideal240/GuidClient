package com.guideal.guidclient.controllers;

import net.minecraft.client.Minecraft;

public class UserNameController {

    public static final UserNameController instance = new UserNameController();

    private UserNameController() {

    }

    public void onConfigUpdated() {
        Minecraft.getInstance().updateTitle();
    }
}
package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.modules.hacks.ServerPlugins;

public class ServerPluginsApi {

    public String[] get() {
        return ServerPlugins.instance.getPlugins();
    }

    public String[] getBukkit() {
        return ServerPlugins.instance.getBukkitPlugins();
    }
}
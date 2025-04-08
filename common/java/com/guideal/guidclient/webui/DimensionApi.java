package com.guideal.guidclient.webui;

import com.guideal.guidclient.controllers.ClientTickController;
import net.minecraft.client.Minecraft;
import org.apache.http.HttpException;

public class DimensionApi extends ApiBase {

    @Override
    public String getRoute() {
        return "dimension";
    }

    @Override
    public String get() throws HttpException {
        return gson.toJson(ClientTickController.instance.getResult(() -> {
            Minecraft mc = Minecraft.getInstance();
            if (mc.level == null) {
                return null;
            }
            return mc.level.dimension().location().toString();
        }, 1000));
    }
}
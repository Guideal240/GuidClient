package com.guideal.guidclient.webui;

import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.controllers.ScriptController;
import com.guideal.guidclient.modules.automation.VillagerRoller;
import org.apache.http.HttpException;

public class VillagerRollerCodeApi extends ApiBase {

    @Override
    public String getRoute() {
        return "villager-roller-code";
    }

    @Override
    public String post(String code) throws HttpException {
        if (code == null || code.length() == 0) {
            ConfigStore.instance.getConfig().villagerRollerConfig.code = null;
            ConfigStore.instance.requestWrite();
            VillagerRoller.instance.setScript(null);
            return "{ \"ok\": true }";
        }

        Runnable script;
        try {
            script = ScriptController.instance.compileVillagerRoller(code);
        }
        catch (Throwable e) {
            throw new HttpException(e.getMessage());
        }
        if (script != null) {
            ConfigStore.instance.getConfig().villagerRollerConfig.code = code;
            ConfigStore.instance.requestWrite();
            VillagerRoller.instance.setScript(script);
        }
        return "{ \"ok\": true }";
    }
}
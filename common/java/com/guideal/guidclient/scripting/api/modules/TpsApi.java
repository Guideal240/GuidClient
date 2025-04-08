package com.guideal.guidclient.scripting.api.modules;

import com.guideal.guidclient.controllers.TpsCounterController;

public class TpsApi {

    public double get() {
        return TpsCounterController.instance.getTps();
    }
}
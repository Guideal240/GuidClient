package com.guideal.guidclient.webui;

import com.guideal.guidclient.common.Registries;
import org.apache.http.HttpException;

import java.util.Objects;

public class ItemInfoApi extends ApiBase {

    @Override
    public String getRoute() {
        return "item-info";
    }

    @Override
    public String get() throws HttpException {
        return gson.toJson(Registries.ITEMS.getValues().stream().filter(Objects::nonNull).toArray());
    }
}
package com.guideal.guidclient.webui;

import com.guideal.guidclient.utils.EntityUtils;
import org.apache.http.HttpException;

public class EntityInfoApi extends ApiBase {

    @Override
    public String getRoute() {
        return "entity-info";
    }

    @Override
    public String get() throws HttpException {
        return gson.toJson(EntityUtils.getEntityClasses());
    }
}
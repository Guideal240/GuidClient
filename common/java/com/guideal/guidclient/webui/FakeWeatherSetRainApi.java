package com.guideal.guidclient.webui;

import com.guideal.guidclient.modules.visuals.FakeWeather;
import org.apache.http.HttpException;

public class FakeWeatherSetRainApi extends ApiBase {

    @Override
    public String getRoute() {
        return "fake-weather-set-rain";
    }

    @Override
    public String post(String body) throws HttpException {
        Request request = gson.fromJson(body, Request.class);
        FakeWeather.instance.setRain(request.value);
        return "{ \"ok\": true }";
    }

    public class Request {
        public float value;
    }
}

package com.guideal.guidclient.webui;

import org.apache.http.HttpException;

public class InternalServerErrorException extends HttpException {
    public InternalServerErrorException(final String message) {
        super(message);
    }
}

package com.guideal.guidclient.common.events;

public interface CancelableEvent {
    void cancel();
    boolean isCanceled();
}
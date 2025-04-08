package com.guideal.guidclient.interfaces;

import com.guideal.guidclient.utils.Dimension;

public interface LevelChunkMixinInterface {
    long getLoadTime();
    Dimension getDimension();
    boolean isUnloaded();
    void onLoad();
    void onUnload();
}
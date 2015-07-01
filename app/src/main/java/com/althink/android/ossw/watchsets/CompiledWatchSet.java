package com.althink.android.ossw.watchsets;

import com.althink.android.ossw.service.WatchOperationContext;

/**
 * Created by krzysiek on 13/06/15.
 */
public class CompiledWatchSet {

    private int id;
    private String name;
    private byte[] watchData;
    private WatchOperationContext watchContext;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getWatchData() {
        return watchData;
    }

    public void setWatchData(byte[] watchData) {
        this.watchData = watchData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WatchOperationContext getWatchContext() {
        return watchContext;
    }

    public void setWatchContext(WatchOperationContext watchContext) {
        this.watchContext = watchContext;
    }
}

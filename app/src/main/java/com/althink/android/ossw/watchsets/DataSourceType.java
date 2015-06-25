package com.althink.android.ossw.watchsets;

/**
 * Created by krzysiek on 22/06/15.
 */
public enum DataSourceType {
    NUMBER(1), STRING(2), ENUM(3);

    private int key;

    private DataSourceType(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}

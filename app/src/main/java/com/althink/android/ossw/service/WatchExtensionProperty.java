package com.althink.android.ossw.service;

import com.althink.android.ossw.watchsets.DataSourceType;

/**
 * Created by krzysiek on 13/06/15.
 */
public class WatchExtensionProperty {
    private String pluginId;
    private String propertyId;
    private DataSourceType type;
    private int range;

    public WatchExtensionProperty(String pluginId, String propertyId, DataSourceType type, int range) {
        this.pluginId = pluginId;
        this.propertyId = propertyId;
        this.type = type;
        this.range = range;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public String getPluginId() {
        return pluginId;
    }

    public DataSourceType getType() {
        return type;
    }

    public void setType(DataSourceType type) {
        this.type = type;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WatchExtensionProperty that = (WatchExtensionProperty) o;

        if (!propertyId.equals(that.propertyId)) return false;
        if (!pluginId.equals(that.pluginId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pluginId.hashCode();
        result = 31 * result + propertyId.hashCode();
        return result;
    }
}

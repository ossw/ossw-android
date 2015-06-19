package com.althink.android.ossw.service;

/**
 * Created by krzysiek on 13/06/15.
 */
public class WatchExtensionProperty {
    private String pluginId;
    private String propertyId;

    public WatchExtensionProperty(String pluginId, String propertyId) {
        this.pluginId = pluginId;
        this.propertyId = propertyId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public String getPluginId() {
        return pluginId;
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

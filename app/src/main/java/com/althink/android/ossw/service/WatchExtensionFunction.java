package com.althink.android.ossw.service;

/**
 * Created by krzysiek on 13/06/15.
 */
public class WatchExtensionFunction {
    private String pluginId;
    private String functionId;

    public WatchExtensionFunction(String pluginId, String functionId) {
        this.pluginId = pluginId;
        this.functionId = functionId;
    }

    public String getPluginId() {
        return pluginId;
    }

    public String getFunctionId() {
        return functionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WatchExtensionFunction that = (WatchExtensionFunction) o;

        if (!functionId.equals(that.functionId)) return false;
        if (!pluginId.equals(that.pluginId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pluginId.hashCode();
        result = 31 * result + functionId.hashCode();
        return result;
    }
}

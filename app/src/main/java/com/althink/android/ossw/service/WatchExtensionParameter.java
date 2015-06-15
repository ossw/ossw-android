package com.althink.android.ossw.service;

/**
 * Created by krzysiek on 13/06/15.
 */
public class WatchExtensionParameter {
    private String pluginId;
    private String parameterId;

    public WatchExtensionParameter(String pluginId, String parameterId) {
        this.pluginId = pluginId;
        this.parameterId = parameterId;
    }

    public String getParameterId() {
        return parameterId;
    }

    public String getPluginId() {
        return pluginId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WatchExtensionParameter that = (WatchExtensionParameter) o;

        if (!parameterId.equals(that.parameterId)) return false;
        if (!pluginId.equals(that.pluginId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pluginId.hashCode();
        result = 31 * result + parameterId.hashCode();
        return result;
    }
}

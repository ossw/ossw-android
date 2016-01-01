package com.althink.android.ossw.service;

/**
 * Created by krzysiek on 13/06/15.
 */
public class WatchExtensionFunction {
    private String pluginId;
    private String functionId;
    private String parameter;

    public WatchExtensionFunction(String pluginId, String functionId, String parameter) {
        this.pluginId = pluginId;
        this.functionId = functionId;
        this.parameter = parameter;
    }

    public String getPluginId() {
        return pluginId;
    }

    public String getFunctionId() {
        return functionId;
    }

    public String getParameter() {
        return parameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WatchExtensionFunction that = (WatchExtensionFunction) o;

        if (functionId != null ? !functionId.equals(that.functionId) : that.functionId != null)
            return false;
        if (parameter != null ? !parameter.equals(that.parameter) : that.parameter != null)
            return false;
        if (pluginId != null ? !pluginId.equals(that.pluginId) : that.pluginId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pluginId != null ? pluginId.hashCode() : 0;
        result = 31 * result + (functionId != null ? functionId.hashCode() : 0);
        result = 31 * result + (parameter != null ? parameter.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return pluginId + "/" + functionId + "(" + parameter + ")";
    }
}

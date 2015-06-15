package com.althink.android.ossw.plugins;

import android.provider.BaseColumns;

/**
 * Created by krzysiek on 12/06/15.
 */
public class PluginDefinition {

    public PluginDefinition() {

    }

    private String pluginId;
    private String label;

    public String getPluginId() {
        return pluginId;
    }

    public void setPluginId(String pluginId) {
        this.pluginId = pluginId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
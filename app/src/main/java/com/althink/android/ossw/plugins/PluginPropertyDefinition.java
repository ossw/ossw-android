package com.althink.android.ossw.plugins;

/**
 * Created by krzysiek on 16/06/15.
 */
public class PluginPropertyDefinition {
    private int id;
    private String name;
    private String description;

    public PluginPropertyDefinition(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

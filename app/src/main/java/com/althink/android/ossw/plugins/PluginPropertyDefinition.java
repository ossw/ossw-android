package com.althink.android.ossw.plugins;

/**
 * Created by krzysiek on 16/06/15.
 */
public class PluginPropertyDefinition {
    private int id;
    private String name;
    private String description;
    private PluginPropertyType type;

    public PluginPropertyDefinition(int id, String name, String description, PluginPropertyType type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
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

    public PluginPropertyType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PluginPropertyDefinition that = (PluginPropertyDefinition) o;

        if (id != that.id) return false;
        if (!description.equals(that.description)) return false;
        if (!name.equals(that.name)) return false;
        if (type != that.type) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}

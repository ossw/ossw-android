package com.althink.android.ossw.db;

/**
 * Created by krzysiek on 04/07/15.
 */
public class WatchSetInfo {
    private Integer id;
    private String name;

    public WatchSetInfo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

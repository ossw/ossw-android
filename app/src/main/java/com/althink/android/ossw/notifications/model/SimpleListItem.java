package com.althink.android.ossw.notifications.model;

/**
 * Created by krzysiek on 25/07/15.
 */
public class SimpleListItem {
    private String text;

    public SimpleListItem(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "SimpleListItem{" +
                "text='" + text + '\'' +
                '}';
    }
}

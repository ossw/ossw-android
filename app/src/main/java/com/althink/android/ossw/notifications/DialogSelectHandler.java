package com.althink.android.ossw.notifications;

import java.util.List;

/**
 * Created by Pavel
 */
public abstract class DialogSelectHandler implements NotificationHandler {

    private final static String TAG = DialogSelectHandler.class.getSimpleName();
    private List<String> items;

    public DialogSelectHandler() {}

    public DialogSelectHandler setItems(List<String> items) {
        this.items = items;
        return this;
    }

    public String getItem(int position) {
        return items.get(position);
    }

    public abstract void handleFunction(int position);

}

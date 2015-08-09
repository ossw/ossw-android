package com.althink.android.ossw.notifications.message;

import com.althink.android.ossw.notifications.model.ListNotification;
import com.althink.android.ossw.notifications.model.Notification;

import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Created by krzysiek on 19/07/15.
 */
public class NotificationSummaryMessageBuilder implements NotificationMessageBuilder {

    private ByteArrayOutputStream out;

    public NotificationSummaryMessageBuilder(int messagesNo) {
        out = new ByteArrayOutputStream();

        if (messagesNo > 255) {
            messagesNo = 255;
        }
        out.write(0);
        out.write(messagesNo);
    }

    @Override
    public byte[] build() {
        return out.toByteArray();
    }
}

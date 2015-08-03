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

    public NotificationSummaryMessageBuilder(List<Notification> notifications) {
        out = new ByteArrayOutputStream();


        byte[] phoneNumberData = "Summary".getBytes();
        byte[] contactNameData = Integer.toString(countMessages(notifications)).getBytes();
        out.write(0);
        out.write(0);
        out.write(5);
        out.write(0);
        out.write(5 + phoneNumberData.length + 1);
        out.write(phoneNumberData, 0, phoneNumberData.length);
        out.write(0);
        out.write(contactNameData, 0, contactNameData.length);
        out.write(0);
    }

    private int countMessages(List<Notification> notifications) {
        int count = 0;
        for (Notification notification : notifications) {
            if (notification instanceof ListNotification) {
                count += ((ListNotification) notification).getItems().size();
            } else {
                count++;
            }
        }
        if (count > 255) {
            return 255;
        }
        return count;
    }

    @Override
    public byte[] build() {
        return out.toByteArray();
    }
}

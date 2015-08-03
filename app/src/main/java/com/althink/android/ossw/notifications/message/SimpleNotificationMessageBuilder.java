package com.althink.android.ossw.notifications.message;

import com.althink.android.ossw.notifications.model.NotificationCategory;
import com.althink.android.ossw.utils.StringNormalizer;

import java.io.ByteArrayOutputStream;

/**
 * Created by krzysiek on 19/07/15.
 */
public class SimpleNotificationMessageBuilder implements NotificationMessageBuilder {

    private ByteArrayOutputStream out;

    public SimpleNotificationMessageBuilder(NotificationCategory category, String title, String text) {
        out = new ByteArrayOutputStream();
        byte[] phoneNumberData = title != null ? StringNormalizer.removeAccents(title).getBytes() : new byte[0];
        byte[] contactNameData = text != null ? StringNormalizer.removeAccents(text).getBytes() : new byte[0];
        out.write(category.getValue());
        out.write(0);
        out.write(5);
        out.write(0);
        out.write(5 + phoneNumberData.length + 1);
        out.write(phoneNumberData, 0, phoneNumberData.length);
        out.write(0);
        out.write(contactNameData, 0, contactNameData.length);
        out.write(0);
    }

    @Override
    public byte[] build() {
        return out.toByteArray();
    }
}

package com.althink.android.ossw.notifications;

import com.althink.android.ossw.utils.StringNormalizer;

import java.io.ByteArrayOutputStream;

/**
 * Created by krzysiek on 19/07/15.
 */
public class IncomingCallNotificationBuilder implements NotificationBuilder {

    private ByteArrayOutputStream out;

    public IncomingCallNotificationBuilder(String phoneNumber, String contactName) {
        out = new ByteArrayOutputStream();

        byte[] phoneNumberData = phoneNumber != null ? StringNormalizer.removeAccents(phoneNumber).getBytes() : new byte[0];
        byte[] contactNameData = contactName != null ? StringNormalizer.removeAccents(contactName).getBytes() : new byte[0];
        out.write(1);
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

package com.althink.android.ossw.notifications.message;

import android.util.Log;

import com.althink.android.ossw.emulator.fonts.FontUtils;
import com.althink.android.ossw.notifications.model.NotificationCategory;
import com.althink.android.ossw.notifications.model.SimpleNotification;
import com.althink.android.ossw.utils.StringNormalizer;
import com.althink.android.ossw.watch.WatchConstants;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/**
 * Created by krzysiek on 19/07/15.
 */
public class SimpleNotificationMessageBuilder extends AbstractNotificationMessageBuilder {

    private ByteArrayOutputStream out;

    public SimpleNotificationMessageBuilder(SimpleNotification simpleNotification, int page) {
        out = new ByteArrayOutputStream();

        StringBuilder sb = new StringBuilder();
        sb.append(simpleNotification.getTitle());
        if (NotificationCategory.EMAIL == simpleNotification.getCategory()) {
            sb.append((char) 0x0B).append(simpleNotification.getText().replaceFirst("\n", "\u000B"));
        } else {
            sb.append((char) 0x0B).append(simpleNotification.getText());
        }

        String text = StringNormalizer.removeAccents(sb.toString());

        int font = getFont("notifications_font");

        int ptr = 0;
        String data = "";
        for (int i = 0; i <= page; i++) {
            data = calculatePageContent(text, font, ptr);
            ptr += data.length();
        }
        String nextPageData = calculatePageContent(text, font, ptr).replaceAll("\\s","");
        boolean hasMore = nextPageData.length() > 0;
        //Log.i("SimpleNotificationMB", "Data to send: " + data);
        //Log.i("SimpleNotificationMB", "Next page data: " + Arrays.toString(nextPageData.toCharArray()));
        byte[] contentData = data != null ? data.getBytes() : new byte[0];

        out.write(simpleNotification.getCategory().getValue());
        out.write((simpleNotification.getExternalId() >> 8) & 0xFF);
        out.write(simpleNotification.getExternalId() & 0xFF);
        out.write(page);
        out.write(font);
        out.write(hasMore ? 1 : 0);
        out.write(contentData, 0, contentData.length);
        out.write(0);
    }

    @Override
    public byte[] build() {
        return out.toByteArray();
    }
}

package com.althink.android.ossw.notifications.message;

import com.althink.android.ossw.notifications.model.ListNotification;
import com.althink.android.ossw.notifications.model.SimpleListItem;
import com.althink.android.ossw.notifications.model.SubjectMessageItem;
import com.althink.android.ossw.utils.StringNormalizer;

import java.io.ByteArrayOutputStream;

/**
 * Created by krzysiek on 19/07/15.
 */
public class ListNotificationMessageBuilder extends AbstractNotificationMessageBuilder {

    private ByteArrayOutputStream out;

    public ListNotificationMessageBuilder(ListNotification simpleNotification, int page) {
        out = new ByteArrayOutputStream();

        int font = getFont("notifications_font");

        StringBuilder sb = new StringBuilder();
        sb.append(simpleNotification.getTitle());
        for (Object item : simpleNotification.getItems()) {
            if (sb.length() > 0) {
                sb.append((char)0x0B);
            }
            if (item instanceof SimpleListItem) {
                sb.append(((SimpleListItem) item).getText());
            } else if (item instanceof SubjectMessageItem) {
                sb.append(((SubjectMessageItem) item).getSubject()).append((char)0x0B).append(((SubjectMessageItem) item).getMessage());
            }
        }
        String text = StringNormalizer.removeAccents(sb.toString());

        int ptr = 0;
        String data = "";
        for (int i = 0; i <= page; i++) {
            data = calculatePageContent(text, font, ptr);
            ptr += data.length();
        }
        boolean hasMore = ptr < text.length();
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

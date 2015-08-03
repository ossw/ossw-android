package com.althink.android.ossw.notifications.message;

import com.althink.android.ossw.notifications.model.NotificationCategory;
import com.althink.android.ossw.notifications.model.Operation;
import com.althink.android.ossw.utils.StringNormalizer;

import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Created by krzysiek on 19/07/15.
 */
public class AlertNotificationMessageBuilder implements NotificationMessageBuilder {

    private ByteArrayOutputStream out;

    public AlertNotificationMessageBuilder(NotificationCategory category, String title, String text, List<Operation> operations) {
        out = new ByteArrayOutputStream();
        ByteArrayOutputStream content = new ByteArrayOutputStream();

        int operationsNo = operations.size() > 2 ? 2 : operations.size();

        int headerSize = 6 + operationsNo * 2;
        int offset = headerSize;
        byte[] titleData = title != null ? StringNormalizer.removeAccents(title).getBytes() : new byte[0];
        byte[] textData = text != null ? StringNormalizer.removeAccents(text).getBytes() : new byte[0];

        out.write(category.getValue());

        offset = addReferencedParameter(content, offset, titleData);
        offset = addReferencedParameter(content, offset, textData);

        out.write(operationsNo);

        for(int i=0; i<operationsNo; i++) {
            offset = addReferencedParameter(content, offset, operations.get(i).getTitle().getBytes());
        }

        byte[] contentData = content.toByteArray();
        out.write(contentData, 0, contentData.length);
    }

    private int addReferencedParameter(ByteArrayOutputStream content, int offset, byte[] data) {
        writeOffset(offset);
        content.write(data, 0, data.length);
        content.write(0);
        offset+=data.length + 1;
        return offset;
    }

    private void writeOffset(int offset) {
        out.write((offset>>8)&0xFF);
        out.write(offset&0xFF);
    }


    @Override
    public byte[] build() {
        return out.toByteArray();
    }
}

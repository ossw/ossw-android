package com.althink.android.ossw.notifications.message;

import com.althink.android.ossw.utils.StringNormalizer;

import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Created by Pavel
 */
public class DialogSelectMessageBuilder extends AbstractNotificationMessageBuilder {

    private ByteArrayOutputStream out;

    public DialogSelectMessageBuilder(String title, List<String> items) {
        out = new ByteArrayOutputStream();
        int font = getFont();
        // default item
        out.write(0);
        // list size
        out.write(items.size());
        out.write(font);
        // list style
        out.write(0);
        out.write(StringNormalizer.removeAccents(title).getBytes(), 0, title.length());
        out.write(0);
        for (String item: items) {
            out.write(StringNormalizer.removeAccents(item).getBytes(), 0, item.length());
            out.write(0);
        }
    }

    @Override
    public byte[] build() {
        return out.toByteArray();
    }
}

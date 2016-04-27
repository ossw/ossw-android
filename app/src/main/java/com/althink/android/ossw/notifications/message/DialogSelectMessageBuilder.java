package com.althink.android.ossw.notifications.message;

import com.althink.android.ossw.utils.StringNormalizer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Pavel
 */
public class DialogSelectMessageBuilder extends AbstractNotificationMessageBuilder {

    private ByteArrayOutputStream out;

    public DialogSelectMessageBuilder(String title, List<String> items, int defItem, int token, int style) {
        this(title, items, defItem, token, style, createEmptyBitSet(items.size()));
    }

    private static byte[] createEmptyBitSet(int itemsSize) {
        int bitSetLength = itemsSize >> 3;
        if ((itemsSize & 7) > 0)
            bitSetLength++;
        byte[] bitset = new byte[bitSetLength];
        return bitset;
    }

    public DialogSelectMessageBuilder(String title, List<String> items, int selectedItem, int token, int style, byte[] init) {
        out = new ByteArrayOutputStream();
        int itemsSize = items.size();
        int font = getFont();
        // init selected item
        out.write(selectedItem);
        // dialog token for multiple dialogs session
        out.write(token);
        // list size
        out.write(itemsSize);
        out.write(font);
        // list style
        out.write(style);
        if (style > 0 && init.length > 0) {
            // set initial selections, here no elements are selected
            try {
                out.write(init);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // title
        String text = StringNormalizer.removeAccents(title);
        out.write(text.getBytes(), 0, text.length());
        // end of line
        out.write(0);
        for (String item : items) {
            text = StringNormalizer.removeAccents(item);
            out.write(text.getBytes(), 0, text.length());
            // end of line
            out.write(0);
        }
    }

    @Override
    public byte[] build() {
        return out.toByteArray();
    }
}

package com.althink.android.ossw.notifications.message;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.althink.android.ossw.emulator.fonts.FontUtils;
import com.althink.android.ossw.service.OsswService;
import com.althink.android.ossw.watch.WatchConstants;

/**
 * Created by krzysiek on 09/08/15.
 */
public abstract class AbstractNotificationMessageBuilder implements NotificationMessageBuilder {

    protected int getFont() {
        OsswService service = OsswService.getInstance();
        if (service != null) {
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(service);
            String font = sharedPref.getString("notifications_font", "normalBold");
            switch (font) {
                case "bigRegular":
                    return WatchConstants.FONT_BIG_REGULAR;
                case "normalBold":
                    return WatchConstants.FONT_NORMAL_BOLD;
                case "normalRegular":
                    return WatchConstants.FONT_NORMAL_REGULAR;
                case "smallBold":
                    return WatchConstants.FONT_SMALL_BOLD;
                case "smallRegular":
                    return WatchConstants.FONT_SMALL_REGULAR;
            }
        }

        return WatchConstants.FONT_NAME_NORMAL_BOLD;
    }

    protected String calculatePageContent(String text, int font, int ptr) {
        return FontUtils.calcTextToDraw(text, ptr, 3, 3, WatchConstants.SCREEN_WIDTH - 6, WatchConstants.SCREEN_HEIGHT - 6, font, WatchConstants.HORIZONTAL_ALIGN_LEFT | WatchConstants.TEXT_FLAGS_MULTILINE);
    }
}

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


    protected int getAlertFont() {
        OsswService service = OsswService.getInstance();
        if (service != null) {
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(service);
            String font = sharedPref.getString("alert_notifications_font", "optionNormal");
            return getFontId(font);
        }
        return WatchConstants.FONT_NAME_OPTION_NORMAL;
    }

    protected int getFont(String font_preference_key) {
        OsswService service = OsswService.getInstance();
        if (service != null) {
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(service);
            String font = sharedPref.getString(font_preference_key, "normalBold");
            return getFontId(font);
        }
        return WatchConstants.FONT_NAME_NORMAL_BOLD;
    }

    private int getFontId(String font) {
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
            case "optionNormal":
                return WatchConstants.FONT_OPTION_NORMAL;
            case "optionBig":
                return WatchConstants.FONT_OPTION_BIG;
        }
        return WatchConstants.FONT_NAME_NORMAL_BOLD;
    }

    protected String calculatePageContent(String text, int font, int ptr) {
        return FontUtils.calcTextToDraw(text, ptr, WatchConstants.NOTIFICATIONS_MARGIN_HORIZ, WatchConstants.NOTIFICATIONS_MARGIN_TOP,
                WatchConstants.SCREEN_WIDTH - 2*WatchConstants.NOTIFICATIONS_MARGIN_HORIZ, WatchConstants.SCREEN_HEIGHT - WatchConstants.NOTIFICATIONS_MARGIN_TOP,
                font, WatchConstants.HORIZONTAL_ALIGN_LEFT | WatchConstants.TEXT_FLAGS_MULTILINE);
    }
}

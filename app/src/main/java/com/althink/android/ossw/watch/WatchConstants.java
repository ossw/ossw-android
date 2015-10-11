package com.althink.android.ossw.watch;

/**
 * Created by krzysiek on 14/06/15.
 */
public class WatchConstants {

    public static final int SCREEN_WIDTH = 144;
    public static final int SCREEN_HEIGHT = 168;

    public static final int SCR_CONTROL_STATIC_RECT = 0;
    public static final int SCR_CONTROL_NUMBER = 1;
    public static final int SCR_CONTROL_HORIZONTAL_PROGRESS_BAR = 2;
    public static final int SCR_CONTROL_VERTICAL_PROGRESS_BAR = 3;
    public static final int SCR_CONTROL_TEXT = 4;
    public static final int SCR_CONTROL_STATIC_IMAGE = 5;
    public static final int SCR_CONTROL_IMAGE_FROM_SET = 6;


    public static final int NUMBER_RANGE_0__9 = 0x10;
    public static final int NUMBER_RANGE_0__19 = 0x20;
    public static final int NUMBER_RANGE_0__99 = 0x30;
    public static final int NUMBER_RANGE_0__199 = 0x40;
    public static final int NUMBER_RANGE_0__999 = 0x50;
    public static final int NUMBER_RANGE_0__1999 = 0x60;
    public static final int NUMBER_RANGE_0__9999 = 0x70;
    public static final int NUMBER_RANGE_0__19999 = 0x80;
    public static final int NUMBER_RANGE_0__99999 = 0x90;
    public static final int NUMBER_RANGE_0__9_9 = 0x11;
    public static final int NUMBER_RANGE_0__19_9 = 0x21;
    public static final int NUMBER_RANGE_0__99_9 = 0x31;
    public static final int NUMBER_RANGE_0__199_9 = 0x41;
    public static final int NUMBER_RANGE_0__999_9 = 0x51;
    public static final int NUMBER_RANGE_0__1999_9 = 0x61;
    public static final int NUMBER_RANGE_0__9999_9 = 0x71;
    public static final int NUMBER_RANGE_0__19999_9 = 0x81;
    public static final int NUMBER_RANGE_0__99999_9 = 0x91;
    public static final int NUMBER_RANGE_0__9_99 = 0x12;
    public static final int NUMBER_RANGE_0__19_99 = 0x22;
    public static final int NUMBER_RANGE_0__99_99 = 0x32;
    public static final int NUMBER_RANGE_0__199_99 = 0x42;
    public static final int NUMBER_RANGE_0__999_99 = 0x52;
    public static final int NUMBER_RANGE_0__1999_99 = 0x62;
    public static final int NUMBER_RANGE_0__9999_99 = 0x72;
    public static final int NUMBER_RANGE_0__19999_99 = 0x82;
    public static final int NUMBER_RANGE_0__99999_99 = 0x92;

    public static final int FONT_NAME_SMALL_REGULAR = 1;
    public static final int FONT_NAME_SMALL_BOLD = 2;
    public static final int FONT_NAME_NORMAL_REGULAR = 3;
    public static final int FONT_NAME_NORMAL_BOLD = 4;
    public static final int FONT_NAME_BIG_REGULAR = 5;
    public static final int FONT_NAME_BIG_BOLD = 6;
    public static final int FONT_NAME_OPTION_NORMAL = 0x10;
    public static final int FONT_NAME_OPTION_BIG = 0x11;

    public static final int HORIZONTAL_ALIGN_LEFT = 0x0;
    public static final int HORIZONTAL_ALIGN_CENTER = 0x40;
    public static final int HORIZONTAL_ALIGN_RIGHT = 0x80;

    public static final int VERTICAL_ALIGN_TOP = 0x0;
    public static final int VERTICAL_ALIGN_CENTER = 0x10;
    public static final int VERTICAL_ALIGN_BOTTOM = 0x20;

    public static final int TEXT_FLAGS_MULTILINE = 0x8;
    public static final int TEXT_FLAGS_SPLIT_WORD = 0x4;

    public static final int WATCH_SET_SECTION_SCREENS = 1;
    public static final int WATCH_SET_SECTION_EXTERNAL_PROPERTIES = 2;
    public static final int WATCH_SET_SECTION_RESOURCES = 3;

    public static final int WATCH_SET_SCREEN_SECTION_CONTROLS = 1;
    public static final int WATCH_SET_SCREEN_SECTION_ACTIONS = 2;
    public static final int WATCH_SET_SCREEN_SECTION_MEMORY = 3;

    public static final int WATCH_SET_END_OF_DATA = 0xFF;

    public static final int DATA_SOURCE_INTERNAL = 0;
    public static final int DATA_SOURCE_EXTERNAL = 1;
    public static final int DATA_SOURCE_SENSOR = 2;

    public static final int RESOURCE_SOURCE_ATTACHED = 1;

    public static final int INTERNAL_DATA_SOURCE_BATTERY_LEVEL = 0;
    public static final int INTERNAL_DATA_SOURCE_TIME_HOUR_24 = 1;
    public static final int INTERNAL_DATA_SOURCE_TIME_HOUR_12 = 2;
    public static final int INTERNAL_DATA_SOURCE_TIME_HOUR_12_DESIGNATOR = 3;
    public static final int INTERNAL_DATA_SOURCE_TIME_MINUTES = 4;
    public static final int INTERNAL_DATA_SOURCE_TIME_SECONDS = 5;
    public static final int INTERNAL_DATA_SOURCE_DATE_DAY_OF_WEEK = 6;
    public static final int INTERNAL_DATA_SOURCE_DATE_DAY_OF_MONTH = 7;
    public static final int INTERNAL_DATA_SOURCE_DATE_DAY_OF_YEAR = 8;
    public static final int INTERNAL_DATA_SOURCE_DATE_MONTH = 9;
    public static final int INTERNAL_DATA_SOURCE_DATE_YEAR = 10;

    public static final int SENSOR_DATA_SOURCE_HR = 0;
    //public static final int INTERNAL_DATA_SOURCE_SENSOR_CYCLING_SPEED = 0x11;
    //public static final int INTERNAL_DATA_SOURCE_SENSOR_CYCLING_CADENCE = 0x12;

    public static final int WATCHSET_FUNCTION_TOGGLE_BACKLIGHT = 1;
    public static final int WATCHSET_FUNCTION_TOGGLE_COLORS = 2;

    public static final int WATCHSET_FUNCTION_CHANGE_SCREEN = 0xF0;
    public static final int WATCHSET_FUNCTION_SHOW_SETTINGS = 0xF1;

    public static final int WATCHSET_FUNCTION_CLOSE = 0xFE;
    public static final int WATCHSET_FUNCTION_EXTENSION = 0xFF;

    public static final int EVENT_BUTTON_UP_SHORT = 0;
    public static final int EVENT_BUTTON_SELECT_SHORT = 1;
    public static final int EVENT_BUTTON_DOWN_SHORT = 2;
    public static final int EVENT_BUTTON_BACK_SHORT = 3;
    public static final int EVENT_BUTTON_UP_LONG = 4;
    public static final int EVENT_BUTTON_SELECT_LONG = 5;
    public static final int EVENT_BUTTON_DOWN_LONG = 6;
    public static final int EVENT_BUTTON_BACK_LONG = 7;

    public static final int OSSW_RX_COMMAND_SET_WATCH_SET_ID = 0x10;
    public static final int OSSW_RX_COMMAND_INVOKE_EXTERNAL_FUNCTION = 0x11;
    ;
    public static final int OSSW_RX_COMMAND_INVOKE_NOTIFICATION_FUNCTION = 0x12;
    public static final int OSSW_RX_COMMAND_UPLOAD_DATA_PERMISSION = 0x20;
    public static final int OSSW_RX_COMMAND_COMMAND_ACK = 0x40;
    public static final int OSSW_RX_COMMAND_COMMAND_ERROR = 0x41;
    public static final int OSSW_RX_COMMAND_UPLOAD_NOTIFICATION_PERMISSION = 0x23;


    public static final int FONT_SMALL_REGULAR = 1;
    public static final int FONT_SMALL_BOLD = 2;
    public static final int FONT_NORMAL_REGULAR = 3;
    public static final int FONT_NORMAL_BOLD = 4;
    public static final int FONT_BIG_REGULAR = 5;
    public static final int FONT_OPTION_NORMAL = 0x10;
    public static final int FONT_OPTION_BIG = 0x11;

    public static final int NOTIFICATIONS_FUNCTION_DISMISS_ALL = 0x10;
    public static final int NOTIFICATIONS_FUNCTION_ALERT_DISMISS = 0x20;
    public static final int NOTIFICATIONS_FUNCTION_ALERT_OPTION_1 = 0x21;
    public static final int NOTIFICATIONS_FUNCTION_ALERT_OPTION_2 = 0x22;

    public static final int NOTIFICATIONS_SHOW_FIRST = 0x30;
    public static final int NOTIFICATIONS_NEXT_PART = 0x31;
    public static final int NOTIFICATIONS_NEXT = 0x32;
    public static final int NOTIFICATIONS_PREV_PART = 0x33;
}

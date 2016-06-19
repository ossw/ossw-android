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
    public static final int SCR_CONTROL_CHOOSE = 0xF0;

    public static final int MAX_TEXT_EXT_PROPERTY_LENGTH = 253;
    public static final int DEFAULT_TEXT_EXT_PROPERTY_LENGTH = 32;

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
    public static final int WATCH_SET_SCREEN_SECTION_BASE_ACTIONS = 4;
    public static final int WATCH_SET_SCREEN_SECTION_MODEL = 5;
    public static final int WATCH_SET_SCREEN_SECTION_SETTINGS = 6;

    public static final int WATCH_SET_SETTING_INVERTIBLE = 1;

    public static final int WATCH_SET_END_OF_DATA = 0xFF;

    public static final int DATA_SOURCE_INTERNAL = 0;
    public static final int DATA_SOURCE_EXTERNAL = 1;
    public static final int DATA_SOURCE_SENSOR = 2;
    public static final int DATA_SOURCE_STATIC = 3;
    public static final int DATA_SOURCE_WATCHSET_MODEL = 4;

    public static final int RESOURCE_SOURCE_ATTACHED = 1;

    public static final int INTERNAL_DATA_SOURCE_BATTERY_LEVEL = 0;
    public static final int INTERNAL_DATA_SOURCE_TIME_IN_SECONDS = 1;
    public static final int INTERNAL_DATA_SOURCE_TIME_HOUR_24 = 2;
    public static final int INTERNAL_DATA_SOURCE_TIME_HOUR_12 = 3;
    public static final int INTERNAL_DATA_SOURCE_TIME_HOUR_12_DESIGNATOR = 4;
    public static final int INTERNAL_DATA_SOURCE_TIME_MINUTES = 5;
    public static final int INTERNAL_DATA_SOURCE_TIME_SECONDS = 6;
    public static final int INTERNAL_DATA_SOURCE_DATE_DAY_OF_WEEK = 7;
    public static final int INTERNAL_DATA_SOURCE_DATE_DAY_OF_MONTH = 8;
    public static final int INTERNAL_DATA_SOURCE_DATE_DAY_OF_YEAR = 9;
    public static final int INTERNAL_DATA_SOURCE_DATE_MONTH = 10;
    public static final int INTERNAL_DATA_SOURCE_DATE_YEAR = 11;
    public static final int INTERNAL_DATA_SOURCE_STOPWATCH_TOTAL_TIME = 12;
    public static final int INTERNAL_DATA_SOURCE_STOPWATCH_CURRENT_LAP_NUMBER = 13;
    public static final int INTERNAL_DATA_SOURCE_STOPWATCH_CURRENT_LAP_TIME = 14;
    public static final int INTERNAL_DATA_SOURCE_STOPWATCH_CURRENT_LAP_SPLIT = 15;
    public static final int INTERNAL_DATA_SOURCE_STOPWATCH_LAST_LAP_TIME = 16;
    public static final int INTERNAL_DATA_SOURCE_STOPWATCH_RECALL_LAP_TIME = 17;
    public static final int INTERNAL_DATA_SOURCE_STOPWATCH_RECALL_LAP_SPLIT = 18;
    public static final int INTERNAL_DATA_SOURCE_FIRMWARE_VERSION = 19;
    public static final int INTERNAL_DATA_SOURCE_MAC_ADDRESS = 20;

    public static final int CONVERTER_MS_TO_HOURS = 1;
    public static final int CONVERTER_MS_TO_MINUTES_REMAINDER = 2;
    public static final int CONVERTER_MS_TO_SECONDS_REMAINDER = 3;
    public static final int CONVERTER_MS_TO_CS_REMAINDER = 4;
    public static final int CONVERTER_MS_REMAINDER = 5;
    public static final int CONVERTER_TIME_TO_HOUR_24 = 6;
    public static final int CONVERTER_TIME_TO_ROUNDED_HOUR_24 = 7;
    public static final int CONVERTER_TIME_TO_MINUTES = 8;
    public static final int CONVERTER_TIME_TO_SECONDS = 9;
    public static final int CONVERTER_TIME_TO_FIVE_MINUTES_ROUNDED_TIME = 10;
    public static final int CONVERTER_HOUR_24_TO_HOUR_12 = 11;
    public static final int CONVERTER_HOUR_24_TO_HOUR_12_PERIOD = 12;
    public static final int CONVERTER_MINUTES_TO_PAST_TO_DESIGNATOR = 13;
    public static final int CONVERTER_MINUTES_TO_PAST_TO_MINUTES = 14;
    public static final int CONVERTER_ONES = 15;
    public static final int CONVERTER_TENS = 16;
    public static final int CONVERTER_HUNDREDS = 17;

    public static final int SENSOR_DATA_SOURCE_HR = 0;
    //public static final int INTERNAL_DATA_SOURCE_SENSOR_CYCLING_SPEED = 0x11;
    //public static final int INTERNAL_DATA_SOURCE_SENSOR_CYCLING_CADENCE = 0x12;

    public static final int WATCHSET_FUNCTION_BACKLIGHT_TOGGLE = 1;
    public static final int WATCHSET_FUNCTION_TOGGLE_COLORS = 2;
    public static final int WATCHSET_FUNCTION_TEMPORARY_BACKLIGHT = 3;
    public static final int WATCHSET_FUNCTION_SET_TEMPORARY_BACKLIGHT_TIMEOUT = 4;
    public static final int WATCHSET_FUNCTION_SET_TIME = 5;

    public static final int WATCHSET_FUNCTION_FORMAT_DATA = 0xE;
    public static final int WATCHSET_FUNCTION_RESTART = 0xF;

    public static final int WATCHSET_FUNCTION_STOPWATCH_START = 0x10;
    public static final int WATCHSET_FUNCTION_STOPWATCH_RESET = 0x11;
    public static final int WATCHSET_FUNCTION_STOPWATCH_STOP = 0x12;
    public static final int WATCHSET_FUNCTION_STOPWATCH_START_STOP = 0x13;
    public static final int WATCHSET_FUNCTION_STOPWATCH_NEXT_LAP = 0x14;

    public static final int WATCHSET_FUNCTION_PHONE_DISCOVERY = 0x20;
    public static final int WATCHSET_FUNCTION_SEND_SMS = 0x21;
    public static final int WATCHSET_FUNCTION_CALL_CONTACT = 0x22;
    public static final int WATCHSET_FUNCTION_GTASKS = 0x23;

    public static final int WATCHSET_FUNCTION_MODEL_SET = 0xA0;
    public static final int WATCHSET_FUNCTION_MODEL_ADD = 0xA1;
    public static final int WATCHSET_FUNCTION_MODEL_SUBTRACT = 0xA2;
    public static final int WATCHSET_FUNCTION_MODEL_INCREMENT = 0xA3;
    public static final int WATCHSET_FUNCTION_MODEL_DECREMENT = 0xA4;

    public static final int WATCHSET_FUNCTION_CHANGE_SCREEN = 0xE0;
    public static final int WATCHSET_FUNCTION_SHOW_SETTINGS = 0xE1;
    public static final int WATCHSET_FUNCTION_SHOW_STATUS = 0xE2;
    public static final int WATCHSET_FUNCTION_SHOW_NOTIFICATIONS = 0xE3;
    public static final int WATCHSET_FUNCTION_SHOW_WATCH_FACES = 0xE4;
    public static final int WATCHSET_FUNCTION_SHOW_APPLICATIONS = 0xE5;
    public static final int WATCHSET_FUNCTION_SHOW_UTILS = 0xE6;
    public static final int WATCHSET_FUNCTION_SHOW_NEXT_WATCH_FACE = 0xE7;
    public static final int WATCHSET_FUNCTION_SHOW_APPLICATION = 0xE8;
    public static final int WATCHSET_FUNCTION_SHOW_UTILITY = 0xE9;

    public static final int WATCHSET_FUNCTION_CLOSE = 0xEE;
    public static final int WATCHSET_FUNCTION_EXTENSION = 0xEF;

    public static final int WATCHSET_FUNCTION_CHOOSE = 0xF0;

    public static final int EVENT_BUTTON_UP_SHORT = 0;
    public static final int EVENT_BUTTON_SELECT_SHORT = 1;
    public static final int EVENT_BUTTON_DOWN_SHORT = 2;
    public static final int EVENT_BUTTON_BACK_SHORT = 3;
    public static final int EVENT_BUTTON_UP_LONG = 4;
    public static final int EVENT_BUTTON_SELECT_LONG = 5;
    public static final int EVENT_BUTTON_DOWN_LONG = 6;
    public static final int EVENT_BUTTON_BACK_LONG = 7;
    public static final int EVENT_WRIST_SHAKE = 8;

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
    public static final int NOTIFICATIONS_FUNCTION_RESEND = 0x11;
    public static final int NOTIFICATIONS_FUNCTION_ALERT_DISMISS = 0x20;
    public static final int NOTIFICATIONS_FUNCTION_ALERT_OPTION_1 = 0x21;
    public static final int NOTIFICATIONS_FUNCTION_ALERT_OPTION_2 = 0x22;

    public static final int NOTIFICATIONS_SHOW_FIRST = 0x30;
    public static final int NOTIFICATIONS_NEXT_PART = 0x31;
    public static final int NOTIFICATIONS_NEXT = 0x32;
    public static final int NOTIFICATIONS_PREV_PART = 0x33;
    public static final int NOTIFICATIONS_OPEN = 0x34;

    public static final int DIALOG_RESULT = 0x35;

    public static final int PHONE_FUNCTION_PHONE_DISCOVERY = 0x40;
    public static final int PHONE_FUNCTION_SEND_SMS = 0x41;
    public static final int PHONE_FUNCTION_CALL_CONTACT = 0x42;
    public static final int PHONE_FUNCTION_GTASKS = 0x43;
    public static final int PHONE_FUNCTION_REJECT_SMS = 0x44;
    public static final int PHONE_FUNCTION_ACCELEROMETER = 0x45;
    public static final int PHONE_FUNCTION_SLEEP_AS_ANDROID = 0x46;
    public static final int PHONE_FUNCTION_PED_DELTA = 0x47;

    public static final int STYLE_RADIO_BUTTON = 0x01;
    public static final int STYLE_CHECK_BOX = 0x02;
    public static final int STYLE_STRIKE = 0x04;

    public static final int BUTTON_UP = 1;
    public static final int BUTTON_DOWN = 2;
    public static final int BUTTON_SELECT = 4;
    public static final int BUTTON_BACK = 8;
    public static final int BUTTON_HOLD = 16;
}

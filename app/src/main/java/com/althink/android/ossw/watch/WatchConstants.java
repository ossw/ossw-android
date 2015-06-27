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
//#define SCR_CONTROL_VERTICAL_PROGRESS_BAR    3
//#define SCR_CONTROL_BATTERY_LEVEL	           4


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


    public static final int WATCH_SET_SECTION_SCREENS = 1;
    public static final int WATCH_SET_SECTION_EXTERNAL_PROPERTIES = 2;
    public static final int WATCH_SET_SECTION_STATIC_CONTENT = 3;

    public static final int WATCH_SET_SCREEN_SECTION_CONTROLS = 1;
    public static final int WATCH_SET_SCREEN_SECTION_ACTIONS = 2;

    public static final int WATCH_SET_END_OF_DATA = 0xFF;

    public static final int DATA_SOURCE_TYPE_INTERNAL = 0;
    public static final int DATA_SOURCE_TYPE_EXTERNAL = 1;

    public static final int INTERNAL_DATA_SOURCE_TIME_HOUR = 0;
    public static final int INTERNAL_DATA_SOURCE_TIME_MINUTES = 1;
    public static final int INTERNAL_DATA_SOURCE_TIME_SECONDS = 2;
    public static final int INTERNAL_DATA_SOURCE_DATE_DAY_OF_MONTH = 3;
    public static final int INTERNAL_DATA_SOURCE_DATE_MONTH = 4;
    public static final int INTERNAL_DATA_SOURCE_DATE_YEAR = 5;
    public static final int INTERNAL_DATA_SOURCE_BATTERY_LEVEL = 6;

    public static final int INTERNAL_DATA_SOURCE_SENSOR_HR = 0x10;
    public static final int INTERNAL_DATA_SOURCE_SENSOR_CYCLING_SPEED = 0x11;
    public static final int INTERNAL_DATA_SOURCE_SENSOR_CYCLING_CADENCE = 0x12;

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

    public static final int OSSW_RX_COMMAND_INVOKE_EXTERNAL_FUNCTION = 0x10;
}

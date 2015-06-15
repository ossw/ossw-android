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

    public static final int NUMBER_FORMAT_0_99 = 0;
//#define NUMBER_FORMAT_0_199    1
//#define NUMBER_FORMAT_0_999    2
//#define NUMBER_FORMAT_0_9999   3


    public static final int WATCH_SET_SECTION_SCREENS = 1;
    public static final int WATCH_SET_SECTION_STATIC_CONTENT = 2;

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
}

package com.iforpowell.android.ipantmanapi;

import android.net.Uri;

public class IpAntManApi {
	// the various constants used for the various interfaces provided by AntPlusSensorManager
	

  /** 
   * Api version number hex a.b.c as 0xaabbcc 
   * send when registering in API_VERSION_EXTRA
   * 0x010600 adds basic BT support.
   * 0X010700 Added Muscle Oxygen support.
   * 0X010800 Added BTLE support.
   * 0X010900 Added RR support.
   */
    public static final int API_VERSION = 0x010900;
    
	/** 
	 * Base name for intents 
	 */
    private static final String BASE_NAME = "com.iforpowell.android.IpAntMan";

    // sent when the Ant service is ready to open look for sensors.  
    // If already open this is straight away. If initial opening this is after reset and caps.
    
    /** 
     * Broadcast Intent sent from Manager to App after successful initialisation.
     * Don't try starting sensors till you see this.
     */
    public static final String ANT_READY = BASE_NAME + ".note.ANT_READY";
    /** 
     * Broadcast Intent sent from Manager to App after unsuccessful initialisation.
     * This will be because there are no radio services, or we failed to get the radio
     * because the user did not let the force claim though.
     * Can also come during use if the user lets another App claim the radio.
     * Or the user puts us in Aeroplane mode.
     * extra ERROR contains an error string for the reason.
     */
    public static final String ANT_NOT_READY = BASE_NAME + ".note.ANT_NOT_READY";
    // standard sensor events
    /** 
     * Broadcast Intent sent from manager only when there is new data to see.
     * BIKE_SPEED has extras as follows.
     * int COUNT with the number of wheel revolutions for this update
     * int TIME with the time in 1/1024 seconds for this event.
     * int DB_ID database ID for this unique sensor
     */
	public static final String BIKE_SPEED_EVENT = BASE_NAME + ".event.BIKE_SPEED";
    /** 
     * Broadcast Intent sent from manager only when there is new data to see.
     * BIKE_CADENCE has extras as follows.
     * int COUNT with the number of pedel revolutions for this update
     * int TIME with the time in 1/1024 seconds for this event.
     * int DB_ID database ID for this unique sensor
     */
	public static final String BIKE_CADENCE_EVENT = BASE_NAME + ".event.BIKE_CADENCE";
    /** 
     * Broadcast Intent sent from manager only when there is new data to see.
     * BIKE_POWER has extras as follows.
     * int COUNT with the number of power events for this update
     * float TIME with the time in seconds for this event.
     * int AMOUNT with the acumulated Watts for the power updates for this event
     * int PERCENT pedal % (or whatever the sensor gives) for this update
     * int DB_ID database ID for this unique sensor
     * int EFFECT optional (only sent if received) effectiveness and smoothness data as per page 19 in the 3.0 spec still compacted.
     * e.g power = AMOUNT / TIME.
     */
	public static final String BIKE_POWER_EVENT = BASE_NAME + ".event.BIKE_POWER";
    /** 
     * Broadcast Intent sent from manager only when there is new data to see.
     * HR has extras as follows.
     * int COUNT with the number of beats for this update
     * int TIME with the time in 1/1024 seconds for this event.
     * int AMOUNT with the last heart rate as transmitted by the sensor.
     * int RR integer array of RR data. optional. Normally just one from good ANT reception can be bigger with bad reception and BT and BTLE may also have multiple.  Oldest to newest order
     * int DB_ID database ID for this unique sensor
     */
	public static final String HR_EVENT = BASE_NAME + ".event.HR";

    /** 
     * Broadcast Intent sent from manager only when there is new data to see.
     * TEMPRATURE has extras as follows.
     * float AMOUNT with the temperature in degrees C
     * float LOW with the Low temperature in degrees C
     * float HIGH with the High temperature in degrees C
     * int DB_ID database ID for this unique sensor
     */
	public static final String TEMPERATURE_EVENT = BASE_NAME + ".event.TEMPERATURE";

    /** 
     * Broadcast Intent sent from manager only when there is new data to see.
     * FOOT_POD has extras as follows.
     * int COUNT strides for this event
     * float AMOUNT speed at this event in m/s
     * float CADANCE stride rate per minute
     * float DISTANCE distance covered for this event
     * int DB_ID database ID for this unique sensor
     */
	public static final String FOOT_POD_EVENT = BASE_NAME + ".event.FOOT_POD";

    /** 
     * Broadcast Intent sent from manager only when there is new data to see.
     * MUSCLE_OXYGEN has extras as follows.
     * float AMOUNT Hemoglobin concentration g/dl
     * float PERCENT Saturated hemoglobin %
     * boolean ERROR indicates ambient light to bright error.
     * int DB_ID database ID for this unique sensor
     */
	public static final String MUSCLE_OXYGEN_EVENT = BASE_NAME + ".event.MUSCLE_OXYGEN";
	
	// other sensor events not so common
	/** 
	 * Broadcast Intent sent only once per session if the sensor reports it's batter is critical.
	 * String URI is the URI to access the database for the sensors information.
     * int DB_ID database ID for this unique sensor
	 */
	
    public static final String BATTERY_CRITICAL_EVENT = BASE_NAME + ".note.BATTERY_CRITICAL_EVENT";
    /** 
     * Broadcast Intent sent when a START_SENSOR_TYPE_ACTION stops searching for sensors
     * either from finding a sensor or timing out.  You get a NEW_SENSOR_EVENT if a sensor is found. 
     */
    public static final String SEARCH_ENDED_EVENT = BASE_NAME + ".note.SEARCH_ENDED";
    /** 
     * Broadcast Intent sent on loosing a sensor or failing to find one.
     * String URI is the URI to access the database for the sensors information.
     * int DB_ID database ID for this unique sensor, if we had found one.
     * int DEVICE_TYPE of the sensor we were looking for.
     */
    public static final String RX_TIMEOUT_EVENT = BASE_NAME + ".note.RX_TIMEOUT_EVENT";
    /** 
     * Broadcast Intent sent with details of an active sensor.  
     * Sent on initial connection to a sensor or when a new app wants the same sort of sensor as is already open
     * String URI is the URI to access the database for the sensors information.
     * int DB_ID database ID for this unique sensor
     * int CHANNEL ant channel for the device.  If you want to decode the raw ant messages this lets you know
     * which channel which sensors are on.
     * int TYPE sensor type.  This is new with 1.0.8 version.  The same BTLE sensor can be multiple ANT types and 
     * will send multiple NEW_SENSOR_EVENTs for each type.
     */
    public static final String NEW_SENSOR_EVENT = BASE_NAME + ".note.NEW_SENSOR_EVENT";
    /** 
     * Broadcast Intent sent in response to a calibration request. 
     * indicates success or failure and the returned code from the device.
     * int DB_ID database ID for this unique sensor
     * boolean RESULT true for success false for failure.
     * int RESULT_CODE result code from the sensor.
     */
    public static final String CALIBRATION_EVENT = BASE_NAME + ".event.CALIBRATION_EVENT";
    
	
	/** 
	 * Extras to go with the various broadcast intents.
	 */
	public static final String COUNT = "count";
	public static final String TIME = "time";
	public static final String AMOUNT = "amount";
	public static final String LOW = "low";
	public static final String HIGH = "high";
	public static final String PERCENT = "percent";
	public static final String EFFECT = "effect";
	public static final String CADANCE = "cadance";
	public static final String DISTANCE = "distance";
	public static final String URI = "uri";
	public static final String ERROR = "error";
	public static final String DB_ID = "bd_id";
	public static final String CHANNEL = "channel";
	public static final String RESULT = "result";
	public static final String RESULT_CODE = "result_code";
	public static final String CAL_TYPE = "cal_type";
	public static final String VALUE = "value";
	public static final String RR = "rr";
//	public static final String TYPE = "type";
    
	
	// various actions
    // these first two are fake and may be removed.
	public static final String REGISTER_ACTION = BASE_NAME + ".action.REGISTER";
	public static final String UNREGISTER_ACTION = BASE_NAME + ".action.UNREGISTER";
	
	// basic startup of the Ant service.
	/** 
	 * StartService Intent sent to register this app with the manager
	 * Extra String NAME should contain the name of the application making the request.
	 * Extra FLAGS can contain the following.
	 * Extra API_VERSION should contain the API_VERSION_EXTRA
	 * KEEP_ANT_IN_AIRPLANE_MODE means that once started the Ant radio will not be stopped on entering airplane mode.
	 * The Service will respond with the ANT_READY broadcast straight away if already initialised,
	 * or after a delay if this is the first App.  The delay may be lengthy if the Ant radio needs
	 * to be claimed via user intervention.  Failure to init will result in an ANT_NOT_READY broadcast.
	 * */
    public static final String REGISTER_ANT_ACTION = BASE_NAME + ".action.REGISTER_ANT";
    /** 
     * StartService intent used to unregister the application.
     * Extra String NAME should contain the name of the application making the request.
     */
    public static final String UNREGISTER_ANT_ACTION = BASE_NAME + ".action.UNREGISTER_ANT";
    /**
     * StartSensor intent used to get the service to start looking for a specific sensor type or types.
     * Extras are.
     * int DEVICE_TYPE 
     *   0 is wildcard. 
     *   1-255 are standard Ant types for a specific sensor type.
     *   DEVICE_TYPE_BIKE_ALL will look for multiple bike sensor types eg spd, cas, spd+cad, Power.
     * int DEVICE_ID
     *   0 is wildcard use for pairing.
     *   1-0xffff a specific device id, only use with a specific DEVICE_TYPE
     *   KNOWN_SENSORS looks for sensors already paired of this type or class. This is the normal case.
     *   UNKNOWN_SENSORS looks for sensors that have not been seen before.
     *   WILDCARD_IF_NONE is a flag that can be ored in to control what happens if there are no known sensors.
     *   BT_MAC_ADDRESS string is used in the case of a specific bluetooth device being needed.
     */
    public static final String START_SENSOR_TYPE_ACTION = BASE_NAME + ".action.START_SENSOR_TYPE";

    /**
     * StartService intent used to close the channel for the specified sensor if open.
     * Extras are.
     * int BD_ID 
     *   database id for the sensor to close.
     */
    public static final String CLOSE_SENSOR_ACTION = BASE_NAME + ".action.CLOSE_SENSOR";
    
    public static final int STANDARD_CALIBRATION = 0;
    public static final int SET_AUTO_ZERO = 1;
    public static final int SET_SLOPE = 2;
    public static final int GET_PAGE = 3;
    public static final int SET_CRANK_LENGTH = 4;
     /**
     * StartService intent used to calibrate the specified sensor if open.
     * Extras are.
     * int BD_ID database id for the sensor to calibrate.
     * int CAL_TYPE optional type defaults to STANDARD_CALIBRATION can also be SET_AUTO_ZERO or SET_SLOPE
     * int VALUE value to set when doing SET_AUTO_ZERO or SET_SLOPE
     */
    public static final String CALIBRATE_SENSOR_ACTION = BASE_NAME + ".action.CALIBRATE_SENSOR";
    
	/**
	 * Extras to go with the various StartService Intents
	 */
    public static final int KEEP_ANT_IN_AIRPLANE_MODE = 1;
    
	public static final String NAME = "name";
    public static final String FLAGS = "flags";
    public static final String DEVICE_TYPE = "device_type";
    public static final String DEVICE_ID = "device_id";
    public static final String API_VERSION_EXTRA = "api_version";
    
    /**
     * Constant used for KNOWEN_SENSORS to indicate all bike sensor types.
     */
    public static final int DEVICE_TYPE_BIKE_ALL = 0x01000000;
    /**
     * constant used for DEVICE_ID to indicate we want known sensors only.
     */
    public static final int KNOWN_SENSORS = 0x01000000;
    /**
     * constant used for DEVICE_ID to indicate we want unknown sensors only.
     */
    public static final int UNKNOWN_SENSORS = 0x03000000; // this really is 3
    /**
     * flag used with DEVICE_ID to indicate what to do when we have seen no sensors of this type.
     */
    public static final int WILDCARD_IF_NONE = 0x04000000;

    /**
     * flag used with DEVICE_ID to indicate we want KNOWN_SENSORS but multiple of the same sort are OK.
     */
    public static final int ALL_KNOWEN_SENSORS = 0x10000000;
    
    /**
     * HR device type
     */
    public static final int DEVICE_TYPE_HR = 0x78;
    /**
     * BIKE_SPEED device type
     */
    public static final int DEVICE_TYPE_BIKE_SPD = 0x7B;
    /**
     * BIKE_CADENCE device type
     */
    public static final int DEVICE_TYPE_BIKE_CAD = 0x7A;
    /**
     * BIKE_SPEED & CADENCE device type
     */
    public static final int DEVICE_TYPE_BIKE_SPDCAD = 0x79;
    /**
     * BIKE_POWER device type
     */
    public static final int DEVICE_TYPE_BIKE_POWER = 0x0B;
    /**
     * ENVIRONMENT device type
     */
    public static final int DEVICE_TYPE_ENVIRONMENT = 0x19;
    /**
     * MUSCLE_OXYGEN device type
     */
    public static final int DEVICE_TYPE_MUSCLE_OXYGEN = 0x1f;
    /**
     * FOOT_POD device type
     */
    public static final int DEVICE_TYPE_FOOT_POD = 124;

    /**
     * Wildcard constant for device type and device id
     */
    public static final int WILDCARD = 0;
	
	// Content Provider related.
	
    public static final String AUTHORITY = BASE_NAME;
    // EXPOSED TABLES
    public static final String ANT_SENSOR_TABLE_NAME = "ant_sensor";
    // URIS TO GET TABLES
    public static final Uri CONTENT_URI_ANT_SENSOR = Uri.parse("content://"
            + AUTHORITY + "/" + ANT_SENSOR_TABLE_NAME);
    public static final String DEFAULT_SORT_ORDER = "_id DESC";

    // ant_sensor
    public static final String _ID = "_id";
//    public static final String NAME = "name";
    public static final String TYPE = "type";
    public static final String TYPE_STRING = "type_string";
    public static final String TRANS_TYPE = "t_type";
    public static final String DEV_ID = "dev_id";
    public static final String BAT_TIME = "bat_time";
    public static final String MAN_ID = "man_id";
    public static final String MODEL_NO = "model_no";
    public static final String HW_VE = "hw_ve";
    public static final String SW_VE = "sw_ve";
    public static final String SN = "sn";
    public static final String BAT_STATE = "bat_state";
    public static final String BAT_VOLT = "bat_volt";
    public static final String STATE_STRING = "state_string";
    public static final String PAIR_FLAGS = "pair_flags";
    public static final String EXTRA_INT = "extra_int";
    public static final String EXTRA_STRING = "extra_string";
    public static final String QUALITY_SESSION = "quality_session";
    public static final String QUALITY_RECENT = "quality_recent";
    
    // the following are from the extra string stuff which is a bit of a hack to avoid changing the database schema.
    public static final String AUTO_ZERO_STATUS = "auto_zero_status";
    public static final String BT_MAC_ADDRESS = "bt_mac_address";
    public static final String BT_DECODE_TYPE = "bt_decode_type";
    public static final String BTLE_TYPE = "btle_type";
    public static final String BT_HR_ZEPHYR = "Zephyr";
    public static final String BT_HR_POLAR = "Polar";
    public static final String BT_HR_ST_HRM1 = "SportsTracker HRM1";
    public static final String BT_HR_UNKNOWEN = "Unknown";
    
    public static final String ACTION_SENSOR_PICK = BASE_NAME + ".ACTION.SENSOR_PICK";
    public static final String ACTION_SENSOR_VIEW = BASE_NAME + ".ACTION.SENSOR_VIEW";
    public static final String ACTION_SENSOR_EDIT = BASE_NAME + ".ACTION.SENSOR_EDIT";

    /**
     * The MIME type of {@link #CONTENT_URI} providing a directory of sensors.
     */
    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.iforpowell.antplus.sensor";

    /**
     * The MIME type of a {@link #CONTENT_URI} sub-directory of a single sensor.
     */
    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.iforpowell.antplus.sensor";
}

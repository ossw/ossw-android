package com.iforpowell.android.ipantmanapi;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.althink.android.ossw.R;

/**
 * Base class for the various ant sensors Just hold the common information that
 * you may want to display to the user. Can interact with the database of Ant
 * Sensors.
 * 
 * @author Ifor
 * 
 */
public class SensorBase {

    public static final String[] PROJECTION = new String[]{IpAntManApi._ID, // 0
            IpAntManApi.NAME, // 1
            IpAntManApi.TYPE, // 2
            IpAntManApi.TRANS_TYPE, // 3
            IpAntManApi.DEV_ID, // 4
            IpAntManApi.BAT_TIME, // 5
            IpAntManApi.MAN_ID, // 6
            IpAntManApi.MODEL_NO, // 7
            IpAntManApi.HW_VE, // 8
            IpAntManApi.SW_VE, // 9
            IpAntManApi.SN, // 10
            IpAntManApi.BAT_STATE, // 11
            IpAntManApi.BAT_VOLT, // 12
            IpAntManApi.TYPE_STRING, // 13
            IpAntManApi.STATE_STRING, // 14
            IpAntManApi.PAIR_FLAGS, // 15
            IpAntManApi.EXTRA_INT, // 16
            IpAntManApi.EXTRA_STRING, // 17
            IpAntManApi.QUALITY_SESSION, // 18
            IpAntManApi.QUALITY_RECENT, // 19
    };

    /** The index of the various columns */
    public static final int COLUMN_INDEX_ID = 0;
    public static final int COLUMN_INDEX_NAME = 1;
    public static final int COLUMN_INDEX_TYPE = 2;
    public static final int COLUMN_INDEX_TRANS_TYPE = 3;
    public static final int COLUMN_INDEX_DEV_ID = 4;
    public static final int COLUMN_INDEX_BAT_TIME = 5;
    public static final int COLUMN_INDEX_MAN_ID = 6;
    public static final int COLUMN_INDEX_MODEL_NO = 7;
    public static final int COLUMN_INDEX_HW_VE = 8;
    public static final int COLUMN_INDEX_SW_VE = 9;
    public static final int COLUMN_INDEX_SN = 10;
    public static final int COLUMN_INDEX_BAT_STATE = 11;
    public static final int COLUMN_INDEX_BAT_VOLT = 12;
    public static final int COLUMN_INDEX_TYPE_STRING = 13;
    public static final int COLUMN_INDEX_STATE_STRING = 14;
    public static final int COLUMN_INDEX_PAIR_FLAGS = 15;
    public static final int COLUMN_INDEX_EXTRA_INT = 16;
    public static final int COLUMN_INDEX_EXTRA_STRING = 17;
    public static final int COLUMN_INDEX_QUALITY_SESSION = 18;
    public static final int COLUMN_INDEX_QUALITY_RECENT = 19;
    
    public static final int AP_BIKE_POWER_TYPE = 11;
    public static final int AP_MS_SPEED_DISTANCE_TYPE = 15;
    public static final int AP_AUDIO_CONTROL_TYPE = 16;
    public static final int AP_FITTNES_EQUIPMENT_TYPE = 17;
    public static final int AP_BLOOD_PRESURE_TYPE = 18;
    public static final int AP_GEO_CACHE_TYPE = 19;
    public static final int AP_LEV_TYPE = 20;
    public static final int AP_ENVIRONMENT_TYPE = 25;
    public static final int AP_MUSCLE_OXYGEN_TYPE = 31;
    public static final int AP_WEIGHT_SCALES_TYPE = 119;
    public static final int AP_HEART_RATE_TYPE = 120;
    public static final int AP_BIKE_SPEED_CADENCE_TYPE = 121;
    public static final int AP_BIKE_CADENCE_TYPE = 122;
    public static final int AP_BIKE_SPEED_TYPE = 123;
    public static final int AP_FOOT_SPEED_CADENCE_TYPE = 124;
    // This is a fake types for the combined btle Viiiiva style sensor.
    public static final int MULTI_TYPE_ALL = 127;
    
    // MASKS FOR THE BTLE TYPE.
    public static final int HR_MASK = 1;
    public static final int CSC_MASK = 2;
    public static final int RSC_MASK = 4;
    public static final int POWER_MASK = 8;

    protected static final int PAGE_OFFSET = 3;
    protected static final String TAG = "IpSensorMan";

    protected Context mCtxt;
    protected Uri mUri;
    protected Cursor mCursor = null;

    public enum BatteryState {
        NEW, GOOD, OK, LOW, CRITICAL, UNKNOWEN
    }

    // everything is signed in java so we need more space then you think

    protected int mDbId;
    protected String mName;
    protected byte mType; // 8 bits
    protected byte mTransType; // 8 bits
    protected short mDevId; // 16 bits
    protected int mBatTime; // about 28 bits
    protected short mManId; // 16 bits
    protected short mModelNo; // 16 bits
    protected byte mHwVe; // 8 bits
    protected byte mSwVe; // 8 bits
    protected int mSN; // 32 bits
    protected BatteryState mBatState; // 3 bits
    protected float mBatVolt; // 4.8 input.
    protected String mTypeString;
    protected String mStateString;
    protected int mPairFlags;
    protected int mExtraInt;
    protected String mExtraString;
    protected float mQualitySession;
    protected float mQualityRecent;
    //generic extra data stored in mExtraString
    // we use this to add the nessasary bluetooth flags
    protected LinkedHashMap<String, String> mExtraStringValues;

    /** Possible states of a device channel */
    public enum ChannelStates {
        /** Channel was explicitly closed or has not been opened */
        CLOSED,

        /** Channel is opened, but we have not received any data yet */
        SEARCHING,

        /** Channel is opened, and has been good but we are searching again */
        RE_SEARCHING,

        /** Channel is opened and has received measurement data */
        TRACKING,

        /** Channel is closed as the result of a search timeout */
        OFFLINE
    }

    // private so we have to come though the getter and setter so I can automate
    // saves.
    private ChannelStates mChannelState;

    public SensorBase(Context ctxt) {
        mCtxt = ctxt;
        mUri = null;
        mCursor = null;
        mExtraStringValues = new LinkedHashMap<String, String>();
        InitBase();
    }

    public SensorBase(Context ctxt, Uri uri) {
        mCtxt = ctxt;
        mUri = uri;
        mExtraStringValues = new LinkedHashMap<String, String>();
        LoadFromUri();
    }

    // Initalise to unknown values.
    public void InitBase() {
        mDbId = 0;
        mName = "unknown";
        mType = 0; // wildcard default
        mTransType = 0; // wildcard default
        mDevId = 0; // wildcard default
        mBatTime = 0;
        mManId = 0;
        mModelNo = 0;
        mHwVe = 0;
        mSwVe = 0;
        mSN = 0;
        mBatState = BatteryState.UNKNOWEN;
        mBatVolt = 0.0f;
        mTypeString = "";
        mStateString = "";
        mChannelState = ChannelStates.CLOSED;
        mPairFlags = 0;
        mExtraInt = 0;
        mExtraString = "";
        mQualitySession = -1.0f;
        mQualityRecent = -1.0f;
    }

    /**
     * Query the database looking for the device id, if found set the uri return
     * true else false
     */
    public boolean setUriFromIds() {
        ContentResolver cr = mCtxt.getContentResolver();
        if (mCursor != null){
          mCursor.close();
          mCursor = null;
        }
        
        if ((mDevId != 0) & (mUri == null)) {
            // try and find the device id.
            String where = "(" + IpAntManApi.DEV_ID + "=" + mDevId + ")";
            if (mType != 0) {
                where = where + "AND(" + IpAntManApi.TYPE + "=" + mType + ")";
            }
// The plugin api has not trans type avalable so ignore it. 
//            if (mTransType != 0) {
//                where = where + "AND(" + IpAntManApi.TRANS_TYPE + "="
//                        + mTransType + ")";
//            }
            mCursor = cr.query(IpAntManApi.CONTENT_URI_ANT_SENSOR, PROJECTION,
                    where, null, IpAntManApi.DEFAULT_SORT_ORDER);
            if (mCursor != null) {
                if (mCursor.getCount() == 1) {
                    mCursor.moveToFirst();
                    long id = mCursor.getLong(COLUMN_INDEX_ID);
//                    Log.d(TAG, "setUriFromIds ID :" + mDevId + " found _ID :"
//                            + id);
                    mUri = ContentUris.withAppendedId(
                            IpAntManApi.CONTENT_URI_ANT_SENSOR, id);
                    mCursor.close();
                    mCursor = null;
                    return true;
                } else {
                    Log.w(TAG, "setUriFromIds ID :" + mDevId
                            + " wrong count got :" + mCursor.getCount());
                }
                mCursor.close();
                mCursor = null;
            }
        }
        return false;
    }

    public void LoadFromUri() {

        ContentResolver cr = mCtxt.getContentResolver();
        if (mCursor != null){
          mCursor.close();
          mCursor = null;
        }
        boolean ok = true;

        if (mUri == null) {
            // try to find the deviceId
            setUriFromIds();
        }

        if (mUri != null) {
            // cursor.setNotificationUri(mCtxt.getContentResolver(), uri);
            mCursor = cr.query(mUri, PROJECTION, null, null,
                    IpAntManApi.DEFAULT_SORT_ORDER);
            if (mCursor != null) {
                //Log.w(TAG, "LoadFromUri Cursor is :" + mCursor.toString());
                if (mCursor.moveToFirst()) {
                    try {
//                        Log.d(TAG,
//                                "LoadFromUri:" + mUri + " Name:"
//                                        + mCursor.getString(COLUMN_INDEX_NAME));
                        mDbId = mCursor.getInt(COLUMN_INDEX_ID);
                        mName = mCursor.getString(COLUMN_INDEX_NAME);
                        mType = (byte) mCursor.getShort(COLUMN_INDEX_TYPE);
                        mTransType = (byte) mCursor
                                .getShort(COLUMN_INDEX_TRANS_TYPE);
                        mDevId = mCursor.getShort(COLUMN_INDEX_DEV_ID);
                        mBatTime = mCursor.getInt(COLUMN_INDEX_BAT_TIME);
                        mManId = mCursor.getShort(COLUMN_INDEX_MAN_ID);
                        mModelNo = mCursor.getShort(COLUMN_INDEX_MODEL_NO);
                        mHwVe = (byte) mCursor.getShort(COLUMN_INDEX_HW_VE);
                        mSwVe = (byte) mCursor.getShort(COLUMN_INDEX_SW_VE);
                        mSN = mCursor.getInt(COLUMN_INDEX_SN);
                        mBatState = BatteryState.values()[mCursor
                                .getShort(COLUMN_INDEX_BAT_STATE)];
                        mBatVolt = mCursor.getFloat(COLUMN_INDEX_BAT_VOLT);
                        mTypeString = mCursor
                                .getString(COLUMN_INDEX_TYPE_STRING);
                        mStateString = mCursor
                                .getString(COLUMN_INDEX_STATE_STRING);
                        mPairFlags = mCursor.getInt(COLUMN_INDEX_PAIR_FLAGS);
                        mExtraInt = mCursor.getInt(COLUMN_INDEX_EXTRA_INT);
                        mExtraString = mCursor
                                .getString(COLUMN_INDEX_EXTRA_STRING);
                        mQualitySession = mCursor.getFloat(COLUMN_INDEX_QUALITY_SESSION);
                        mQualityRecent = mCursor.getFloat(COLUMN_INDEX_QUALITY_RECENT);
                        setExtrasMapFromString();
//                        Log.d(TAG, "LoadFromUri StateString :" + mStateString
//                                + " mState :" + mChannelState);

                    } catch (Exception e) {
                        Log.e(TAG, "LoadFromUri:" + mUri
                                + " get date exception:", e);
                        ok = false;
                    }
                } else {
                    Log.e(TAG, "LoadFromUri:" + mUri + " row count 0");
                    ok = false;
                }
                // mCursor.close();
                // mCursor = null;
                // we will monitor updates.

            } else {
                Log.e(TAG, "LoadFromUri:" + mUri + " null mCursor.");
                ok = false;
            }
        } else {
            // null uri
            ok = false;
        }
        if (!ok) {
            mUri = null;
            InitBase();
        }
    }

	public void close(){
      if (mCursor != null){
        mCursor.close();
        mCursor = null;
      }
    }

    /** save automatic state to the Uri. Inserts if Uri null */
    public void SaveStateToUri() {
    	setExtraStringFromMap();
        if (mDevId != 0) {
            ContentValues cv = new ContentValues();
            cv.put(IpAntManApi.TYPE, mType);
            cv.put(IpAntManApi.TRANS_TYPE, mTransType);
            cv.put(IpAntManApi.DEV_ID, mDevId);
            cv.put(IpAntManApi.BAT_TIME, mBatTime);
            cv.put(IpAntManApi.MAN_ID, mManId);
            cv.put(IpAntManApi.MODEL_NO, mModelNo);
            cv.put(IpAntManApi.HW_VE, mHwVe);
            cv.put(IpAntManApi.SW_VE, mSwVe);
            cv.put(IpAntManApi.SN, mSN);
            cv.put(IpAntManApi.BAT_STATE, mBatState.ordinal());
            cv.put(IpAntManApi.BAT_VOLT, mBatVolt);
            cv.put(IpAntManApi.EXTRA_INT, mExtraInt);
            cv.put(IpAntManApi.EXTRA_STRING, mExtraString); 
            cv.put(IpAntManApi.QUALITY_SESSION, mQualitySession); 
            cv.put(IpAntManApi.QUALITY_RECENT, mQualityRecent); 

            // for these two we re-evaluate the data rather than using what we
            // loaded.
            cv.put(IpAntManApi.TYPE_STRING, getTypeString(mType));
            String state = getStateString();
            // Log.d(TAG, "SaveToUri state :" + state);
            if (state.equals("null")) {
                state = mStateString;
                // Log.d(TAG, "SaveToUri state null:" + state);
            }
            cv.put(IpAntManApi.STATE_STRING, state);
            doSaveToUri(cv);
        } else {
            // save call but no device id!!!
//            Log.w(TAG, "SaveToUri but no Device Id type " + mType + " Uri :"
//                    + mUri);
        }
    }

	/** save manually set state to the Uri. Inserts if Uri null */
    public void SaveNameToUri() {
        if (mDevId != 0) {
            ContentValues cv = new ContentValues();
            cv.put(IpAntManApi.NAME, mName);
            cv.put(IpAntManApi.PAIR_FLAGS, mPairFlags);         
            doSaveToUri(cv);            
        } else {
            // save call but no device id!!!
//            Log.w(TAG, "SaveNameToUri but no Device Id type " + mType
//                    + " Uri :" + mUri);
        }
    }

    /** save to the Uri. Inserts if Uri null */
    public void SaveToUri() {
    	setExtraStringFromMap();
        if (mDevId != 0) {
            ContentValues cv = new ContentValues();
            cv.put(IpAntManApi.NAME, mName);
            cv.put(IpAntManApi.TYPE, mType);
            cv.put(IpAntManApi.TRANS_TYPE, mTransType);
            cv.put(IpAntManApi.DEV_ID, mDevId);
            cv.put(IpAntManApi.BAT_TIME, mBatTime);
            cv.put(IpAntManApi.MAN_ID, mManId);
            cv.put(IpAntManApi.MODEL_NO, mModelNo);
            cv.put(IpAntManApi.HW_VE, mHwVe);
            cv.put(IpAntManApi.SW_VE, mSwVe);
            cv.put(IpAntManApi.SN, mSN);
            cv.put(IpAntManApi.BAT_STATE, mBatState.ordinal());
            cv.put(IpAntManApi.BAT_VOLT, mBatVolt);
            cv.put(IpAntManApi.QUALITY_SESSION, mQualitySession); 
            cv.put(IpAntManApi.QUALITY_RECENT, mQualityRecent); 

            // for these two we re-evaluate the data rather than using what we
            // loaded.
            cv.put(IpAntManApi.TYPE_STRING, getTypeString(mType));
            String state = getStateString();
            // Log.d(TAG, "SaveToUri state :" + state);
            if (state.equals("null")) {
                state = mStateString;
                // Log.d(TAG, "SaveToUri state null:" + state);
            }
            cv.put(IpAntManApi.STATE_STRING, state);

            cv.put(IpAntManApi.PAIR_FLAGS, mPairFlags);
            cv.put(IpAntManApi.EXTRA_INT, mExtraInt);
            cv.put(IpAntManApi.EXTRA_STRING, mExtraString);
            doSaveToUri(cv);
        } else {
            // save call but no device id!!!
            Log.w(TAG, "SaveToUri but no Device Id type " + mType + " Uri :"
                    + mUri);
        }
    }

    protected void doSaveToUri(ContentValues cv) {
        try {
            if (mUri == null) {
                mUri = mCtxt.getContentResolver().insert(
                        IpAntManApi.CONTENT_URI_ANT_SENSOR, cv);
                mDbId = Integer.valueOf(mUri.getLastPathSegment());
//                Log.d(TAG, "insert " + mUri + " Id :" + mDbId);
            } else {
                mCtxt.getContentResolver().update(mUri, cv, null, null);
//                Log.d(TAG, "update " + mUri);
                mCtxt.getContentResolver().notifyChange(mUri, null); 
            }
        } catch (Exception e) {
            Log.e(TAG, "SaveToUri:" + mUri + " Db Error", e);
        }
    }

    private String getStateString() {
        return ("" + mChannelState);
    }

    public String getTypeString(int type) {
        int resid = 0;
        switch (type) {
            case AP_BIKE_POWER_TYPE :
                resid = R.string.power;
                break;
            case AP_MS_SPEED_DISTANCE_TYPE :
                resid = R.string.ms_speed_distance;
                break;
            case AP_AUDIO_CONTROL_TYPE :
                resid = R.string.audio_control;
                break;
            case AP_FITTNES_EQUIPMENT_TYPE :
                resid = R.string.fittness_equipment;
                break;
            case AP_BLOOD_PRESURE_TYPE :
                resid = R.string.blood_pressure;
                break;
            case AP_GEO_CACHE_TYPE :
                resid = R.string.geo_cache;
                break;
            case AP_LEV_TYPE :
                resid = R.string.lev;
                break;
            case AP_ENVIRONMENT_TYPE :
                resid = R.string.environment;
                break;
            case AP_WEIGHT_SCALES_TYPE :
                resid = R.string.weight_scales;
                break;
            case AP_HEART_RATE_TYPE :
                resid = R.string.heart_rate;
                break;
            case AP_BIKE_SPEED_CADENCE_TYPE :
                resid = R.string.bike_speed_cadence;
                break;
            case AP_BIKE_CADENCE_TYPE :
                resid = R.string.bike_cadence;
                break;
            case AP_BIKE_SPEED_TYPE :
                resid = R.string.bike_speed;
                break;
            case AP_FOOT_SPEED_CADENCE_TYPE :
                resid = R.string.stride_speed_distance;
                break;
            case AP_MUSCLE_OXYGEN_TYPE :
                resid = R.string.muscle_oxygen;
                break;
            case MULTI_TYPE_ALL :
                resid = R.string.multi_type_device;
                break;
            default :
                resid = R.string.unknowen;
        }
        return mCtxt.getString(resid);
    }

    /**
     * @return the mCtxt
     */
    public Context getmCtxt() {
        return mCtxt;
    }

    /**
     * @param mCtxt
     *            the mCtxt to set
     */
    public void setmCtxt(Context mCtxt) {
        this.mCtxt = mCtxt;
    }

    /**
     * @return the mUri
     */
    public Uri getmUri() {
        return mUri;
    }

    /**
     * @param mUri
     *            the mUri to set
     */
    public void setmUri(Uri mUri) {
        this.mUri = mUri;
    }

    /**
     * @return the mName
     */
    public String getmName() {
        return mName;
    }

    /**
     * @param mName
     *            the mName to set
     */
    public void setmName(String mName) {
        this.mName = mName;
    }

    /**
     * @return the mType
     */
    public short getmType() {
        return mType;
    }

    /**
     * @param mType
     *            the mType to set
     */
    public void setmType(byte mType) {
        this.mType = mType;
    }

    /**
     * @return the mTransType
     */
    public short getmTransType() {
        return mTransType;
    }

    /**
     * @param mTransType
     *            the mTransType to set
     */
    public void setmTransType(byte mTransType) {
        this.mTransType = mTransType;
    }

    /**
     * @return the mDevId
     */
    public int getmDevId() {
        return mDevId;
    }

    /**
     * @param mDevId
     *            the mDevId to set
     */
    public void setmDevId(short mDevId) {
        this.mDevId = mDevId;
    }
    
    /**
     * @return the mDevId
     */
    public int getIntDevId() {
        return ((int)mDevId & 0xffff);
    }

    /**
     * @return the mBatTime
     */
    public int getmBatTime() {
        return mBatTime;
    }

    /**
     * @param mBatTime
     *            the mBatTime to set
     */
    public void setmBatTime(int mBatTime) {
        this.mBatTime = mBatTime;
    }

    /**
     * @return the mManId
     */
    public int getmManId() {
        return mManId;
    }

    /**
     * @param mManId
     *            the mManId to set
     */
    public void setmManId(short mManId) {
        this.mManId = mManId;
    }

    /**
     * @return the mModelNo
     */
    public int getmModelNo() {
        return mModelNo;
    }

    /**
     * @param mModelNo
     *            the mModelNo to set
     */
    public void setmModelNo(short mModelNo) {
        this.mModelNo = mModelNo;
    }

    /**
     * @return the mHwVe
     */
    public short getmHwVe() {
        return mHwVe;
    }

    /**
     * @param mHwVe
     *            the mHwVe to set
     */
    public void setmHwVe(byte mHwVe) {
        this.mHwVe = mHwVe;
    }

    /**
     * @return the mSwVe
     */
    public short getmSwVe() {
        return mSwVe;
    }

    /**
     * @param mSwVe
     *            the mSwVe to set
     */
    public void setmSwVe(byte mSwVe) {
        this.mSwVe = mSwVe;
    }

    /**
     * @return the mSN
     */
    public long getmSN() {
        return mSN;
    }

    /**
     * @param mSN
     *            the mSN to set
     */
    public void setmSN(int mSN) {
        this.mSN = mSN;
    }

    /**
     * @return the mBatState
     */
    public BatteryState getmBatState() {
        return mBatState;
    }

    /**
     * @param mBatState
     *            the mBatState to set
     */
    public void setmBatState(BatteryState mBatState) {
        this.mBatState = mBatState;
    }

    /**
     * @return the mBatVolt
     */
    public float getmBatVolt() {
        return mBatVolt;
    }

    /**
     * @param mBatVolt
     *            the mBatVolt to set
     */
    public void setmBatVolt(float mBatVolt) {
        this.mBatVolt = mBatVolt;
    }

    /**
     * @return the mTypeString
     */
    public String getmTypeString() {
        return mTypeString;
    }

    /**
     * @return the mStateString
     */
    public String getmStateString() {
        return mStateString;
    }

    /**
     * @param mChannelState
     *            the mChannelState to set
     */
    public void setmChannelState(ChannelStates mChannelState) {
        boolean change = (this.mChannelState != mChannelState);
        this.mChannelState = mChannelState;
        if (change & (mUri != null)) {
            SaveStateToUri();
        }
    }

    /**
     * @return the mChannelState
     */
    public ChannelStates getmChannelState() {
        return mChannelState;
    }

    /**
     * @return the mDbId
     */
    public int getmDbId() {
        return mDbId;
    }
    
    /**
     * @return the mPairFlags
     */
    public int getmPairFlags() {
        return mPairFlags;
    }

    /**
     * @param mPairFlags the mPairFlags to set
     */
    public void setmPairFlags(int mPairFlags) {
        this.mPairFlags = mPairFlags;
    }

    /**
     * @return the mExtraInt
     */
    public int getmExtraInt() {
        return mExtraInt;
    }

    /**
     * @param mExtraInt the mExtraInt to set
     */
    public void setmExtraInt(int mExtraInt) {
        this.mExtraInt = mExtraInt;
    }

    /**
     * @return the mExtraString
     */
    public String getmExtraString() {
        return mExtraString;
    }

    /**
     * @param mExtraString the mExtraString to set
     */
    public void setmExtraString(String mExtraString) {
        this.mExtraString = mExtraString;
    }

    /**
     * set an extra string parameter
     * parameters stored as name=value,
     */
    public void setExtraStringParam(String name, String value) {
    	mExtraStringValues.put(name, value);
    }

    public String getExtraStringParam(String name) {
        return (mExtraStringValues.get(name));
    }

    private void setExtraStringFromMap() {
    	String res = "";
    	if ((mExtraStringValues != null) && (!mExtraStringValues.isEmpty())){
	    	Iterator<Entry<String, String>> it = mExtraStringValues.entrySet().iterator();
	    	while(it.hasNext()){
	    		Entry<String, String> entry = it.next();//see no explicit cast
	    	    res = res + entry.getKey()+"="+entry.getValue()+"\n";
	    	}
    	}
//    	Log.v(TAG,"setExtraStringFromMap :" + mExtraString);
    	this.mExtraString = res;
	}
    
    private void setExtrasMapFromString() {
    	mExtraStringValues.clear();
    	if (mExtraString != null){
//    		Log.v(TAG, "about to parse mExtraString :" + mExtraString);
    		String[] subst = mExtraString.split("\n");
//    		Log.v(TAG, "subst length :" + subst.length);
    		for(int pos = 0; pos < (subst.length); pos++){
//        		Log.v(TAG, "subst[" + pos + "]=" + subst[pos]);
    			String[] subsub = subst[pos].split("=");
    			if (subsub.length >= 2){
	    			String key = subsub[0];
	    			String val = subsub[1];
//	        		Log.v(TAG, "subst pair :" + key + ":" + val);
	    			mExtraStringValues.put(key, val);
    			}
    		}
    	}
	}
        
    /**
     * @return the mQualitySession
     */
    public float getmQualitySession() {
        return mQualitySession;
    }

    /**
     * @param mQualitySession the mQualitySession to set
     */
    public void setmQualitySession(float mQualitySession) {
        this.mQualitySession = mQualitySession;
    }

    /**
     * @return the mQualityRecent
     */
    public float getmQualityRecent() {
        return mQualityRecent;
    }

    /**
     * @param mQualityRecent the mQualityRecent to set
     */
    public void setmQualityRecent(float mQualityRecent) {
        this.mQualityRecent = mQualityRecent;
    }

    /**
     * @return the mCursor
     */
    public Cursor getmCursor() {
        return mCursor;
    }

    /**
     * @return the battery age as Days:hours:mins:secs format string.
     */
    public String GetBatTimeString() {
        String res = "";
        int days = mBatTime / (60 * 60 * 24);
        res = res + days + ":";
        int rem = mBatTime - (days * 60 * 60 * 24);
        int hours = rem / (60 * 60);
        res = res + hours + ":";
        rem = rem - (hours * 60 * 60);
        int mins = rem / 60;
        res = res + mins + ":";
        int secs = rem - (mins * 60);
        res = res + secs;
        return res;
    }

    public boolean isDefmDevId() {
        return mDevId != 0;
    }

    public boolean isDefmTransType() {
        return mTransType != 0;
    }

    public boolean isDefmBatTime() {
        return mBatTime != 0;
    }

    public boolean isDefmType() {
        return mType != 0;
    }

    public boolean isDefmManId() {
        return mManId != 0;
    }

    public boolean isDefmModelNo() {
        return mModelNo != 0;
    }

    public boolean isDefmHwVe() {
        return mHwVe != 0;
    }

    public boolean isDefmSwVe() {
        return mSwVe != 0;
    }

    public boolean isDefmSN() {
        return mSN != 0;
    }

    public boolean isDefmBatState() {
        return mBatState != BatteryState.UNKNOWEN;
    }

    public boolean isDefmBatVolt() {
        return mBatVolt != 0.0f;
    }

    public boolean isDefmPairFlags() {
        return mPairFlags != 0;
    }

    public boolean isDefmExtraInt() {
        return mExtraInt != 0;
    }

    public boolean isDefmExtraString() {
        return ((mExtraString != null) || (mExtraString.length() != 0));
    }

    public boolean isDefmQualitySession() {
        return (mQualitySession >= 0.0f);
    }

    public boolean isDefmQualityRecent() {
        return (mQualityRecent >= 0.0f);
    }
    
    //Blootooth extensions
    // using extra string list for now for the storage which is a bit hacky.

    public boolean isBt() {
    	return (getExtraStringParam(IpAntManApi.BT_MAC_ADDRESS) != null);
    }

    public boolean isBtle() {
    	return (getExtraStringParam(IpAntManApi.BTLE_TYPE) != null);
    }
    
    public String getBtMacAddress() {
    	return (getExtraStringParam(IpAntManApi.BT_MAC_ADDRESS));
    }

    public void setBtMacAddress(String mac) {
    	setExtraStringParam(IpAntManApi.BT_MAC_ADDRESS, mac);
    }
    
    public String getBtDecodeType() {
    	return (getExtraStringParam(IpAntManApi.BT_DECODE_TYPE));
    }

    public void setBtle(int btle) {
    	String ss = "" + btle;
    	setExtraStringParam(IpAntManApi.BTLE_TYPE, ss);
    }

    public int getBtleType() {
    	int res = 0;
    	String temp = getExtraStringParam(IpAntManApi.BTLE_TYPE);
    	try {
    		res = Integer.parseInt(temp);
    	} catch (Exception e){
    		// anything bad reset to 0
        	setExtraStringParam(IpAntManApi.BTLE_TYPE, "0");
    	}
    	return res;
    }
    
    public void setBtDecodeType(String mac) {
    	setExtraStringParam(IpAntManApi.BT_DECODE_TYPE, mac);
    }
}

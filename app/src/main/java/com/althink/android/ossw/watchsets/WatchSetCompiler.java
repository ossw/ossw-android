package com.althink.android.ossw.watchsets;

import android.util.Log;

import com.althink.android.ossw.watch.WatchConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by krzysiek on 14/06/15.
 */
public class WatchSetCompiler {

    private final static String TAG = WatchSetsFragment.class.getSimpleName();

    public CompiledWatchSet compile(String watchsetData) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        try {
            JSONObject jsonObject = new JSONObject(watchsetData);

            String type = jsonObject.getString("type");
            if (!"watchset".equals(type)) {
                throw new RuntimeException("Invalid file");
            }

            int apiVersion = jsonObject.getInt("apiVersion");
            if (apiVersion != 1) {
                throw new RuntimeException("Invalid api version");
            }

            JSONObject data = jsonObject.getJSONObject("data");

            CompiledWatchSet watchset = new CompiledWatchSet();
            String watchsetName = data.getString("name");

            JSONArray screens = data.getJSONArray("screens");
            Map<String, Integer> screenIdToNumber = new HashMap<>();

            if (screens.length() < 1 || screens.length() > 255) {
                throw new RuntimeException("Invalid number of screens");
            }


            os.write(WatchConstants.WATCH_SET_SECTION_SCREENS);
            // write number of screens
            os.write(screens.length());

            // in first round parse only screen ids
            for (int scrNo = 0; scrNo < screens.length(); scrNo++) {
                JSONObject screen = screens.getJSONObject(scrNo);
                String screenId = screen.getString("id");

                if (screenIdToNumber.containsKey("screenId")) {
                    throw new RuntimeException("Screen " + screenId + " already defined");
                }
                screenIdToNumber.put(screenId, scrNo);
            }

            // parse screen controls and actions
            for (int scrNo = 0; scrNo < screens.length(); scrNo++) {
                JSONObject screen = screens.getJSONObject(scrNo);

                byte[] screenData = parseScreen(screen);
                os.write((screenData.length>>8) & 0xFF);
                os.write(screenData.length & 0xFF);
                os.write(screenData);
            }

            os.write(WatchConstants.WATCH_SET_END_OF_DATA);

            watchset.setName(watchsetName);
            //watchset.setParameters();
            //watchset.setFunctions();
            watchset.setWatchData(os.toByteArray());

            return watchset;
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            throw new RuntimeException(e);
        }

    }

    private byte[] parseScreen(JSONObject screen) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        JSONArray controls = screen.getJSONArray("controls");

        if (controls == null && controls.length() == 0) {
            throw new RuntimeException("Empty screen");
        }

        if (controls.length() > 255) {
            throw new RuntimeException("Too many controls, 255 is max");
        }

        os.write(WatchConstants.WATCH_SET_SCREEN_SECTION_ACTIONS);
        os.write(controls.length());

        for (int controlNo = 0; controlNo < controls.length(); controlNo++) {
            byte[] controlData = compileControl(controls.getJSONObject(controlNo));
            os.write(controlData);
        }

        JSONObject actions = screen.getJSONObject("actions");

        os.write(WatchConstants.WATCH_SET_END_OF_DATA);
        return os.toByteArray();
    }

    private byte[] compileControl(JSONObject control) throws Exception {
        String controlType = control.getString("type");

        switch (controlType) {
            case "integer":
                return compileIntegerControl(control);

        }
        throw new RuntimeException("Not supported control type: " + controlType);
    }

    private byte[] compileIntegerControl(JSONObject control) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        os.write(WatchConstants.SCR_CONTROL_NUMBER);
        os.write(getIntegerNumberFormat(control.getString("numberRange")));
        JSONObject position = control.getJSONObject("position");
        os.write(getIntegerInRange(position, "x", 0, WatchConstants.SCREEN_WIDTH - 1));
        os.write(getIntegerInRange(position, "y", 0, WatchConstants.SCREEN_HEIGHT - 1));
        JSONObject size = control.getJSONObject("size");
        os.write(getIntegerInRange(size, "width", 0, WatchConstants.SCREEN_WIDTH));
        os.write(getIntegerInRange(size, "height", 0, WatchConstants.SCREEN_HEIGHT));

        JSONObject style = control.getJSONObject("style");
        switch (style.getString("type")) {
            case "generated":
                os.write(getIntegerInRange(style, "thickness", 0, 63));
                break;
        }
        os.write(control.optBoolean("leftPadded", false) ? 0x80 : 0);
        JSONObject source = control.getJSONObject("source");
        os.write(compileSource(source));
        return os.toByteArray();
    }

    private int getIntegerNumberFormat(String numberRange) {
        switch(numberRange) {
            case "0_99":
                return WatchConstants.NUMBER_FORMAT_0_99;
            default:
                throw new RuntimeException("Unknown number format: " + numberRange);
        }
    }

    private byte[] compileSource(JSONObject source) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        int type;
        int value;
        switch (source.getString("type")) {
            case "internal":
                type = WatchConstants.DATA_SOURCE_TYPE_INTERNAL;
                value = getInternalSourceKey(source.getString("property"));
                break;
            case "extension":
                type = WatchConstants.DATA_SOURCE_TYPE_EXTERNAL;
                //TODO
                value = 0;
                break;
            default:
                throw new RuntimeException("Unknown type: " + source.getString("type"));
        }

        os.write(type);
        os.write(value);
        return os.toByteArray();
    }

    private int getInternalSourceKey(String property) {
        switch (property) {
            case "hour":
                return WatchConstants.INTERNAL_DATA_SOURCE_TIME_HOUR;
            case "minutes":
                return WatchConstants.INTERNAL_DATA_SOURCE_TIME_MINUTES;
            case "seconds":
                return WatchConstants.INTERNAL_DATA_SOURCE_TIME_SECONDS;
        }
        throw new RuntimeException("Unknown property: " + property);
    }

    private int getIntegerInRange(JSONObject control, String property, int min, int max) throws JSONException {
        int val = control.getInt(property);
        if (val < min || val > max) {
            throw new RuntimeException("Value of " + property + " is not in range");
        }
        return val;
    }
}

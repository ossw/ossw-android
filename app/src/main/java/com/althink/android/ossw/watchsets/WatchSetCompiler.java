package com.althink.android.ossw.watchsets;

import android.util.Log;

import com.althink.android.ossw.service.WatchExtensionFunction;
import com.althink.android.ossw.service.WatchExtensionProperty;
import com.althink.android.ossw.service.WatchOperationContext;
import com.althink.android.ossw.watch.WatchConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by krzysiek on 14/06/15.
 */
public class WatchSetCompiler {

    private Map<String, Integer> screenIdToNumber = new HashMap<>();

    private final static String TAG = WatchSetsFragment.class.getSimpleName();

    private List<WatchExtensionProperty> extensionParameters = new LinkedList<>();

    private List<WatchExtensionFunction> extensionFunctions = new LinkedList<>();

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

            if (screens.length() < 1 || screens.length() > 255) {
                throw new RuntimeException("Invalid number of screens");
            }


            os.write(WatchConstants.WATCH_SET_SECTION_SCREENS);
            // write number of screens
            os.write(screens.length());

            screenIdToNumber.clear();
            extensionParameters.clear();
            extensionFunctions.clear();

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
                os.write((screenData.length >> 8) & 0xFF);
                os.write(screenData.length & 0xFF);
                os.write(screenData);
            }

            os.write(WatchConstants.WATCH_SET_END_OF_DATA);

            watchset.setName(watchsetName);
            watchset.setWatchContext(new WatchOperationContext(extensionParameters, extensionFunctions));
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

        os.write(WatchConstants.WATCH_SET_SCREEN_SECTION_CONTROLS);
        os.write(controls.length());

        for (int controlNo = 0; controlNo < controls.length(); controlNo++) {
            byte[] controlData = compileControl(controls.getJSONObject(controlNo));
            os.write(controlData);
        }

        JSONObject actions = screen.getJSONObject("actions");

        if (actions.length() > 255) {
            throw new RuntimeException("Too many actions");
        }

        os.write(WatchConstants.WATCH_SET_SCREEN_SECTION_ACTIONS);
        os.write(actions.length());

        Iterator<String> events = actions.keys();
        while (events.hasNext()) {
            String eventKey = events.next();
            byte[] actionData = compileAction(eventKey, actions.getJSONObject(eventKey));
            os.write(actionData);
        }

        os.write(WatchConstants.WATCH_SET_END_OF_DATA);
        return os.toByteArray();
    }

    private byte[] compileAction(String eventKey, JSONObject config) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        os.write(getEventId(eventKey));
        String action = config.getString("action");

        int fId;
        int fParam;

        switch (action) {
            case "extensionFunction":
                String extensionId = config.getString("extensionId");
                String function = config.getString("function");
                //String parameter = config.optString("parameter");
                fId = WatchConstants.WATCHSET_FUNCTION_EXTENSION;
                fParam = addExtensionFunction(new WatchExtensionFunction(extensionId, function));
                break;
            case "toggleBacklight":
                fId = WatchConstants.WATCHSET_FUNCTION_TOGGLE_BACKLIGHT;
                fParam = 0;
                break;
            case "toggleColors":
                fId = WatchConstants.WATCHSET_FUNCTION_TOGGLE_COLORS;
                fParam = 0;
                break;
            case "showScreen":
                fId = WatchConstants.WATCHSET_FUNCTION_CHANGE_SCREEN;
                String screenId = config.getString("screenId");
                fParam = resolveScreenId(screenId);
                break;
            case "settings":
                fId = WatchConstants.WATCHSET_FUNCTION_SHOW_SETTINGS;
                fParam = 0;
                break;
            default:
                throw new RuntimeException("Invalid action: " + action);
        }
        os.write(fId);
        os.write(fParam >> 8);
        os.write(fParam & 0xFF);
        return os.toByteArray();
    }

    private int addExtensionFunction(WatchExtensionFunction extensionFunction) {
        int funcIdx = extensionFunctions.indexOf(extensionFunction);
        if (funcIdx < 0) {
            extensionFunctions.add(extensionFunction);
            return extensionFunctions.size() - 1;
        } else {
            return funcIdx;
        }
    }

    private int resolveScreenId(String screenId) {
        Integer screenNo = screenIdToNumber.get(screenId);
        if (screenNo == null) {
            throw new RuntimeException("Screen is not defined: " + screenId);
        }
        return screenNo;
    }

    private int getEventId(String eventKey) {
        switch (eventKey) {
            case "button_up_short":
                return WatchConstants.EVENT_BUTTON_UP_SHORT;
            case "button_select_short":
                return WatchConstants.EVENT_BUTTON_SELECT_SHORT;
            case "button_down_short":
                return WatchConstants.EVENT_BUTTON_DOWN_SHORT;
            case "button_back_short":
                return WatchConstants.EVENT_BUTTON_BACK_SHORT;
            case "button_up_long":
                return WatchConstants.EVENT_BUTTON_UP_LONG;
            case "button_select_long":
                return WatchConstants.EVENT_BUTTON_SELECT_LONG;
            case "button_down_long":
                return WatchConstants.EVENT_BUTTON_DOWN_LONG;
            case "button_back_long":
                return WatchConstants.EVENT_BUTTON_BACK_LONG;
        }
        throw new IllegalArgumentException("Unknown event key: " + eventKey);
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
        switch (numberRange) {
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
                String extensionId = source.getString("extensionId");
                String property = source.getString("property");
                value = addExtensionProperty(new WatchExtensionProperty(extensionId, property));
                break;
            default:
                throw new RuntimeException("Unknown type: " + source.getString("type"));
        }

        os.write(type);
        os.write(value);
        return os.toByteArray();
    }

    private int addExtensionProperty(WatchExtensionProperty parameter) {
        int paramIdx = extensionParameters.indexOf(parameter);
        if (paramIdx < 0) {
            extensionParameters.add(parameter);
            return extensionParameters.size() - 1;
        } else {
            return paramIdx;
        }
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

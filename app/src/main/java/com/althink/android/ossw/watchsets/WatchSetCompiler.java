package com.althink.android.ossw.watchsets;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.althink.android.ossw.plugins.PluginDefinition;
import com.althink.android.ossw.plugins.PluginManager;
import com.althink.android.ossw.service.WatchExtensionFunction;
import com.althink.android.ossw.service.WatchExtensionProperty;
import com.althink.android.ossw.service.WatchOperationContext;
import com.althink.android.ossw.watch.WatchConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
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

    private final static String TAG = WatchSetCompiler.class.getSimpleName();

    private List<WatchExtensionProperty> extensionParameters = new LinkedList<>();

    private List<WatchExtensionFunction> extensionFunctions = new LinkedList<>();

    private Map<String, PluginDefinition> plugins;

    private Context context;

    public WatchSetCompiler(Context context) {
        this.context = context;
    }

    public CompiledWatchSet compile(String watchSetSource, Integer extWatchSetId) {

        plugins = new HashMap<>();
        List<PluginDefinition> pluginList = new PluginManager(context).findPlugins();
        for (PluginDefinition plugin : pluginList) {
            plugins.put(plugin.getPluginId(), plugin);
        }

        try {
            JSONObject jsonObject = new JSONObject(watchSetSource);

            String type = jsonObject.getString("type");
            if (!"watchset".equals(type)) {
                throw new KnownParseError("Invalid file type");
            }

            int apiVersion = jsonObject.getInt("apiVersion");
            if (apiVersion != 1) {
                throw new KnownParseError("Invalid api version");
            }
            String watchsetName = jsonObject.getString("name");

            JSONObject data = jsonObject.getJSONObject("data");

            JSONArray screens = data.getJSONArray("screens");

            if (screens.length() > 255) {
                throw new KnownParseError("Invalid number of screens");
            }

            byte[] screensData = compileScreensSection(screens);

            byte[] extensionPropertiesData = compileExternalProperties();

            CompiledWatchSet watchset = new CompiledWatchSet();
            if (extWatchSetId != null) {
                watchset.setId(extWatchSetId);
            } else {
                watchset.setId(generateWatchSetId());
            }

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            // write watch set id
            os.write(watchset.getId() >> 24);
            os.write(watchset.getId() >> 16 & 0xFF);
            os.write(watchset.getId() >> 8 & 0xFF);
            os.write(watchset.getId() & 0xFF);

            os.write(WatchConstants.WATCH_SET_SECTION_SCREENS);

            os.write(screensData.length >> 8);
            os.write(screensData.length & 0xFF);
            os.write(screensData);

            // write external properties info
            os.write(WatchConstants.WATCH_SET_SECTION_EXTERNAL_PROPERTIES);
            //write number of properties
            os.write(extensionPropertiesData.length >> 8);
            os.write(extensionPropertiesData.length & 0xFF);
            os.write(extensionPropertiesData);

            os.write(WatchConstants.WATCH_SET_END_OF_DATA);

            watchset.setName(watchsetName);
            watchset.setWatchContext(new WatchOperationContext(extensionParameters, extensionFunctions));
            watchset.setWatchData(os.toByteArray());

            if (watchset.getWatchData().length + 1 > 0x1000) {
                throw new KnownParseError("Watchset is too big, this version has 4K bytes limit");
            }

            //Log.i(TAG, "size: " + watchset.getWatchData().length + ", data: " + Arrays.toString(watchset.getWatchData()));

            return watchset;
        } catch (KnownParseError e) {
            throw e;
        } catch (Exception e) {
            //Log.e(TAG, e.getMessage(), e);
            throw new KnownParseError("JSON format error");
        }
    }

    private int generateWatchSetId() {
        String prefKey = "next_watchset_id";
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        int value = sharedPref.getInt(prefKey, 1);
        sharedPref.edit().putInt(prefKey, value + 1).commit();
        return value;
    }

    private byte[] compileExternalProperties() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        os.write(extensionParameters.size());
        for (WatchExtensionProperty property : extensionParameters) {
            //write parameter info
            os.write(property.getType().getKey());
            os.write(property.getRange());
        }
        return os.toByteArray();
    }

    private byte[] compileScreensSection(JSONArray screens) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

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
                throw new KnownParseError("Screen " + screenId + " is already defined");
            }
            screenIdToNumber.put(screenId, scrNo);
        }

        LinkedList<byte[]> screensData = new LinkedList<>();
        // parse screen controls and actions / write screen table
        int screenOffset = 1 + (screens.length() * 2);
        for (int scrNo = 0; scrNo < screens.length(); scrNo++) {
            JSONObject screen = screens.getJSONObject(scrNo);

            byte[] screenData = parseScreen(screen);
            screensData.add(screenData);

            // write screen start address
            os.write((screenOffset >> 8) & 0xFF);
            os.write(screenOffset & 0xFF);
            screenOffset += screenData.length;
        }

        // write screens data
        for (byte[] screenData : screensData) {
            os.write(screenData);
        }
        return os.toByteArray();
    }

    private byte[] parseScreen(JSONObject screen) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        JSONArray controls = screen.getJSONArray("controls");

        if (controls == null && controls.length() == 0) {
            throw new KnownParseError("Empty screen");
        }

        if (controls.length() > 255) {
            throw new KnownParseError("Too many controls, 255 is max");
        }

        os.write(WatchConstants.WATCH_SET_SCREEN_SECTION_CONTROLS);
        os.write(controls.length());

        for (int controlNo = 0; controlNo < controls.length(); controlNo++) {
            byte[] controlData = compileControl(controls.getJSONObject(controlNo));
            os.write(controlData);
        }

        JSONObject actions = screen.optJSONObject("actions");

        os.write(WatchConstants.WATCH_SET_SCREEN_SECTION_ACTIONS);
        if (actions == null) {
            os.write(0); //no actions
        } else {
            if (actions.length() > 255) {
                throw new KnownParseError("Too many actions");
            }

            os.write(actions.length());

            Iterator<String> events = actions.keys();
            while (events.hasNext()) {
                String eventKey = events.next();
                byte[] actionData = compileAction(eventKey, actions.getJSONObject(eventKey));
                os.write(actionData);
            }
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
                String parameter = config.optString("parameter");
                fId = WatchConstants.WATCHSET_FUNCTION_EXTENSION;
                fParam = addExtensionFunction(new WatchExtensionFunction(extensionId, function, parameter));
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
            case "close":
                fId = WatchConstants.WATCHSET_FUNCTION_CLOSE;
                fParam = 0;
                break;
            case "settings":
                fId = WatchConstants.WATCHSET_FUNCTION_SHOW_SETTINGS;
                fParam = 0;
                break;
            default:
                throw new KnownParseError("Invalid action: " + action);
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
            throw new KnownParseError("Screen is not defined: " + screenId);
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
        throw new KnownParseError("Unknown event key: " + eventKey);
    }

    private byte[] compileControl(JSONObject control) throws Exception {
        String controlType = control.getString("type");

        switch (controlType) {
            case "number":
                return compileNumberControl(control);
            case "text":
                return compileTextControl(control);
            case "progress":
                return compileProgressControl(control);

        }
        throw new KnownParseError("Not supported control type: " + controlType);
    }

    private byte[] compileProgressControl(JSONObject control) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        os.write(WatchConstants.SCR_CONTROL_HORIZONTAL_PROGRESS_BAR);
        int maxValue = control.getInt("maxValue");
        os.write(maxValue >> 24);
        os.write(maxValue >> 16 & 0xFF);
        os.write(maxValue >> 8 & 0xFF);
        os.write(maxValue & 0xFF);
        JSONObject position = control.getJSONObject("position");
        os.write(getIntegerInRange(position, "x", 0, WatchConstants.SCREEN_WIDTH - 1));
        os.write(getIntegerInRange(position, "y", 0, WatchConstants.SCREEN_HEIGHT - 1));
        JSONObject size = control.getJSONObject("size");
        os.write(getIntegerInRange(size, "width", 0, WatchConstants.SCREEN_WIDTH));
        os.write(getIntegerInRange(size, "height", 0, WatchConstants.SCREEN_HEIGHT));
        JSONObject style = control.optJSONObject("size");
        int border = 0;
        if (style != null) {
            border = style.optInt("border", 0);
        }
        os.write(border);
        os.write(0); //RFU
        JSONObject source = control.getJSONObject("source");
        os.write(compileSource(source, DataSourceType.NUMBER, buildNumberRangeFromMaxValue(maxValue)));
        return os.toByteArray();
    }

    private int buildNumberRangeFromMaxValue(int maxValue) {
        int bytesNo = 0;
        while (maxValue > 0) {
            maxValue = maxValue / 256;
            bytesNo++;
        }
        return bytesNo;
    }

    private byte[] compileNumberControl(JSONObject control) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        os.write(WatchConstants.SCR_CONTROL_NUMBER);
        int numberRange = getIntegerNumberFormat(control.getString("numberRange"));
        os.write(numberRange);
        JSONObject position = control.getJSONObject("position");
        os.write(getIntegerInRange(position, "x", 0, WatchConstants.SCREEN_WIDTH - 1));
        os.write(getIntegerInRange(position, "y", 0, WatchConstants.SCREEN_HEIGHT - 1));

        JSONObject style = control.getJSONObject("style");
        int digitSpace = getIntegerInRange(style, "space", 0, 31);

        // do not allow left padding for ranges 0-1XXX
        boolean leftPadded = style.optBoolean("leftPadded", false) && (numberRange >> 4) % 2 != 0;
        os.write((leftPadded ? 0x80 : 0) | (digitSpace >> 2));
        switch (style.getString("type")) {
            case "generated":
                os.write((digitSpace & 0x3) << 6 | getIntegerInRange(style, "thickness", 0, 63));
                os.write(getIntegerInRange(style, "width", 0, WatchConstants.SCREEN_WIDTH));
                os.write(getIntegerInRange(style, "height", 0, WatchConstants.SCREEN_HEIGHT));
                break;
        }
        JSONObject source = control.getJSONObject("source");
        os.write(compileSource(source, DataSourceType.NUMBER, numberRange));
        return os.toByteArray();
    }

    private byte[] compileTextControl(JSONObject control) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        os.write(WatchConstants.SCR_CONTROL_TEXT);
        JSONObject position = control.getJSONObject("position");
        os.write(getIntegerInRange(position, "x", 0, WatchConstants.SCREEN_WIDTH - 1));
        os.write(getIntegerInRange(position, "y", 0, WatchConstants.SCREEN_HEIGHT - 1));
        JSONObject size = control.getJSONObject("size");
        os.write(getIntegerInRange(size, "width", 0, WatchConstants.SCREEN_WIDTH));
        os.write(getIntegerInRange(size, "height", 0, WatchConstants.SCREEN_HEIGHT));
        // write style
        int font = parseFont(control.getJSONObject("font"));
        os.write(font);
        int alignment = parseFontAlignment(control.getJSONObject("style"));
        alignment |= parseFontFlags(control.getJSONObject("style"));
        os.write(alignment);
        int flags = 0;//parseFontFlags(control.getJSONObject("style"));
        os.write(flags);
        os.write(0);

        JSONObject source = control.getJSONObject("source");
        os.write(compileSource(source, DataSourceType.STRING, 17));
        return os.toByteArray();
    }

    private int parseFontFlags(JSONObject style) {
        int flags = 0;
        Boolean multiline = style.optBoolean("multiline");
        flags = (multiline != null && multiline) ? WatchConstants.TEXT_FLAGS_MULTILINE : 0x0;
        return flags;
    }

    private int parseFontAlignment(JSONObject style) {
        int alignment = 0;
        String horizontalAlign = style.optString("horizontalAlign");
        if (horizontalAlign != null) {
            switch (horizontalAlign) {
                case "center":
                    alignment |= WatchConstants.HORIZONTAL_ALIGN_CENTER;
                    break;
                case "left":
                    alignment |= WatchConstants.HORIZONTAL_ALIGN_LEFT;
                    break;
                case "right":
                    alignment |= WatchConstants.HORIZONTAL_ALIGN_RIGHT;
                    break;
                default:
                    throw new KnownParseError("Invalid horizontal align: " + horizontalAlign);
            }
        }
        return alignment;
    }

    private int parseFont(JSONObject font) throws JSONException {
        String fontType = font.getString("type");
        String fontName = font.getString("name");
        switch (fontType) {
            case "builtin":
                return buildBuiltinFontData(fontName);
        }
        throw new KnownParseError("Invalid font type: " + fontType);
    }

    private int buildBuiltinFontData(String fontName) {
        switch (fontName) {
            case "optionBig":
                return WatchConstants.FONT_NAME_OPTION_BIG;
            case "optionNormal":
                return WatchConstants.FONT_NAME_OPTION_NORMAL;
            case "smallRegular":
                return WatchConstants.FONT_NAME_SMALL_REGULAR;
            case "smallBold":
                return WatchConstants.FONT_NAME_SMALL_BOLD;
            case "normalRegular":
                return WatchConstants.FONT_NAME_NORMAL_REGULAR;
            case "normalBold":
                return WatchConstants.FONT_NAME_NORMAL_BOLD;
            case "bigRegular":
                return WatchConstants.FONT_NAME_BIG_REGULAR;
            case "bigBold":
                return WatchConstants.FONT_NAME_BIG_BOLD;
        }
        throw new KnownParseError("Invalid font name: " + fontName);
    }

    private int getIntegerNumberFormat(String numberRange) {
        switch (numberRange) {
            case "0-9":
                return WatchConstants.NUMBER_RANGE_0__9;
            case "0-19":
                return WatchConstants.NUMBER_RANGE_0__19;
            case "0-99":
                return WatchConstants.NUMBER_RANGE_0__99;
            case "0-199":
                return WatchConstants.NUMBER_RANGE_0__199;
            case "0-999":
                return WatchConstants.NUMBER_RANGE_0__999;
            case "0-1999":
                return WatchConstants.NUMBER_RANGE_0__1999;
            case "0-9999":
                return WatchConstants.NUMBER_RANGE_0__9999;
            case "0-19999":
                return WatchConstants.NUMBER_RANGE_0__19999;
            case "0-99999":
                return WatchConstants.NUMBER_RANGE_0__99999;
            case "0-9.9":
                return WatchConstants.NUMBER_RANGE_0__9_9;
            case "0-19.9":
                return WatchConstants.NUMBER_RANGE_0__19_9;
            case "0-99.9":
                return WatchConstants.NUMBER_RANGE_0__99_9;
            case "0-199.9":
                return WatchConstants.NUMBER_RANGE_0__199_9;
            case "0-999.9":
                return WatchConstants.NUMBER_RANGE_0__999_9;
            case "0-1999.9":
                return WatchConstants.NUMBER_RANGE_0__1999_9;
            case "0-9999.9":
                return WatchConstants.NUMBER_RANGE_0__9999_9;
            case "0-19999.9":
                return WatchConstants.NUMBER_RANGE_0__19999_9;
            case "0-99999.9":
                return WatchConstants.NUMBER_RANGE_0__99999_9;
            case "0-9.99":
                return WatchConstants.NUMBER_RANGE_0__9_99;
            case "0-19.99":
                return WatchConstants.NUMBER_RANGE_0__19_99;
            case "0-99.99":
                return WatchConstants.NUMBER_RANGE_0__99_99;
            case "0-199.99":
                return WatchConstants.NUMBER_RANGE_0__199_99;
            case "0-999.99":
                return WatchConstants.NUMBER_RANGE_0__999_99;
            case "0-1999.99":
                return WatchConstants.NUMBER_RANGE_0__1999_99;
            case "0-9999.99":
                return WatchConstants.NUMBER_RANGE_0__9999_99;
            case "0-19999.99":
                return WatchConstants.NUMBER_RANGE_0__19999_99;
            case "0-99999.99":
                return WatchConstants.NUMBER_RANGE_0__99999_99;
            default:
                throw new KnownParseError("Unknown number format: " + numberRange);
        }
    }

    private byte[] compileSource(JSONObject source, DataSourceType dataSourceType, int dataSourceRange) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        int type;
        int value;
        switch (source.getString("type")) {
            case "internal":
                type = WatchConstants.DATA_SOURCE_INTERNAL;
                value = getInternalSourceKey(source.getString("property"), dataSourceType, dataSourceRange);
                break;
            case "sensor":
                type = WatchConstants.DATA_SOURCE_SENSOR;
                value = getSensorSourceKey(source.getString("property"), dataSourceType, dataSourceRange);
                break;
            case "extension":
                type = WatchConstants.DATA_SOURCE_EXTERNAL;
                String extensionId = source.getString("extensionId");
                String property = source.getString("property");
                value = addExtensionProperty(new WatchExtensionProperty(extensionId, property, dataSourceType, dataSourceRange));
                break;
            default:
                throw new KnownParseError("Unknown type: " + source.getString("type"));
        }

        os.write(type);
        os.write(value);
        return os.toByteArray();
    }

    private int addExtensionProperty(WatchExtensionProperty property) {
        if (plugins.get(property.getPluginId()) == null) {
            throw new KnownParseError("Plugin is not available: " + property.getPluginId());
        }

        int paramIdx = extensionParameters.indexOf(property);
        if (paramIdx < 0) {
            extensionParameters.add(property);
            return extensionParameters.size() - 1;
        } else {
            WatchExtensionProperty oldProperty = extensionParameters.get(paramIdx);
            if (!oldProperty.getType().equals(property.getType())) {
                throw new KnownParseError("Property " + property.getPropertyId() + " is defined multiple times with different type");
            }
            oldProperty.setRange(mergePropertyRange(property.getType(), property.getRange(), oldProperty.getRange()));
            return paramIdx;
        }
    }

    private int mergePropertyRange(DataSourceType type, int range1, int range2) {
        if (DataSourceType.NUMBER == type) {
            return (Math.max(range1 >> 4, range2 >> 4) << 4) | Math.max(range1 & 0xF, range2 & 0xF);
        }
        return Math.max(range1, range2);
    }

    private int getInternalSourceKey(String property, DataSourceType dataSourceType, int dataSourceRange) {
        if (!dataSourceType.equals(DataSourceType.NUMBER)) {
            throw new IllegalArgumentException("Unknown data source type");
        }
        switch (property) {
            case "hour":
                return WatchConstants.INTERNAL_DATA_SOURCE_TIME_HOUR;
            case "minutes":
                return WatchConstants.INTERNAL_DATA_SOURCE_TIME_MINUTES;
            case "seconds":
                return WatchConstants.INTERNAL_DATA_SOURCE_TIME_SECONDS;
            case "dayOfMonth":
                return WatchConstants.INTERNAL_DATA_SOURCE_DATE_DAY_OF_MONTH;
            case "month":
                return WatchConstants.INTERNAL_DATA_SOURCE_DATE_MONTH;
            case "year":
                return WatchConstants.INTERNAL_DATA_SOURCE_DATE_YEAR;
            case "batteryLevel":
                return WatchConstants.INTERNAL_DATA_SOURCE_BATTERY_LEVEL;
        }
        throw new KnownParseError("Unknown internal property: " + property);
    }

    private int getSensorSourceKey(String property, DataSourceType dataSourceType, int dataSourceRange) {
        if (!dataSourceType.equals(DataSourceType.NUMBER)) {
            throw new IllegalArgumentException("Unknown data source type");
        }
        switch (property) {
            case "heartRate":
                return WatchConstants.SENSOR_DATA_SOURCE_HR;
        }
        throw new KnownParseError("Unknown sensor property: " + property);
    }

    private int getIntegerInRange(JSONObject control, String property, int min, int max) throws JSONException {
        int val = control.getInt(property);
        if (val < min || val > max) {
            throw new KnownParseError("Value of " + property + " is not in range");
        }
        return val;
    }
}

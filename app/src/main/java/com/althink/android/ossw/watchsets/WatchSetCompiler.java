package com.althink.android.ossw.watchsets;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Base64;

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
import java.io.IOException;
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

    private Map<String, Integer> resourceIdToNumber = new HashMap<>();

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

            JSONArray resources = data.optJSONArray("resources");
            if (resources != null) {
                parseResources(resources);
            }

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
            os.write(extensionPropertiesData.length >> 8);
            os.write(extensionPropertiesData.length & 0xFF);
            os.write(extensionPropertiesData);

            if (resources != null) {
                byte[] resourcesData = compileResources(resources);
                os.write(WatchConstants.WATCH_SET_SECTION_RESOURCES);
                os.write(resourcesData.length >> 8);
                os.write(resourcesData.length & 0xFF);
                os.write(resourcesData);
            }

            os.write(WatchConstants.WATCH_SET_END_OF_DATA);

            watchset.setName(watchsetName);
            watchset.setWatchContext(new WatchOperationContext(extensionParameters, extensionFunctions));
            watchset.setWatchData(os.toByteArray());

            //Log.i(TAG, "size: " + watchset.getWatchData().length + ", data: " + Arrays.toString(watchset.getWatchData()));

            return watchset;
        } catch (KnownParseError e) {
            throw e;
        } catch (Exception e) {
            //Log.e(TAG, e.getMessage(), e);
            throw new KnownParseError("JSON format error", e);
        }
    }

    private byte[] compileResources(JSONArray resources) throws JSONException, IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        os.write(resources.length());

        LinkedList<byte[]> resourcesData = new LinkedList<>();

        int resourceDataOffset = 1 + (resources.length() * 3);
        for (int resNo = 0; resNo < resources.length(); resNo++) {
            JSONObject resource = resources.getJSONObject(resNo);

            byte[] resourceData = Base64.decode(resource.getString("data"), Base64.DEFAULT);
            resourcesData.add(resourceData);

            // write resource start address
            os.write((resourceDataOffset >> 16) & 0xFF);
            os.write((resourceDataOffset >> 8) & 0xFF);
            os.write(resourceDataOffset & 0xFF);
            resourceDataOffset += resourceData.length;
        }

        // write resources data
        for (byte[] resourceData : resourcesData) {
            os.write(resourceData);
        }

        return os.toByteArray();
    }

    private void parseResources(JSONArray resources) throws JSONException {
        if (resources.length() > 256) {
            throw new KnownParseError("Too many resources");
        }
        for (int i = 0; i < resources.length(); i++) {
            JSONObject resource = resources.getJSONObject(i);
            resourceIdToNumber.put(resource.getString("id"), i);
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

    private class MemoryAllocator {

        int size = 0;

        public int addBuffer(int size) {
            int ptr = this.size;
            this.size += size;
            return ptr;
        }

        public int getSize() {
            return size;
        }
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

        MemoryAllocator allocator = new MemoryAllocator();

        os.write(WatchConstants.WATCH_SET_SCREEN_SECTION_CONTROLS);
        byte[] screenControlsData = parseScreenControls(controls, allocator);
        os.write((screenControlsData.length >> 8) & 0xFF);
        os.write(screenControlsData.length & 0xFF);
        os.write(screenControlsData);

        JSONObject actions = screen.optJSONObject("actions");

        if (actions != null) {
            os.write(WatchConstants.WATCH_SET_SCREEN_SECTION_ACTIONS);
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

        String defaultActions = screen.optString("defaultActions", null);
        if (defaultActions != null) {
            os.write(WatchConstants.WATCH_SET_SCREEN_SECTION_BASE_ACTIONS);
            switch(defaultActions) {
                case "watchface":
                    os.write(1);
                break;
                default:
                    throw new KnownParseError("Invalid default actions: " + defaultActions);
            }
        }

        os.write(WatchConstants.WATCH_SET_SCREEN_SECTION_MEMORY);
        os.write((allocator.getSize() >> 8) & 0xFF);
        os.write(allocator.getSize() & 0xFF);

        os.write(WatchConstants.WATCH_SET_END_OF_DATA);
        return os.toByteArray();
    }

    private byte[] parseScreenControls(JSONArray controls, MemoryAllocator allocator) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        os.write(controls.length());

        for (int controlNo = 0; controlNo < controls.length(); controlNo++) {
            byte[] controlData = compileControl(controls.getJSONObject(controlNo), allocator);
            os.write(controlData);
        }
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
            case "stopwatchStart":
                fId = WatchConstants.WATCHSET_FUNCTION_STOPWATCH_START;
                fParam = 0;
                break;
            case "stopwatch.stop":
                fId = WatchConstants.WATCHSET_FUNCTION_STOPWATCH_STOP;
                fParam = 0;
                break;
            case "stopwatch.reset":
                fId = WatchConstants.WATCHSET_FUNCTION_STOPWATCH_RESET;
                fParam = 0;
                break;
            case "stopwatch.startStop":
                fId = WatchConstants.WATCHSET_FUNCTION_STOPWATCH_START_STOP;
                fParam = 0;
                break;
            case "stopwatch.nextLap":
                fId = WatchConstants.WATCHSET_FUNCTION_STOPWATCH_NEXT_LAP;
                fParam = 0;
                break;
            case "stopwatch.recall.nextLap":
                fId = WatchConstants.WATCHSET_FUNCTION_STOPWATCH_RECALL_NEXT_LAP;
                fParam = 0;
                break;
            case "stopwatch.recall.prevLap":
                fId = WatchConstants.WATCHSET_FUNCTION_STOPWATCH_RECALL_PREV_LAP;
                fParam = 0;
                break;
            case "stopwatch.recall.firstLap":
                fId = WatchConstants.WATCHSET_FUNCTION_STOPWATCH_RECALL_FIRST_LAP;
                fParam = 0;
                break;
            case "stopwatch.recall.lastLap":
                fId = WatchConstants.WATCHSET_FUNCTION_STOPWATCH_RECALL_LAST_LAP;
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
            case "screen_init":
                return WatchConstants.EVENT_SCREEN_INIT;
        }
        throw new KnownParseError("Unknown event key: " + eventKey);
    }

    private byte[] compileControl(JSONObject control, MemoryAllocator allocator) throws Exception {
        String controlType = control.getString("type");

        switch (controlType) {
            case "number":
                return compileNumberControl(control, allocator);
            case "text":
                return compileTextControl(control, allocator);
            case "progress":
                return compileProgressControl(control, allocator);
            case "image":
                return compileImageControl(control, allocator);
            case "imageFromSet":
                return compileImageFromSetControl(control, allocator);

        }
        throw new KnownParseError("Not supported control type: " + controlType);
    }

    private byte[] compileProgressControl(JSONObject control, MemoryAllocator allocator) throws Exception {
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
        JSONObject style = control.optJSONObject("style");
        int flags = 0;
        String orientation = style.optString("orientation", "horizontal");
        switch (orientation) {
            case "vertical":
                flags |= 0x20;
                break;
            case "horizontal":
                break;
            default:
                throw new KnownParseError("Not supported orientation: " + orientation);
        }
        int border = 0;
        if (style != null) {
            border = style.optInt("border", 0);
        }
        os.write(flags); //RFU
        os.write(border);
        os.write(0); //RFU
        os.write(0); //RFU
        JSONObject source = control.getJSONObject("source");
        int dataSize = buildNumberRangeFromMaxValue(maxValue);
        os.write(compileSource(source, DataSourceType.NUMBER, dataSize));

        int dataPtr = allocator.addBuffer(4);
        os.write((dataPtr >> 8) & 0xFF);
        os.write(dataPtr & 0xFF);

        return os.toByteArray();
    }

    private int buildNumberRangeFromMaxValue(int maxValue) {
        int v = 0;
        while (maxValue > 0) {
            maxValue /= 256;
            v++;
        }
        return v << 5;
    }

    private byte[] compileImageControl(JSONObject control, MemoryAllocator allocator) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        os.write(WatchConstants.SCR_CONTROL_STATIC_IMAGE);
        JSONObject position = control.getJSONObject("position");
        os.write(getIntegerInRange(position, "x", 0, WatchConstants.SCREEN_WIDTH - 1));
        os.write(getIntegerInRange(position, "y", 0, WatchConstants.SCREEN_HEIGHT - 1));

        JSONObject style = control.getJSONObject("style");
        os.write(getIntegerInRange(style, "width", 0, WatchConstants.SCREEN_WIDTH));
        os.write(getIntegerInRange(style, "height", 0, WatchConstants.SCREEN_HEIGHT));

        JSONObject image = control.getJSONObject("image");
        writeResourceType(os, image);
        return os.toByteArray();
    }

    private byte[] compileImageFromSetControl(JSONObject control, MemoryAllocator allocator) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        os.write(WatchConstants.SCR_CONTROL_IMAGE_FROM_SET);
        JSONObject position = control.getJSONObject("position");
        os.write(getIntegerInRange(position, "x", 0, WatchConstants.SCREEN_WIDTH - 1));
        os.write(getIntegerInRange(position, "y", 0, WatchConstants.SCREEN_HEIGHT - 1));

        JSONObject style = control.getJSONObject("style");
        os.write(getIntegerInRange(style, "width", 0, WatchConstants.SCREEN_WIDTH));
        os.write(getIntegerInRange(style, "height", 0, WatchConstants.SCREEN_HEIGHT));

        JSONObject image = control.getJSONObject("imageSet");
        writeResourceType(os, image);

        JSONObject source = control.getJSONObject("source");
        os.write(compileSource(source, DataSourceType.NUMBER, 0x20));

        int dataPtr = allocator.addBuffer(4);
        os.write((dataPtr >> 8) & 0xFF);
        os.write(dataPtr & 0xFF);
        return os.toByteArray();
    }

    private void writeResourceType(ByteArrayOutputStream os, JSONObject image) throws JSONException {
        String imageType = image.getString("type");
        switch (imageType) {
            case "resource":
                String resourceId = image.getString("id");
                os.write(WatchConstants.RESOURCE_SOURCE_ATTACHED);
                os.write(resourceIdToNumber.get(resourceId));
                break;
            default:
                throw new KnownParseError("Invalid image type: " + imageType);

        }
    }

    private byte[] compileNumberControl(JSONObject control, MemoryAllocator allocator) throws Exception {
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

        switch (style.getString("type")) {
            case "generated":
                os.write((leftPadded ? 0x20 : 0) | digitSpace);
                os.write(getIntegerInRange(style, "thickness", 0, 63));
                os.write(getIntegerInRange(style, "width", 0, WatchConstants.SCREEN_WIDTH));
                os.write(getIntegerInRange(style, "height", 0, WatchConstants.SCREEN_HEIGHT));
                break;
            case "numbersFont":
                os.write(0x40 | (leftPadded ? 0x20 : 0) | digitSpace);
                os.write(0);
                JSONObject font = style.getJSONObject("numbersFont");
                writeResourceType(os, font);
                break;
        }
        JSONObject source = control.getJSONObject("source");
        int sourceRange = buildDataSourceRangeFromNumberRange(numberRange);
        os.write(compileSource(source, DataSourceType.NUMBER, sourceRange));

        int dataPtr = allocator.addBuffer(4);
        os.write((dataPtr >> 8) & 0xFF);
        os.write(dataPtr & 0xFF);
        return os.toByteArray();
    }

    private int buildDataSourceRangeFromNumberRange(int range) {

        int size = 0;
        if (range == WatchConstants.NUMBER_RANGE_0__9 ||
                range == WatchConstants.NUMBER_RANGE_0__19 ||
                range == WatchConstants.NUMBER_RANGE_0__99 ||
                range == WatchConstants.NUMBER_RANGE_0__199 ||
                range == WatchConstants.NUMBER_RANGE_0__9_9 ||
                range == WatchConstants.NUMBER_RANGE_0__19_9) {
            size = 1;
        } else if (range == WatchConstants.NUMBER_RANGE_0__999 ||
                range == WatchConstants.NUMBER_RANGE_0__1999 ||
                range == WatchConstants.NUMBER_RANGE_0__9999 ||
                range == WatchConstants.NUMBER_RANGE_0__19999 ||
                range == WatchConstants.NUMBER_RANGE_0__99_9 ||
                range == WatchConstants.NUMBER_RANGE_0__199_9 ||
                range == WatchConstants.NUMBER_RANGE_0__999_9 ||
                range == WatchConstants.NUMBER_RANGE_0__1999_9 ||
                range == WatchConstants.NUMBER_RANGE_0__9_99 ||
                range == WatchConstants.NUMBER_RANGE_0__19_99 ||
                range == WatchConstants.NUMBER_RANGE_0__99_99 ||
                range == WatchConstants.NUMBER_RANGE_0__199_99) {
            size = 2;
        } else if (range == WatchConstants.NUMBER_RANGE_0__99999 ||
                range == WatchConstants.NUMBER_RANGE_0__9999_9 ||
                range == WatchConstants.NUMBER_RANGE_0__19999_9 ||
                range == WatchConstants.NUMBER_RANGE_0__99999_9 ||
                range == WatchConstants.NUMBER_RANGE_0__999_99 ||
                range == WatchConstants.NUMBER_RANGE_0__1999_99 ||
                range == WatchConstants.NUMBER_RANGE_0__9999_99 ||
                range == WatchConstants.NUMBER_RANGE_0__19999_99 ||
                range == WatchConstants.NUMBER_RANGE_0__99999_99) {
            size = 3;
        }
        return size << 5 | (range&0xF);
    }

    private byte[] compileTextControl(JSONObject control, MemoryAllocator allocator) throws Exception {
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

        int stringLength = control.optInt("length", WatchConstants.DEFAULT_TEXT_EXT_PROPERTY_LENGTH);
        if (stringLength < 0 || stringLength > WatchConstants.MAX_TEXT_EXT_PROPERTY_LENGTH)
            throw new KnownParseError("Text length is not in range [0, " +
                    WatchConstants.MAX_TEXT_EXT_PROPERTY_LENGTH + "]");
        JSONObject source = control.getJSONObject("source");
        os.write(compileSource(source, DataSourceType.STRING, stringLength));

        int dataPtr = allocator.addBuffer(stringLength + 1);
        os.write((dataPtr >> 8) & 0xFF);
        os.write(dataPtr & 0xFF);
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
        String horizontalAlign = style.optString("horizontalAlign", "left");
        switch (horizontalAlign) {
            case "center":
                alignment |= WatchConstants.HORIZONTAL_ALIGN_CENTER;
                break;
            case "left":
                break;
            case "right":
                alignment |= WatchConstants.HORIZONTAL_ALIGN_RIGHT;
                break;
            default:
                throw new KnownParseError("Invalid horizontal align: " + horizontalAlign);
        }
        String verticalAlign = style.optString("verticalAlign", "top");
        switch (verticalAlign) {
            case "top":
                break;
            case "center":
                alignment |= WatchConstants.VERTICAL_ALIGN_CENTER;
                break;
            case "bottom":
                alignment |= WatchConstants.VERTICAL_ALIGN_BOTTOM;
                break;
            default:
                throw new KnownParseError("Invalid vertical align: " + verticalAlign);
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
        int type = 0;
        int value;
        String converter = source.optString("converter", null);
        if (converter != null) {
            type = getConverterKey(converter)<<2;
        }
        switch (source.getString("type")) {
            case "internal":
                type |= WatchConstants.DATA_SOURCE_INTERNAL;
                value = getInternalSourceKey(source.getString("property"), dataSourceType, dataSourceRange);
                break;
            case "sensor":
                type |= WatchConstants.DATA_SOURCE_SENSOR;
                value = getSensorSourceKey(source.getString("property"), dataSourceType, dataSourceRange);
                break;
            case "extension":
                type |= WatchConstants.DATA_SOURCE_EXTERNAL;
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
            return (Math.max(range1 >> 5, range2 >> 5) << 5) | Math.max(range1 & 0x1F, range2 & 0x1F);
        }
        return Math.max(range1, range2);
    }

    private int getInternalSourceKey(String property, DataSourceType dataSourceType, int dataSourceRange) {
        if (!dataSourceType.equals(DataSourceType.NUMBER)) {
            throw new IllegalArgumentException("Unknown data source type");
        }
        switch (property) {
            case "hour":
                return WatchConstants.INTERNAL_DATA_SOURCE_TIME_HOUR_24;
            case "hour12":
                return WatchConstants.INTERNAL_DATA_SOURCE_TIME_HOUR_12;
            case "hour12designator":
                return WatchConstants.INTERNAL_DATA_SOURCE_TIME_HOUR_12_DESIGNATOR;
            case "minutes":
                return WatchConstants.INTERNAL_DATA_SOURCE_TIME_MINUTES;
            case "seconds":
                return WatchConstants.INTERNAL_DATA_SOURCE_TIME_SECONDS;
            case "dayOfWeek":
                return WatchConstants.INTERNAL_DATA_SOURCE_DATE_DAY_OF_WEEK;
            case "dayOfMonth":
                return WatchConstants.INTERNAL_DATA_SOURCE_DATE_DAY_OF_MONTH;
            case "dayOfYear":
                return WatchConstants.INTERNAL_DATA_SOURCE_DATE_DAY_OF_YEAR;
            case "month":
                return WatchConstants.INTERNAL_DATA_SOURCE_DATE_MONTH;
            case "year":
                return WatchConstants.INTERNAL_DATA_SOURCE_DATE_YEAR;
            case "batteryLevel":
                return WatchConstants.INTERNAL_DATA_SOURCE_BATTERY_LEVEL;

            case "stopwatch.total.time":
                return WatchConstants.INTERNAL_DATA_SOURCE_STOPWATCH_TOTAL_TIME;
            case "stopwatch.currentLap.number":
                return WatchConstants.INTERNAL_DATA_SOURCE_STOPWATCH_CURRENT_LAP_NUMBER;
            case "stopwatch.currentLap.time":
                return WatchConstants.INTERNAL_DATA_SOURCE_STOPWATCH_CURRENT_LAP_TIME;
            case "stopwatch.currentLap.split":
                return WatchConstants.INTERNAL_DATA_SOURCE_STOPWATCH_CURRENT_LAP_SPLIT;
            case "stopwatch.recallLap.number":
                return WatchConstants.INTERNAL_DATA_SOURCE_STOPWATCH_RECALL_LAP_NUMBER;
            case "stopwatch.recallLap.time":
                return WatchConstants.INTERNAL_DATA_SOURCE_STOPWATCH_RECALL_LAP_TIME;
            case "stopwatch.recallLap.split":
                return WatchConstants.INTERNAL_DATA_SOURCE_STOPWATCH_RECALL_LAP_SPLIT;
            case "stopwatch.lastLap.time":
                return WatchConstants.INTERNAL_DATA_SOURCE_STOPWATCH_LAST_LAP_TIME;
        }
        throw new KnownParseError("Unknown internal property: " + property);
    }

    private int getConverterKey(String converterName) {
        switch(converterName) {
            case "msToHours":
               return WatchConstants.CONVERTER_MS_TO_HOURS;
            case "msToMinutesRemainder":
                return WatchConstants.CONVERTER_MS_TO_MINUTES_REMAINDER;
            case "msToSecondsRemainder":
                return WatchConstants.CONVERTER_MS_TO_SECONDS_REMAINDER;
            case "msToCsRemainder":
                return WatchConstants.CONVERTER_MS_TO_CS_REMAINDER;
            case "msRemainder":
                return WatchConstants.CONVERTER_MS_REMAINDER;
        }
        throw new KnownParseError("Unknown converter: " + converterName);
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

package com.althink.android.ossw.emulator.watchset;

import com.althink.android.ossw.emulator.WatchEmulator;
import com.althink.android.ossw.emulator.actions.EmulatorAction;
import com.althink.android.ossw.emulator.actions.EmulatorCompoundAction;
import com.althink.android.ossw.emulator.actions.EmulatorEventHandler;
import com.althink.android.ossw.emulator.actions.EmulatorChooseAction;
import com.althink.android.ossw.emulator.actions.EmulatorModelAction;
import com.althink.android.ossw.emulator.actions.SimpleEmulatorAction;
import com.althink.android.ossw.emulator.control.ChooseEmulatorControl;
import com.althink.android.ossw.emulator.control.EmulatorControl;
import com.althink.android.ossw.emulator.control.ImageEmulatorControl;
import com.althink.android.ossw.emulator.control.ImageFromSetEmulatorControl;
import com.althink.android.ossw.emulator.control.NumberEmulatorControl;
import com.althink.android.ossw.emulator.control.ProgressEmulatorControl;
import com.althink.android.ossw.emulator.control.TextEmulatorControl;
import com.althink.android.ossw.emulator.control.digits.NumbersFontRenderer;
import com.althink.android.ossw.emulator.control.digits.DigitsRenderer;
import com.althink.android.ossw.emulator.control.digits.GeneratedDigits;
import com.althink.android.ossw.emulator.model.EmulatorModelProperty;
import com.althink.android.ossw.emulator.model.IntegerEmulatorModelProperty;
import com.althink.android.ossw.emulator.source.EmulatorAttachedResourceSource;
import com.althink.android.ossw.emulator.source.EmulatorDataSource;
import com.althink.android.ossw.emulator.source.EmulatorDataSourceFactory;
import com.althink.android.ossw.emulator.source.EmulatorResourceSource;
import com.althink.android.ossw.watch.WatchConstants;
import com.althink.android.ossw.watchsets.KnownParseError;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by krzysiek on 14/06/15.
 */
public class WatchSetEmulatorParser {

    private WatchEmulator emulator;

    public WatchSetEmulatorParser(WatchEmulator emulator) {
        this.emulator = emulator;
    }

    private static class ParseContext {
        WatchSetEmulatorModel model;
    }

    public WatchSetEmulatorModel parse(byte[] watchSetData) {
        try {
            InputStream is = new ByteArrayInputStream(watchSetData);
            //skip watchset id
            int id = is.read() << 24;
            id |= is.read() << 16;
            id |= is.read() << 8;
            id |= is.read();

            WatchSetEmulatorModel model = new WatchSetEmulatorModel(id);

            ParseContext ctx = new ParseContext();
            ctx.model = model;

            int key;
            while ((key = is.read()) != WatchConstants.WATCH_SET_END_OF_DATA) {
                // read section size
                int size = is.read() << 8;
                size |= is.read();
                switch (key) {
                    case WatchConstants.WATCH_SET_SECTION_SCREENS:
                        //screens
                        model.setScreens(parseScreens(is, ctx));
                        break;
                    case WatchConstants.WATCH_SET_SECTION_EXTERNAL_PROPERTIES:
                        is.skip(size);
                        break;
                    case WatchConstants.WATCH_SET_SECTION_RESOURCES:
                        model.setResources(parseResources(is, size));
                        break;
                    default:
                        throw new RuntimeException("Unknown key: " + key);
                }
            }
            return model;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Map<Integer, byte[]> parseResources(InputStream is, int size) throws IOException {
        Map<Integer, byte[]> result = new HashMap<>();
        int resNo = is.read();
        int[] resourceOffsets = new int[resNo];
        for (int i = 0; i < resNo; i++) {
            resourceOffsets[i] = is.read() << 16 | is.read() << 8 | is.read();
        }
        for (int i = 0; i < resNo; i++) {
            int resSize = (i == resNo - 1) ? size - resourceOffsets[i] : resourceOffsets[i + 1] - resourceOffsets[i];

            byte[] data = new byte[resSize];
            is.read(data);

            result.put(i, data);
        }


        return result;
    }

    private List<WatchSetScreenEmulatorModel> parseScreens(InputStream is, ParseContext ctx) throws Exception {
        int screensNo = is.read();

        //skip screens table
        for (int i = 0; i < screensNo; i++) {
            is.read();
            is.read();
        }

        List<WatchSetScreenEmulatorModel> screens = new ArrayList<>(screensNo);
        for (int i = 0; i < screensNo; i++) {
            screens.add(parseScreen(is, ctx));
        }
        return screens;
    }

    private WatchSetScreenEmulatorModel parseScreen(InputStream is, ParseContext ctx) throws Exception {
        WatchSetScreenEmulatorModel screen = new WatchSetScreenEmulatorModel();
        int key;
        while ((key = is.read()) != WatchConstants.WATCH_SET_END_OF_DATA) {
            switch (key) {
                case WatchConstants.WATCH_SET_SCREEN_SECTION_CONTROLS:

                    is.read();
                    is.read();

                    //parse controls
                    screen.setControls(parseControls(is, ctx));
                    break;
                case WatchConstants.WATCH_SET_SCREEN_SECTION_ACTIONS:
                    //parse actions
                    screen.setActions(parseEventHandlers(is));
                    break;
                case WatchConstants.WATCH_SET_SCREEN_SECTION_MEMORY:
                    is.read();
                    is.read();
                    break;
                case WatchConstants.WATCH_SET_SCREEN_SECTION_BASE_ACTIONS:
                    //parse base actions
                    is.read();
                    break;
                case WatchConstants.WATCH_SET_SCREEN_SECTION_MODEL:
                    is.read();
                    is.read();
                    screen.setModel(parseModel(is));
                    break;
                default:
                    throw new RuntimeException("Unknown key: " + key);
            }
        }
        return screen;
    }

    private Map<Integer, EmulatorModelProperty> parseModel(InputStream is) throws Exception {
        int variablesNo = is.read();
        Map<Integer, EmulatorModelProperty> properties = new HashMap<>();
        for (int i = 0; i < variablesNo; i++) {
            int type = is.read();//type
            int flags = is.read();//flags
            EmulatorDataSource dataSource = null;
            Integer min = null;
            Integer max = null;

            if ((flags & 0x80) != 0) {
                //read init value
                dataSource = parseDataSource(is);
            }
            boolean overflow = (flags & 0x40) != 0;
            if ((flags & 0x20) != 0) {
                max = is.read() << 8;
                max |= is.read();
            }

            if ((flags & 0x10) != 0) {
                min = is.read() << 8;
                min |= is.read();
            }

            properties.put(i, new IntegerEmulatorModelProperty(dataSource, max, min, overflow));
        }
        return properties;
    }

    private List<EmulatorEventHandler> parseEventHandlers(InputStream is) throws Exception {
        LinkedList<EmulatorEventHandler> actions = new LinkedList<>();
        int eventsNo = is.read();
        for (int i = 0; i < eventsNo; i++) {
            actions.add(parseEventHandler(is));
        }
        return actions;
    }

    private EmulatorEventHandler parseEventHandler(InputStream is) throws Exception {
        int eventId = is.read();
        List<EmulatorAction> emulatorActions = parseActions(is);
        return new EmulatorEventHandler(eventId, new EmulatorCompoundAction(emulatorActions));
    }

    private List<EmulatorAction> parseActions(InputStream is) throws Exception {
        int actionsNo = is.read();
        List<EmulatorAction> actions = new LinkedList<EmulatorAction>();
        for (int i = 0; i < actionsNo; i++) {

            int actionType = is.read();

            if (WatchConstants.WATCHSET_FUNCTION_EXTENSION == actionType || WatchConstants.WATCHSET_FUNCTION_CHANGE_SCREEN == actionType) {
                int parameter = (is.read() << 8) | is.read();
                actions.add(new SimpleEmulatorAction(actionType, parameter));
            } else if (WatchConstants.WATCHSET_FUNCTION_MODEL_INCREMENT == actionType || WatchConstants.WATCHSET_FUNCTION_MODEL_DECREMENT == actionType) {
                int propertyId = is.read();
                actions.add(new EmulatorModelAction(actionType, propertyId));
            } else if (WatchConstants.WATCHSET_FUNCTION_MODEL_SET == actionType || WatchConstants.WATCHSET_FUNCTION_MODEL_ADD == actionType || WatchConstants.WATCHSET_FUNCTION_MODEL_SUBTRACT == actionType) {
                int propertyId = is.read();
                EmulatorDataSource dataSource = parseDataSource(is);
                actions.add(new EmulatorModelAction(actionType, propertyId, dataSource));
            } else if (WatchConstants.WATCHSET_FUNCTION_CHOOSE == actionType) {
                EmulatorDataSource dataSource = parseDataSource(is);
                int optionsNo = is.read();
                HashMap<Object, List<EmulatorAction>> map = new HashMap<>();
                for (int o = 0; o < optionsNo; o++) {
                    int option = is.read();
                    map.put(option, parseActions(is));
                }
                actions.add(new EmulatorChooseAction(dataSource, map));
            } else {
                actions.add(new SimpleEmulatorAction(actionType, 0));
            }
        }
        return actions;
    }

    private List<EmulatorControl> parseControls(InputStream is, ParseContext ctx) throws Exception {
        int controlsNo = is.read();
        List<EmulatorControl> controls = new ArrayList<>(controlsNo);
        for (int i = 0; i < controlsNo; i++) {
            controls.add(parseControl(is, ctx));
        }
        return controls;
    }

    private EmulatorControl parseControl(InputStream is, ParseContext ctx) throws Exception {
        int controlType = is.read();
        switch (controlType) {
            case WatchConstants.SCR_CONTROL_STATIC_IMAGE:
                return parseImageControl(is, ctx);
            case WatchConstants.SCR_CONTROL_IMAGE_FROM_SET:
                return parseImageFromSetControl(is, ctx);
            case WatchConstants.SCR_CONTROL_NUMBER:
                return parseNumberControl(is, ctx);
            case WatchConstants.SCR_CONTROL_TEXT:
                return parseTextControl(is);
            case WatchConstants.SCR_CONTROL_HORIZONTAL_PROGRESS_BAR:
                return parseProgressControl(is);
            case WatchConstants.SCR_CONTROL_CHOOSE:
                return parseChooseControl(is, ctx);
            default:
                throw new RuntimeException("Unknown control type: " + controlType);
        }
    }

    private EmulatorControl parseChooseControl(InputStream is, ParseContext ctx) throws Exception {
        EmulatorDataSource dataSource = parseDataSource(is);
        int optionsNo = is.read();
        Map<Object, List<EmulatorControl>> map = new HashMap<>();
        for (int i = 0; i < optionsNo; i++) {
            int key = 0xFF & is.read();
            map.put(key, parseControls(is, ctx));
        }
        return new ChooseEmulatorControl(dataSource, map);
    }

    private EmulatorControl parseImageControl(InputStream is, ParseContext ctx) throws Exception {
        int x = is.read();
        int y = is.read();
        int width = is.read();
        int height = is.read();
        EmulatorResourceSource resource = parseResource(is, ctx);
        return new ImageEmulatorControl(x, y, width, height, resource);
    }

    private EmulatorControl parseImageFromSetControl(InputStream is, ParseContext ctx) throws Exception {
        int x = is.read();
        int y = is.read();
        int width = is.read();
        int height = is.read();
        EmulatorResourceSource resource = parseResource(is, ctx);
        is.read();
        is.read();
        EmulatorDataSource dataSource = parseDataSource(is);
        return new ImageFromSetEmulatorControl(x, y, width, height, resource, dataSource);
    }

    private EmulatorResourceSource parseResource(InputStream is, ParseContext ctx) throws IOException {
        int type = is.read();
        int id = is.read();
        return new EmulatorAttachedResourceSource(ctx.model, id);
    }

    private EmulatorControl parseNumberControl(InputStream is, ParseContext ctx) throws Exception {
        NumberEmulatorControl.NumberRange numberRange = NumberEmulatorControl.NumberRange.resolveByKey(is.read());
        int x = is.read();
        int y = is.read();
        int style = is.read();

        DigitsRenderer renderer;
        int type = style >> 6;
        int digitSpace = style & 0x1F;
        boolean zeroPadded = (style & 0x20) != 0;
        switch (type) {
            case 0:
                int gen2 = is.read();
                int gen3 = is.read();
                int gen4 = is.read();
                int digitWidth = gen3;
                int digitHeight = gen4;
                int thickness = gen2 & 0x3F;
                renderer = new GeneratedDigits(digitWidth, digitHeight, thickness);
                break;
            case 1:
                is.read(); //zero
                EmulatorResourceSource resource = parseResource(is, ctx);
                renderer = new NumbersFontRenderer(resource);
                break;
            default:
                throw new KnownParseError("Invalid digit type");
        }
        is.read();
        is.read();
        EmulatorDataSource dataSource = parseDataSource(is);
        return new NumberEmulatorControl(numberRange, x, y, digitSpace, zeroPadded, renderer, dataSource);
    }

    private EmulatorControl parseTextControl(InputStream is) throws Exception {
        int x = is.read();
        int y = is.read();
        int width = is.read();
        int height = is.read();
        int style1 = is.read();
        int style2 = is.read();
        int style3 = is.read();
        int style4 = is.read();
        is.read();
        is.read();
        EmulatorDataSource dataSource = parseDataSource(is);

        return new TextEmulatorControl(x, y, width, height, style1 << 24 | style2 << 16 | style3 << 8 | style4, dataSource);
    }

    private EmulatorControl parseProgressControl(InputStream is) throws Exception {
        int maxValue = is.read() << 24;
        maxValue |= is.read() << 16;
        maxValue |= is.read() << 8;
        maxValue |= is.read();
        int x = is.read();
        int y = is.read();
        int width = is.read();
        int height = is.read();
        int style = is.read() << 24;
        style |= is.read() << 16;
        style |= is.read() << 8;
        style |= is.read();
        is.read();
        is.read();
        EmulatorDataSource dataSource = parseDataSource(is);
        return new ProgressEmulatorControl(maxValue, x, y, width, height, style, dataSource);
    }

    private EmulatorDataSource parseDataSource(InputStream is) throws Exception {
        int type = is.read();
        int property = is.read();
        if ((type & 0x80) != 0) {
            is.read();//converter
        }
        switch (type & 0x3F) {
            case WatchConstants.DATA_SOURCE_INTERNAL:
                return EmulatorDataSourceFactory.internalDataSource(property);
            case WatchConstants.DATA_SOURCE_EXTERNAL:
                return EmulatorDataSourceFactory.externalDataSource(property, emulator);
            case WatchConstants.DATA_SOURCE_SENSOR:
                return EmulatorDataSourceFactory.sensorDataSource(property);
            case WatchConstants.DATA_SOURCE_STATIC:
                return EmulatorDataSourceFactory.staticDataSource(property, is);
            case WatchConstants.DATA_SOURCE_WATCHSET_MODEL:
                return EmulatorDataSourceFactory.modelDataSource(property);
            default:
                throw new RuntimeException("unknown data source type: " + type);
        }
    }

}

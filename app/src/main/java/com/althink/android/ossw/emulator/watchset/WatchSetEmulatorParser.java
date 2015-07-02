package com.althink.android.ossw.emulator.watchset;

import com.althink.android.ossw.emulator.WatchEmulator;
import com.althink.android.ossw.emulator.actions.EmulatorAction;
import com.althink.android.ossw.emulator.control.EmulatorControl;
import com.althink.android.ossw.emulator.control.NumberEmulatorControl;
import com.althink.android.ossw.emulator.control.ProgressEmulatorControl;
import com.althink.android.ossw.emulator.control.TextEmulatorControl;
import com.althink.android.ossw.emulator.source.EmulatorDataSource;
import com.althink.android.ossw.emulator.source.EmulatorDataSourceFactory;
import com.althink.android.ossw.watch.WatchConstants;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by krzysiek on 14/06/15.
 */
public class WatchSetEmulatorParser {

    private WatchEmulator emulator;

    public WatchSetEmulatorParser(WatchEmulator emulator) {
        this.emulator = emulator;
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

            int key;
            while ((key = is.read()) != WatchConstants.WATCH_SET_END_OF_DATA) {
                // read section size
                int size = is.read() << 8;
                size |= is.read();
                switch (key) {
                    case WatchConstants.WATCH_SET_SECTION_SCREENS:
                        //screens
                        model.setScreens(parseScreens(is));
                        break;
                    case WatchConstants.WATCH_SET_SECTION_EXTERNAL_PROPERTIES:
                        is.skip(size);
                        break;
                    case WatchConstants.WATCH_SET_SECTION_STATIC_CONTENT:
                        //TODO
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

    private List<WatchSetScreenEmulatorModel> parseScreens(InputStream is) throws Exception {
        int screensNo = is.read();

        //skip screens table
        for (int i = 0; i < screensNo; i++) {
            is.read();
            is.read();
        }

        List<WatchSetScreenEmulatorModel> screens = new ArrayList<>(screensNo);
        for (int i = 0; i < screensNo; i++) {
            screens.add(parseScreen(is));
        }
        return screens;
    }

    private WatchSetScreenEmulatorModel parseScreen(InputStream is) throws Exception {
        WatchSetScreenEmulatorModel screen = new WatchSetScreenEmulatorModel();
        int key;
        while ((key = is.read()) != WatchConstants.WATCH_SET_END_OF_DATA) {
            switch (key) {
                case WatchConstants.WATCH_SET_SCREEN_SECTION_CONTROLS:
                    //parse controls
                    screen.setControls(parseControls(is));
                    break;
                case WatchConstants.WATCH_SET_SCREEN_SECTION_ACTIONS:
                    //parse actions
                    screen.setActions(parseActions(is));
                    break;
                default:
                    throw new RuntimeException("Unknown key: " + key);
            }
        }
        return screen;
    }

    private List<EmulatorAction> parseActions(InputStream is) throws Exception {
        LinkedList<EmulatorAction> actions = new LinkedList<>();
        int actionsNo = is.read();
        for (int i = 0; i < actionsNo; i++) {
            actions.add(parseAction(is));
        }
        return actions;
    }

    private EmulatorAction parseAction(InputStream is) throws Exception {
        int eventId = is.read();
        int actionType = is.read();
        int parameter = (is.read() << 8) | is.read();
        return new EmulatorAction(eventId, actionType, parameter);
    }

    private List<EmulatorControl> parseControls(InputStream is) throws Exception {
        int controlsNo = is.read();
        List<EmulatorControl> controls = new ArrayList<>(controlsNo);
        for (int i = 0; i < controlsNo; i++) {
            controls.add(parseControl(is));
        }
        return controls;
    }

    private EmulatorControl parseControl(InputStream is) throws Exception {
        int controlType = is.read();
        switch (controlType) {
            case WatchConstants.SCR_CONTROL_NUMBER:
                return parseNumberControl(is);
            case WatchConstants.SCR_CONTROL_TEXT:
                return parseTextControl(is);
            case WatchConstants.SCR_CONTROL_HORIZONTAL_PROGRESS_BAR:
                return parseProgressControl(is);
            default:
                throw new RuntimeException("Unknown control type: " + controlType);
        }
    }

    private EmulatorControl parseNumberControl(InputStream is) throws Exception {
        NumberEmulatorControl.NumberRange numberRange = NumberEmulatorControl.NumberRange.resolveByKey(is.read());
        int x = is.read();
        int y = is.read();
        int style1 = is.read();
        int style2 = is.read();
        int style3 = is.read();
        int style4 = is.read();
        EmulatorDataSource dataSource = parseDataSource(is);
        return new NumberEmulatorControl(numberRange, x, y, style1 << 24 | style2 << 16 | style3 << 8 | style4, dataSource);
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
        int style = is.read() << 8;
        style |= is.read();
        EmulatorDataSource dataSource = parseDataSource(is);
        return new ProgressEmulatorControl(maxValue, x, y, width, height, style, dataSource);
    }

    private EmulatorDataSource parseDataSource(InputStream is) throws Exception {
        int type = is.read();
        int property = is.read();
        switch (type) {
            case WatchConstants.DATA_SOURCE_INTERNAL:
                return EmulatorDataSourceFactory.internalDataSource(property);
            case WatchConstants.DATA_SOURCE_EXTERNAL:
                return EmulatorDataSourceFactory.externalDataSource(property, emulator);
            default:
                throw new RuntimeException("unknown data source type: " + type);
        }
    }

}

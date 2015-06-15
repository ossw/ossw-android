package com.althink.android.ossw.emulator.watchset;

import com.althink.android.ossw.emulator.control.EmulatorControl;
import com.althink.android.ossw.emulator.control.NumberEmulatorControl;
import com.althink.android.ossw.emulator.source.EmulatorDataSource;
import com.althink.android.ossw.emulator.source.EmulatorDataSourceFactory;
import com.althink.android.ossw.watch.WatchConstants;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by krzysiek on 14/06/15.
 */
public class WatchSetEmulatorParser {

    public WatchSetEmulatorModel parse(byte[] watchSetData) {
        try {
            InputStream is = new ByteArrayInputStream(watchSetData);

            WatchSetEmulatorModel model = new WatchSetEmulatorModel();

            int key;
            while ((key = is.read()) != WatchConstants.WATCH_SET_END_OF_DATA) {
                switch (key) {
                    case WatchConstants.WATCH_SET_SECTION_SCREENS:
                        //screens
                        model.setScreens(parseScreens(is));

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
        List<WatchSetScreenEmulatorModel> screens = new ArrayList<>(screensNo);
        for (int i = 0; i < screensNo; i++) {
            screens.add(parseScreen(is));
        }
        return screens;
    }

    private WatchSetScreenEmulatorModel parseScreen(InputStream is) throws Exception {
        //skip screen size
        is.read();
        is.read();

        WatchSetScreenEmulatorModel screen = new WatchSetScreenEmulatorModel();
        int key;
        while ((key = is.read()) != WatchConstants.WATCH_SET_END_OF_DATA) {
            switch (key) {
                case WatchConstants.WATCH_SET_SCREEN_SECTION_ACTIONS:
                    //parse controls
                    screen.setControls(parseControls(is));
                    break;
                case WatchConstants.WATCH_SET_SCREEN_SECTION_CONTROLS:
                    //TODO
                    break;
                default:
                    throw new RuntimeException("Unknown key: " + key);
            }
        }
        return screen;
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
        switch(controlType) {
            case WatchConstants.SCR_CONTROL_NUMBER:
                return parseNumberControl(is);
            default:
                throw new RuntimeException("Unknown control type: " + controlType);
        }
    }

    private EmulatorControl parseNumberControl(InputStream is) throws Exception {
        NumberEmulatorControl.NumberFormat numberFormat = NumberEmulatorControl.NumberFormat.resolveByKey(is.read());
        int x = is.read();
        int y = is.read();
        int width = is.read();
        int height = is.read();
        int style1 = is.read();
        int style2 = is.read();
        EmulatorDataSource dataSource = parseDataSource(is);

        int thickness = style1 & 0x3F;
        return new NumberEmulatorControl(numberFormat, x, y, width, height, thickness, dataSource);
    }

    private EmulatorDataSource parseDataSource(InputStream is) throws Exception {
        int type = is.read();
        int property = is.read();
        switch(type) {
            case WatchConstants.DATA_SOURCE_TYPE_INTERNAL:
                return EmulatorDataSourceFactory.internalDataSource(property);
            case WatchConstants.DATA_SOURCE_TYPE_EXTERNAL:
                return EmulatorDataSourceFactory.externalDataSource(property);
            default:
                throw new RuntimeException("unknown data source type: " + type);
        }
    }

}

package com.althink.android.ossw.emulator.control;

import com.althink.android.ossw.emulator.renderer.EmulatorExecutionContext;
import com.althink.android.ossw.emulator.renderer.LowLevelRenderer;
import com.althink.android.ossw.emulator.source.EmulatorDataSource;
import com.althink.android.ossw.watchsets.DataSourceType;

import java.util.List;
import java.util.Map;

/**
 * Created by krzysiek on 22/11/15.
 */
public class ChooseEmulatorControl extends AbstractEmulatorControl {

    private Map<Object, List<EmulatorControl>> controlsMap;

    public ChooseEmulatorControl(EmulatorDataSource dataSource, Map<Object, List<EmulatorControl>> controls) {
        super(dataSource);
        this.controlsMap = controls;
    }

    @Override
    public void draw(LowLevelRenderer renderer, EmulatorExecutionContext ctx) {
        Integer data = (Integer) getData(DataSourceType.NUMBER, 0x40, ctx);
        List<EmulatorControl> controls = controlsMap.get(data);
        if (controls != null) {
            for (EmulatorControl control : controls) {
                control.draw(renderer, ctx);
            }
        } else {
            List<EmulatorControl> otherwise = controlsMap.get(null);
            if (otherwise != null) {
                for (EmulatorControl control : otherwise) {
                    control.draw(renderer, ctx);
                }
            }
        }
    }
}

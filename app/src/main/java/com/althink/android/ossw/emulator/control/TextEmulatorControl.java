package com.althink.android.ossw.emulator.control;

import com.althink.android.ossw.emulator.renderer.LowLevelRenderer;
import com.althink.android.ossw.emulator.source.EmulatorDataSource;

/**
 * Created by krzysiek on 14/06/15.
 */
public class TextEmulatorControl extends AbstractEmulatorControl {
    private int format;
    private int x;
    private int y;
    private int width;
    private int height;

    public TextEmulatorControl(int format, int x, int y, int width, int height, EmulatorDataSource dataSource) {
        super(dataSource);
        this.format = format;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(LowLevelRenderer renderer) {
        String value = (String) getData();
        renderer.drawText(value, x, y, width, height);
    }
}

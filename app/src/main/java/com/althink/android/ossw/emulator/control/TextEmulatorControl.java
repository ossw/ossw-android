package com.althink.android.ossw.emulator.control;

import com.althink.android.ossw.emulator.fonts.FontInfo;
import com.althink.android.ossw.emulator.fonts.OptionsBig;
import com.althink.android.ossw.emulator.renderer.LowLevelRenderer;
import com.althink.android.ossw.emulator.source.EmulatorDataSource;
import com.althink.android.ossw.watchsets.DataSourceType;

/**
 * Created by krzysiek on 14/06/15.
 */
public class TextEmulatorControl extends AbstractEmulatorControl {
    private int x;
    private int y;
    private int width;
    private int height;
    private int style;

    public TextEmulatorControl(int x, int y, int width, int height, int style, EmulatorDataSource dataSource) {
        super(dataSource);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.style = style;
    }

    public void draw(LowLevelRenderer renderer) {
        String value = (String) getData(DataSourceType.STRING, 0);
        int fontType = (style >> 24) & 0xFF;
        int alignment = (style >> 16) & 0xFF;
        renderer.drawText(value, x, y, width, height, fontType, alignment);
    }
}

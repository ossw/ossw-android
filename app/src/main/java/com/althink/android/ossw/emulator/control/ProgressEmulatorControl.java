package com.althink.android.ossw.emulator.control;

import com.althink.android.ossw.emulator.renderer.LowLevelRenderer;
import com.althink.android.ossw.emulator.source.EmulatorDataSource;
import com.althink.android.ossw.watchsets.DataSourceType;

/**
 * Created by krzysiek on 14/06/15.
 */
public class ProgressEmulatorControl extends AbstractEmulatorControl {
    private int maxValue;
    private int x;
    private int y;
    private int width;
    private int height;
    private int style;

    public ProgressEmulatorControl(int maxValue, int x, int y, int width, int height, int style, EmulatorDataSource dataSource) {
        super(dataSource);
        this.maxValue = maxValue;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.style = style;
    }

    public void draw(LowLevelRenderer renderer) {
        Object value = getData(DataSourceType.NUMBER, 0);
        if (value == null || !(value instanceof Integer)) {
            return;
        }
        int intValue = (int) value;
        float percentage = (float) intValue/(float) maxValue;
        if (percentage > 1) {
            percentage = 1;
        }
        renderer.drawRect(x, y, (int) (width * percentage), height);
    }
}

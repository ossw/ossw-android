package com.althink.android.ossw.emulator.control;

import com.althink.android.ossw.emulator.renderer.EmulatorExecutionContext;
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

    public void draw(LowLevelRenderer renderer, EmulatorExecutionContext ctx) {
        Object value = getData(DataSourceType.NUMBER, 0, ctx);
        if (value == null || !(value instanceof Integer)) {
            return;
        }
        int intValue = (int) value;
        float percentage = (float) intValue / (float) maxValue;
        if (percentage > 1) {
            percentage = 1;
        }

        int border = style >> 16 & 0xFF;
        boolean vertical = (style >> 24 & 0x20) != 0;
        int delta = 0;
        if (border > 0) {
            renderer.drawEmptyRect(x, y, width, height, border);
            delta = border + 1;
        }

        if (vertical) {
            int h = height - (2 * delta);
            int barHeight = (int)(h * percentage);
            renderer.drawRect(x + delta, y + delta + h - barHeight, width - 2 * delta, barHeight);
        } else {
            renderer.drawRect(x + delta, y + delta, (int) ((width - (2 * delta)) * percentage), height - (2 * delta));
        }
    }
}

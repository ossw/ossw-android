package com.althink.android.ossw.emulator.control;

import com.althink.android.ossw.emulator.renderer.EmulatorExecutionContext;
import com.althink.android.ossw.emulator.renderer.LowLevelRenderer;
import com.althink.android.ossw.emulator.source.EmulatorDataSource;
import com.althink.android.ossw.emulator.source.EmulatorResourceSource;
import com.althink.android.ossw.watchsets.DataSourceType;

/**
 * Created by krzysiek on 14/06/15.
 */
public class ImageEmulatorControl extends AbstractEmulatorControl {
    private int x;
    private int y;
    private int width;
    private int height;
    private EmulatorResourceSource image;

    public ImageEmulatorControl(int x, int y, int width, int height, EmulatorResourceSource image) {
        super(null);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public void draw(LowLevelRenderer renderer, EmulatorExecutionContext ctx) {
        renderer.drawImage(image.getData(), x, y, width, height);
    }
}

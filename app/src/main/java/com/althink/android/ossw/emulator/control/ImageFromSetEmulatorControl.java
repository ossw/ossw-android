package com.althink.android.ossw.emulator.control;

import com.althink.android.ossw.emulator.renderer.EmulatorExecutionContext;
import com.althink.android.ossw.emulator.renderer.LowLevelRenderer;
import com.althink.android.ossw.emulator.source.EmulatorDataSource;
import com.althink.android.ossw.emulator.source.EmulatorResourceSource;
import com.althink.android.ossw.watchsets.DataSourceType;

/**
 * Created by krzysiek on 14/06/15.
 */
public class ImageFromSetEmulatorControl extends AbstractEmulatorControl {
    private int x;
    private int y;
    private int width;
    private int height;
    private EmulatorResourceSource image;

    public ImageFromSetEmulatorControl(int x, int y, int width, int height, EmulatorResourceSource image, EmulatorDataSource dataSource) {
        super(dataSource);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public void draw(LowLevelRenderer renderer, EmulatorExecutionContext ctx) {
        Object value = getData(DataSourceType.NUMBER, 0, ctx);
        if (value == null) {
            return;
        }
        int intValue = (int) value;

        int firstImageId = 0xFF&image.getData()[2];
        int numberOfImages = 0xFF&image.getData()[3];

        if (intValue < firstImageId || intValue >= firstImageId + numberOfImages) {
            return;
        }

        int imageWidth = 0xFF&image.getData()[4];
        int imageHeight = 0xFF&image.getData()[5];

        int imageNo = intValue - firstImageId;
        int idx = 6 + (((imageWidth + 7) / 8) * imageHeight * imageNo);
        renderer.drawBitmap(image.getData(), idx, x, y, imageWidth, imageHeight, imageWidth);
    }
}

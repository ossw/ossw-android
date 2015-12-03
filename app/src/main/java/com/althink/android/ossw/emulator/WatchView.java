package com.althink.android.ossw.emulator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.althink.android.ossw.emulator.actions.EmulatorAction;
import com.althink.android.ossw.emulator.actions.EmulatorEventHandler;
import com.althink.android.ossw.emulator.control.EmulatorControl;
import com.althink.android.ossw.emulator.control.NumberEmulatorControl;
import com.althink.android.ossw.emulator.control.digits.GeneratedDigits;
import com.althink.android.ossw.emulator.renderer.LowLevelRenderer;
import com.althink.android.ossw.emulator.source.internal.Hour12InternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.Hour24InternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.MinutesInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.watchset.WatchSetEmulatorModel;
import com.althink.android.ossw.emulator.watchset.WatchSetScreenEmulatorModel;
import com.althink.android.ossw.watch.WatchConstants;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by krzysiek on 13/06/15.
 */
public class WatchView extends View {

    private WatchEmulator watchEmulator;

    private Handler viewHandler = new Handler();
    private Runnable updateView = new Runnable() {
        @Override
        public void run() {
            WatchView.this.invalidate();
        }
    };

    private int[] frameBuffer = new int[WatchConstants.SCREEN_WIDTH * WatchConstants.SCREEN_HEIGHT];
    private Bitmap bitmap = Bitmap.createBitmap(WatchConstants.SCREEN_WIDTH, WatchConstants.SCREEN_HEIGHT, Bitmap.Config.ARGB_8888);

    public WatchView(Context context) {
        super(context);
    }

    public WatchView(Context context, AttributeSet attrs) {
        super(context, attrs);

        watchEmulator = new WatchEmulator();

        List<EmulatorControl> controls = new LinkedList<>();
        //controls.add(new NumberEmulatorControl(NumberEmulatorControl.NumberRange.NUMBER_RANGE_0__99, 5, 4, 3, false, new GeneratedDigits(20, 20, 8), new Hour24InternalEmulatorDataSource()));
        //controls.add(new NumberEmulatorControl(NumberEmulatorControl.NumberRange.NUMBER_RANGE_0__99, 5, 85, 3, false, new GeneratedDigits(20, 20, 6), new MinutesInternalEmulatorDataSource()));
        List<WatchSetScreenEmulatorModel> screens = new LinkedList<>();
        screens.add(new WatchSetScreenEmulatorModel(controls, new LinkedList<EmulatorEventHandler>()));
        WatchSetEmulatorModel watchset = new WatchSetEmulatorModel(screens);
        watchEmulator.showWatchSet(watchset);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //long startTime = System.currentTimeMillis();
        LowLevelRenderer renderer = new LowLevelRenderer(canvas, frameBuffer, bitmap);
        watchEmulator.render(renderer);
        renderer.flush();

        //long endTime = System.currentTimeMillis();
        //Log.i("RENDER", "Total time: " + (endTime - startTime));

        viewHandler.postDelayed(updateView, 300);
    }

    public WatchEmulator getWatchEmulator() {
        return watchEmulator;
    }
}
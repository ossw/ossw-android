package com.althink.android.ossw.emulator.actions;

import com.althink.android.ossw.emulator.WatchEmulator;
import com.althink.android.ossw.service.OsswService;
import com.althink.android.ossw.watch.WatchConstants;

/**
 * Created by krzysiek on 19/06/15.
 */
public class EmulatorActionHandler {
    private OsswService service;
    private WatchEmulator emulator;

    public EmulatorActionHandler(OsswService service, WatchEmulator emulator) {
        this.service = service;
        this.emulator = emulator;
    }

    public void invoke(int actionId, int parameter) {

    }
}

package com.althink.android.ossw.emulator.model;

import com.althink.android.ossw.emulator.renderer.EmulatorExecutionContext;

/**
 * Created by krzysiek on 22/11/15.
 */
public interface EmulatorModelProperty {

    void initialize(EmulatorExecutionContext ctx);

    void add(Object value);

    void subtract(Object value);

    void increment();

    void decrement();

    Object getValue();

    void setValue(Object value);
}

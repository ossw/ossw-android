package com.althink.android.ossw.emulator.model;

import com.althink.android.ossw.emulator.renderer.EmulatorExecutionContext;
import com.althink.android.ossw.emulator.source.EmulatorDataSource;
import com.althink.android.ossw.watchsets.DataSourceType;

/**
 * Created by krzysiek on 22/11/15.
 */
public class IntegerEmulatorModelProperty implements EmulatorModelProperty {

    private EmulatorDataSource initValue;

    private Integer min;

    private Integer max;

    private boolean overflow;

    private Integer value;

    public IntegerEmulatorModelProperty(EmulatorDataSource initValue, Integer max, Integer min, boolean overflow) {
        this.initValue = initValue;
        this.max = max;
        this.min = min;
        this.overflow = overflow;
    }

    @Override
    public void initialize(EmulatorExecutionContext ctx) {
        setValue(initValue.getData(DataSourceType.NUMBER, 0x40, ctx));
    }

    @Override
    public void add(Object value) {
        if (this.value != null && value != null) {
            this.value += (Integer) value;
            if (max != null && this.value > max) {
                if (overflow) {
                    this.value = min;
                } else {
                    this.value = max;
                }
            }
        }
    }

    @Override
    public void subtract(Object value) {
        if (this.value != null && value != null) {
            this.value -= (Integer) value;
            if (min != null && this.value < min) {
                if (overflow) {
                    this.value = max;
                } else {
                    this.value = min;
                }
            }
        }
    }

    @Override
    public void increment() {
        if (value != null) {
            value++;
            if (max != null && value > max) {
                if (overflow) {
                    this.value = min;
                } else {
                    this.value = max;
                }
            }
        }
    }

    @Override
    public void decrement() {
        if (value != null) {
            value--;
            if (min != null && value < min) {
                if (overflow) {
                    this.value = max;
                } else {
                    this.value = min;
                }
            }
        }
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) {
        this.value = (Integer) value;
        if (this.value != null) {
            if (max != null && this.value > max) {
                this.value = max;
            }
            if (min != null && this.value < min) {
                this.value = min;
            }
        }
    }
}

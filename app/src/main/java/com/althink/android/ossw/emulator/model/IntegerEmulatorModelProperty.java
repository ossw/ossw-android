package com.althink.android.ossw.emulator.model;

import com.althink.android.ossw.emulator.renderer.EmulatorExecutionContext;
import com.althink.android.ossw.emulator.source.EmulatorDataSource;
import com.althink.android.ossw.watchsets.DataSourceType;

/**
 * Created by krzysiek on 22/11/15.
 */
public class IntegerEmulatorModelProperty implements EmulatorModelProperty {

    private EmulatorDataSource initValue;

    private EmulatorDataSource min;

    private EmulatorDataSource max;

    private boolean overflow;

    private Integer value;

    private EmulatorExecutionContext ctx;

    public IntegerEmulatorModelProperty(EmulatorDataSource initValue, EmulatorDataSource max, EmulatorDataSource min, boolean overflow, EmulatorExecutionContext ctx) {
        this.initValue = initValue;
        this.max = max;
        this.min = min;
        this.overflow = overflow;
        this.ctx = ctx;
    }

    @Override
    public void initialize() {
        setValue(initValue.getData(DataSourceType.NUMBER, 0x40, ctx));
    }

    @Override
    public void add(Object value) {
        if (this.value != null && value != null) {
            this.value += (Integer) value;
            if (max != null) {
                int maxValue = (int) max.getData(DataSourceType.NUMBER, 0, ctx);
                if (this.value > maxValue) {
                    if (overflow && min != null) {
                        this.value = (int) min.getData(DataSourceType.NUMBER, 0, ctx);
                    } else {
                        this.value = maxValue;
                    }
                }
            }
        }
    }

    @Override
    public void subtract(Object value) {
        if (this.value != null && value != null) {
            this.value -= (Integer) value;
            if (min != null) {
                int minValue = (int) min.getData(DataSourceType.NUMBER, 0, ctx);
                if (this.value < minValue) {
                    if (overflow && max != null) {
                        this.value = (int) max.getData(DataSourceType.NUMBER, 0, ctx);
                        ;
                    } else {
                        this.value = minValue;
                    }
                }
            }
        }
    }

    @Override
    public void increment() {
        if (value != null) {
            value++;
            if (max != null) {
                int maxValue = (int) max.getData(DataSourceType.NUMBER, 0, ctx);
                if (value > maxValue) {
                    if (overflow && min != null) {
                        this.value = (int) min.getData(DataSourceType.NUMBER, 0, ctx);
                    } else {
                        this.value = maxValue;
                    }
                }
            }
        }
    }

    @Override
    public void decrement() {
        if (value != null) {
            value--;
            if (min != null) {
                int minValue = (int) min.getData(DataSourceType.NUMBER, 0, ctx);
                if (value < minValue) {
                    if (overflow && max != null) {
                        this.value = (int) max.getData(DataSourceType.NUMBER, 0, ctx);
                    } else {
                        this.value = minValue;
                    }
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
            if (min != null) {
                int minValue = (int) min.getData(DataSourceType.NUMBER, 0, ctx);
                if (this.value < minValue) {
                    this.value = minValue;
                }
            }
            if (max != null) {
                int maxValue = (int) max.getData(DataSourceType.NUMBER, 0, ctx);
                if (this.value > maxValue) {
                    this.value = maxValue;
                }
            }
        }
    }
}

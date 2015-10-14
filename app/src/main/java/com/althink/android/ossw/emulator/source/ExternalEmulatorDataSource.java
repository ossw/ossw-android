package com.althink.android.ossw.emulator.source;

import com.althink.android.ossw.emulator.WatchEmulator;
import com.althink.android.ossw.utils.StringNormalizer;
import com.althink.android.ossw.watchsets.DataSourceType;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by krzysiek on 19/06/15.
 */
public class ExternalEmulatorDataSource implements EmulatorDataSource {

    private WatchEmulator emulator;
    private int property;

    public ExternalEmulatorDataSource(WatchEmulator emulator, int property) {
        this.emulator = emulator;
        this.property = property;
    }

    @Override
    public Object getData(DataSourceType type, int range) {
        Object value = emulator.getExternalProperty(property);
        switch (type) {
            case NUMBER:
                int decimalNo = range & 0xF;
                int multi = 1;
                for (int i = 0; i < decimalNo; i++) {
                    multi *= 10;
                }
                if (value instanceof Float) {
                    BigDecimal decimal = new BigDecimal(((float) value) * multi);
                    return decimal.setScale(0, RoundingMode.HALF_UP).intValue();
                }
                return (int) value * multi;
            case STRING:
                return StringNormalizer.removeAccents((String)value);
        }
        return value;
    }
}

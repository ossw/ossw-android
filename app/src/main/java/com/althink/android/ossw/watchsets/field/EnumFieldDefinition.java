package com.althink.android.ossw.watchsets.field;

import java.util.Map;

/**
 * Created by krzysiek on 21/11/15.
 */
public class EnumFieldDefinition extends FieldDefinition {

    private Map<String, Integer> values;

    public EnumFieldDefinition(int fieldId, Map<String, Integer> values) {
        super(fieldId);
        this.values = values;
    }

    public Integer getValueKey(String value) {
        return values.get(value);
    }

    @Override
    public Object resolve(Object value) {
        if (value instanceof String) {
            return values.get(value);
        } else {
            return null;
        }
    }
}

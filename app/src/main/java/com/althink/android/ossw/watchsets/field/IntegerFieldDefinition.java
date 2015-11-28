package com.althink.android.ossw.watchsets.field;

/**
 * Created by krzysiek on 21/11/15.
 */
public class IntegerFieldDefinition extends FieldDefinition {

    public IntegerFieldDefinition(int fieldId) {
        super(fieldId);
    }

    @Override
    public Object resolve(Object value) {
        if (value instanceof String) {
            return Integer.parseInt((String) value);
        } else if (value instanceof Integer) {
            return (Integer) value;
        } else {
            return null;
        }
    }

}

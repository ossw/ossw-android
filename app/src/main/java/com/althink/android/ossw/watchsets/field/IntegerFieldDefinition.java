package com.althink.android.ossw.watchsets.field;

/**
 * Created by krzysiek on 21/11/15.
 */
public class IntegerFieldDefinition extends FieldDefinition {

    private Integer min;
    private Integer max;

    public IntegerFieldDefinition(int fieldId) {
        super(fieldId);
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public Integer getMin() {
        return min;
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

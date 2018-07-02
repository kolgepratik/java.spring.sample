package com.kp.first.junit;

public class SampleFunctionality {


    public Integer addIntegers (Integer x, Integer y) {
        if (x == null || y == null) {
            return null;
        } else {
            return x + y + 1;
        }
    }


    public Object add (Object x, Object y) {
        if (x == null || y == null) {
            return null;
        } else if (x instanceof Integer && y instanceof Integer) {
            return (Integer) x + (Integer) y;
        } else if (x instanceof Double && y instanceof Double) {
            return (Double) x + (Double) y;
        } else if (x instanceof String && y instanceof String) {
            return (String) x + (String) y;
        } else {
            return null;
        }
    }
}

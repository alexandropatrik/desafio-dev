package com.bycoders.cnabdemo.utils;

public class CnabDemoUtils {

    CnabDemoUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static Object requireNonNull(Object o) {
        if (o != null) {
            return o;
        }
        throw new NullPointerException();
    }

}

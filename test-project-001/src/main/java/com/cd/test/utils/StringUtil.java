package com.cd.test.utils;

/**
 * Created by Administrator on 2017/12/13.
 */
public class StringUtil {

    public static boolean isEmptyStr(String string) {
        if (string == null || "".equals(string) || "null".equals(string) || "NULL".equals(string) || "nil".equals(string)) {
            return true;
        }
        return false;
    }

    public static String dealEmptyStr(String string) {
        if (isEmptyStr(String.valueOf(string))) {
            return Constants.REPLACEMENT_EMPTY_STRING;
        }
        return String.valueOf(string);
    }

    public static String dealEmptyStr(String string, String replace) {
        if (isEmptyStr(String.valueOf(string))) {
            return replace;
        }
        return String.valueOf(string);
    }

    public static String zeroFill(int value) {
        return String.valueOf(value < 10 ? "0" + value : value);
    }
}

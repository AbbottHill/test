package com.cd.test.project.common;

/**
 * Created by Administrator on 2017/12/13.
 */
public class StringUtil {

    public static boolean isEmptyStr(String string) {
        if (string == null || "".equals(string) || "null".equals(string) || "NULL".equals(string)) {
            return true;
        }
        return false;
    }
}
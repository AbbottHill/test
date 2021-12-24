package com.cd.test.utils;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Objects;

public class CheckUtils {

    /**
     * check value of params relate keys
     * @param params
     * @param keys
     * @return
     */
    public static boolean CheckParams(Map params, String...keys) {
        for (int i = 0; i < keys.length; i++) {
            if (Objects.equals(params.get(keys[i]), null)) {
                return false;
            }
        }
        return true;
    }
}
    
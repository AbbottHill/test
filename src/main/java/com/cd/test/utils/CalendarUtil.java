package com.cd.test.utils;

import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {

    /**
     * 去年对应的日期
     * 注：今年的2月29号，对应去年的3月1号
     * @return
     */
    public static Date dateOfLastYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, -1);
        System.out.println(calendar.getTime());
        return calendar.getTime();
    }

}
    
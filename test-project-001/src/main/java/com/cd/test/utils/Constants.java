package com.cd.test.utils;


import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

/**
 * Created by Administrator on 2017/12/11.
 */
public class Constants {
    public static final String REPLACEMENT_EMPTY_STRING = "--";
    public static final String VERSION = "APP_VERSION";
    public static final SimpleDateFormat VERSION_TIME_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    DateTimeFormatter VERSION_TIME;
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final String NETURL = "localhost:8099";

    public static final int MY_MINIMUM_COLUMN_COUNT = 4;
    public static final String FILE_PATH = "D:\\TaskManagement\\";
    public static final String IMAGE_FILE_PATH = FILE_PATH + "images\\";
    public static final String FILE_NAME = "tasks.xlsx";
    public static final SimpleDateFormat FILE_NAME_TIME_RORMAT = new SimpleDateFormat("yyyyMMdd-HHmmss");
}



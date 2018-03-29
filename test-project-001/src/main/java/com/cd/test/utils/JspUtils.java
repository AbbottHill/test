package com.cd.test.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2017/9/27.
 */
public class JspUtils {


    @Deprecated
    public static String resourceVersion() {
//        ResourceBundle rb = ResourceBundle.getBundle("config");
//        return rb.getString("resource_version");

//        String path = Config.class.getClassLoader().getResource("config.properties").getPath();
//        String path = "/config.properties";
        Properties props=new Properties();
        try {
            InputStream is = JspUtils.class.getResourceAsStream("/config.properties");
            props.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props.getProperty("resource_version");

    }
}

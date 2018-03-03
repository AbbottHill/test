package com.cd.test.common;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2017/12/23.
 */
@Component
public class MyPropertyPlaceholder extends PropertyPlaceholderConfigurer {

    private static Map<String, String> propertyMap;

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
//        MyPropertyPlaceholder.updateProperty("resource_version", "3.2");
        propertyMap = new HashMap<String, String>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            propertyMap.put(keyStr, value);
        }
    }

    //static method for accessing context properties
    public static String getProperty(String name) {
        return propertyMap.get(name);
    }


    /**
     * 修改/添加AutoAnalysisTime.properties资源文件中键值对;
     * 如果K值原先存在则，修改该K值对应的value值;
     * 如果K值原先不存在则，添加该键值对到资源中.
     *
     * @param key
     * @param value
     * @author zzb
     */
    public static void updateProperty(String key, String value) {
//        String path ="classpath:config.properties";
//        String path ="/config.properties";
        String path = MyPropertyPlaceholder.class.getResource("/config.properties").getPath();
        System.out.println("xx.class.getResource(\"/config.properties\").getPath(): " + path);
        File file = new File(path);
        Properties prop = new Properties();
        try (
                InputStream inputFile = new FileInputStream(file);
                OutputStream outputFile = new FileOutputStream(file);
        ) {
            prop.load(inputFile);
            inputFile.close();//一定要在修改值之前关闭inputFile
            //设值-保存
            prop.setProperty(key, value);
            //添加注释
            prop.store(outputFile, "Update '" + key + "'+ '" + value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

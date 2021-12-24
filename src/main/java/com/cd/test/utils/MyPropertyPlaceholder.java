package com.cd.test.utils;

import com.cd.test.config.RootConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.lang.Nullable;
import org.springframework.objenesis.instantiator.annotations.Instantiator;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.InitBinder;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2017/12/23.
 */
//@Component
public class MyPropertyPlaceholder extends PropertyPlaceholderConfigurer {
//    @Autowired
//    LoggerProxy loggerProxy;
//    Resource location = null;

    private static Map<String,String> propertyMap = new HashMap<>();


    void beforeInit() {
        this.setLocation(new FileSystemResource("config.properties"));
    }


    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) {
//        this.setLocation(new PathResource("config.properties"));
//        this.setLocation(new FileSystemResource("config.properties"));

        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            propertyMap.put(keyStr, value);
        }
        propertyMap.put(Constants.VERSION, Constants.VERSION_TIME_FORMAT.format(new Date()));
//        logger.info("propertyMap: " + propertyMap);
    }

    //static method for accessing context properties
    public static Object getProperty(String name) {
        return propertyMap.get(name);
    }

    //static method for get system version
    public static Object appVersion() {
//        return propertyMap.get(Constants.VERSION);//todo
//        return Constants.VERSION_TIME_FORMAT.format(new Date());

        return RootConfig.configProperties.get(Constants.VERSION);

    }

    //static method for get system version
    public static Object staticResourceUrl() {
//        return propertyMap.get("staticResourceUrl");
        return "";
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

package com.cd.test.project.operation.servlet.listeners;


import com.sun.deploy.Environment;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Administrator on 2017/9/26.
 */
public class MyApplicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        String path = Environment.class.getResource("").getPath();
//        String webAppPath = path.substring(0, path.toUpperCase().lastIndexOf("WEB-INF/")).replaceAll("%20", " ");
        System.setProperty("logPath", "D:\\IDEA_workspace\\isolarcloud-master\\test-project\\trunk\\test-project-001\\src\\main");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

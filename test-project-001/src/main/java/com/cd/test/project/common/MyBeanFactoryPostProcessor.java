package com.cd.test.project.common;

import org.junit.runner.notification.StoppedByUserException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/12/23.
 * 实现Spring的Bean后置处理器接口
 * BeanFactoryPostProcessor表示：该Bean加载完成之后，Spring可以让开发者自定义一些事件。
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        System.out.println("================>[BeanFactoryPostProcessor]自动加载启动开始.");

//        MyPropertyPlaceholder.updateProperty("resource_version", "3.2");

        System.out.println("================>[BeanFactoryPostProcessor]自动加载启动结束.");
    }
}

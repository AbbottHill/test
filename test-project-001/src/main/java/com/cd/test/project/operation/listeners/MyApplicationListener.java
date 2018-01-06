package com.cd.test.project.operation.listeners;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/12/26.
 */
@Service
public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    private static final Log LOGGER = LogFactory.getLog(MyApplicationListener.class);
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            // 在web项目中（spring mvc），系统会存在两个容器，一个是root application context
            // ,另一个就是我们自己的 projectName-servlet context（作为root application context的子容器）。
            // 这种情况下，就会造成onApplicationEvent方法被执行两次。为了避免这个问题，我们可以只在root
            // application context初始化完成后调用逻辑代码，其他的容器的初始化完成，则不做任何处理。
            if (event.getApplicationContext().getParent() == null) {
                // 需要实现的功能
                System.out.println("MyApplicationListener");
            }
        } catch (Exception e) {
            LOGGER.error("StartGateServiceData", e);
        }
    }
}

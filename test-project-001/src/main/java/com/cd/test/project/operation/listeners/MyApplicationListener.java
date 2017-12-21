package com.cd.test.project.operation.listeners;



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
        System.setProperty("logPath", "D:\\test-project-001");

//        Subscriber subscriber = new Subscriber();
//        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-conf.xml");
//        JedisConnectionFactory jedisConnectionFactory = (JedisConnectionFactory) ac.getBean("connectionFactory");
//        System.out.println(String.format("redis pool is starting, redis ip %s, redis port %d", jedisConnectionFactory.getHostName(), jedisConnectionFactory.getPort()));
//        Jedis jedis = (Jedis) jedisConnectionFactory.getConnection().getNativeConnection();
//        jedis.subscribe(subscriber, Constants.channel);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

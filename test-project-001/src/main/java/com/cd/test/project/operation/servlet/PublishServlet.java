package com.cd.test.project.operation.servlet;

import com.cd.test.project.common.SpringContextUtil;
import com.cd.test.project.common.StringUtil;
import com.cd.test.test.RedisPubSub.Subscriber;
import lombok.extern.log4j.Log4j2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Administrator on 2017/12/15.
 */
@Log4j2
public class PublishServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        synchronized (this) {
            log.info("timesTopic: ---> " + session.getAttribute("timesTopic"));
            System.out.println("timesTopic: ---> " + session.getAttribute("timesTopic"));
            if (StringUtil.isEmptyStr(String.valueOf(session.getAttribute("timesTopic")))) {
                int random = Integer.parseInt(String.valueOf(Math.random() * 10).substring(0, 1));
                String channel = String.valueOf("abcdefghij".charAt(random));
                session.setAttribute("timesTopic", channel);

                System.out.println("session.getId -> " + session.getId());
                Subscriber subscriber = (Subscriber) SpringContextUtil.getBean("subscriber");
                session.setAttribute("Subscriber", subscriber);
                ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(3);
                session.setAttribute("arrayBlockingQueue", arrayBlockingQueue);

//                Thread t1 = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        JedisConnectionFactory jedisConnectionFactory = (JedisConnectionFactory) SpringContextUtil.getBean("connectionFactory");
//                        System.out.println(String.format("redis pool is starting, redis ip %s, redis port %d", jedisConnectionFactory.getHostName(), jedisConnectionFactory.getPort()));
//                        Jedis jedis = (Jedis) jedisConnectionFactory.getConnection().getNativeConnection();
//                        jedis.subscribe(subscriber, channel);
//                    }
//                });
//                t1.start();
            }
        }
        log.info("timesTopic: ---> " + session.getAttribute("timesTopic"));
        try {
            response.getWriter().write("null");
        } catch (IOException e) {
            log.error("doPost: " + e.getMessage(), e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        this.doPost(request, response);
    }

}

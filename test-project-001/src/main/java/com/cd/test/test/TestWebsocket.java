package com.cd.test.test;

/**
 * Created by Administrator on 2017/12/8.
 */
import com.cd.test.project.common.Constants;
import com.cd.test.project.common.GetHttpSessionConfigurator;
import com.cd.test.project.common.SpringContextUtil;
import com.cd.test.test.RedisPubSub.Subscriber;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.web.socket.server.standard.SpringConfigurator;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(value = "/getServer", configurator = GetHttpSessionConfigurator.class)
@Log4j2
//@ServerEndpoint(value = "/getServer", configurator = SpringConfigurator.class)
public class TestWebsocket {
    //    private int i = 0;
    int random = Integer.parseInt(String.valueOf(Math.random() * 10).substring(0, 1));
    //    String channel = String.valueOf("abcdefghij".charAt(random));
    String channel = "t";
    private HttpSession httpSession;

    /**
     * 收到客户端消息时触发
     *
     * @param message
     * @return
     */
    @OnMessage
    public String onMessage(Session session, String message) {
        System.out.println(message);
        return "Got you msg !" + message;
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        channel = String.valueOf(httpSession.getAttribute("timesTopic"));
//        Subscriber subscriber = (Subscriber) SpringContextUtil.getBean("subscriber");

        System.out.println("httpSession.getId -> " + httpSession.getId());
        System.out.println("session.getId -> " + session.getId());

        httpSession.setAttribute("TestWebsocket", "testSession");

        final RemoteEndpoint.Basic basic = session.getBasicRemote();
        try {
            basic.sendText("open success on server");
            basic.sendText("channel -----> " + channel);
        } catch (IOException e) {
            e.printStackTrace();
        }
//
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                JedisConnectionFactory jedisConnectionFactory = (JedisConnectionFactory) SpringContextUtil.getBean("connectionFactory");
//                System.out.println(String.format("redis pool is starting, redis ip %s, redis port %d", jedisConnectionFactory.getHostName(), jedisConnectionFactory.getPort()));
//                Jedis jedis = (Jedis) jedisConnectionFactory.getConnection().getNativeConnection();
//                jedis.subscribe(subscriber, channel);
//            }
//        });
//        t1.start();

//        Thread t1=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true){
//                    try {
//                        Thread.currentThread();
//                        Thread.sleep(5000);
//                        basic.sendText(channel + " server message: " + (i ++));
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        t1.start();
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    while (!Thread.currentThread().isInterrupted()) {
                        try {
//                            String m = subscriber.getArrayBlockingQueue().take();
                            String m = ((Subscriber)httpSession.getAttribute("Subscriber")).getArrayBlockingQueue().take();
                            System.out.println("Subscribed: " + m);
                            try {
                                basic.sendText("Subscribed: " + m);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        t2.start();
        log.error("Thread.activeCount() -->" + Thread.activeCount());
    }


    /**
     * 异常时触发
     *
     * @param session
     */
    @OnError
    public void onError(Throwable throwable, Session session) {
        System.out.print("onError" + throwable.toString());
    }

    /**
     * 关闭连接时触发
     *
     * @param session
     */
    @OnClose
    public void onClose(Session session) {
        System.out.print("onClose ");
    }
}


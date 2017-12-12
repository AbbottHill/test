package com.cd.test.test;

/**
 * Created by Administrator on 2017/12/8.
 */
import com.cd.test.project.common.Constants;
import com.cd.test.project.common.SpringContextUtil;
import com.cd.test.test.RedisPubSub.Subscriber;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/getServer")
public class TestWebsocket {
    private int i = 0;

    @OnOpen
    public void onOpen(Session session) {
        final RemoteEndpoint.Basic basic =  session.getBasicRemote();
        Subscriber subscriber = (Subscriber) SpringContextUtil.getBean("subscriber");
        try {
            basic.sendText("open success on server");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                int random = Integer.parseInt(String.valueOf(Math.random() * 10).substring(0, 1));
                String channel = String.valueOf("abcdefghij".charAt(random));
                try {
                    basic.sendText("channel -----> " + channel);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JedisConnectionFactory jedisConnectionFactory = (JedisConnectionFactory) SpringContextUtil.getBean("connectionFactory");
                System.out.println(String.format("redis pool is starting, redis ip %s, redis port %d", jedisConnectionFactory.getHostName(), jedisConnectionFactory.getPort()));
                Jedis jedis = (Jedis) jedisConnectionFactory.getConnection().getNativeConnection();
//        SubThread subThread = new SubThread(jedis);
                jedis.subscribe(subscriber, channel);


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


            }
        });
        t1.start();

        while (!Thread.currentThread().isInterrupted()) {
            try {
                String m = subscriber.getArrayBlockingQueue().take();
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
    /**
     * 收到客户端消息时触发
     * @param message
     * @return
     */
    @OnMessage
    public String onMessage(Session session,String message) {
        System.out.println("pathParams:"+session.getPathParameters());
        System.out.println("requestParams"+session.getRequestParameterMap());
        System.out.println(message);
        return	"Got you msg !"+message;
    }

    /**
     * 异常时触发
     * @param session
     */
    @OnError
    public void onError(Throwable throwable,Session session) {
        System.out.println("pathParams:"+session.getPathParameters());
        System.out.println("requestParams"+session.getRequestParameterMap());
        System.out.print("onError"+throwable.toString());
    }

    /**
     * 关闭连接时触发
     * @param session
     */
    @OnClose
    public void onClose(Session session) {
        System.out.println("pathParams:"+session.getPathParameters());
        System.out.println("requestParams"+session.getRequestParameterMap());
        System.out.print("onClose ");
    }
}


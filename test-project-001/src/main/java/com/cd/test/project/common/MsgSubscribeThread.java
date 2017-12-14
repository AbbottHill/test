package com.cd.test.project.common;

import com.cd.test.test.RedisPubSub.Subscriber;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.web.context.annotation.SessionScope;
import redis.clients.jedis.Jedis;

import java.io.IOException;

/**
 * Created by Administrator on 2017/12/13.
 */
@SessionScope
public class MsgSubscribeThread extends Thread {
    String channel = "t";
    private Subscriber subscriber = null;

    public MsgSubscribeThread(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void run() {
        System.out.println("MsgSubThread start");
        JedisConnectionFactory jedisConnectionFactory = (JedisConnectionFactory) SpringContextUtil.getBean("connectionFactory");
        System.out.println(String.format("redis pool is starting, redis ip %s, redis port %d", jedisConnectionFactory.getHostName(), jedisConnectionFactory.getPort()));
        Jedis jedis = (Jedis) jedisConnectionFactory.getConnection().getNativeConnection();
//        SubThread subThread = new SubThread(jedis);
        jedis.subscribe(subscriber, channel);
    }

}

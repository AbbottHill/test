package com.cd.test.test.RedisPubSub;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import redis.clients.jedis.JedisPubSub;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Administrator on 2017/12/9.
 * redis pub/sub 订阅者
 */
@Component("subscriber") @Scope("prototype")
public class Subscriber extends JedisPubSub implements Serializable{

    private ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(3);
//    private ArrayBlockingQueue<String> arrayBlockingQueue = null;

    public Subscriber() {
    }

    public Subscriber(ArrayBlockingQueue<String> arrayBlockingQueue) {
        this.arrayBlockingQueue = arrayBlockingQueue;
    }

    public void onMessage(String channel, String message) {
        System.out.println(String.format("receive redis published message, channel %s, message %s", channel, message));
        this.arrayBlockingQueue.add(String.valueOf(message));
    }

    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println(String.format("subscribe redis channel success, channel %s, subscribedChannels %d",
                channel, subscribedChannels));
    }

    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println(String.format("unsubscribe redis channel, channel %s, subscribedChannels %d",
                channel, subscribedChannels));
    }

    public ArrayBlockingQueue<String> getArrayBlockingQueue() {
        return arrayBlockingQueue;
    }

    public void setArrayBlockingQueue(ArrayBlockingQueue<String> arrayBlockingQueue) {
        this.arrayBlockingQueue = arrayBlockingQueue;
    }
}

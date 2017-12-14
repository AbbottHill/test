package com.cd.test.test.RedisPubSub;

/**
 * Created by Administrator on 2017/12/9.
 */
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


public class SubThread extends Thread {
//    private final Jedis jedis;
    private final JedisPool jedisPool;
    private final Subscriber subscriber = new Subscriber();

    private final String channel = "topic";

    public SubThread(JedisPool jedisPool) {
        super("SubThread");
        this.jedisPool = jedisPool;
    }

//    public SubThread(Jedis jedis) {
//        super("SubThread");
//        this.jedis = jedis;
//    }

    @Override
    public void run() {
        System.out.println(String.format("subscribe redis, channel %s, thread will be blocked", channel));
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.subscribe(subscriber, channel);
        } catch (Exception e) {
            System.out.println(String.format("subsrcibe channel error, %s", e));
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
package com.cd.test;

/**
 * Created by Administrator on 2017/12/9.
 */
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class ThreadPool implements Serializable {
    private static ArrayBlockingQueue<Map> arrayBlockingQueue = null;
    private static ExecutorService executorService = null;

    public ThreadPool(int poolSize) {
        arrayBlockingQueue = new ArrayBlockingQueue<Map>(3 * poolSize);
        //创建一个可重用固定线程数的线程池
        executorService = Executors.newFixedThreadPool(poolSize);
        executorService.execute(new Producer());
        executorService.execute(new Producer());
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Map m = arrayBlockingQueue.take();
                //Retrieves and removes the head of this queue, waiting if necessary until an element becomes available. Shouldn’t put in main Thread.
                executorService.execute(new Consumer(m));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayBlockingQueue<Map> getArrayBlockingQueue() {
        return arrayBlockingQueue;
    }

    public static void main(String[] args) {
        int cpuNum = Runtime.getRuntime().availableProcessors();// 获取处理器数量
        int capacity = cpuNum * 2 + 1;// 根据cpu数量,计算出合理的线程并发数
        new ThreadPool(capacity); //实际应用中不在主线程中new
    }

}

/**
 * producer
 */
class Producer implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Map m = new HashMap();
            m.put("name", Thread.currentThread().getName());
            ThreadPool.getArrayBlockingQueue().add(m);
        }
    }
}

/**
 * consumer
 */
class Consumer implements Runnable {

    private Map m = null;

    public Consumer(Map m) {
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.m = m;
    }

    @Override
    public void run() {
        System.out.println(m.get("name") + "");
    }
}

package com.cd.test.concurrent.threadpool;


import java.util.concurrent.*;

public class FixedThreadPool {

    public static void main(String[] args) {
        /**
         * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
         * 因为线程池大小为3，每个任务输出index后sleep 2秒，所以每两秒打印3个数字。
          */
//        int nThreads = Runtime.getRuntime().availableProcessors();
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        ThreadPoolExecutor fixedThreadPool = (ThreadPoolExecutor)Executors.newFixedThreadPool(3);

        fixedThreadPool.setKeepAliveTime(20L, TimeUnit.SECONDS);
        fixedThreadPool.allowCoreThreadTimeOut(true);

        for (int i = 0; i < 16; i++) {
            int finalI = i;
            fixedThreadPool.execute(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(String.format("%s -> %s", Thread.currentThread().getName(), finalI));
            });
        }
    }

}

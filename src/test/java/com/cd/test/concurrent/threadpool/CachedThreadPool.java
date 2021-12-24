package com.cd.test.concurrent.threadpool;

import java.util.concurrent.*;

public class CachedThreadPool {

    public static void main(String[] args) {

        /**
         * 发现10个线程都是使用的线程1，线程池为无限大，当执行第二个任务时第一个任务已经完成，
         * 会复用执行第一个任务的线程，而不用每次新建线程。
         */
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 500); // 大于任务时间，则会复用
            } catch (Exception e) {
                e.printStackTrace();
            }

            cachedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println(index + "当前线程" + Thread.currentThread().getName());
                }
            });
        }


        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 8; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000 * finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(String.format("%s -> %s", Thread.currentThread().getName(), finalI));
                }
            });
        }
    }
}

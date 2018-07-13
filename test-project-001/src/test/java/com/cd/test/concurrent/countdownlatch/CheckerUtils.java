package com.cd.test.concurrent.countdownlatch;


import com.cd.test.concurrent.countdownlatch.BaseHealthChecker;

import java.util.ArrayList;
import java.util.concurrent.*;

public class CheckerUtils {
//    private static CountDownLatch countDownLatch;

    private CheckerUtils () {
    }

    public static Boolean checkAllStatus() throws InterruptedException {
        boolean allStatus = true;
//        threadPool = Executors.newCachedThreadPool();
        int cpuNum = Runtime.getRuntime().availableProcessors();// 获取处理器数量
        int capacity = cpuNum * 2 + 1;// 根据cpu数量,计算出合理的线程并发数
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(capacity);

        ArrayList<BaseHealthChecker> checkers = new ArrayList<>();
        checkers.add(new NetHealthChecker());
        checkers.add(new DatabaseHealthChecker());
        checkers.add(new CacheHealthChecker());

        System.out.println("----- main start ------");
        CountDownLatch countDownLatch = new CountDownLatch(checkers.size());

        for (int i = 0; i < checkers.size(); i++) {
            BaseHealthChecker checker = checkers.get(i);
            checker.setLatch(countDownLatch);
            threadPool.execute(checker);
        }
        countDownLatch.await();


        for (int i = 0; i < checkers.size(); i++) {
            BaseHealthChecker checker = checkers.get(i);
            if (!checker.getStatus()) {
                allStatus = false;
            }
        }
        // 队列的任务全部结束后将，释放所有的线程
        threadPool.setKeepAliveTime(10, TimeUnit.SECONDS);
        threadPool.allowCoreThreadTimeOut(true);

        System.out.println("----- main end ------");
        return allStatus;
    }

    public static void main(String[] args) {
        try {
            System.out.println("is everything ok? " + CheckerUtils.checkAllStatus());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

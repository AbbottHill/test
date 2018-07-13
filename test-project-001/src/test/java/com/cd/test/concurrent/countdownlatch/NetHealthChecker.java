package com.cd.test.concurrent.countdownlatch;


public class NetHealthChecker extends BaseHealthChecker {

    public NetHealthChecker() {
        super(false, null);
    }

    @Override
    void verifyStatus() throws InterruptedException {
        int s = 4 * 1000;
        Thread.sleep(s);
        System.out.println(Thread.currentThread().getName() + " sleep: " + s);
    }
}

class DatabaseHealthChecker extends BaseHealthChecker {

    public DatabaseHealthChecker() {
        super(false, null);
    }

    @Override
    void verifyStatus() throws InterruptedException {
        int s = 2 * 1000;
        Thread.sleep(s);
        System.out.println(Thread.currentThread().getName() + " sleep: " + s);
    }
}

class CacheHealthChecker extends BaseHealthChecker {

    public CacheHealthChecker() {
        super(false, null);
    }

    @Override
    void verifyStatus() throws InterruptedException {
        int s = 1 * 1000;
        Thread.sleep(s);
        System.out.println(Thread.currentThread().getName() + " sleep: " + s);
    }
}

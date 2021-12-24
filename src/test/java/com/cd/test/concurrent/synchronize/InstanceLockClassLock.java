package com.cd.test.concurrent.synchronize;

public class InstanceLockClassLock extends Thread{
    private String x;

    private synchronized void doJobInstanceLk() {
        for (int i = 0; i < 50; i++) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-> " + x);
        }
    }

    private void doJobClassLk() {
        synchronized(InstanceLockClassLock.class) {
            for (int i = 0; i < 50; i++) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "-> " + x);
            }
        }
    }

    InstanceLockClassLock(String x) {
        this.x = x;
    }

    @Override
    public void run() {
        super.run();
        doJobInstanceLk();
    }

    public static void main(String[] args) {
        new InstanceLockClassLock("1").start();
        new InstanceLockClassLock("2").start();
    }
}



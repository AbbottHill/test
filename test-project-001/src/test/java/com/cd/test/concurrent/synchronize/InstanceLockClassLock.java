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
            System.out.print(x);
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
                System.out.print(x);
            }
        }
    }

    InstanceLockClassLock(String x) {
        this.x = x;
    }

    @Override
    public void run() {
        super.run();
        doJobClassLk();
    }

    public static void main(String[] args) {
        new InstanceLockClassLock("1").start();
        new InstanceLockClassLock("2").start();
    }
}



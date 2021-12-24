//package com.cd.test.concurrent;

public class DeadLock {

    public static void main(String[] args) {
        Object lock01 = new Object();
        Object lock02 = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock01) {
                    System.out.println("get lock01");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock02) {
                        System.out.println("get lock02");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock02) {
                    System.out.println("get lock02");
                    synchronized (lock01) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("get lock01");
                    }
                }
            }
        }).start();
    }
}

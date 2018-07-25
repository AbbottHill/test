package com.cd.test.concurrent.volatile_test;

/**
 * volatile 不能保证数据的同步性
 */
public class Asynchronize {
    public volatile static int count = 0;

    /**
     * @param _something @throws InterruptedException @author mikecoder
     */
    public static void main(String[] _something) throws InterruptedException {

        class UnsafeThread implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) Math.hypot(Math.pow(92456789, i), Math.cos(i));
                count++;
            }

            public int getCount() {
                return count;
            }
        }

        int value = 1000;
        int loops = 0;
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while (loops++ < value) {
            UnsafeThread unsafeThread = new UnsafeThread();
            for (int i = 0; i < 1000; i++) new Thread(new UnsafeThread()).start();
            do Thread.sleep(5); while (threadGroup.activeCount() != 1);

            if (unsafeThread.getCount() != value) {
                System.out.println("Loops:" + loops + " Unsafe!");
                System.out.println("Count:" + unsafeThread.getCount());
                System.exit(0);
            }
            count = 0;
            System.out.println("Loops:" + loops + " Safe!");
        }
    }
}
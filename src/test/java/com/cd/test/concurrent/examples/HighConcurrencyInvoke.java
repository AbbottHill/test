package com.cd.test.concurrent.examples;

import com.sun.javafx.robot.FXRobotImage;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.concurrent.*;

/**
 * @author ChuD
 * @date 2019-07-02 14:33
 */
public class HighConcurrencyInvoke {

    public static LinkedBlockingQueue<CompletableFuture> linkedBlockingQueue = new LinkedBlockingQueue();

    public String handleRequestMethod() {
        System.out.println(Thread.currentThread().getName());
        return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public String handleRequestMethodBatch() {
        int size = linkedBlockingQueue.size();
        System.out.println("linkedBlockingQueue.size = " + size);
        for (int i = 0; i < size; i++) {
            CompletableFuture poll = linkedBlockingQueue.poll();
            poll.complete(linkedBlockingQueue.size() + "");
        }
        return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public String apiMethod(String threadId) throws InterruptedException, ExecutionException {
//        linkedBlockingQueue.put(threadId);
//        System.out.println(threadId);
//        synchronized (CyclicBarrier.class) {
//            System.out.println(Thread.currentThread().getName());
//        }
//        return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        System.out.println(Thread.currentThread().getName());
        CompletableFuture<String> result = new CompletableFuture();
        linkedBlockingQueue.put(result);
        return result.get();
    }

    @Test
    public void simulateMassiveRequest() throws ExecutionException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(100);
        for (int i = 0; i < 10000; i++) {
            new Thread((Runnable) () -> {
                try {
                    cyclicBarrier.await();
                    String s = new HighConcurrencyInvoke().apiMethod(Thread.currentThread().getName());
                    System.out.println(s);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }


        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);
        ScheduledFuture<?> scheduledFuture = scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                new HighConcurrencyInvoke().handleRequestMethodBatch();
            }
        }, 1, 2, TimeUnit.SECONDS);

        scheduledFuture.get();

    }

}

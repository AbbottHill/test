package com.cd.test.common;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoggerPrintUtil {
    private static ExecutorService executorService;

    static {
        int cpuNum = Runtime.getRuntime().availableProcessors();
        executorService = Executors.newFixedThreadPool(cpuNum * 2);
    }

    public static void printLog(String log) {
        executorService.execute(
                new Thread(() -> System.out.println(System.currentTimeMillis() + ": " + log))
//                new Thread(){
//                    @Override
//                    public void run() {
//                        System.out.println(System.currentTimeMillis() + ": " + log);
//                    }
//                }
        );
    }

    public static void main(String[] args) {
        LoggerPrintUtil.printLog("logs " + Math.random());
    }
}
    
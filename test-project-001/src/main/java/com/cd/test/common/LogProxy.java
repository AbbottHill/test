package com.cd.test.common;

import org.aspectj.lang.JoinPoint;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component("logProxy")
public class LogProxy {
    @Async("logExecutor")
    public void logStart(JoinPoint jp) {
        System.out.println("----> ");
    }
}
    
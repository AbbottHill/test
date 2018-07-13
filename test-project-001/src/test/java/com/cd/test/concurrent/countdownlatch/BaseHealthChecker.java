package com.cd.test.concurrent.countdownlatch;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.CountDownLatch;

public abstract class BaseHealthChecker implements Runnable {
    @Getter(AccessLevel.PUBLIC)@Setter(AccessLevel.PRIVATE)
    private Boolean status;
    @Setter(AccessLevel.PUBLIC)
    private CountDownLatch latch;

    public BaseHealthChecker(Boolean status, CountDownLatch latch) {
        super();
        this.status = status;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            verifyStatus();
            this.setStatus(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cutDown();
    }

    private void cutDown() {
        this.latch.countDown();
    }

    abstract void verifyStatus() throws InterruptedException;

//    private void setStatus(Boolean status) {
//        this.status = status;
//    }

}

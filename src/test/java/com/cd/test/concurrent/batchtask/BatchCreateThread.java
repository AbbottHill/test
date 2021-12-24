package com.cd.test.concurrent.batchtask;

public class BatchCreateThread implements Runnable {
    private CreateOne createOne;

    public BatchCreateThread(CreateOne createOne) {
        this.createOne = createOne;
    }

    @Override
    public void run() {
        createOne.createOneObj();
    }
}

package com.cd.test.concurrent.batchtask;

import java.util.Map;

public class CreateOne {
    private Map params;

    public CreateOne(Map params) {
        this.params = params;
    }

    public void createOneObj () {
        System.out.println("create one");
    }
}

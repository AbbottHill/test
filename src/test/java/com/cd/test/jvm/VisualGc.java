package com.cd.test.jvm;

import java.util.ArrayList;

public class VisualGc {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(15000);
        ArrayList<Object> objects = new ArrayList<>();
        while (true) {
            objects.add(new Object());
        }
    }
}

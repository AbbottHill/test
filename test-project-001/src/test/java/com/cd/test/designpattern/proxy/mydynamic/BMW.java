package com.cd.test.designpattern.proxy.mydynamic;

/**
 * @author ChuD
 * @date 2019-06-26 21:19
 */
public class BMW implements Car {

    @Override
    public String getBrand() {
        return "BMW";
    }

    @Override
    public void drive() {
        System.out.println("Driving BMW ...");
    }
}

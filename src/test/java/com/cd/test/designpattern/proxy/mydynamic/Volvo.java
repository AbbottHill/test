package com.cd.test.designpattern.proxy.mydynamic;

/**
 * @author ChuD
 * @date 2019-06-26 21:19
 */
public class Volvo implements Car {

    @Override
    public String getBrand() {
        return "Volvo";
    }

    @Override
    public void drive() {
        System.out.println("Driving Volvo ...");
    }
}

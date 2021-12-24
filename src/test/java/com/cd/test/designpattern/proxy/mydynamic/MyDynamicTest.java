package com.cd.test.designpattern.proxy.mydynamic;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author ChuD
 * @date 2019-06-26 21:21
 */
public class MyDynamicTest {

    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        //
        Car bmw = BMW.class.newInstance();
        FourSHandler foursHandler = new FourSHandler(bmw);
        Car car = (Car) Proxy.newProxyInstance(BMW.class.getClassLoader(), BMW.class.getInterfaces(), foursHandler);
        String brand = car.getBrand();
        System.out.println("brand: " + brand);

        // bind method is recommend
/*        FourSHandler fourSHandler = new FourSHandler();
//        Car bmw = BMW.class.newInstance();
        Car Volvo = Volvo.class.newInstance();
        Car bmwProxy = fourSHandler.bind(bmw);
        Car volvoProxy = fourSHandler.bind(Volvo);
        bmwProxy.getBrand();
        volvoProxy.drive();*/
    }

    /**
     * before proxy
     */
    public void beforeHandle() {
        System.out.println("before handle ...");
    }

    /**
     * after proxy
     */
    public void afterHandle() {
        System.out.println("after handle ...");
    }

}

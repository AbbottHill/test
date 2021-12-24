package com.cd.test.designpattern.proxy.mydynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ChuD
 * @date 2019-06-26 21:23
 */
public class FourSHandler implements InvocationHandler {
    private Object object;

    public FourSHandler() {

    }

    public FourSHandler(Car car) {
        this.object = car;
    }

//    public <T> T bind(T t) throws IllegalAccessException, InstantiationException {
//        T o = (T)Proxy.newProxyInstance(JiLiCarImpl.class.getClassLoader(), JiLiCarImpl.class.getInterfaces(), this);
//        this.car = (CarInterface) o;
//        return o;
//    }

    public <T> T bind(T t) {
//        Object o = Proxy.newProxyInstance(JiLiCarImpl.class.getClassLoader(), JiLiCarImpl.class.getInterfaces(), this);
        this.object = t;
        Object o = Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), this);
        return (T) o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        MyDynamicTest.beforeHandle();
        Class<?> aClass = Class.forName("com.cd.test.designpattern.proxy.mydynamic.MyDynamicTest");
        MyDynamicTest myDynamicTest = (MyDynamicTest)aClass.newInstance();
        myDynamicTest.beforeHandle();
        Object result = method.invoke(this.object, args);
        myDynamicTest.afterHandle();
        return result;
    }
}

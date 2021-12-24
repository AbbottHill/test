package com.cd.test.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

    public <T> T bind(Class<T> business) throws IllegalAccessException, InstantiationException {
        T t = business.newInstance();
        return (T)Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), this);
    }


    public Object bind(Object business) {
        return Proxy.newProxyInstance(business.getClass().getClassLoader(), business.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());
        return null;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();

        SellCigarette cigarette = myInvocationHandler.bind(Huangshan.class);

//        Huangshan huangshan = new Huangshan();
//        SellCigarette cigarette = (SellCigarette) myInvocationHandler.bind(huangshan);

        cigarette.maiYan();

    }

}

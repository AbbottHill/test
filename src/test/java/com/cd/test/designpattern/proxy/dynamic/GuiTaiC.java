package com.cd.test.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GuiTaiC implements InvocationHandler {

    private Object sellCigarette;

    public GuiTaiC(SellCigarette sellCigarette) {
        this.sellCigarette = sellCigarette;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("柜台：" + this.getClass().getSimpleName());
        method.invoke(sellCigarette, args);
        System.out.println("end\n");
        return null;
    }
}

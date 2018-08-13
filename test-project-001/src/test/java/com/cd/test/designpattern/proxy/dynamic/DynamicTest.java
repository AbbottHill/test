package com.cd.test.designpattern.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * 跟静态一样也需要一个顶级的接口，
 * 静态代理方式，顶级的接口的实现类、代理类都要要实现顶级接口
 * 动态代理方式，代理类不用实现顶级接口，要实现 InvocationHandler
 */
public class DynamicTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MaotaiJiu maotaijiu = new MaotaiJiu();
        WuLiangYe wuLiangYe = new WuLiangYe();

        GuitaiA guitaiA = new GuitaiA(maotaijiu);
        GuitaiA guitaiAWLY = new GuitaiA(wuLiangYe);
        GuiTaiC guiTaiC = new GuiTaiC(new Huangshan());

        SellWine sellWine = (SellWine) Proxy.newProxyInstance(MaotaiJiu.class.getClassLoader(),
                MaotaiJiu.class.getInterfaces(), guitaiA);
        SellWine sellWineWLY = (SellWine) Proxy.newProxyInstance(MaotaiJiu.class.getClassLoader(),
                MaotaiJiu.class.getInterfaces(), guitaiAWLY);
        SellCigarette sellCigarette = (SellCigarette) Proxy.newProxyInstance(Huangshan.class.getClassLoader(),
                Huangshan.class.getInterfaces(), guiTaiC);

        sellWine.maiJiu();
        sellWineWLY.maiJiu();
        sellCigarette.maiYan();

        System.out.println("guitaiA class name:" + guitaiA.getClass().getName());
        System.out.println("dynamicProxy class name:" + sellWine.getClass().getName());
        System.out.println("dynamicProxy1 class name:" + sellWineWLY.getClass().getName());
        System.out.println("dynamicProxy3 class name:" + sellCigarette.getClass().getName());
    }
}

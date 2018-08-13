package com.cd.test.designpattern.proxy.dynamic;

public class MaotaiJiu implements SellWine {

    @Override
    public void maiJiu() {
        // TODO Auto-generated method stub
        System.out.println("我卖得是茅台酒。");
    }
}

class WuLiangYe implements SellWine {

    @Override
    public void maiJiu() {
        // TODO Auto-generated method stub
        System.out.println("我卖得是 五粮液。");
    }
}

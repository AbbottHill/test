package com.cd.test.designpattern.singleton;

public enum Singleton {
    INSTANCE, INSTANCE1;

    public void whatSoEverMethod() {}

    private Singleton() {
        System.out.println(this);
    }

    // 该方法非必须，只是为了保证与其它方案一样使用静态方法得到实例
    public static Singleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println();
    }

}

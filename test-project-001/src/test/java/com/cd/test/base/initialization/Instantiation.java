package com.cd.test.base.initialization;

/**
 * result
 * Dervied tell name: null
 * Dervied print name: null
 * Base tell pass: pass
 * Dervied tell name: dervied
 * Dervied print name: dervied
 * Base tell pass: pass
 *
 * 首先是对name域（父类Base）进行初始化，然后调用tellName()方法，
 * 因为子类以及覆写了tellName()方法，所以tellName方法实际调用为Dervied.tellName()方法，
 * tellName方法要打印name域（子类Dervied）的值，但是当前Dervied对象中的name域还没有被初始化，所以打印出来的值为null。
 */

public class Instantiation {
    public static void main(String[] args){
        new Dervied();
    }
}

class Dervied extends Base{
    private String name = "dervied";

    public Dervied() {
        tellName();
        printName();
    }

    @Override
    public void tellName() {
        System.out.println("Dervied tell name: " + name);
    }

    @Override
    public void printName() {
        System.out.println("Dervied print name: " + name);
        System.out.println("Base tell pass: " + pass);
    }
}

class Base {

    private String name = "base";
    protected String pass = "pass";

    public Base() {
        tellName();
        printName();
    }

    public void tellName() {
        System.out.println("Base tell name: " + name);
        System.out.println("Base tell pass: " + pass);
    }

    public void printName() {
        System.out.println("Base print name: " + name);
    }
}
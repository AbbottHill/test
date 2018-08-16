package com.cd.test.jdk8.MethodInvoke;

import java.util.function.Supplier;

public class Car {
    public static Car create(Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public void follow(Car another) {
        System.out.println("Following the " + another.toString());
    }

}

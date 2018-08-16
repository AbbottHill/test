package com.cd.test.beans;

import com.cd.test.AnnotationTest.CarSign;

@CarSign
public interface Car {

    default void drive() {
        System.out.println("drive " + getName());
    }

    default String getName() {
        return this.getClass().getSimpleName();
    }
}

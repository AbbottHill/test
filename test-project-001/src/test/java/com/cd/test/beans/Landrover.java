package com.cd.test.beans;

import com.cd.test.AnnotationTest.CarSign;

@CarSign(brand = "Landrover")
public class Landrover implements Car {

    @Override
    public void drive() {
        System.out.println("drive" + getName());
    }
}

package com.cd.test.designpattern.simplefactory;

import com.cd.test.AnnotationTest.CarSign;
import com.cd.test.beans.Car;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CarFactory {
    private static final Logger log = LoggerFactory.getLogger(CarFactory.class);

    private static Map<String, Class> carWare;

    static {
        Reflections reflections = new Reflections("com.cd.test.beans");
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(CarSign.class, false);
        carWare = new ConcurrentHashMap();
        for (Class<?> classObj : typesAnnotatedWith) {
            carWare.put(classObj.getSimpleName(), classObj);
        }
        carWare = Collections.unmodifiableMap(carWare);
    }

    public static Car newCar(String carName) {
        Car car = null;
        if (carWare.containsKey(carName)) {
            try {
                car = (Car) carWare.get(carName).newInstance();
            } catch (InstantiationException e) {
                log.error(e.getMessage(), e);
            } catch (IllegalAccessException e) {
                log.error(e.getMessage(), e);
            }
        } else {
            log.error("specified car type {} does not exist", carName);
        }
        return car;
    }


    public static void main(String[] args) {
        Car car = CarFactory.newCar("Volkswagen");
        car.drive();
    }

}

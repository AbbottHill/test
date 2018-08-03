package com.cd.test.jdk8.methodinvoke;

import com.cd.test.beans.Car;

import java.util.Arrays;
import java.util.List;

public class MethodInvoke {

    public static void main(String[] args) {
        // 1. 引用的类型是构造器引用，语法是Class::new，或者更一般的形式：Class<T>::new。注意：这个构造器没有参数。
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);

        // 2. 引用的类型是静态方法引用，语法是Class::static_method。注意：这个方法接受一个Car类型的参数。
        cars.forEach(Car::collide);

        // 3. 引用的类型是某个类的成员方法的引用，语法是Class::method，注意：这个方法没有定义入参：
        cars.forEach(Car::repair);

        // 4. 引用的类型是某个实例对象的成员方法的引用，语法是instance::method。注意：这个方法接受一个Car类型的参数：
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }

}
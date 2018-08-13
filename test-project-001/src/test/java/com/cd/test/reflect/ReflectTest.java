package com.cd.test.reflect;

import com.cd.test.beans.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

    public static void main(String[] args) throws Exception {

        // 返回与带有给定字符串名的类或接口相关联的 Class 对象。
//         Class classType = Person.class;
        Class classType = Class.forName("com.cd.test.beans.Person");
        Object obj = classType.newInstance();
        System.out.println("使用反射机制创建的对象是Person类的对象—"  + (obj instanceof Person));

        ReflectTest reflectTest = new ReflectTest();
        Method foo = reflectTest.getClass().getDeclaredMethod("foo", String.class);
        reflectTest.executeMethod(foo);
    }

    private String foo(String string) {
        return string;
    }

    private void executeMethod(Method method) throws InvocationTargetException, IllegalAccessException {
        Object hello = method.invoke(this, "hello world");
        System.out.println(hello);
    }

}

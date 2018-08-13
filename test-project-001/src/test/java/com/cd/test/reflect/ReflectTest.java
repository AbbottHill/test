package com.cd.test.reflect;

import com.cd.test.beans.Person;

public class ReflectTest {

    public static void main(String[] args) throws Exception {

        // 返回与带有给定字符串名的类或接口相关联的 Class 对象。
//         Class classType = Person.class;
        Class classType = Class.forName("com.cd.test.beans.Person");
        Object obj = classType.newInstance();
        System.out.println("使用反射机制创建的对象是Person类的对象—"  + (obj instanceof Person));

    }

}

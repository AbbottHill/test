package com.cd.test.javassist.makeclass;

import java.util.concurrent.atomic.AtomicInteger;

import com.cd.test.beans.Person;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;


/**
 * 类AssistFactory.java的实现描述：TODO 类实现描述
 *
 * @author onlyone 2012-6-17 下午04:20:46
 */
public class AssistFactory {

    // Class载入器
    private static ClassPool pool;
    // 原子计数器
    private static AtomicInteger number = new AtomicInteger(1);

    static {
        pool = ClassPool.getDefault();
    }

    public void compileAndExe(String body) throws Exception {
        String name = Person.class.getName();
        // 新定义的子类，可以修改
        CtClass cc = pool.makeClass(name + "$" + number.incrementAndGet());
        // 父类
        cc.setSuperclass(pool.get(name));
        // 复写父类方法
        String method = "public String getName(){ System.out.println(super.getName()+\" is %s!\"); return super.getName(); }";

        method = String.format(method, body);
        // 将新方法添加到类中
        cc.addMethod(CtMethod.make(method, cc));

        // 类模板
        Class<?> c = cc.toClass();
        cc.detach();

        // 实例化对象
        Person p = (Person) c.newInstance();
        p.setName("onlyone");

        p.getName();
    }

    public static void main(String[] args) throws Exception {
        new AssistFactory().compileAndExe("sign");
    }
}


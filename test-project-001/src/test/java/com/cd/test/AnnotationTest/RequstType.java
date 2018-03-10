package com.cd.test.AnnotationTest;

import java.lang.annotation.*;

@Target(ElementType.METHOD)//元注解，标记作用范围在方法中
@Documented //元注解，标记生产文档时不清除
@Retention(RetentionPolicy.RUNTIME)//元注解，标记注解生命周期，有运行时，class
public @interface RequstType {
    //返回类型是Type中的一个，默认是GET
    Type value() default Type.POST;
}

    
package com.cd.test.AnnotationTest;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CarSign {
    String brand() default "car";
}

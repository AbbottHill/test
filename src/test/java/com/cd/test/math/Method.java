package com.cd.test.math;

public class Method {
    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            /**
             * hypot: 计算直角三角形的斜边长；
             * pow(x,y)： 方法返回 x 的 y 次幂；
             *
             */
            double hypot = Math.hypot(Math.pow(92456789, i), Math.cos(i));
            System.out.println(hypot);
        }
    }
}

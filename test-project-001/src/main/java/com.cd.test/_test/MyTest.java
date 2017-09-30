
package com.cd.test._test;

import com.googlecode.aviator.AviatorEvaluator;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Pattern;

public class MyTest {
    public static void main(String[] args) {
        new MyTest();
    }
    private int i;
    public MyTest() {
        int j = 0;
        System.out.println(i);
        System.out.println(j);
        System.out.println(MyTest.class.getName());
        ApacheCommonsLang.arr2String();



        //        testCollections.test_map();
    }

    static void myPrint(Object obj) {
        System.out.println("-----> " + obj);
    }
}

class Tools{

    /**
     * @param str
     * @return
     * @throws NullPointerException if str is null
     */
    static boolean isStringDigit(String str) throws NullPointerException{
        return Pattern.matches("-?\\d+\\.?\\d+", str);
    }

    static void copyFile(String filePath) {
//        FileInputStream fileInputStream = null;
//        try {
//            fileInputStream = new FileInputStream(filePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            fileInputStream.close();
//        }
    }
}

class Collections_test {
    static void test_map() {
        Map map = new HashMap(2);//initialCapacity
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        System.out.println(map);
    }

}

/**
 * commons-lang3
 */
class ApacheCommonsLang {
    static void arr2String() {
        List list = new ArrayList();
//        list.add("abc");
//        list.add("123");
//        Map map = new HashMap();
//        list.add(map);
//        map.put("1", 1);
        System.out.println(StringUtils.join(list, ","));
    }
}

/**
 * aviator
 */
class GooeleAviator {
    static void expressionEngine() {
        Long result = (Long) AviatorEvaluator.execute("1+2+3");
        MyTest.myPrint(result);
    }
}






package com.cd.test.test;

import com.googlecode.aviator.AviatorEvaluator;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.swing.*;
import javax.xml.bind.SchemaOutputResolver;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class MyTest {
    String fieldStr;

    public static void main(String[] args) {
        new MyTest();
    }

    public MyTest() {
//		List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//		features.forEach(n -> System.out.println(n));
        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
        // 看起来像C++的作用域解析运算符
//		features.forEach(System.out::println);

//		String variableStr = null;
//		System.out.println(fieldStr);
//		System.out.println(variableStr);

//		String[] arr = {"Lambdas", "Default Method", "Stream API", "Date and Time API"};
//		System.out.println(ArrayUtils.contains(arr,"Lambda"));

//		System.out.println(String.valueOf(null));

    }

    public static void myPrint(Object obj) {
        System.out.println("-----> " + obj);
    }
}

class Tools {

    public static void main(String[] args) {
//		double aa = -19162431.1254;
//		System.out.println(aa);
        System.out.println(10000000.0d);
        System.out.println(9999999.999999999d);
        System.out.println(new BigDecimal(9999999.999999999d));
        System.out.println(9999999.9999999999d);
        System.out.println(0.0001);


    }

    /**
     * @param str
     * @return
     * @throws NullPointerException
     *             if str is null
     */
    static boolean isStringDigit(String str) throws NullPointerException {
        return Pattern.matches("-?\\d+\\.?\\d*", str);
    }

    /**
     * is empty
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if ("".equals(obj) || "null".equals(obj) || "NULL".equals(obj) || "--".equals(obj) || "undefined".equals(obj)
                || "nil".equals(obj) || "".equals(obj.toString().trim())) {
            return true;
        }
        return false;
    }

    static void copyFile(String filePath) {
        // FileInputStream fileInputStream = null;
        // try {
        // fileInputStream = new FileInputStream(filePath);
        // } catch (IOException e) {
        // e.printStackTrace();
        // } finally {
        // fileInputStream.close();
        // }
    }
}

class CollectionsTest {
    public static void main(String[] args) {
        String[] strs = {
                "0.4500", "--", "0.5200", "0.4500", "0.4800", "0.4500", "0.5000", "0.5300", "--", "0.5200",
                "0.4500", "--", "--", "0.4600", "0.4800", "0.4600", "0.4800", "0.5000", "0.5300", "0.5700", "0.5200", "--", "0.5500", "0.4800",
                "0.4600", "0.4500", "0.5000", "0.5000", "--", "0.5500", "0.5700", "0.5500", "--", "--", "0.5900", "0.5000", "0.5700"
        };
        List list = Arrays.asList(strs);
        System.out.println(list);
        sortList(list, "value", -1, 0);
        System.out.println(list);
    }

    static void mapCapacity() {
        Map map = new HashMap(2);// initialCapacity
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        System.out.println(map);
    }

    /**
     * @param list;
     * key; sort 1 升序，-1 倒序; type 1 字符排序，0 表示数字排序
     */
    public static void sortList(List<String> list, final String key, final int order, final int type) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String value1 = String.valueOf(o1);
                String value2 = String.valueOf(o2);
                if (type == 0) {
                    if (!Tools.isStringDigit(value1) && !Tools.isStringDigit(value2)) {
                        return 0;
                    }
                    if (!Tools.isStringDigit(value1)) {
                        return 1;
                    }
                    if (!Tools.isStringDigit(value2)) {
                        return -1;
                    }
                    return new BigDecimal(value1).compareTo(new BigDecimal(value2)) * order;
                } else {
                    return value1.compareTo(value2) * order;
                }
            }
        });
    }

    /**
     * @param list;
     * key; sort 1 升序，-1 倒序; type 1 字符排序，0 表示数字排序
     */
    public static void sortListMap(List<Map<String, Object>> list, final String key, final int order, final int type) {
        Collections.sort(list, new Comparator<Map<String, Object>>() {
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                String value1 = String.valueOf(o1.get(key));
                String value2 = String.valueOf(o2.get(key));
                if (type == 0) {
                    if (!Tools.isStringDigit(value1) && !Tools.isStringDigit(value2)) {
                        return 0;
                    }
                    if (!Tools.isStringDigit(value1)) {
                        return 1;
                    }
                    if (!Tools.isStringDigit(value2)) {
                        return -1;
                    }
                    return new BigDecimal(value1).compareTo(new BigDecimal(value2)) * order;
                } else {
                    return value1.compareTo(value2) * order;
                }
            }
        });
    }

    public static void SetTest() {
        Set set = new HashSet();
        set.add("123");
        set.add("123");
        System.out.println(set.size());
    }

}

/**
 * commons-lang3
 */
class ApacheCommonsLang {
    public static void main(String[] args) {
        arr2String();
    }

    static void arr2String() {
        List list = new ArrayList();
        list.add("abc");
        list.add("123");
        Map map = new HashMap();
        list.add(map);
        map.put("1", 1);
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

class MyException extends Exception {

    public static void main(String[] args) {
        try {
            throw new MyException("由于MyException重写了fillInStackTrace方法，那么它不会收集线程运行栈信息。");
        } catch (MyException e) {
            e.printStackTrace(); // 在控制台的打印结果为：demo.blog.java.exception.MyException:
            // 由于MyException重写了fillInStackTrace方法，那么它不会收集线程运行栈信息。
        }
    }

    public MyException(String message) {
        super(message);
    }

    /*
     * 重写fillInStackTrace方法会使得这个自定义的异常不会收集线程的整个异常栈信息，会大大 提高减少异常开销。
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}

class LambdaExpress {

    public static void main(String[] args) {
        lambdaRunnble();
    }

    public static void lambdaRunnble(){
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();

        new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!" + Thread.currentThread().getName())).start();
    }
}

class FileTest {
    public static void main(String[] args) {
        System.out.println(File.separatorChar);
    }
}

class BlockQueueTest {
    public static ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(3);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    arrayBlockingQueue.add(i + "");
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        String m = arrayBlockingQueue.take();
                        System.out.println(m);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        System.out.println("the end");

    }

}

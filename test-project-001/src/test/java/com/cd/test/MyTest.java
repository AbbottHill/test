
package com.cd.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cd.test.beans.Person;
import com.cd.test.enums.ColorEnum;
import com.cd.test.utils.Constants;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.apache.avro.data.Json;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.xerces.dom.PSVIAttrNSImpl;
import org.codehaus.groovy.runtime.powerassert.SourceText;
import org.junit.Test;
import sun.util.locale.provider.DecimalFormatSymbolsProviderImpl;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.cd.test.EnumTest.PropertiesSingleton.PROPERTIES_SINGLETON;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class MyTest {
    String fieldStr;

    public static void main(String[] args) {
        System.out.println(Double.valueOf("12345678123"));
        System.out.println(Double.valueOf("12345678123")/ 1000);
        System.out.println(new BigDecimal("1234567812312342315321423"));
        System.out.println(new BigDecimal("12345678123").divide(new BigDecimal(1000)));

//        int binVal = 0b10000000000000000000000000000000;
//        System.out.println(binVal);

//        String s = "abc def".replaceAll("(\\w+)\\s+(\\w+)", "$2 $1"); //s 就是 "def abc"，replaceFirst 也可以用 $1, $2 的替换。
//        System.out.println(s);

////        new MyTest();//
//        long l = 10_0_0;
//        System.out.println(l);

//        System.out.println(1 / 3);//0
//        System.out.println(1 + 0.5);//0
//        System.out.println(1 / 3f);//0.33333334
//        System.out.println(1d / 3d);//0.3333333333333333
//
//        for (int i = 0; i < 25600; i++) {
//            System.out.println(i + ": " + (char)i);
//        }

        String str = "1234.1234";

        str = str.replace(".", ",");
        System.out.println(str);

    }

    public static void myPrint(Object obj) {
        System.out.println("-----> " + obj);
    }

    @Test
    public void UnitTest() {
        System.out.println("JUnit test");
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

        System.out.println(0.1d + 0.2d);


    }

    /**
     * @param str
     * @return
     * @throws NullPointerException if str is null
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

}

class CollectionsTest {
    public static void main(String[] args) {
        String[] strs = {
                "0.4500", "--", "0.5200", "0.4500", "0.4800", "0.4500", "0.5000", "0.5300", "--", "0.5200",
                "0.4500", "--", "--", "0.4600", "0.4800", "1.4", "0.4800", "5", "5.3", "0.5700", "0.5200", "--", "0.5500", "0.4800",
                "0.4600", "0.4500", "0.5000", "0.5000", "--", "0.5500", "0.5700", "0.5500", "--", "--", "0.5900", "0.5000", "0.5700",
                "!", "$"
        };
        List list = Arrays.asList(strs);
        System.out.println(list);
        sortList(list, "value", -1, 0);
        System.out.println(list);
//
//        for (Object object : list) {
//            System.out.println(object);
//        }


//        TreeSetTest();


        // remove
//        List<String> list = new ArrayList<String>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        Iterator<String> iterator = list.iterator();
////        synchronized (iterator) {
//            while (iterator.hasNext()) {
//                String item = iterator.next();
//                if (Objects.equals("2", item)) {
//                    iterator.remove();
//                }
////            }
//        }
//        System.out.println(JSONObject.toJSONString(list));

        // JDK8 map.forEach
//        Map map = new HashMap(3);
//        map.put("1", 1);
//        map.put("2", 2);
//        map.put("3", 3);
//        map.forEach(new BiConsumer() {
//            @Override
//            public void accept(Object o, Object o2) {
//                System.out.println(o + "--> " + o2);
//            }
//        });

        // treeMap
//        Map treeMap = new TreeMap(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                String value1 = String.valueOf(o1);
//                String value2 = String.valueOf(o2);
//                if (!Tools.isStringDigit(value1) && !Tools.isStringDigit(value2)) {
//                    return value1.compareTo(value2);
//                }
//                if (!Tools.isStringDigit(value1)) {
//                    return 1;
//                }
//                if (!Tools.isStringDigit(value2)) {
//                    return -1;
//                }
//                return new BigDecimal(value1).compareTo(new BigDecimal(value2));
//            }
//        });
//        treeMap.put("*", "*");
//        treeMap.put("100", 100);
//        treeMap.put("19", 10);
//        treeMap.put("$", "$");
//        treeMap.put("101", 101);
//        treeMap.put("-", "-");
//        treeMap.put("!", "!");
//        treeMap.put("--", "--");
//        treeMap.forEach(new BiConsumer() {
//            @Override
//            public void accept(Object o, Object o2) {
//                System.out.println(o + " --> " + o2);
//            }
//        });

    }

    /**
     * @param list; key; sort 1 升序，-1 倒序; type 1 字符排序，0 表示数字排序
     */
    public static void sortList(List<String> list, final String key, final int order, final int type) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String value1 = String.valueOf(o1);
                String value2 = String.valueOf(o2);
                if (type == 0) {
                    if (!Tools.isStringDigit(value1) && !Tools.isStringDigit(value2)) {
                        return value1.compareTo(value2);
//                        return 0;
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
     * @param list; key; sort 1 升序，-1 倒序; type 1 字符排序，0 表示数字排序
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

        //keySet
        Map map = new HashMap();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        Set mapSet = map.keySet();
        for (Object object : mapSet) {
            System.out.println(object);
        }
    }

    public static void TreeSetTest() {/*
        Set<String> set = new TreeSet(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                return Double.parseDouble(o1).compareTo(Double.parseDouble(o1));
                return o1.compareTo(o2);
            }
        });*/
        Set<String> set = new TreeSet();
//        Set<String> set = new HashSet<>();
        set.add("10");
        set.add("2010");
        set.add("2099");
        set.add("2018");
        set.add("2017");
        set.add("2020");
        set.add("0");

        System.out.println("set.size(): " + set.size());
        for (String str: set) {
            System.out.println(str);
        }

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
class AviatorTest {
    public static void main(String[] args) {
        calculateVariance();
    }

    private static void expressionEngine() {
        Long result = (Long) AviatorEvaluator.execute("1+2+3");
        MyTest.myPrint(result);
    }

    private static void calculateVariance() {
        Map<String, Object> env = new HashMap<String, Object>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(20);
        list.add(10);
        env.put("list", list);
        env.put("count", list.size());
        Object avg = AviatorEvaluator.execute("reduce(list, +, 0.0)/count", env);
        System.out.println(avg);

        List<Object> tmpList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Object pow = AviatorEvaluator.exec("math.pow(a-b, 2)", list.get(i), avg);
            System.out.println(pow);
            tmpList.add(pow);
        }
    }

    static class AddFunction extends AbstractFunction {
        @Override
        public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
            Number left = FunctionUtils.getNumberValue(arg1, env);
            Number right = FunctionUtils.getNumberValue(arg2, env);
            return new AviatorDouble(left.doubleValue() + right.doubleValue());
        }
        public String getName() {
            return "add";
        }
    }

}

class MyException extends Exception {

    public static void main(String[] args) {
//        try {
//            throw new MyException("由于MyException重写了fillInStackTrace方法，那么它不会收集线程运行栈信息。");
//        } catch (MyException e) {
//            e.printStackTrace(); // 在控制台的打印结果为：demo.blog.java.exception.MyException:
//            // 由于MyException重写了fillInStackTrace方法，那么它不会收集线程运行栈信息。
//        }


        int result;

        result = foo();
        System.out.println(result);     /////////2

        result = bar();
        System.out.println(result);    /////////2

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

    public static void testThrow() throws Exception {
        System.out.println("start");
        throw new Exception();
//        System.out.println("end"); //unreachable statement
    }



    @SuppressWarnings("finally")
    public static int foo() {
        int a = 0;
        try {
            if (true) {
                return 0;
            }
            a = 5 / 0;
        } catch (Exception e) {
            return 1;
        } finally {
            return 2;
        }
    }

    @SuppressWarnings("finally")
    public static int bar() {
        try {
            return 1;
        }finally {
            return 2;
        }
//        return 3;
    }


}

class MapTest {

    public static void main(String[] args) {
        Map map = new HashMap(2);// initialCapacity
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        Iterator iterator = map.keySet().iterator();


    }

    static void mapCapacity() {
        Map map = new HashMap(2);// initialCapacity
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        System.out.println(map);
    }

}


class LambdaExpress {

    public static void main(String[] args) {
        lambdaRunnble();
    }

    public static void lambdaRunnble() {
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();

        new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!" + Thread.currentThread().getName())).start();
    }
}

class FileTest {
    public static void main(String[] args) {
//        copyFile();
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

class CharSetTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        String str = "C逆变器ａｂ１２あㅟㅡ";
//        int[] ints = checkHalf(str);
//        System.out.println(ints[0] + ", " + ints[1]);


//        System.out.println(leftSubstr("全角文字", 10));
//        System.out.println(leftSubstr("C逆变ａｂa１２あㅟㅡ", 10));
//        System.out.println(leftSubstr("全角文字判", 10));
//        System.out.println(leftSubstr("全角文字123", 10));
//        System.out.println(leftSubstr("全角文字判a", 10));
//        System.out.println(leftSubstr("全角文字判断", 10));

//        String string = null;
//        getStrLength(string);

        // string2Unicode
        String 中 = Integer.toHexString('中');
        System.out.println(中);
        System.out.println((char) Integer.parseInt(中.substring(2), 16));
    }

    /**
     * 字符串长度取得（区分半角、全角）,全角字符2
     *
     * @param string
     * @return
     */
    public static Integer getStrLength(String string) {
        int len = 0;
        if (null == string) {
            return null;
        } else {
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if (isDbcCase(c)) { // 半角
                    len = len + 1;
                } else { // 全角
                    len = len + 2;
                }
            }
        }
        return len;
    }

    /**
     * 半角、全角字符判断
     *
     * @param c 字符
     * @return true：半角； false：全角
     */
    public static boolean isDbcCase(char c) {
        // 基本拉丁字母（即键盘上可见的，空格、数字、字母、符号）
        if (c >= 32 && c <= 127) {
            return true;
        }
        // 日文半角片假名和符号
        else if (c >= 65377 && c <= 65439) {
            return true;
        }
        return false;
    }

    /**
     * 字符串截取（区分半角、全角）
     *
     * @param str   字符串
     * @param limit 长度
     * @return
     */
    public static String leftSubstr(String str, int limit) {
        if (getStrLength(str) <= limit) {
            return str;
        }
        char[] chars = str.toCharArray();
        int charLenSum = 0;
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            int charLen = isDbcCase(chars[i]) ? 1 : 2;
            if (charLenSum + charLen > limit) {
                return result;
            }
            charLenSum += charLen;
            result += chars[i];
            if (charLenSum == limit) {
                return result;
            }
        }
        return "";
    }

    /**
     * char是可以动态的（1-2字节），如果char的长度超过了1就是全角，否则半角
     * return  checkRet[0]:半角个数    checkRet[1]:全角个数
     */
    public static int[] checkHalf(String str) {
        int checkRet[] = new int[2];
        byte[] Char = null;
        for (int i = 0; i < str.length(); i++) {
            try {
                Char = (new Character(str.charAt(i)).toString()).getBytes("UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (Char.length == 1) {// 统计半角个数
                checkRet[0]++;
            } else {// 统计全角个数
                checkRet[1]++;
            }
        }
        return checkRet;
    }

    public static String string2Unicode(String string) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            // 取出每一个字符
            char c = string.charAt(i);
            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }
        return unicode.toString();
    }

    public static String unicode2String(String unicode) {
        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);
            // 追加成string
            string.append((char) data);
        }
        return string.toString();
    }


}

class ThreadTest {

    public static void main(String[] args) {
        for (Thread t : listThreads()) {
            System.out.println("---------> Name：" + t.getName() + "State：" + t.getState() + "Class：" + t.getClass().getName());
        }
    }

    public static java.util.List<Thread> listThreads() {
        int tc = Thread.activeCount();
        Thread[] ts = new Thread[tc];
        Thread.enumerate(ts);
        return Arrays.asList(ts);
    }
}

class CalendarTest {
    public static void main(String[] args) {

    }


}

class CallableTest implements Callable<String> {

    public CallableTest(String acceptStr) {
        this.acceptStr = acceptStr;
    }

    private String acceptStr;

    @Override
    public String call() throws Exception {
        // 任务阻塞 1 秒
        Thread.sleep(1000);
        return this.acceptStr + " append some chars and return it!";
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new CallableTest("my callable test!");
        FutureTask<String> task = new FutureTask<>(callable);
        long beginTime = System.currentTimeMillis();
        // 创建线程
        new Thread(task).start();
        // 调用get()阻塞主线程，反之，线程不会阻塞
        String result = task.get();
        long endTime = System.currentTimeMillis();
        System.out.println("hello : " + result);
        System.out.println("cast : " + (endTime - beginTime) / 1000 + " second!");
        String result1 = task.get();
        System.out.println("hello : " + result1);
    }
}

class CallableTest2 {

    static class Sum implements Callable<Long> {
        private final long from;
        private final long to;

        Sum(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public Long call() {
            long acc = 0;
            for (long i = from; i <= to; i++) {
                acc = acc + i;
            }
            System.out.println(Thread.currentThread().getName() + " : " + acc);
            return acc;
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Long>> results = executor.invokeAll(Arrays.asList(
                new Sum(0, 10), new Sum(0, 1_000), new Sum(0, 1_000_000)
        ));
        executor.shutdown();
        for (Future<Long> result : results) {
            System.out.println(result.get());
        }
    }
}

class RunTimeTest {
    public static void main(String[] args) {
        System.out.println("availableProcessors: " + Runtime.getRuntime().availableProcessors() + "");
        System.out.println("freeMemory: " + Runtime.getRuntime().freeMemory() / (1024 * 1024) + " M");
        System.out.println("totalMemory: " + Runtime.getRuntime().totalMemory() / (1024 * 1024) + " M");
        System.out.println("maxMemory: " + Runtime.getRuntime().maxMemory() / (1024 * 1024) + " M");

    }

}

class EnumTest {

    public static void main(String[] args) {
        Color color = Color.BLANK;
        switch (color) {
            case RED:
                System.out.println(Color.BLANK.getIndex() + ": " + Color.BLANK.getName());
                System.out.println(Color.BLANK);
            case BLANK:
                System.out.println(Color.BLANK.getIndex() + ": " + Color.BLANK.getName());
                System.out.println(Color.BLANK);
        }

        color.printAll();

        ColorEnum black = ColorEnum.BLACK;
        black.printAll();
    }

    enum PropertiesSingleton {
        PROPERTIES_SINGLETON;
        private Map<String, String> map;

        public String getProperty(String key) {
            return map.get(key);
        }

        PropertiesSingleton() {
            map = new HashMap();
            map.put("flag", "1");
            System.out.println("PropertiesSingleton");
        }
    }

}

class StringTest {
    public static void main(String[] args) {

        // split
//        String str = "abc";
//        String str1 = "a，b，，,c，,d,".replaceAll("，", ",");
//        str1 = str1.replaceAll(",+", ",");
//        str1 = str1.replaceAll(",$", "");
//        System.out.println(str + "==" + str1);
//        System.out.println(str == str1);
//
////        Arrays.stream(str1.split(",")).forEach(System.out::print);
//        String[] split = str1.split(",");
//        for (int i = 0; i < split.length; i++) {
//            System.out.println(split[i]);
//        }


//        String [] strArr = "".split(",");
//        System.out.println(strArr);

//        System.out.println(Objects.equals(null, null));

        // place holder
        String str = "this is a test!";
        System.out.println(MessageFormat.format("MessageFormat方法：{0}这是{1}的使用", str , "占位符"));

        String stringFormat  = "lexical error at position %s, encountered %s, expected %s ";
        String messageFormat ="lexical error at position {0}, encountered {1}, expected {2}";
        System.out.println(String.format(stringFormat, 123, 100, 456));
        System.out.println(MessageFormat.format(messageFormat, new Date(), 100, 456));

        // %n$ms：代表输出的是字符串，n代表是第几个参数，设置m的值可以在输出之前放置空格，%n$-ms 可以在输出之后放置空格
        // %n$md：代表输出的是整数，n代表是第几个参数，设置m的值可以在输出之前放置空格，也可以设为0m,在输出之前放置m个0
        // %n$mf：代表输出的是浮点数，n代表是第几个参数，设置m的值可以控制小数位数，如m=2.2时，输出格式为00.00
        String format = "%1$-5s%2$-5s,%3$2.2f";
        System.out.format(format, "111","222", 1234.1299); //111  222  ,1234.13



//        StringBuilder stringBuilder = new StringBuilder();
//        System.out.println(stringBuilder.append("a").append("b"));
//        System.out.println(stringBuilder.replace(0, stringBuilder.length(), ""));

//        System.out.println(Pattern.matches("^\\w+@[a-zA-Z0-9]{2,10}(\\.[a-z0-9]{2,4}){1,3}$", "1234@123.qw"));

//        checkDate("2007/1/7");

//        System.out.println(new SimpleDateFormat("yyyy/MM/dd").toPattern());

    }

    /**
     * date format
     * @param str
     */
    private static void checkDate(String str) {
        boolean flag = true;
        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        try{
            Calendar instance = Calendar.getInstance();
            Date date = formatter.parse(str);
            instance.setTime(date);
            String[] ymd = str.split("/");
            int year = instance.get(Calendar.YEAR);
            int month = instance.get(Calendar.MONTH) + 1;
            int dt = instance.get(Calendar.DATE);
            if (Integer.parseInt(ymd[0]) != year) {
                flag = false;
            }
            if (Integer.parseInt(ymd[1]) != month) {
                flag = false;
            }
            if (Integer.parseInt(ymd[2]) != dt) {
                flag = false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(flag);
    }

}

class PolymorphicTest {
    public static void main(String[] args) {
        List<animal> animals = new ArrayList<>();
        animals.add(new panda());
        animals.add(new shark());
        for (animal a: animals) {
            a.eat();
        }
    }

    static class animal{
        protected void eat(){
            System.out.println("eat foot");
        }
    }

    static class panda extends animal{
        protected void eat(){
            System.out.println("eat bamboo");
        }
    }

    static class shark extends animal{
        protected void eat(){
            System.out.println("eat fish");
        }
    }
}

class RegexTest{
    public static void main(String[] args) {

        String xxx = "\\' name";
        System.out.println(xxx.replace("\\", ""));
        System.out.println(xxx);


        Matcher abcd = Pattern.compile("[a-z]").matcher("ab,cd");
        System.out.println(abcd.replaceAll("1234"));

        // back reference
//        System.out.println("def abc".replaceAll("(\\w+)\\s+(\\w+)", "$2$1"));
        System.out.println(Pattern.matches("\\d+", "1a234"));
        getDiamondBracketsElement();

        // /^(?:-?\d+|-?\d{1,3}(?:,\d{3})+)?(?:\.\d+)?$/
        System.out.println("*************** ?: ?= ********************");
        System.out.println("4444a666b".replace("44", "$1")); // $1$1a666b
        System.out.println("444a666b".replaceAll("\\d{3}(?:a)(6)", "$1")); // 666b
        System.out.println("444a666b".replaceAll("\\d{3}(?=a)(6)", "$4")); // 444a666b
        System.out.println("444a666b".replaceAll("\\d{3}(?=a)", "1")); // 1a666b
        System.out.println("444a666b".replaceAll("\\d{3}(?!a)", "1")); // 444a1b
        System.out.println("444a666b".replaceAll("\\d{3}(?=a)a6", "1")); // 166b
        System.out.println("444a666b".replaceAll("\\d{3}(?:a)6", "1")); // 166b
        System.out.println("444a666b".replaceAll("\\d{3}(?:a)(6)", "$1")); // 666b

        System.out.println("*************** number ********************");

        System.out.println(Pattern.matches("^(?:-?\\d+|-?\\d{1,3}(?:,\\d{3})+)?(?:\\.\\d+)?$", "1234"));
        System.out.println(Pattern.matches("^(?:-?\\d+|-?\\d{1,3}(?:,\\d{3})+)?(?:\\.\\d+)?$", "-12,345.67"));
        System.out.println(Pattern.matches("^(-?\\d+|-?\\d{1,3}(,\\d{3})+)?(\\.\\d+)?$", "-12,345,678.67"));
        System.out.println(Pattern.matches("^(-?\\d+|-?\\d{1,3}(,\\d{3})+)?(\\.\\d+)?$", ".67"));

        System.out.println("***********************************");

        /*.{3}(?=a)代表着这样的功能：
         * 查找给出的字符串中符合a前面有三个字母的这样的子串，当然取得的子串不包括（？=a)
         */
        Pattern p = Pattern.compile(".{3}(?=a)");//(?=X) X，通过零宽度的正 lookahead
        String s1 = "444a66b";
        Matcher m = p.matcher(s1);
        while (m.find()) {
            System.out.println(m.group());
        }
        System.out.println("***********************************");

        /*同理\\d{3}(?=a)代表着这样的功能：
         * 查找给出的字符串中符合a前面有三个数字的这样的子串，当然取得的子串不包括（？=a)
         * 本例给出的444a66b是匹配的，得出的group是444
         * 而 "44d4a66b";是不匹配的，因为没有在a之前没连续的三个数字
         * 在例如.{3}(?=b)这样的匹配，如果用来匹配444a66b得到的字符串是a66
         */
        p = Pattern.compile("\\d{3}(?=a)");//(?=X) X，通过零宽度的正 lookahead
        String s2 = "444a66b";
        m = p.matcher(s2);
        while (m.find()) {
            System.out.println(m.group());
        }
        System.out.println("***********************************");


        /**
         * 通过上面的（？=X）下面来测试和设想一下(?!a)，api解释为
         * (?！X) X，通过零宽度的负lookahead，所以对比一下很容易想到
         * \\d{3}(?!a)代表着连续三个数字的后面出现的字符不是a的匹配，
         * 所以字符串444a666b只有一个匹配子串666
         * 字符串444b666b两个匹配444 666
         * 字符串444a666a都不匹配
         */
        p = Pattern.compile("\\d{3}(?!a)");//(?！X) X，通过零宽度的负lookahead
        String s3 = "444b666b";
        m = p.matcher(s3);
        while (m.find()) {
            System.out.println(m.group());
        }




    }
        /// 获取字符串中的 <> 元素 ； regex
    private static List<String> getDiamondBracketsElement() {
        String str = "a<b><c><储><><<<>>><>";
        List<String> list = new ArrayList<String>();
        Pattern p = Pattern.compile("(<[^>]*>)");

        Matcher m = p.matcher(str);
        while (m.find()) {
            list.add(m.group());
        }
        for (String s1 : list) {
            System.out.println(s1);
        }
        return list;
    }


}

class OptionalTest {
    public static void main(String[] args) {

        Optional<String> optional1 = Optional.ofNullable(PROPERTIES_SINGLETON.getProperty("flag"));
        Optional<String> optional2 = Optional.ofNullable(PROPERTIES_SINGLETON.getProperty("xkey"));

        if (optional1.isPresent()) {
            System.out.println("flag is present");
        }
        if (optional2.isPresent()) {
            System.out.println("xkey is present");
        }

        // orElse
        System.out.println(Objects.equals(optional1.orElse("1"), "1"));// true
        System.out.println(Objects.equals(optional2.orElse("1000"), "1000"));// true

    }
}

class HttpClientTest {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://test.isolarcloud.com/sungws/AppService");
        List <NameValuePair> nvps = new ArrayList <NameValuePair>();
        nvps.add(new BasicNameValuePair("service", "login"));
        nvps.add(new BasicNameValuePair("username", "vip"));
        nvps.add(new BasicNameValuePair("password", "secret"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        CloseableHttpResponse response2 = httpclient.execute(httpPost);
        try {
            System.out.println(response2.getStatusLine());
            HttpEntity entity = response2.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            System.out.println(JSONObject.parseObject(EntityUtils.toString(entity, "UTF-8"), HashMap.class));
            EntityUtils.consume(entity);
        } finally {
            response2.close();
        }
    }
}

class IOTest {


//    String --> InputStream
    String str = "abc";
    ByteArrayInputStream stream = new ByteArrayInputStream(str.getBytes());

//    InputStream --> String
    String inputStream2String(InputStream is) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = in.readLine()) != null){
            buffer.append(line);
        }
        return buffer.toString();
    }

    //    File --> InputStream
    InputStream fileToInputStream() throws FileNotFoundException {
        File file = new File("");
        InputStream in = new FileInputStream(file);
        return in;
    }

//    InputStream --> File
    public void inputstreamtofile(InputStream ins,File file) throws IOException {
        OutputStream os = new FileOutputStream(file);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        os.close();
        ins.close();
    }

    static void copyFile() {
        String filePath = "C:/Users/Administrator/Desktop/handbook.pdf";
        try (FileInputStream in = new FileInputStream(filePath);
             FileOutputStream out = new FileOutputStream("C:/Users/Administrator/Desktop/handbook.copy.pdf")
        ) {
            Long start = System.currentTimeMillis();
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }

//            byte buffer[] = new byte[1024];
//            //判断输入流中的数据是否已经读完的标识
//            int len;
//            //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
//            while ((len = in.read(buffer)) > 0) {
//                //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "/" + filename)当中
//                out.write(buffer, 0, len);
//            }

            Long end = System.currentTimeMillis();
            System.out.println("time: " + (end - start));

        } catch (IOException e) {e.getMessage();
        }
    }
}

class ClassLoaderTeset{
    public static void main(String[] args) {

        System.out.println(ClassLoader.getSystemResource(""));
    }
}

class MD5Test {

    public static void main(String[] args) throws Exception {
        System.out.println(MD5("abcd"));
        System.out.println(GetMD5Code("abcd"));
    }

    private static String MD5(String s) throws NoSuchAlgorithmException {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        byte[] btInput = s.getBytes();
        // 获得MD5摘要算法的 MessageDigest 对象
        MessageDigest mdInst = MessageDigest.getInstance("MD5");
        // 使用指定的字节更新摘要
        mdInst.update(btInput);
        // 获得密文
        byte[] md = mdInst.digest();
        // 把密文转换成十六进制的字符串形式
        int j = md.length;
        char str[] = new char[j * 2];
        for (int i = 0, k = 0; i < j; i++) {
            byte byte0 = md[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
    }

    private static final String KEY_MD5 = "MD5";
    // 全局数组
    private static final String[] strDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    // 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // 转换字节数组为16进制字串
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    /**
     * MD5加密
     * @param strObj
     * @return
     * @throws Exception
     */
    public static String GetMD5Code(String strObj) throws Exception {
        MessageDigest md = MessageDigest.getInstance(KEY_MD5);
        // md.digest() 该函数返回值为存放哈希值结果的byte数组
        return byteToString(md.digest(strObj.getBytes()));
    }

}

class BigDecimalTest {
    public static void main(String[] args) {
        valueOfFun();
    }

    public static void valueOfFun() {
        System.out.println(new BigDecimal(1.1)); //1.100000000000000088817841970012523233890533447265625
        System.out.println(new BigDecimal("1.1")); //1.1
        System.out.println(BigDecimal.valueOf(1.1)); //1.1

        Pattern compile = Pattern.compile("(\\d{1,3})(?=(?:\\d{3})+(?!\\d))");
//        return x[0].replace(/(\d{1,3})(?=(?:\d{3})+(?!\d))/g, '$1.') + (x.length > 1 ? '.' + x[1] : '');

        String[] numArr = "1234678.90".split("\\.");
        System.out.println( numArr[0].replaceAll("(\\d{1,3})(?=(?:\\d{3})+(?!\\d))", "$1.") + (numArr.length > 1? "." + numArr[1]: ""));

    }
}

class BigIntegerTest {
    public static void main(String[] args) {
        byte[] bytes = new byte[]{1,1};
        System.out.println(new BigInteger(bytes));
    }

}

class PathTest {
    public static void main(String[] args) {
        System.out.println(PathTest.class.getName());
        System.out.println(PathTest.class.getSimpleName());

        System.out.println(ClassLoader.getSystemResource("").getPath());
        System.out.println(ClassLoader.getSystemResource(""));

    }
}

class LocalTest {
    public static void main(String[] args) {
        Locale myLocale = Locale.getDefault();
        System.out.println(myLocale.getCountry());
        System.out.println(myLocale.getLanguage());
        System.out.println(myLocale.getDisplayCountry());
        System.out.println(myLocale.getDisplayLanguage());

        NumberFormat integerFormat = NumberFormat.getIntegerInstance(myLocale);
        System.out.println(integerFormat.format(123456789.234));

        Locale germany = Locale.GERMANY;
        integerFormat = NumberFormat.getIntegerInstance(germany);
        NumberFormat numberFormat = DecimalFormat.getNumberInstance(germany);
//        System.out.println(numberFormat.format(123456789123456789.234));
        System.out.println(numberFormat.format(BigDecimal.valueOf(1234567891234567.234))); //此处精度不够

    }
}


class Generic_test {

    public static void main(String[] args) {

        ArrayList<String> objects = new ArrayList<>();
        objects.add("1");
        System.out.println(objects);

        System.out.println(getMe("a").getClass());
        System.out.println(getMe("a") instanceof String);
        System.out.println(getMe(1));
        System.out.println(getMe(1).getClass());
        System.out.println(getMe(Arrays.asList("1", 1, 'a')).getClass());
        System.out.println(getMe(new String[]{""}.getClass()));

        System.out.println("--------------------------");
        Box<String> stringBox = new Box<>("1");
        Box<Double> doubleBox = new Box<>(1.1);
        Box.getValue(doubleBox);


        // 编译正常
        List<?>[] lsa2 = new List<?>[10];
        // 编译 Error
//        List<String>[] lsa = new List<String>[10];

        ArrayList<? extends Map> maps = new ArrayList<>();
        HashMap<Object, Object> hmap = new HashMap<>();
        //compile error:
        // add  (capture<? extends java.util.Map>) in ArrayList cannot be applied to (java.util.HashMap<java.lang.Object,java.lang.Object>)
//        maps.add(hmap);



    }



    private static <T> T getMe(T a) {
        return a;
    }

    private static Class getMe(Class c) {
        return c;
    }

    private static <T extends Number> T getMeNumber(T a) {
        return a;
    }

    // BOX class
    static class Box<E> {
        private Object value;

        public Box(E e) {
            this.setValue(e);
        }

//        static Box<E> getValue(Box<E> e) {
//            System.out.println("object: " + e.get);
//            return e;
//        }

        // wildcard
        static Box getValue(Box<? extends Number> num) {
            System.out.println("number: " + num.getValue());
            return num;
        }

        public Object getValue() {
            ArrayList<String> strings = new ArrayList<>();
            ArrayList<Integer> is = new ArrayList<>();
            System.out.println(strings);
            System.out.println(is);
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }

    public Object getValue() {
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> is = new ArrayList<>();
        System.out.println(strings);
        System.out.println(is);
        return null;
    }

}


class CountDownLatch_test {

    public static void main(String[] args) throws InterruptedException {
        //1、 创建CountDownLatch 对象， 设定需要计数的子线程数目
        final java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(3);
        System.out.println(Thread.currentThread().getName() + " 主线程开始执行....");
        for (int i = 0; i < 3; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "  开始执行存储过程..");
                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName() + "  存储过程执行完毕...");
                        //2、子线程执行完毕，计数减1
                        latch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
        System.out.println(Thread.currentThread().getName() + " 等待子线程执行完毕...");
        //3、 当前线程挂起等待
        latch.await();
        System.out.println(Thread.currentThread().getName() + " 主线程执行完毕....");
    }
}

class MemoryAnalysis_test {

    static void setDate (Date date) {
//        Calendar instance = Calendar.getInstance();
//        instance.set(Calendar.DAY_OF_MONTH, 1);
//        date = instance.getTime();
        date.setDate(1);
        System.out.println(date);
    }

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        Person person = new Person();
        Person person1 = new Person();
        person.setBirth(date);
        person1.setBirth(date);
        System.out.println(person);
        System.out.println(person1);
        setDate(date);
        System.out.println(date);
        System.out.println(person);
        System.out.println(person1);
    }
}

class ClassPath {
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemResource("/").toString());
        System.out.println(ClassLoader.getSystemResource("").toString());
        System.out.println(ClassPath.class.getResource("").getPath());
        String path = ClassPath.class.getResource("/").getPath();
        System.out.println(path);
        System.out.println(path.substring(1, path.length()));

        // 4. 读取文件内容
        try (BufferedReader reader = new BufferedReader(new FileReader(path + "data.txt"))) {
            String fileText = reader.lines().reduce("", String::concat);
            System.out.println(fileText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // D:\IdeaWorkSpace\web-trunk\projects\test\target\test-classes\data.txt
    // D:\IdeaWorkSpace\web-trunk\projects\test\target\test-classes\data.txt
}


class Encode {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String gb2312 = new String("毎時間発電".getBytes("gb2312")); // ?????
        String utf8 = new String("毎時間発電".getBytes("UTF-8")); // 毎時間発電
        System.out.println(gb2312);
        System.out.println(utf8);
    }

}

class DateTime {
    public static void main(String[] args) throws ParseException {
        System.out.println("TimeZone.getDefault -> " + TimeZone.getDefault());

        // LocalDateTime.now
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        // parse trans
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss aaa", Locale.US); // Locale.US is required
        Date parse = simpleDateFormat1.parse("Aug 15, 2018 14:04:10 AM");
        System.out.println(simpleDateFormat.format(parse));
//        long parse = Date.parse("Aug 8, 2018 12:00:00 AM");
//        Calendar instance = Calendar.getInstance();
//        instance.setTimeInMillis(parse);
//        System.out.println(parse);
        System.out.println(simpleDateFormat.format(parse));
    }
}




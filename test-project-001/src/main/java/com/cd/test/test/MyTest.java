
package com.cd.test.test;

import com.googlecode.aviator.AviatorEvaluator;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.swing.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class MyTest {
	public static void main(String[] args) {
		new MyTest();
	}

	public MyTest() {

	}

	public static void myPrint(Object obj) {
		System.out.println("-----> " + obj);
	}
	

}

class Tools {

	/**
	 * @param str
	 * @return
	 * @throws NullPointerException
	 *             if str is null
	 */
	static boolean isStringDigit(String str) throws NullPointerException {
		return Pattern.matches("-?\\d+\\.?\\d+", str);
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
		List list = new ArrayList();
		Map m1 = new HashMap();
		m1.put("value", 1);
		list.add(m1);
		Map m2 = new HashMap();
		m2.put("value", "--");
		list.add(m2);
		Map m3 = new HashMap();
		m3.put("value", 3);
		list.add(m3);
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
	 *            key; sort 1 升序，-1 倒序; type 1 字符排序，0 表示数字排序
	 */
	public static void sortList(List<Map<String, Object>> list, final String key, final int order, final int type) {
		Collections.sort(list, new Comparator<Map<String, Object>>() {
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				String value1 = String.valueOf(o1.get(key));
				String value2 = String.valueOf(o2.get(key));
				if (Tools.isEmpty(value1)) {
					System.out.println("value1" + value1);
					return 1;
				}
				if (Tools.isEmpty(value2)) {
					System.out.println("value2" + value2);
					return -1;
				}
				if (type == 0) {
					return new BigDecimal(value1).compareTo(new BigDecimal(value2)) * order;
				} else {
					return value1.compareTo(value2) * order;
				}
			}
		});
	}

	/**
	 * @param list;
	 *            key; sort 1 升序，-1 倒序; type 1 字符排序，0 表示数字排序
	 */
	public static void sortList2(List<Map<String, Object>> list, final String key, final int order, final int type) {
		Collections.sort(list, new Comparator<Map<String, Object>>() {
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				String value1 = String.valueOf(o1.get(key));
				String value2 = String.valueOf(o2.get(key));
				if (Tools.isEmpty(value1)) {
					System.out.println("value1" + value1);
					return 1;
				}
				if (Tools.isEmpty(value2)) {
					System.out.println("value2" + value2);
					return -1;
				}
				if (type == 0) {
					return new BigDecimal(value1).compareTo(new BigDecimal(value2)) * order;
				} else {
					return value1.compareTo(value2) * order;
				}
			}
		});
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
	
	@Test
	public void lambdaRunnble(){
		new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
	}
}

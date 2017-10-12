
package com.cd.test.test;

import com.googlecode.aviator.AviatorEvaluator;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class MyTest {
    public static void main(String[] args) {
        new MyTest();
    }
    private int i;
    public MyTest() {

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

    /**
     * is empty
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if ("".equals(obj) || "null".equals(obj) || "NULL".equals(obj) || "--".equals(obj) || "undefined".equals(obj) ||
                "nil".equals(obj) || "".equals(obj.toString().trim())) {
            return true;
        }
        return false;
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

class CollectionsTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        Map m1 = new HashMap(); m1.put("value", 1); list.add(m1);
        Map m2 = new HashMap(); m2.put("value", "--"); list.add(m2);
        Map m3 = new HashMap(); m3.put("value", 3); list.add(m3);
        System.out.println(list);
        sortList(list, "value", -1, 0);
        System.out.println(list);
    }

    static void mapCapacity() {
        Map map = new HashMap(2);//initialCapacity
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        System.out.println(map);
    }


    /**
     * @param list; key; sort  1 升序，-1 倒序; type  1 字符排序，0 表示数字排序
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

    public MyException(String message) {
        super(message);
    }

    /*
     * 重写fillInStackTrace方法会使得这个自定义的异常不会收集线程的整个异常栈信息，会大大
     * 提高减少异常开销。
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    public static void main(String[] args) {
        try {
            throw new MyException("由于MyException重写了fillInStackTrace方法，那么它不会收集线程运行栈信息。");
        } catch (MyException e) {
            e.printStackTrace(); // 在控制台的打印结果为：demo.blog.java.exception.MyException: 由于MyException重写了fillInStackTrace方法，那么它不会收集线程运行栈信息。
        }
    }
}


class JedisUtil {

    private static final String ipAddr = "127.0.0.1";
    private static final int port = 6379;
    private static Jedis jedis= null;

    @BeforeClass
    public static void init()
    {
        jedis = JedisUtil.getInstance().getJedis(ipAddr, port);
    }

    @Test
    public void testKey() throws InterruptedException
    {
        System.out.println("清空数据："+jedis.flushDB());
        System.out.println("判断某个键是否存在："+jedis.exists("username"));
        System.out.println("新增<'username','zzh'>的键值对："+jedis.set("username", "zzh"));
        System.out.println(jedis.exists("name"));
        System.out.println("新增<'password','password'>的键值对："+jedis.set("password", "password"));
        System.out.print("系统中所有的键如下：");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        System.out.println("删除键password:"+jedis.del("password"));
        System.out.println("判断键password是否存在："+jedis.exists("password"));
        System.out.println("设置键username的过期时间为5s:"+jedis.expire("username", 5));
        TimeUnit.SECONDS.sleep(2);
        System.out.println("查看键username的剩余生存时间："+jedis.ttl("username"));
        System.out.println("移除键username的生存时间："+jedis.persist("username"));
        System.out.println("查看键username的剩余生存时间："+jedis.ttl("username"));
        System.out.println("查看键username所存储的值的类型："+jedis.type("username"));
    }


    @AfterClass
    public static void close()
    {
        JedisUtil.getInstance().closeJedis(jedis,ipAddr, port);
    }

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private JedisUtil(){}

    private static class RedisUtilHolder{
        private static final JedisUtil instance = new JedisUtil();
    }

    public static JedisUtil getInstance(){
        return RedisUtilHolder.instance;
    }

    private static Map<String, JedisPool> maps = new HashMap<String,JedisPool>();

    private static JedisPool getPool(String ip, int port){
        String key = ip+":"+port;
        JedisPool pool = null;
        if(!maps.containsKey(key))
        {
            JedisPoolConfig config = new JedisPoolConfig();
//            config.setMaxActive(RedisConfig.MAX_ACTIVE);
            config.setMaxIdle(RedisConfig.MAX_IDLE);
//            config.setMaxWait(RedisConfig.MAX_WAIT);
            config.setTestOnBorrow(true);
            config.setTestOnReturn(true);

            pool = new JedisPool(config,ip,port,RedisConfig.TIMEOUT);
            maps.put(key, pool);
        }
        else
        {
            pool = maps.get(key);
        }
        return pool;
    }

    public Jedis getJedis(String ip, int port)
    {
        Jedis jedis = null;
        int count = 0;
        do
        {
            try
            {
                jedis = getPool(ip,port).getResource();
            }
            catch (Exception e)
            {
                logger.error("get redis master1 failed!",e);
                getPool(ip,port).returnBrokenResource(jedis);
            }
        }
        while(jedis == null && count<RedisConfig.RETRY_NUM);
        return jedis;
    }

    public void closeJedis(Jedis jedis, String ip, int port){
        if(jedis != null)
        {
            getPool(ip,port).returnResource(jedis);
        }
    }
}

class RedisConfig
{
    //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    public static int MAX_ACTIVE = 1024;

    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    public static int MAX_IDLE = 200;

    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    public static int MAX_WAIT = 10000;

    public static int TIMEOUT = 10000;

    public static int RETRY_NUM = 5;
}




package com.cd.test.AnnotationTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestNet {
    public static String doGetRequest(String url) {
        String result = "";
        if (null == url) {
            try {
                throw new Throwable("empty netUrl!!!");
            } catch (Throwable e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        HttpURLConnection conneciton = null;
        try {
            URL mURL = new URL(url);
            conneciton = (HttpURLConnection) mURL.openConnection();
            InputStream inputs = conneciton.getInputStream();
            String line = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputs));
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\r\n");
            }
            result = stringBuilder.toString();
            System.out.println("test 网络请求结果：" + result);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("test 网络异常原因：" + e.toString());
        } finally {
            //下面是谷歌官方推荐的，详见谷歌官方文档
            if (conneciton != null) {
                conneciton.disconnect();
            }
        }
        return result;


    }

    public static String doPostRequest(String url) {
        return null;
    }

    //解析传入的对象中含有的注解
    //注解底层就是反射
    public static String parseRequest(Object obj) {
        String url = "";
        String result = "";
        //第一步。获取class文件
        Class clazz = obj.getClass();
        System.out.println("test class 名字：" + clazz.getSimpleName());
        //第二部，注解都是在方法上的，获取所有的方法
        Method[] methods = clazz.getMethods();
        //第三步：遍历方法
        for (Method method : methods) {
            System.out.println("test 方法名字：" + method.getName());
            //判断每个方法上的注解是否含有
            if (method.isAnnotationPresent(RequestUrl.class)) {
                //拿出方法上的这个注解
                RequestUrl urlAnotation = method.getAnnotation(RequestUrl.class);
                //拿出注解传入的值
                url = urlAnotation.value();
                System.out.println("test 网址的值11：" + url);
            }

            if (method.isAnnotationPresent(RequstType.class)) {
                RequstType requestType = method.getAnnotation(RequstType.class);
                if (requestType.value().equals(Type.GET)) {
                    //执行GET网络请求
                    result = doGetRequest(url);
                }

                if (requestType.value().equals(Type.POST)) {
                    //执行POST网络请求
                    result = doPostRequest(url);
                }
            }
        }
        return result;

    }
}
    
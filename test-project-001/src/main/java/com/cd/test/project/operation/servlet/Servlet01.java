package com.cd.test.project.operation.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import com.cd.test.project.common.MsgSubscribeThread;
import com.cd.test.project.common.SpringContextUtil;
import com.cd.test.project.common.StringUtil;
import com.cd.test.test.RedisPubSub.Subscriber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2017/9/22.
 */
public class Servlet01 extends HttpServlet {
    private static Logger logger = LogManager.getLogger(Servlet01.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=UTF-8");
            response.setHeader("cache-control", "no-cache");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try (Writer writer = response.getWriter()) {
            Map requestMap = getParamsFromRequest(request);
            Object result = doExecute(requestMap);

            writer.write(JSONArray.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        synchronized (this) {
            if (StringUtil.isEmptyStr(String.valueOf(session.getAttribute("timesTopic")))) {
                int random = Integer.parseInt(String.valueOf(Math.random() * 10).substring(0, 1));
                String channel = String.valueOf("abcdefghij".charAt(random));
                session.setAttribute("timesTopic", channel);

                System.out.println("session.getId -> " + session.getId());
                Subscriber subscriber = (Subscriber) SpringContextUtil.getBean("subscriber");
                session.setAttribute("Subscriber", subscriber);
                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        JedisConnectionFactory jedisConnectionFactory = (JedisConnectionFactory) SpringContextUtil.getBean("connectionFactory");
                        System.out.println(String.format("redis pool is starting, redis ip %s, redis port %d", jedisConnectionFactory.getHostName(), jedisConnectionFactory.getPort()));
                        Jedis jedis = (Jedis) jedisConnectionFactory.getConnection().getNativeConnection();
                        jedis.subscribe(subscriber, channel);
                    }
                });
                t1.start();
            }
        }
        System.out.println("timesTopic: " + session.getAttribute("timesTopic"));
        System.out.println("TestWebsocket: " + session.getAttribute("TestWebsocket"));

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        this.doPost(request, response);
    }

    private Object doExecute(Map params) {
        Object result = null;
//        String service = String.valueOf(params.get("service"));
//        String method = String.valueOf(params.get("method"));
        Class classType = null;
        String method = String.valueOf(params.get("method"));
        try {
            if ("treeService".equals(String.valueOf(params.get("service")))) {
                classType = Class.forName("com.cd.test.project.operation.service.treeService.TreeService");
            } else if ("pollingService".equals(String.valueOf(params.get("service")))) {
                classType = Class.forName("com.cd.test.project.operation.service.PollingService.PollingService");
            }
            Object obj = classType.newInstance();
            Method[] methods = obj.getClass().getMethods();
            Method mExec = null;
            for (int i = 0; i < methods.length; i++) {
                if (method.equals(methods[i].getName())) {
                    mExec = methods[i];
                    break;
                }
            }
//            Method method = obj.getClass().getMethod("queryTreeNodes", classType);
            result = mExec.invoke(obj, params);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }


    protected Map getParamsFromRequest(HttpServletRequest request) {
        Map map = new HashMap();
        for (Enumeration enu = request.getParameterNames(); enu.hasMoreElements();) {
            String key = enu.nextElement().toString();
            String val = request.getParameter(key);
            map.put(key,val);
        }
        logger.info("request.params: " + map);
        return map;
    }

}

package com.cd.test.project.operation.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sun.deploy.net.HttpRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Administrator on 2017/9/22.
 */
public class Servlet01 extends HttpServlet {
    private static final Logger logger = LogManager.getLogger("Servlet01");

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
//            try {
//                Map requestMap = request.getParameterMap();
//                requestMap.put("service", "treeService");
//                requestMap.put("method", "queryTreeNodes");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }


            Map requestMap = getParamsFromRequest(request);
            requestMap.put("service", "treeService");
            requestMap.put("method", "queryTreeNodes");
            System.out.println(doExecute(requestMap));


            List nodes = new ArrayList();
            Map map1 = new HashMap(); map1.put("id", "10001"); map1.put("name", "node10001");
            Map map2 = new HashMap(); map1.put("id", "10004"); map1.put("name", "node1004");
            Map map3 = new HashMap(); map1.put("id", "10002"); map1.put("name", "node10002"); map1.put("isParent", "true");
            nodes.add(map1);
//            nodes.add(map2);
            nodes.add(map3);
            String treeNodes = "[{id: 10001, name: 'node10001'}, " +
                    "{id: 10004, name: 'node1002'}, " +
                    "{id: 10002, pId: 10001, rootPId: 0, name: 'node10002', isParent: 'true'}]";
//            writer.write("\"[" +
//                    "{id: 10001, name: 'node10001'}, " +
//                    "{id: 10004, name: 'node1002'}, " +
//                    "{id: 10002, pId: 10001, rootPId: 0, name: 'node10002', isParent: 'true'}]\"");
//            writer.write(JSONArray.toJSONString(treeNodes));
            writer.write(JSONArray.toJSONString(nodes));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        try {
            classType = Class.forName("com.cd.test.project.operation.service.treeService.TreeService");
            Object obj = classType.newInstance();

            Method[] methods = obj.getClass().getMethods();
            Method mExec = null;
            for (int i = 0; i < methods.length; i++) {
                if ("queryTreeNodes".equals(methods[i].getName())) {
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
        logger.error("request.params: " + map);
        return map;
    }

}

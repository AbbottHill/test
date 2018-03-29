package com.cd.test.operation.servlet;

import com.alibaba.fastjson.JSONArray;
import com.cd.test.utils.LoggerProxy;
import com.cd.test.utils.SpringContextUtil;
import com.cd.test.utils.StringUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/22.
 */
@WebServlet(name="servlet01", urlPatterns="/servlet_01", initParams={@WebInitParam(name="servlet1", value="servlet01")})
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
                classType = Class.forName("com.cd.test.operation.mytest.service.TestService");
            } else if ("pollingService".equals(String.valueOf(params.get("service")))) {
                classType = Class.forName("com.cd.test.project.operation.service.PollingService.PollingService");
            }
//            Object obj = classType.newInstance();\

            String service = String.valueOf(params.get("service"));
            Object obj = SpringContextUtil.getBean(service);
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
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    protected Map getParamsFromRequest(HttpServletRequest request) {
        Map map = new HashMap();
        for (Enumeration enu = request.getParameterNames(); enu.hasMoreElements(); ) {
            String key = enu.nextElement().toString();
            String val = request.getParameter(key);
            map.put(key, val);
        }
        logger.info("request.params: " + map);
        return map;
    }

}

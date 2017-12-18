package com.cd.test.project.operation.servlet;

import com.cd.test.project.common.SpringContextUtil;
import com.cd.test.project.common.StringUtil;
import com.cd.test.test.RedisPubSub.Subscriber;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Administrator on 2017/12/15.
 */
@Log4j2
public class SubscribeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        ((ArrayBlockingQueue)session.getAttribute("arrayBlockingQueue")).add("xxx");

        log.info("timesTopic: ---> " + session.getAttribute("timesTopic"));
        try {
            response.getWriter().write("null");
        } catch (IOException e) {
            log.error("doPost: " + e.getMessage(), e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        this.doPost(request, response);
    }

}

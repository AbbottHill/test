package com.cd.test.project.operation.controllers;

import com.alibaba.fastjson.JSON;
import com.cd.test.project.bean.User;
import com.cd.test.project.common.SpringContextUtil;
import com.cd.test.test.RedisPubSub.Subscriber;
import com.cd.test.test.TestWebsocket;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/11/25.
 */
@Controller
@RequestMapping("/mvc")
public class TestController {

    @RequestMapping("/hello")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
//        model.addAttribute("name", name);
        User user = new User();
        user.setName("super man");
        model.addAttribute("name", user.getName());
        return "hello";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest req) {
        MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
        MultipartFile file = mreq.getFile("file");
        String fileName = file.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String str = req.getSession().getServletContext().getRealPath("/");
        try (FileOutputStream fos = new FileOutputStream(str + sdf.format(new Date()) + fileName.substring(fileName.lastIndexOf('.')))) {
            fos.write(file.getBytes());
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "hello";
    }


    @RequestMapping("/setTopic/{topic}")
    @ResponseBody
    public String setTopic(HttpSession session, @PathVariable("topic") String topic) {
        System.out.println("topic=" + topic);
        session.setAttribute("topic", topic);

//        if (null == session.getAttribute("executorService")) {
//            ExecutorService executorService = Executors.newFixedThreadPool(2);
//            session.setAttribute("executorService", executorService);
//        }


//        if (null == session.getAttribute("subscriberFlag")) {
//            ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(3);
////            arrayBlockingQueue = TestWebsocket.arrayBlockingQueue;
//
//            session.setAttribute("subscriberFlag", "111");
//            session.setAttribute("arrayBlockingQueue", arrayBlockingQueue);
//            Subscriber subscriber = new Subscriber(arrayBlockingQueue);
//            Thread t1 = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    arrayBlockingQueue.add("xxx");
//                    JedisConnectionFactory jedisConnectionFactory = (JedisConnectionFactory) SpringContextUtil.getBean("connectionFactory");
//                    System.out.println(String.format("redis pool is starting, redis ip %s, redis port %d", jedisConnectionFactory.getHostName(), jedisConnectionFactory.getPort()));
//                    Jedis jedis = (Jedis) jedisConnectionFactory.getConnection().getNativeConnection();
//                    jedis.subscribe(subscriber, topic);
//                }
//            });
//            t1.start();
////            executorService.execute(t1);
//        }

        System.out.println(session.getAttribute("topic"));
        return "success";
    }

    @RequestMapping("/subscriberFlag")
    @ResponseBody
    public String setSubscriberFlag(HttpSession session) {
        session.setAttribute("subscriberFlag", "1");
        return "success";
    }

    @RequestMapping("/queryJson")
    @ResponseBody
    public String queryJson(HttpServletRequest request) {
//        Map resultMap = new HashMap(3);
//        resultMap.put("size", 1);
//        resultMap.put("value", 2);
//        return JSON.toJSONString(resultMap);
//        return JSON.toJSONString(resultMap.toString());


        List list = new ArrayList();
        Map map = new HashMap();
        map.put("a", "a01");
        list.add(map);
//        return JSON.toJSONString(list);
//        return JSON.toJSONString(list.toString());

        String str = "[{a: \"a01\"}]";
//        return JSON.toJSONString(str);
        return JSON.toJSONString(JSON.parseArray(str));
    }
}

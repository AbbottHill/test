package com.cd.test.operation.mytest.controller;

import com.alibaba.fastjson.JSON;
import com.cd.test.base.BaseController;
import com.cd.test.maintain.User.model.UserInfo;
import com.cd.test.utils.LoggerProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/11/25.
 */
@Controller
@RequestMapping("/mvc")
public class  TestController extends BaseController{
    @Autowired
    LoggerProxy logProxy;

    @RequestMapping("/hello")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
//        model.addAttribute("name", name);
        UserInfo user = new UserInfo();
        user.setName("super man");
        model.addAttribute("name", user.getName());
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        return "mytest/hello";
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
        return "mytest/hello";
    }


    @RequestMapping("/setTopic/{topic}")
    @ResponseBody
    public String setTopic(HttpSession session, @PathVariable("topic") String topic) {
        System.out.println("topic=" + topic);
        session.setAttribute("topic", topic);
        System.out.println(session.getAttribute("topic"));
        return "success";
    }

    @RequestMapping("/queryJson")
    @ResponseBody
    public String queryJson(HttpServletRequest request) {
        System.out.println("asyncTest. " + Thread.currentThread().getName());

//        logProxy.asyncTest();
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("a", "a01");
        list.add(map);
        String str = "[{a: \"a01\"}]";
        return JSON.toJSONString(JSON.parseArray(str));
    }


}

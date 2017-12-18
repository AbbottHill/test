package com.cd.test.project.operation.controllers;

import com.cd.test.project.common.SpringContextUtil;
import com.cd.test.project.operation.websocket.MyHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/12/14.
 */
@Controller
public class SocketController {

    //    @Autowired(required=true)
//    private MyHandler myHandler;
    private MyHandler myHandler = (MyHandler) SpringContextUtil.getBean("myHandler");

    @RequestMapping("/login/{userId}")
    @ResponseBody
    public String login(HttpSession session, @PathVariable("userId") String userId) {
        System.out.println("登录接口,userId=" + userId);
        session.setAttribute("userId", userId);
        System.out.println(session.getAttribute("userId"));
        return "success";
    }

    @RequestMapping("/message")
    @ResponseBody
    public String sendMessage(HttpSession session) {
        System.out.println("timesTopic: ---> " + session.getAttribute("timesTopic"));
        System.out.println("timesTopic: " + session.getAttribute("timesTopic"));

        boolean hasSend = myHandler.sendMessageToUser(4, new TextMessage("userId: " + session.getAttribute("userId")));
        System.out.println(hasSend);
        return "message";
    }

}

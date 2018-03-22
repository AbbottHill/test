package com.cd.test.maintain.User.controller;

import com.cd.test.maintain.User.service.UserService;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/queryUser")
    @ResponseBody
    public List queryUser() {
        Map params = new HashMap();
//        return userService.queryUser(params);
        return null;
    }
}
    
package com.cd.test.maintain.User.controller;

import com.cd.test.base.BaseController;
import com.cd.test.maintain.User.service.UserService;
import com.cd.test.utils.CheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    UserService userService;

    @RequestMapping("/queryUser")
    @ResponseBody
    public List queryUser() {
        Map params = new HashMap();
//        return userService.queryUser(params);
        return null;
    }

    @RequestMapping("/login")
    @ResponseBody
    public Map login(HttpServletRequest request, HttpSession session) {
        Map params = this.requestParameters(request);
        Map result = new HashMap(3);
        int loginStatus = 0;
        // 登录状态 0:参数错误，1成功，2密码错误，3，4无用户
        if (CheckUtils.CheckParams(params, "user_account", "user_pwd")) {
            List list = userService.queryUser(params);
            if (list.size() == 1) {
                Map tempMap = (Map) list.get(0);
                if (Objects.equals(params.get("user_pwd"), tempMap.get("user_password"))) {
                    loginStatus = 1;
                    session.setAttribute("user_account", tempMap.get("user_account"));
                    session.setAttribute("user_name", tempMap.get("user_name"));
                    result.put("user_name", tempMap.get("user_name"));
                } else {
                    loginStatus = 2;
                }
            } else {
                loginStatus = 4;
            }
        }
        result.put("login_status", loginStatus);
        return result;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Map logout(HttpSession session) {
        Map result = new HashMap(3);
        session.invalidate();
        return result;
    }
}
    
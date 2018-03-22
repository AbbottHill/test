package com.cd.test.UserTest;

import com.cd.test.base.RootConfig;
import com.cd.test.maintain.User.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class})
public class UserControllerTest {

    @Autowired
    UserService userService;

    @Autowired
    SqlSessionFactoryBean sqlSessionFactoryBean;

    @Test
    public void testQuery() {
//        System.out.println(sqlSessionFactoryBean);
        Map params = new HashMap();
        params.put("id", 10000);
        List list = userService.queryUser(params);
        System.out.println(list);
    }
}
    
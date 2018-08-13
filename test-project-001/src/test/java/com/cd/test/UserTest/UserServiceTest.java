package com.cd.test.UserTest;

import com.cd.test.config.RootConfig;
import com.cd.test.maintain.User.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mortbay.util.ajax.JSON;
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
@Log4j2
public class UserServiceTest {
    static {
    }

    @Autowired
    UserService userService;

    @Autowired
    SqlSessionFactoryBean sqlSessionFactoryBean;

    @Test
    public void testQuery() {
//        LogFactory.useLog4J2Logging();
//        System.out.println(sqlSessionFactoryBean);
        Map params = new HashMap();
//        params.put("id", 10000);
//        params.put("user_account", "root");
        List list = userService.queryUser(params);
        log.info(JSON.toString(list));
    }
}
    
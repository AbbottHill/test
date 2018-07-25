package com.cd.test.spring;

import com.cd.test.config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class})
public class TestAsync {
    @Autowired
    private TestAsyncBean testAsyncBean;
    @Test
    public void test_sayHello1() throws InterruptedException, ExecutionException {
        Future<String> future = null;
        System.out.println("你不爱我了么?");
        future = testAsyncBean.sayHello1();
        System.out.println("你竟无话可说, 我们分手吧。。。");
//        Thread.sleep(3 * 1000);// 不让主进程过早结束
        System.out.println(future.get());
    }
}

@Component
class TestAsyncBean {
    @Async
    public Future<String> sayHello1() throws InterruptedException {
        int thinking = 2;
        Thread.sleep(thinking * 1000);//网络连接中 。。。消息发送中。。。
        System.out.print("我爱你啊!");
        return new AsyncResult<String>("（发送消息用了"+thinking+"秒）");
    }
}
    
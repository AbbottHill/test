package com.cd.test.project.operation.service.PollingService;

import com.cd.test.project.common.MsgSubscribeThread;
import com.cd.test.project.common.SpringContextUtil;
import com.cd.test.test.RedisPubSub.Subscriber;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/13.
 */
public class PollingService {
    public static int times;

    public Map getTimes(Map map) {
        Map result = new HashMap();
        result.put("times", times ++);
        return result;
    }
}

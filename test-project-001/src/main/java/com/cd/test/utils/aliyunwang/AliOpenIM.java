package com.cd.test.utils.aliyunwang;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.OpenimUsersAddRequest;
import com.taobao.api.response.OpenimUsersAddResponse;

public class AliOpenIM {

    public static void userAdd() throws ApiException {
//        String httpUrl = "http://gw.api.taobao.com/router/rest";
        String httpsUrl = "https://eco.taobao.com/router/rest";
        String appkey = "24863283";
        String secret = "545679d56c5dc82f2e8efe8401705dcb";
        TaobaoClient client = new DefaultTaobaoClient(httpsUrl, appkey, secret);
        OpenimUsersAddRequest req = new OpenimUsersAddRequest();
//        req.setUserinfos("{'userid': 'demo', 'password': 'demo1234'}");
//        req.setUserinfos("{'userid': 'demo01', 'password': 'demo0101'}");
        req.setUserinfos("{'userid': 'demo02', 'password': 'demo0202'}");
        OpenimUsersAddResponse response = client.execute(req);
        System.out.println("response: " + response);

        System.out.println("response.getFailMsg: " + response.getFailMsg());
        System.out.println("response.getUidSucc: " + response.getUidSucc());
        System.out.println("response.getBody: " + response.getBody());
        System.out.println("response.getErrorCode: " + response.getErrorCode());
    }

    public static void main(String[] args) {
        try {
            userAdd();
        } catch (ApiException e) {

        }
    }

}
    
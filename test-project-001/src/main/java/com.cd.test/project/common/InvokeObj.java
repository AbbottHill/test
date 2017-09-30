package com.cd.test.project.common;

import java.util.Map;

/**
 * Created by Administrator on 2017/9/23.
 */
public class InvokeObj {
    private String service;

    private String method;

    private Map params;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }
}

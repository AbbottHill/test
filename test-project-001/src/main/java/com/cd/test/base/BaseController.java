package com.cd.test.base;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@Controller
public class BaseController {

    protected Map requestParameters(HttpServletRequest request) {
        Map params = new HashMap();
        for (Enumeration enu = request.getParameterNames(); enu.hasMoreElements(); ) {
            String key = enu.nextElement().toString();
            String val = request.getParameter(key);
            params.put(key, val);
        }
        log.info("request params: " + params);
        return params;
    }
}
    
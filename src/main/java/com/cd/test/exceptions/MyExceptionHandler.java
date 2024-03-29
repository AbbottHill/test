package com.cd.test.exceptions;

import com.cd.test.utils.LoggerProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component("exceptionHandler") //TODO
public class MyExceptionHandler implements HandlerExceptionResolver {
    @Autowired
    LoggerProxy loggerProxy;

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        loggerProxy.error(ex);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("ex", ex);

        // 根据不同错误转向不同页面
        if(ex instanceof BusinessException) {
            return new ModelAndView("error-business", model);
        }else if(ex instanceof ParameterException) {
            return new ModelAndView("error-parameter", model);
        } else {
            return new ModelAndView("error", model);
        }
    }
}
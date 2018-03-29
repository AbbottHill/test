package com.cd.test.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@ControllerAdvice
public class MyExceptionController {

//    @ExceptionHandler
    public void myExceptionHandler(HttpServletRequest request, HttpServletResponse response) throws Exception{
//        return "/static/html/404/index.html";
        response.sendRedirect(request.getContextPath() + "/static/html/404/index.html");
    }

}
    
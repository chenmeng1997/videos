package com.qf.utils;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object userName = request.getSession().getAttribute("userName");
        Object userAccount = request.getSession().getAttribute("userAccount");

        if(userName != null || userAccount != null){
            return true;
        }else{
            response.sendRedirect("index");
            return false;
        }
    }


}

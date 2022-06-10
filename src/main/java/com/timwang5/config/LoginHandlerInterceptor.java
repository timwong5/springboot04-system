package com.timwang5.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实现登录拦截器
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginSession = request.getSession().getAttribute("loginUser");
        if (loginSession == null){
            request.setAttribute("msg", "权限不够,请先登录");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }
        else return true;
    }
}

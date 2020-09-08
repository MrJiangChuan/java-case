package com.jc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截入口");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        //解决post提交中文乱码问题
        httpServletRequest.setCharacterEncoding("utf-8");
//        //过滤姓名为fuck的字段
//        if("fuck".equals(httpServletRequest.getParameter("name"))){
//            httpServletResponse.sendRedirect("a.html");
//        }else {
//            //放行
//            filterChain.doFilter(httpServletRequest,httpServletResponse);
//            System.out.println("拦截出口");
//        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
        System.out.println("拦截出口");
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy...");
    }
}

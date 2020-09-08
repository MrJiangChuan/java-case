package com.jc.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebServlet(urlPatterns="/demo1",loadOnStartup=-1)
public class ServletDemo1 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init........");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig.....");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        System.out.println("service......."+req.getContextPath());
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo.....");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy.....");
    }
}

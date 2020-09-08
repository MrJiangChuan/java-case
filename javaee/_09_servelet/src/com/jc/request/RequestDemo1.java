package com.jc.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

/*
    演示获取请求信息
 */
@WebServlet("/demo3")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求行
//        getRequestLine(req);
        //2.获取请求头
//        getHeader(req, resp);
        //3.根据user-agent内容判断浏览器类型
//        getUserAgent(req);
        //4.防止盗链
//        ProtectRefer(req);
        //5.获取请求体
        BufferedReader reader = req.getReader();
        String buf;
        while ((buf=reader.readLine())!=null){
            System.out.println(buf);
        }
    }

    private void ProtectRefer(HttpServletRequest req) {
        String referer = req.getHeader("referer");
        if (referer != null && !"".equals(referer)) {
            if(referer.contains("_09_servelet")){
                System.out.println("欢迎光临....."+referer);
            }else {
                System.out.println("滚蛋....."+referer);
            }
        }
    }

    private void getUserAgent(HttpServletRequest req) {
        String usergent = req.getHeader("user-agent");
        if (usergent != null && !"".equals(usergent)) {
            if (usergent.contains("Chrome")) {
                System.out.println("谷歌浏览器....");
            } else if (usergent.contains("Firefox")) {
                System.out.println("火狐浏览器...");
            }

        }
    }

    private void getHeader(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=utf-8");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            String header = req.getHeader(s);
            resp.getWriter().write(s + ": " + header + "<br>");
        }
    }

    private void getRequestLine(HttpServletRequest req) {
        //1.获取请求方法
        String method = req.getMethod();
        System.out.println(method);
        //2.获取请求虚拟路径（项目路径）
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        //3.获取请求资源路径
        String servletPath = req.getServletPath();
        System.out.println(servletPath);
        //4.请求参数
        String queryString = req.getQueryString();
        System.out.println(queryString);
        //5.获取请求URI/URL
        String requestURI = req.getRequestURI();
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURI);
        System.out.println(requestURL);
        //6.获取请求http版本
        String protocol = req.getProtocol();
        System.out.println(protocol);
        //7.获取请求ip地址
        String remoteAddr = req.getRemoteAddr();
        String remoteUser = req.getRemoteUser();
        String remoteHost = req.getRemoteHost();
        int remotePort = req.getRemotePort();
        System.out.println(remoteAddr);
        System.out.println(remoteUser);
        System.out.println(remoteHost + ":" + remotePort);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

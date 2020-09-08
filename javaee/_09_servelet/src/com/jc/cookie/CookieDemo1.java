package com.jc.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieDemo1")
public class CookieDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("name","Tom");
        Cookie cookie1 = new Cookie("passwword", "fds22wfswsd");
        cookie.setMaxAge(60);
        cookie1.setMaxAge(60);
//        cookie.setPath("/");//tomcat下的所有项目间共享
//        cookie.setDomain(".baidu.com");//所有子域名间共享
        response.addCookie(cookie);
        response.addCookie(cookie1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

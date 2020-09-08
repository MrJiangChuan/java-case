package com.jc.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 案例：获取上一次访问时间
 * 注：cookie中不能含有空格，如果有需要ULR编解码
 */
@WebServlet("/cookieDemo3")
public class CookieDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        //设置一个标记位
//        boolean flag = false;
        //1.获取cookie中的localtime
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("localtime".equals(name)) {
//                    flag = true;
                    //获取上一次访问的时间
                    String value = URLDecoder.decode(cookie.getValue(),"utf-8");
                    //重新设置cookie为当前时间
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年-MM月-dd日 HH：mm:ss");
                    String format = simpleDateFormat.format(date);
                    cookie.setValue(URLEncoder.encode(format,"utf-8"));
                    cookie.setMaxAge(30);
                    response.addCookie(cookie);
                    //展示本次访问的内容
                    response.getWriter().write("<h1>欢迎您再次访问，上一次访问时间为:" + value + "</h1>");
//                    break;
                    return;
                }
            }
        }
        //首次访问
//        if(!flag){
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年-MM月-dd日 HH：mm:ss");
            String format = simpleDateFormat.format(date);
            Cookie localtime = new Cookie("localtime", URLEncoder.encode(format,"utf-8"));
            localtime.setMaxAge(30);
            response.addCookie(localtime);
            response.getWriter().write("<h1>欢迎您首次访问</h1>");
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

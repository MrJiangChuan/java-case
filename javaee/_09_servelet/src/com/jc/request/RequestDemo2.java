package com.jc.request;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * request的其它功能获取
 */
@WebServlet("/demo4")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
//        getParameter(req);
        //2.请求转发
//        dispatch(req, resp);
        //3.request域对象
//        requetDomain(req, resp);
        //4.ServletContext
//        getServletContext1(req);

    }

    private void getServletContext1(HttpServletRequest req) {
        ServletContext servletContext = req.getServletContext();
        System.out.println(servletContext);
    }

    private void requetDomain(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("tag1","Hello");
        req.getRequestDispatcher("/demo5").forward(req,resp);
    }

    private void dispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/demo5").forward(req,resp);
        System.out.println("demo4被访问了....");
        resp.getWriter().write("demo4....");
    }

    private void getParameter(HttpServletRequest req) throws UnsupportedEncodingException {
        //解决post提交中文乱码问题
        req.setCharacterEncoding("utf-8");

        System.out.println("=========getParameter===========");
        String username = req.getParameter("username");
        System.out.println("username: "+username);
        System.out.println("=========getParameterValues===========");
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby: hobbies) {
            System.out.println(hobby);
        }
        System.out.println("=========getParameterNames==========");
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            String parameter = req.getParameter(name);
            System.out.println(name+"---"+parameter);
        }
        System.out.println("=======getParameterMap============");
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> item: entries) {
            String key = item.getKey();
            String[] value = item.getValue();
            System.out.println(key);
            for (String ite:value) {
                System.out.println(ite);
            }
            System.out.println("-------------");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}

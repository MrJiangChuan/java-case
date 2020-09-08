package com.jc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    /**
     * 增加用户
     * @param request
     * @param response
     */
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("add....");
    }

    /**
     * 查找用户
     * @param request
     * @param response
     */
    public void find(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("find....");
    }
}

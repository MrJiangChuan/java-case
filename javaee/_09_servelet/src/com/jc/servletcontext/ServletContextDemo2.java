package com.jc.servletcontext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取MIME类型
        String jpg = getServletContext().getMimeType("a.jpg");
        String avi = getServletContext().getMimeType("a.avi");
        String pdf = getServletContext().getMimeType("a.pdf");
        String mp3 = getServletContext().getMimeType("a.mp3");
        System.out.println(jpg);
        System.out.println(avi);
        System.out.println(pdf);
        System.out.println(mp3);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}

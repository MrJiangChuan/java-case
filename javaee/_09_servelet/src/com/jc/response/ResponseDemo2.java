package com.jc.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

@WebServlet("/respout")
public class ResponseDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.输出字符流
//        resp.setContentType("text/html; charset=utf-8");
//        resp.getWriter().write("你好");

        //2.输入字节流
        boolean id = false;
        Random random = new Random();
        if (random.nextInt(10) >= 5) {
            id = true;
        }
        System.out.println(id);
        InputStream rs = ResponseDemo2.class.getClassLoader().getResourceAsStream(id ? "head.jpg" : "head2.jpg");
        ServletOutputStream os = resp.getOutputStream();
        int len;
        byte[] buf = new byte[1024];
        while ((len = rs.read(buf)) != -1) {
            os.write(buf, 0, len);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

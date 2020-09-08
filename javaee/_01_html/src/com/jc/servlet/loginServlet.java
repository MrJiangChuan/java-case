package com.jc.servlet;

import com.jc.entity.User;
import com.jc.service.UserService;
import com.jc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class loginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
//        req.setCharacterEncoding("utf-8");//解决post提交中文乱码问题
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        //2.保存待转发的数据
//        req.setAttribute("username",name);
//        req.setAttribute("password",password);
//        List<String> list = new ArrayList<>();
//        list.add("aa");
//        list.add("bb");
//        list.add("cc");
//        list.add("ee");
//        list.add("ff");
//        req.setAttribute("list",list);
        //3.业务逻辑处理
        if(userService.userContains(new User(null, name, password))){
            req.getSession().setAttribute("user",name);
            resp.addCookie(new Cookie("username",name));
            resp.sendRedirect("home.jsp");
        }else {
            //4.转发请求到jsp页面
            req.setAttribute("login_msg","登录失败");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
//        resp.setContentType("text/html;charset=utf-8");
//        resp.getWriter().println(name+"登录成功");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }


}

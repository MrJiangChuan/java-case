package com.jc.usercase.web.servlet;

import com.jc.usercase.entity.PageBreak;
import com.jc.usercase.entity.User;
import com.jc.usercase.service.UserService;
import com.jc.usercase.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 展示用户信息列表(分页)
 */
@WebServlet("/listServlet")
public class ListServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //访问权限控制(未登录不能访问)
        if (request.getSession().getAttribute("userInfo") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }
        //1.获取请求参数
        String _currentPage = request.getParameter("currentPage");
        String _itemPerPage = request.getParameter("itemPerPage");
        if (_currentPage == null || "".equals(_currentPage.trim())) _currentPage = "1";
        if (_itemPerPage == null || "".equals(_itemPerPage.trim())) _itemPerPage = "5";
        int currentPage = Integer.parseInt(_currentPage);
        int itemPerPage = Integer.parseInt(_itemPerPage);
        //1.查询数据库，获取所有用户信息
//        List<User> allUsers = userService.findAllusers();
        PageBreak<User> pageUsers =  userService.findPageUsers(currentPage,itemPerPage);
//        System.out.println(pageUsers);
        //2.转发数据到list.jsp页面
        request.setAttribute("pageUsers", pageUsers);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

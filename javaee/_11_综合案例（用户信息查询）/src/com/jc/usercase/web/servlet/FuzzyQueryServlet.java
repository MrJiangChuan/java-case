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
 * 模糊查询用户信息（带分页）
 */
@WebServlet("/fuzzyQueryServlet")
public class FuzzyQueryServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //访问权限控制
        if (request.getSession().getAttribute("userInfo") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取请求参数
        String realName = request.getParameter("realName");
        String address = request.getParameter("address");
        String email = request.getParameter("email");

        String _currentPage = request.getParameter("currentPage");
        String _itemPerPage = request.getParameter("itemPerPage");
        if (_currentPage == null || "".equals(_currentPage.trim())) _currentPage = "1";
        if (_itemPerPage == null || "".equals(_itemPerPage.trim())) _itemPerPage = "5";
        int currentPage = Integer.parseInt(_currentPage);
        int itemPerPage = Integer.parseInt(_itemPerPage);
        //3.模糊查询数据库
        PageBreak<User> fuzzyUsers =  userService.fuzzyPageQueryUsers(realName,address,email,currentPage,itemPerPage);
        //4.将数据转发到list页中
//        System.out.println(fuzzyUsers);
        request.setAttribute("fuzzyUsers",fuzzyUsers);
        request.setAttribute("realName",realName);
        request.setAttribute("address",address);
        request.setAttribute("email",email);
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

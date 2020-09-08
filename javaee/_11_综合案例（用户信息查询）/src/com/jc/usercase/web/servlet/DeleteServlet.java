package com.jc.usercase.web.servlet;

import com.jc.usercase.service.UserService;
import com.jc.usercase.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 删除指定id用户
 */
@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //访问权限控制
        if (request.getSession().getAttribute("userInfo") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }
        //对于有些页面，应该设置禁止直接访问，必须来源内部链接跳转
        String referer = request.getHeader("referer");
        if (referer == null || "".equals(referer) || !referer.contains(request.getContextPath())) {
            response.sendRedirect(request.getContextPath() + "/fuzzyQueryServlet");
            return;
        }
        //1.获取请求参数
        String id = request.getParameter("id");
        //2.删除数据
        userService.delUserbyId(Integer.parseInt(id));
        //3.跳转都list页
        response.sendRedirect(request.getContextPath() + "/fuzzyQueryServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

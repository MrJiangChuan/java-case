package com.jc.usercase.web.servlet;

import com.jc.usercase.entity.User;
import com.jc.usercase.service.UserService;
import com.jc.usercase.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 修改用户信息
 */
@WebServlet("/updateUserServlet")
public class UpdateServlet extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        //1.获取请求参数，并封装参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //2.修改数据库中数据
        userService.updateUser(user);
        //3.跳到list页
        response.sendRedirect(request.getContextPath()+"/fuzzyQueryServlet");





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

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
 * 增加用户
 */
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

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
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (parameterMap == null) {
            response.sendRedirect(request.getContextPath() + "/add.jsp");
            return;
        }
        //3.封装请求参数
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.插入数据到数据库
        int r = userService.insertUser(user);
        if (r > 0){
            //5.跳转到list页中
            response.sendRedirect(request.getContextPath() + "/fuzzyQueryServlet");
        }else{
            //添加失败，转发到add.jsp中
            request.setAttribute("add_error","添加数据失败");
            request.getRequestDispatcher("/add.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

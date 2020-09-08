package com.jc.usercase.web.servlet;

import com.jc.usercase.service.UserService;
import com.jc.usercase.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * 批量删除用户信息
 */
@WebServlet("/deleteBatchServlet")
public class DeleteBatchServlet extends HttpServlet {

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
        String[] _ids = request.getParameterValues("id");
        if (_ids == null || _ids.length == 0) {
            //跳转到list页
            response.sendRedirect(request.getContextPath() + "/fuzzyQueryServlet");
            return;
        }
        //字符串参数转成数字类型
        int[] ids = new int[_ids.length];
        for (int i = 0; i < _ids.length; i++) {
            ids[i] = Integer.parseInt(_ids[i]);
        }
//        System.out.println(Arrays.toString(ids));
        //2.批量删除数据库中用户
        userService.delUserbyIds(ids);
        //3.跳转到list页
        response.sendRedirect(request.getContextPath() + "/fuzzyQueryServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

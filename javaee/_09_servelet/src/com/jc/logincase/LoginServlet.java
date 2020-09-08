package com.jc.logincase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        //3.判断用户信息是否正确
        HttpSession session = request.getSession();
        Object checkCodeImage = session.getAttribute("checkCode");
        if (checkCodeImage != null) {
            String checkCodeImageStr = (String) checkCodeImage;
            session.removeAttribute("checkCode");
            if (checkCodeImageStr.equalsIgnoreCase(checkCode)) {
                if ("Tom".equals(username) && "123abc".equals(password)) {
                    //跳转到成功页面
                    session.setAttribute("user","Tom");
                    response.sendRedirect(request.getContextPath() + "/home.jsp");
                } else {
                    //用户名或密码错误
                    request.setAttribute("user_erro", "用户名或密码错误");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            } else {
                //验证码不正确
                request.setAttribute("code_erro", "验证码不正确");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            //验证码不正确
            request.setAttribute("code_erro", "验证码不正确");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

package com.jc.usercase.web.servlet;

import com.jc.usercase.entity.Manager;
import com.jc.usercase.service.UserService;
import com.jc.usercase.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 登录
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //1.访问权限控制
        //1.1已登录直接跳到首页
        HttpSession session = request.getSession();
        if (session.getAttribute("userInfo") != null) {
//            System.out.println("跳到首页");
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }
        //1.2对于有些页面，应该设置禁止直接访问，必须来源内部链接跳转
        String referer = request.getHeader("referer");
        if (referer == null || "".equals(referer) || !referer.contains(request.getContextPath())) {
            //登录，跳到登录页
//            System.out.println("跳到登录页");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }
        //2.解决post乱码问题
        request.setCharacterEncoding("utf-8");
        //3.获取请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        String verifycode = parameterMap.get("verifycode")[0];

        //4.判断验证码是否正确
        Object checkcode_server = session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证码只能使用一次
        if (checkcode_server == null || !((String) checkcode_server).equals(verifycode)) {
            //验证码错误
            request.setAttribute("login_error", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        //5.判断用户名和密码是否有误
        Manager user = new Manager();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        Manager loginUser = userService.findUser(user);
        if (loginUser == null) {
            //用户名或密码有误
            request.setAttribute("login_error", "用户名或密码有误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        //6.验证通过跳转到首页，并保存用户登录状态
        session.setAttribute("userInfo",loginUser);
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

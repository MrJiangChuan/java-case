package com.jc.controller;

import com.jc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/response")
public class ResponseController {

    @RequestMapping("/responseTest1")
    public String responseTest1(){

        return "success";
    }

    @RequestMapping("/responseTest2")
    public void responseTest2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write("天天向上");
    }

    @RequestMapping("/responseTest3")
    public void responseTest3(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath()+"/home.jsp");
    }

    @RequestMapping("/responseTest4")
    public void responseTest4(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/success.jsp").forward(request,response);
    }

    @RequestMapping("/responseTest5")
    public String responseTest5() {
        return "forward:/home.jsp";
    }

    @RequestMapping("/responseTest6")
    public String responseTest6() {
        return "redirect:/success.jsp";
    }

    @RequestMapping("/responseTest7")
    public ModelAndView responseTest7() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user","Tom");
        modelAndView.setViewName("mv");
        return modelAndView;
    }

    @RequestMapping("/responseTest8")
    @ResponseBody
    public User responseTest8(String username, String password) {
        System.out.println(username+"---"+password);
        return new User("Jerry",25,"男",new Date());
    }
}

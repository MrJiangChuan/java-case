package com.jc.controller;


import com.jc.entity.User;
import com.jc.entity.User2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@Controller
@RequestMapping("/param")
@SessionAttributes("username")
public class ParamController {

    @RequestMapping("/paramTest1")
    public String paramTes1(String username, String password){
        System.out.println(username+"---"+password);
        return "success";
    }

    @RequestMapping("/paramTest2")
    public String paramTes2(String username, String password)  {
        System.out.println(username+"---"+password);
        return "success";
    }

    @RequestMapping("/paramTest3")
    public String paramTes3( User user)  {
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/paramTest4")
    public String paramTes4(HttpSession session)  {
        session.setAttribute("user","Tom");
        return "success";
    }

    @RequestMapping("/paramTest5")
    public String paramTes5(HttpSession session)  {
        System.out.println(session.getAttribute("user"));
        return "success";
    }

    @RequestMapping("/paramTest6")
    public String paramTes6(HttpSession session)  {
        session.invalidate();
        return "success";
    }

    @RequestMapping("/paramTest7")
    public String paramTes7(@RequestParam(name = "name",required = true) String username, @RequestParam(name="gg",required = true) Integer age){
        System.out.println(username+"---"+age);
        return "success";
    }

    @RequestMapping("/paramTest8")
    public String paramTes8(@RequestBody String user)  {
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/paramTest9/{id}")
    public String paramTes9(@PathVariable("id") Integer id)  {
        System.out.println(id);
        return "success";
    }

    @RequestMapping("/paramTest10")
    public String paramTes10(@RequestHeader("user-agent") String header)  {
        System.out.println(header);
        return "success";
    }

    @RequestMapping("/paramTest11")
    public String paramTes11(@CookieValue("JSESSIONID") String cookie)  {
        System.out.println(cookie);
        return "success";
    }

    @ModelAttribute
    public void paramTes12(User2 user2, Map<String,User2> map)  {
//        user2.setUsername("Tom");
        System.out.println("paramTes12");
        map.put("sd",new User2("tom","222"));
    }

    @RequestMapping("/paramTest13")
    public String paramTes13(@ModelAttribute("sd") User2 user2)  {
        System.out.println(user2);
        return "success";
    }

    @RequestMapping("/paramTest14")
    public String paramTes14(Model model)  {
        model.addAttribute("username","Tom");
        return "success";
    }

    @RequestMapping("/paramTest15")
    public String paramTes15(ModelMap model)  {
        System.out.println(model.get("username"));
        return "success";
    }

    @RequestMapping("/paramTest16")
    public String paramTes16(SessionStatus sessionStatus)  {
        sessionStatus.setComplete();
        return "success";
    }

}

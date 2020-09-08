package com.jc.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sessionDemo1")
public class SessionDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object value = null;
        if ((value=session.getAttribute("name")) != null) {
            System.out.println(value);
        }else {
            Cookie jsessionid = new Cookie("JSESSIONID", session.getId());
            jsessionid.setMaxAge(60);
            session.setAttribute("name", "Tom");
            response.addCookie(jsessionid);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

<%--
  Created by IntelliJ IDEA.
  User: 10735
  Date: 2020/8/22
  Time: 6:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <style>
        #span1{
            color: red;
            font-size: 50px;
            font-family: 微软雅黑;
        }
    </style>
    <script>
        window.onload=function () {
            var el = document.getElementById("span1");
            el.onmouseup=function () {
                el.style.color='blue'
<%--                <jsp:forward page="a.html"></jsp:forward>--%>
            }
            el.onmouseover=function () {
                el.style.color='green'
            }
        }
    </script>
</head>
<body>
    <% if(session.getAttribute("user")!=null){
        %>
        <h1><%=session.getAttribute("user")%>登录成功！Cookie:<% Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if("username".equals(cookie.getName())){%>
                <%=cookie.getValue()%>
            <%
                }
            }

        %></h1>
    <%
    }else {
        response.sendRedirect("index.jsp");
    }%>
    <spn id="span1">百度</spn>
</body>
</html>

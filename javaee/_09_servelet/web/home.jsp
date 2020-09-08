<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    <%
        Object userInfo = request.getSession().getAttribute("user");
        if(userInfo==null) {
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return;
        }
        String userInfoStr = (String) userInfo;
        out.print("<h1>"+userInfoStr+"登录成功！</h1>");
    %>
<input id="btn_logout" type="button" value="退出">
<script>
    document.getElementById("btn_logout").onclick=function () {
        location.href="<%=request.getContextPath()%>/logoutServlet"
    }
</script>
</body>
</html>

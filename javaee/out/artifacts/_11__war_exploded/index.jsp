<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //访问权限控制(未登录不能访问)
    if (request.getSession().getAttribute("userInfo") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }

%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>首页</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body>
<div align="center">
    <a
            href="${pageContext.request.contextPath}/fuzzyQueryServlet" style="text-decoration:none;font-size:33px">查询所有用户信息
    </a>
</div>
<div style="float: right;margin-right: 60px;font-size: 18px">
    <span style="margin-right: 15px">欢迎,&nbsp;${userInfo.username}管理员</span>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/logoutServlet" >退出登录</a>
</div>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: 10735
  Date: 2020/8/27
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>提交个人信息</title>
    <!--导入bootstrap框架-->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<form action="demo4" method="post">
    用户名：<input type="text" placeholder="用户名" name="username"><br>
    密码：<input type="password" placeholder="密码" name="password"><br>
    性别：<input type="radio" name="gender" value="male">男
    <input type="radio" name="gender" value="female">女<br>
    爱好：<input type="checkbox" name="hobby" value="book">看书
    <input type="checkbox" name="hobby" value="sleep">睡觉<br>
    <input type="submit" value="提交">
    <input type="reset" value="清空">
</form>
</body>
</html>

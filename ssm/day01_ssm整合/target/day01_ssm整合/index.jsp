<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<h3>查询账户</h3>
<a href="${pageContext.request.contextPath}/account/findAll">点击查询所有账户</a>
<h3>增加账户</h3>
<form action="${pageContext.request.contextPath}/account/insert" method="post">
    用户名<input type="text" name="name" /><br>
    金额<input type="number" name="money" /><br>
    <input type="submit" value="提交" />
</form>
<h3>更新账户</h3>
<form action="${pageContext.request.contextPath}/account/update" method="post">
    用户ID<input type="number" name="id" /><br>
    用户名<input type="text" name="name" /><br>
    金额<input type="number" name="money" /><br>
    <input type="submit" value="提交" />
</form>
<h3>删除账户</h3>
<form action="${pageContext.request.contextPath}/account/delete" method="post">
    用户ID<input type="number" name="id" /><br>
    <input type="submit" value="提交" />
</form>
</body>
</html>

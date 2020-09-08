<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/param/paramTest1?username=姜川&password=123asd">参数绑定</a>
<form action="${pageContext.request.contextPath}/param/paramTest2" method="post">
    用户名<br><input type="text" placeholder="请输入用户名" name="username"/><br>
    密码<br><input type="password" placeholder="请输入密码" name="password"/><br>
    <input type="submit" value="提交" />
</form>
<br>
<form action="${pageContext.request.contextPath}/param/paramTest3" method="post">
    用户名<input type="text" placeholder="请输入用户名" name="username"/><br>
    年龄<input type="number" placeholder="请输入年龄" name="age"/><br>
    生日<input type="date" name="birthday"/><br>
    编号1<input type="number" name="num[0]"/><br>
    编号2<input type="number" name="num[1]"/><br>
    编号3<input type="number" name="num[2]"/><br>
    兴趣1<input type="text" name="list[0]"/><br>
    兴趣2<input type="text" name="list[1]"/><br>
    兴趣3<input type="text" name="list[2]"/><br>
    键值对1<input type="number" name="map['one']"/><br>
    键值对2<input type="number" name="map['two']"/><br>
    <input type="submit" value="提交" />
</form>
<a href="${pageContext.request.contextPath}/param/paramTest4">添加session</a>
<a href="${pageContext.request.contextPath}/param/paramTest5">获取session</a>
<a href="${pageContext.request.contextPath}/param/paramTest6">清除session</a>
<br>
<a href="param/paramTest7?name=嗯嗯&gg=12">@RequestParam</a>
<br>
<form action="${pageContext.request.contextPath}/param/paramTest8" method="post">
    用户名<br><input type="text" placeholder="请输入用户名" name="username"/><br>
    密码<br><input type="password" placeholder="请输入密码" name="password"/><br>
    <input type="submit" value="提交" />
</form>
<br>
<a href="param/paramTest9/12">@PathVariable</a>
<a href="param/paramTest10">@RequestHeader</a>
<a href="param/paramTest11">@CookieValue</a>
<a href="param/paramTest13?username=aa&password=123">@ModelAttribute</a>
<br>
<a href="param/paramTest14">@SessionAttributes设置</a>
<a href="param/paramTest15">@SessionAttributes获取</a>
<a href="param/paramTest16">@SessionAttributes清除</a>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>
<form action='<%=request.getContextPath()%>/loginServlet' method="post">
    <table border="1px" align="left" width="300px">
        <tr >
            <td>用户名</td>
            <td><input type="text" placeholder="请输入用户名" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" placeholder="请输入密码" name="password"></td>
        </tr>
        <tr>
            <td>输入验证码</td>
            <td><input type="text" placeholder="请输入验证码" name="checkCode"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="img1" src='<%=request.getContextPath()%>/valideCodeServlet' width="100px" height="50px" ></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
            <td><input type="reset" value="清空"></td>
        </tr>
    </table>
</form>
<div><%=request.getAttribute("code_erro")==null?"":request.getAttribute("code_erro")%></div>
<div><%=request.getAttribute("user_erro")==null?"":request.getAttribute("user_erro")%></div>
<script>
    document.getElementById("img1").onclick=function () {
        this.src="<%=request.getContextPath()%>/valideCodeServlet?id="+new Date().getTime()
    }
</script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<h3>传统文件上传</h3>
<form action="${pageContext.request.contextPath}/file/upload1" method="post" enctype="multipart/form-data">
    <input type="file" name="upload"/><br>
    <input type="submit" value="上传"/>
</form>
<h3>springmvc方式文件上传</h3>
<form action="${pageContext.request.contextPath}/file/upload2" method="post" enctype="multipart/form-data">
    <input type="file" name="upload"/><br>
    <input type="submit" value="上传"/>
</form>
<h3>跨服务器文件上传传</h3>
<form action="${pageContext.request.contextPath}/file/upload3" method="post" enctype="multipart/form-data">
    <input type="file" name="upload"/><br>
    <input type="submit" value="上传"/>
</form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>500</title>
</head>
<body>
<h1>服务器正忙....</h1>
<%
    out.print(exception.getMessage());
%>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //  System.out.println("jsp执行");

//    System.out.println(request.getParameter("msg") == null ? "" : request.getParameter("msg"));
%>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
${pageContext.request.getParameter("msg")}
</body>
</html>

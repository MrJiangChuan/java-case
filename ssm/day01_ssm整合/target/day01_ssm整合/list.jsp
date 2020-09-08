<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>账户列表</title>
</head>
<body>
<h3>账户列表</h3>
<ul>
    <c:forEach items="${list}" var="item" varStatus="s">
        <li>
            ${item.id}-----${item.name}----${item.money}
        </li>
    </c:forEach>
</ul>
</body>
</html>

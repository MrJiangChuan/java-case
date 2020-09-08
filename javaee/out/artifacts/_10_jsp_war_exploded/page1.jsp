<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" errorPage="500.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@include file="hello.jsp"%>--%>
<html>
<head>
    <title>page1</title>
</head>
<body>
<%
    request.setAttribute("username", "3");
    List<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");
    request.setAttribute("list", list);
//    int i = 1 / 0;
%>
<c:if test="${'Tom'.equals(requestScope['username'])}">
    <h1>I'am Tom</h1>
</c:if>
<c:choose>
    <c:when test="${'1'.equals(requestScope['username'])}">
        <h1>1</h1>
    </c:when>
    <c:when test="${'2'.equals(requestScope['username'])}">
        <h1>2</h1>
    </c:when>
    <c:when test="${'3'.equals(requestScope['username'])}">
        <h1>3</h1>
    </c:when>
    <c:when test="${'4'.equals(requestScope['username'])}">
        <h1>4</h1>
    </c:when>
    <c:otherwise>
        <h1>5</h1>
    </c:otherwise>
</c:choose>
<ol>
    <c:forEach var="item" items="${list}">
        <li>${item}</li>
    </c:forEach>
</ol>
</body>
</html>

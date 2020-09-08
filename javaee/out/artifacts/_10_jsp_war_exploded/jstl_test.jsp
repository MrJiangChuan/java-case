<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL标签库练习</title>
</head>
<body>
<%
    request.setAttribute("flag",false);
    request.setAttribute("week",11);
    List<String> list = new ArrayList<>();
    list.add("ac");
    list.add("ffs");
    list.add("re3");
    list.add("gre3");
%>
<c:if test="${flag}">
<h3>true</h3>
</c:if>

<c:choose>
    <c:when test="${week==1}">
        <h3>星期一</h3>
    </c:when>
    <c:when test="${week==2}">
        <h3>星期二</h3>
    </c:when>
    <c:when test="${week==3}">
        <h3>星期三</h3>
    </c:when>
    <c:when test="${week==4}">
        <h3>星期四</h3>
    </c:when>
    <c:when test="${week==5}">
        <h3>星期五</h3>
    </c:when>
    <c:when test="${week==6}">
        <h3>星期六</h3>
    </c:when>
    <c:when test="${week==7}">
        <h3>星期七</h3>
    </c:when>
    <c:otherwise>
    <h3>输入有误</h3>
    </c:otherwise>
</c:choose>

<c:forEach var="i" begin="0" end="10" step="2" varStatus="s">
    <h3>${i}---${s.index}---${s.count}</h3>
</c:forEach>

<c:forEach var="item" items="${list}" varStatus="s">
    <h3>${s.index}--${s.count}---${item}</h3>
</c:forEach>
</body>
</html>

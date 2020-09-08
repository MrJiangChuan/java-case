<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: 10735
  Date: 2020/8/22
  Time: 5:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>登录</title>
</head>
<body>
<%--<%! String px = "600px";%>--%>
<%--<%String tmp = "blue";%>--%>
<div>
    <form method="post" action="login" >
        <input type="text" placeholder="请输入用户名" name="name" /><br/>
        <input type="password" placeholder="请输入密码" name="password" /><br/>
        <input type="submit" value="提交"/>
        <input type="reset" value="清空"/>
<%--        <input type="hidden"/>--%>
    </form>
    <span style="color: red"><%=request.getAttribute("login_msg")%></span>
<%--    <%=request.getServletContext().getAttribute("global")%>--%>
    ${applicationScope["global"]}
<%--    <%=request.getAttribute("username")==null?"":request.getAttribute("username")%>--%>
<%--    <%=request.getAttribute("password")==null?"":request.getAttribute("password")%>--%>
<%--    <ul>--%>
<%--        <% if(request.getAttribute("list")!=null){--%>
<%--            List<String > list = (List<String>) request.getAttribute("list");--%>
<%--            for (String s : list) {--%>
<%--                %>--%>
<%--                <li><%=s%></li>--%>
<%--         <%--%>
<%--            }--%>
<%--        }%>--%>
<%--    </ul>--%>
<%--    <%--%>
<%--        if("姜川".equals(request.getAttribute("username"))){%>--%>
<%--             <div style="width: <%=px%>;height: 100px;background-color: chocolate"></div>--%>
<%--        <%}else {%>--%>
<%--             <div style="width: 100px;height: 100px;background-color: <%=tmp%>"></div>--%>
<%--        <%}--%>

<%--    %>--%>
    <%
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"tom");map.put(2,"jerry");map.put(3,"kitty");
        request.setAttribute("map",map);
    %>
    <ul>
        <c:forEach var="v1" items="${requestScope['map']}">
            <c:if test="${v1.key==3}">
                <li>yyyyy</li>
            </c:if>
            <c:choose>
                <c:when test="${v1.key==1}">
                    <li>gggg</li>
                </c:when>
            </c:choose>
            <li>${v1.key}----${v1.value}</li>
        </c:forEach>
    </ul>
    <%!
        private  String eat(){
            return "eat";
        }
        private  String sleep(){
            return "sleep";
        }
    %>
    <%= eat() %>
    <%= sleep() %>
    <%
        // 设置每隔5秒自动刷新
        response.setIntHeader("Refresh", 5);
        // 获取当前时间
        Calendar calendar = new GregorianCalendar();
        String am_pm;
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        if(calendar.get(Calendar.AM_PM) == 0)
            am_pm = "AM";
        else
            am_pm = "PM";
        String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
        out.println("当前时间: " + CT + "\n");
    %>

</div>
</body>
</html>

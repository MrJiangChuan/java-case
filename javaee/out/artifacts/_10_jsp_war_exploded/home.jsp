<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
    <%
        //1.获取cookie中的localtime
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("localtime".equals(name)) {
                    //获取上一次访问的时间
                    String value = URLDecoder.decode(cookie.getValue(),"utf-8");
                    //重新设置cookie为当前时间
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年-MM月-dd日 HH：mm:ss");
                    String format = simpleDateFormat.format(date);
                    cookie.setValue(URLEncoder.encode(format,"utf-8"));
                    cookie.setMaxAge(30);
                    response.addCookie(cookie);
                    //展示本次访问的内容
                    %>
                    <h1>欢迎您再次访问，上一次访问时间为:<%=value%></h1>
    <%
                    return;
                }
            }
        }
        //首次访问
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年-MM月-dd日 HH：mm:ss");
        String format = simpleDateFormat.format(date);
        Cookie localtime = new Cookie("localtime", URLEncoder.encode(format,"utf-8"));
        localtime.setMaxAge(30);
        response.addCookie(localtime);
        %>
        <h1>欢迎您首次访问</h1>
</body>
</html>

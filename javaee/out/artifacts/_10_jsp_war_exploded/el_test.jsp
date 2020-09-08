<%@ page import="com.jc.entity.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>el表达式练习</title>
</head>
<body>

<%
    //1.普通类型
    pageContext.setAttribute("name","Tom");
    //2.数组类型
    String[] hobby = {"篮球","足球","游泳","看书","睡觉"};
    request.setAttribute("hobby",hobby);
    //3.对象类型
    User jerry = new User("Jerry", 21, new Date());
    session.setAttribute("jerry",jerry);
    //4.集合类型
    List<String> list = new ArrayList<>();
    list.add("ac");
    list.add("ffs");
    list.add("re3");
    list.add("gre3");
    Map<String,String> map = new HashMap<>();
    map.put("a","2w");
    map.put("b","sds");
    map.put("c","3e3");
    application.setAttribute("list",list);
    application.setAttribute("map",map);

%>

<h3>0.el表达式运算</h3>
${12*12}
${3/4}
${3 div 4}
${10%3}
${10 mod 3}

${12>3}
${12==3}

${12>4&&3<6}
${12>4||3<6}

${empty list}
${not empty list}

<h3>1.普通类型</h3>
${name}<br>
${pageScope.name}<br>
${pageScope["name"]}<br>
${pageScope.get("name")}<br>
<%--${pageContext.name}--%>
<%--${pageContext["name"]}--%>
<%--${pageContext.get(name)}--%>
<h3>2.数组类型</h3>
${hobby[0]}<br>
<h3>3.对象类型</h3>
${jerry.name}<br>
${jerry.age}<br>
${jerry.birthday}<br>
${jerry.birthFormat}<br>
<h3>4.集合类型</h3>
${list[0]}<br>
${list[3]}<br>
${map["a"]}<br>
${map.a}<br>
</body>
</html>

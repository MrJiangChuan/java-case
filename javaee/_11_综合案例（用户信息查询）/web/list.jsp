<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    //访问权限控制(未登录不能访问)
    if (request.getSession().getAttribute("userInfo") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }
    //对于有些页面，应该设置禁止直接访问，必须来源内部链接跳转
//    String referer = request.getHeader("referer");
//    if (referer == null || "".equals(referer) || !referer.contains(request.getContextPath())) {
//        response.sendRedirect(request.getContextPath() + "/index.jsp");
//        return;
//    }

%>

<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>

    <div style="float: left;">

        <form class="form-inline" action="${pageContext.request.contextPath}/fuzzyQueryServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" id="exampleInputName2" name="realName">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" class="form-control" id="exampleInputName3" name="address">
            </div>

            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="email" class="form-control" id="exampleInputEmail2" name="email">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>
    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:delPatchUser()">删除选中</a>

    </div>

    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input id="checkboxAll" type="checkbox"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <form id="deleteBatch_form" action="${pageContext.request.contextPath}/deleteBatchServlet" method="post">
            <c:forEach var="user" items="${fuzzyUsers.items}" varStatus="s">
                <tr>
                    <th><input type="checkbox" name="id" value="${user.id}"></th>
                    <td>${s.count}</td>
                    <td>${user.realName}</td>
                    <td>${user.sex}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}</td>
                    <td><a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/update.jsp?id=${user.id}&realName=${user.realName}&sex=${user.sex}&age=${user.age}&address=${user.address}&qq=${user.qq}&email=${user.email}">修改</a>&nbsp;<a
                            class="btn btn-default btn-sm" href="javascript:delUser(${user.id})">删除</a></td>
                </tr>
            </c:forEach>
        </form>
    </table>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="${pageContext.request.contextPath}/fuzzyQueryServlet?realName=${realName}&address=${address}&email=${email}&currentPage=${fuzzyUsers.currentPage<=1?1:fuzzyUsers.currentPage-1}&itemPerPage=5" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${fuzzyUsers.totalPage}" step="1" var="i">
                    <c:if com.jc.test="${fuzzyUsers.currentPage==i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/fuzzyQueryServlet?realName=${realName}&address=${address}&email=${email}&currentPage=${i}&itemPerPage=5">${i}</a></li>
                    </c:if>
                    <c:if com.jc.test="${fuzzyUsers.currentPage!=i}">
                        <li><a href="${pageContext.request.contextPath}/fuzzyQueryServlet?realName=${realName}&address=${address}&email=${email}&currentPage=${i}&itemPerPage=5">${i}</a></li>
                    </c:if>
                </c:forEach>
                <li>
                    <a href="${pageContext.request.contextPath}/fuzzyQueryServlet?realName=${realName}&address=${address}&email=${email}&currentPage=${fuzzyUsers.currentPage>=fuzzyUsers.totalPage?fuzzyUsers.totalPage:fuzzyUsers.currentPage+1}&itemPerPage=5" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 5px;">
                    共${fuzzyUsers.total}条记录，共${fuzzyUsers.totalPage}页
                </span>

            </ul>
        </nav>


    </div>
</div>
<script>
    //删除指定用户
    function delUser(id) {
        if (confirm("你确定要删除吗？")) {
            location.href = "${pageContext.request.contextPath}/deleteServlet?id=" + id;
        }
    }

    //批量删除
    function delPatchUser() {
        if (confirm("你确定要批量删除吗？")) {
            let elementById = document.getElementById("deleteBatch_form");
            elementById.submit();
        }
    }

    //全选全部选
    document.getElementById("checkboxAll").onclick = function () {
        let el = document.getElementsByName("id");
        for (let i = 0; i < el.length; i++) {
            el[i].checked = this.checked;
        }
    }
</script>
</body>
</html>


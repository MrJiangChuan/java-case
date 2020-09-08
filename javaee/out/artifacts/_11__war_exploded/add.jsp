<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //访问权限控制
    if (request.getSession().getAttribute("userInfo") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }

%>
<!-- HTML5文档-->
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
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <center><h3>添加联系人页面</h3></center>
    <form action="${pageContext.request.contextPath}/addServlet" method="post">
        <div class="form-group">
            <label for="realName">姓名：</label>
            <input type="text" class="form-control" id="realName" name="realName" placeholder="请输入姓名">
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="sex" value="男" checked="checked"/>男
            <input type="radio" name="sex" value="女"/>女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" id="address">
                <option value="陕西">陕西</option>
                <option value="北京">北京</option>
                <option value="上海">上海</option>
                <option value="山西">山西</option>
                <option value="天津">天津</option>
                <option value="河北">河北</option>
                <option value="河南">河南</option>
                <option value="湖北">湖北</option>
                <option value="湖南">湖南</option>
                <option value="黑龙江">黑龙江</option>
                <option value="吉林">吉林</option>
                <option value="辽宁">辽宁</option>
                <option value="青海">青海</option>
                <option value="西藏">西藏</option>
                <option value="四川">四川</option>
                <option value="重庆">重庆</option>
                <option value="宁夏">宁夏</option>
                <option value="甘肃">甘肃</option>
                <option value="新疆">新疆</option>
                <option value="内蒙古">内蒙古</option>
                <option value="江苏">江苏</option>
                <option value="浙江">浙江</option>
                <option value="海南">海南</option>
                <option value="福建">福建</option>
                <option value="广东">广东</option>
                <option value="广西">广西</option>
                <option value="贵州">贵州</option>
                <option value="云南">云南</option>
                <option value="江西">江西</option>
                <option value="安徽">安徽</option>
                <option value="山东">山东</option>
                <option value="香港">香港</option>
                <option value="澳门">澳门</option>
                <option value="台湾">台湾</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" id="qq" name="qq" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input id="submit" class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input id="back" class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
    <!-- 出错显示的信息框 -->
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert">
            <span>&times;</span>
        </button>
        <strong>${requestScope.add_error}</strong>
    </div>
</div>
<script>
    //返回到list页面
    document.getElementById("back").onclick = function () {
        location.href = "${pageContext.request.contextPath}/fuzzyQueryServlet"
    };
    //提交数据
    document.getElementById("submit").onclick = function () {
        let name_input = document.getElementById('realName');
        let age_input = document.getElementById('age');
        let qq_input = document.getElementById('qq');
        let email_input = document.getElementById('email');
        if (name_input.value && age_input.value && qq_input.value && email_input.value) {
            return true;
        }
        alert("请将信息填写完整");
        return false;
    };
</script>
</body>
</html>
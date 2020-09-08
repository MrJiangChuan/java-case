<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>index</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/response/responseTest8",
                    data: {"username":"tom","password":"123qwer"},
                    dataType: "json",
                    success:function (data) {
                        alert(data);
                        alert(data.name);
                        alert(data.age);
                        alert(data.sex);
                        alert(new Date(data.birthday).toDateString());
                    }
                });
            });
        });
    </script>
</head>
<body>
<a href="response/responseTest1">responseTest1...</a><br>
<a href="response/responseTest2">responseTest2...</a><br>
<a href="response/responseTest3">responseTest3...</a><br>
<a href="response/responseTest4">responseTest4...</a><br>
<a href="response/responseTest5">responseTest5...</a><br>
<a href="response/responseTest6">responseTest6...</a><br>
<a href="response/responseTest7">responseTest7...</a><br>
<input id="btn" type="button" value="Ajax请求">
</body>
</html>

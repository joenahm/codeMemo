<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>模糊搜索</title>
</head>
<body>
    <h4>查找用户</h4>
    <form:form action="search" method="post" modelAttribute="user">
        <form:input path="username" placeholder="请输入姓名" />
        <form:errors path="*" />

        <input type="submit">
    </form:form>
</body>
</html>

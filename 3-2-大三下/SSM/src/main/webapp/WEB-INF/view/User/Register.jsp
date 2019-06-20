<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>注册</title>
    <style>
        form {
            width: 300px;
            height: 200px;
            display: flex;
            flex-direction: column;
            justify-content: space-around;
        }
    </style>
</head>
<body>
    <h4>注册信息提交</h4>
    <form:form action="register" method="post" modelAttribute="user">
        <form:input path="username" placeholder="用户名" />
        <form:password path="password" placeholder="密码" />
        <form:password path="confirm" placeholder="确认密码" />
        <input type="submit">
    </form:form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录</title>
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
    <h4>用户登录</h4>
    <form action="#">
        <input type="text" name="username" placeholder="用户名" />
        <input type="password" name="password" placeholder="密码">

        <input type="submit">
    </form>
</body>
</html>

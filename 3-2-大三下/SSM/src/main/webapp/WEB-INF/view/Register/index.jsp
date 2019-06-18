<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <form action="handle" method="POST">
        <input type="text" name="name" placeholder="姓名" />
        <input type="number" name="id" placeholder="身份证号" />
        <input type="email" name="email" placeholder="邮箱">
        <input type="text" name="addr" placeholder="地址">

        <input type="submit">
    </form>
</body>
</html>

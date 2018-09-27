<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="userInfo.aspx.cs" Inherits="aspDotNetBlank.userInfo" %>

<!DOCTYPE html>

<html>
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <title>用户信息</title>
  <style>
    body {
      display: flex;
      justify-content: center;
    }

    table {
      width: 100px;
    }
  </style>
</head>
<body>
  <table>
    <tr>
      <td><b>姓名：</b></td>
      <td><%= this.name %></td>
    </tr>
    <tr>
      <td>
        <b>昵称：</b>
      </td>
      <td>
        <%= this.nickname %>
      </td>
    </tr>
    <tr>
      <td>
        <b>性别：</b>
      </td>
      <td>
        <%= this.gender %>
      </td>
    </tr>
    <tr>
      <td>
         <b>地区：</b>
      </td>
      <td>
        <%= this.location %>
      </td>
    </tr>
    <tr>
      <td>
        <b>备注：</b>
      </td>
      <td>
        <%= this.remarks %>
      </td>
    </tr>
  </table>
</body>
</html>

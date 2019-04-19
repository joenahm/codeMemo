<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Vector" %>
<%@ page import="top.sjydzq.javabean.User" %>

<%!
  String roleMapper(int roleCode) {
    switch (roleCode) {
      case 1:
        return "系统管理员";
      case 2:
        return "企业管理员";
      case 3:
      default:
        return "普通用户";
    }
  }
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>在线用户列表</title>
<link href="../css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="index.html">首页</a></li>
    <li>在线用户列表</li>
  </ul>
</div>
<div class="rightinfo">
  <%
    Vector<User> users = (Vector<User>) request.getServletContext().getAttribute("ONLINE_USERS");
  %>
  <table class="imgtable">
    <thead>
      <tr>
        <th>用户登录名</th>
        <th>用户真实姓名</th>
        <th>用户角色</th>
        <th>操作</th>
      </tr>
    </thead>
    <tbody>
      <% if (users != null) { %>
        <% for (User user: users) { %>
          <tr height="50px">
            <td><%= user.getName() %></td>
            <td><%= user.getRealName() %></td>
            <td><%= roleMapper(user.getRole()) %></td>
            <td ><a href="/logout?uid=<%=user.getId()%>&type=force" class="tablelink">强制下线</a> </td>
          </tr>
        <% } %>
      <% } %>
    </tbody>
  </table>
</div>
</body>
</html>

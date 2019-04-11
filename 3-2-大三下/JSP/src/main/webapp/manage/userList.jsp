<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Vector" %>
<%@ page import="top.sjydzq.javabean.User" %>
<%@ page import="top.sjydzq.javabean.Page" %>

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

  String stateMapper(int stateCode) {
      switch (stateCode) {
        case 1:
            return "启用";
        case 0:
        default:
            return "禁用";
      }
  }
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>用户列表</title>
<link href="../css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">用户列表</a></li>
  </ul>
</div>
<div class="rightinfo">
  <div class="tools">
    <ul class="toolbar">
      <li class="click"><span><img src="../images/t01.png" /></span><a href="/manage/userAdd.html">添加</a></li>
      <li class="click"><span><img src="../images/t02.png" /></span><a href="#">修改</a></li>
      <li><span><img src="../images/t03.png" /></span><a href="#">删除</a></li>
    </ul>
    <iframe src="/manage/userSearch.html" scrolling="no" frameborder="0" width="400" height="42"></iframe>
  </div>
  <table class="imgtable">
    <thead>
      <tr>
        <th ><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>用户登录名</th>
        <th>用户真实姓名</th>
        <th>用户Email</th>
        <th>用户角色</th>
        <th>用户状态</th>
        <th>操作</th>
      </tr>
    </thead>
    <tbody>
      <%
        Page<User> userListPage = (Page<User>)request.getAttribute("userList");
        Vector<User> users = userListPage.getRecords();
      %>
      <% for (User user: users) { %>

      <tr height="50px">
        <td ><input name="" type="checkbox" value="" /></td>
        <td><%= user.getName() %></td>
        <td><%= user.getRealName() %></td>
        <td><%= user.getEmail() %></td>
        <td><%= roleMapper(user.getRole()) %></td>
        <td><%= stateMapper(user.getState()) %></td>
        <td ><a href="userAdd.html" class="tablelink">修改</a> &nbsp;&nbsp;<a href="#" class="tablelink"> 删除</a></td>
      </tr>

      <% } %>
    </tbody>
  </table>
  <div class="pagin">
    <div class="message">
      共&nbsp;<i class="blue"><%=userListPage.getTotalPages()%></i>
      &nbsp;页，当前显示第&nbsp;<i class="blue"><%=userListPage.getPageNo()%></i>&nbsp;页
    </div>
    <ul class="paginList">
      <li class="paginItem"><a href="/UserListServlet?pageNo=1">首页</a></li>
      <% if (userListPage.hasPrev()) { %>
      <li class="paginItem"><a href="/UserListServlet?pageNo=<%=userListPage.getPageNo()-1%>">上一页<span class="pagepre"></span></a></li>
      <% } %>
      <% if (userListPage.hasNext()) { %>
      <li class="paginItem"><a href="/UserListServlet?pageNo=<%=userListPage.getPageNo()+1%>">下一页<span class="pagenxt"></span></a></li>
      <% } %>
      <li class="paginItem"><a href="/UserListServlet?pageNo=<%=userListPage.getTotalPages()%>">尾页</a></li>
    </ul>
  </div>
</div>
</body>
</html>

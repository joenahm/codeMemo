<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Vector" %>
<%@ page import="top.sjydzq.javabean.Company" %>
<%@ page import="top.sjydzq.javabean.Page" %>

<%!
  String stateMapper(int stateCode) {
    switch (stateCode) {
      case 1:
        return "招聘中";
      case 2:
        return "已暂停";
      case 3:
      default:
        return "已结束";
    }
  }
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>企业列表</title>
<link href="../css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">企业列表</a></li>
  </ul>
</div>
<div class="rightinfo">
  <div class="tools">
    <ul class="toolbar">
      <li class="click"><span><img src="../images/t01.png" /></span><a href="companyAdd.html">添加</a></li>
      <li><span><img src="../images/t03.png" /></span><a href="#">删除</a></li>
    </ul>
  </div>
  <table class="imgtable">
    <thead>
      <tr>
        <th ><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>企业名称</th>
        <th>企业所在地</th>
        <th>企业规模</th>
        <th>企业性质</th>
        <th>招聘状态</th>
        <th>显示排序</th>
        <th>浏览数</th>
        <th>操作</th>
      </tr>
    </thead>
    <tbody>
      <%
        Page<Company> companyListPage = (Page<Company>)request.getAttribute("companyList");
        Vector<Company> companies = companyListPage.getRecords();
      %>
      <% for(Company company: companies) { %>
      <tr height="50px">
        <td ><input name="" type="checkbox" value="" /></td>
        <td><%= company.getName() %></td>
        <td><%= company.getArea() %></td>
        <td><%= company.getSize() %></td>
        <td><%= company.getType() %></td>
        <td><%= stateMapper(company.getState()) %></td>
        <td><%= company.getSort() %></td>
        <td><%= company.getViewNum() %></td>
        <td ><a href="companyAdd.html" class="tablelink">修改</a> &nbsp;&nbsp;<a href="#" class="tablelink"> 删除</a></td>
      </tr>
      <% } %>
    </tbody>
  </table>
  <div class="pagin">
    <div class="message">
      共&nbsp;<i class="blue"><%=companyListPage.getTotalPages()%></i>
      &nbsp;页，当前显示第&nbsp;<i class="blue"><%=companyListPage.getPageNo()%></i>&nbsp;页
    </div>
    <ul class="paginList">
      <li class="paginItem"><a href="/CompanyListServlet?pageNo=1">首页</a></li>
      <% if (companyListPage.hasPrev()) { %>
      <li class="paginItem"><a href="/CompanyListServlet?pageNo=<%=companyListPage.getPageNo()-1%>">上一页<span class="pagepre"></span></a></li>
      <% } %>
      <% if (companyListPage.hasNext()) { %>
      <li class="paginItem"><a href="/CompanyListServlet?pageNo=<%=companyListPage.getPageNo()+1%>">下一页<span class="pagenxt"></span></a></li>
      <% } %>
      <li class="paginItem"><a href="/CompanyListServlet?pageNo=<%=companyListPage.getTotalPages()%>">尾页</a></li>
    </ul>
  </div>
</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="top.sjydzq.javabean.Page" %>
<%@ page import="java.util.Vector" %>
<%@ page import="top.sjydzq.javabean.Resume" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>简历列表</title>
<link href="../css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="../index.html">首页</a></li>
    <li>简历列表</li>
  </ul>
</div>
<div class="rightinfo">
  <div class="tools">
    <ul class="toolbar">
      <li><span><img src="../images/t03.png" /></span><a href="#">删除</a></li>
    </ul>
  </div>
  <table class="imgtable">
    <thead>
      <tr>
        <th ><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>姓名</th>
        <th>手机</th>
        <th>Email</th>
        <th>工作经验</th>
        <th>求职意向</th>
        <th>操作</th>
      </tr>
    </thead>
    <tbody>
      <%
          Page<Resume> resumeListPage = (Page<Resume>)request.getAttribute("resumeList");
          Vector<Resume> resumes = resumeListPage.getRecords();
      %>
      <% for (Resume resume : resumes) { %>
        <tr height="50px">
          <td ><input name="" type="checkbox" value="" /></td>
          <td><%=resume.getRealName()%></td>
          <td><%=resume.getPhone()%></td>
          <td><%=resume.getEmail()%></td>
          <td><%=resume.getExperience()%></td>
          <td><%=resume.getIntention()%></td>
          <td ><a href="/ResumeViewServlet?id=<%=resume.getId()%>" class="tablelink">查看</a> &nbsp;&nbsp;<a href="#" class="tablelink"> 删除</a></td>
        </tr>
      <% } %>
    </tbody>
  </table>
 <div class="pagin">
    <div class="message">共&nbsp;<i class="blue"><%=resumeListPage.getTotalPages()%></i>&nbsp;页，当前显示第&nbsp;<i class="blue"><%=resumeListPage.getPageNo()%></i>&nbsp;页</div>
    <ul class="paginList">
      <li class="paginItem"><a href="/ResumeListServlet?pageNo=1">首页</a></li>
      <% if (resumeListPage.hasPrev()) { %>
        <li class="paginItem"><a href="/ResumeListServlet?pageNo=<%=resumeListPage.getPageNo()-1%>">上一页<span class="pagepre"></span></a></li>
      <% } %>
      <% if (resumeListPage.hasNext()) { %>
        <li class="paginItem"><a href="/ResumeListServlet?pageNo=<%=resumeListPage.getPageNo()+1%>">下一页<span class="pagenxt"></span></a></li>
      <% } %>
      <li class="paginItem"><a href="/ResumeListServlet?pageNo=<%=resumeListPage.getTotalPages()%>">尾页</a></li>
    </ul>
  </div>
</div>
</body>
</html>

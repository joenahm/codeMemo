<%@ page import="top.sjydzq.javabean.Resume" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>简历详情</title>
<link href="../css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="../index.jsp">首页</a></li>
    <li>简历详情</li>
  </ul>
</div>
<%
  Resume resume = (Resume)request.getAttribute("resume");
%>
<div class="formbody">
  <div class="usual">
    <div class="tabson">
      <ul class="forminfo">
      	<li>
          <label>真实姓名：</label><label style="width: 200px;"><b style="color: #000"><%=resume.getRealName()%></b></label>
        </li>
        <li>
          <label>照片：</label><img src="<%=resume.getAvatar()%>" width="100px" height="100px">
        </li>
        <li>
          <label>性别：</label><label style="width: 200px;"><b style="color: #000"><%=resume.getGender()%></b></label>
        </li>
        <li>
          <label>出生日期：</label><label style="width: 200px;"><b style="color: #000"><%=resume.getBirthday()%></b></label>
        </li>
        <li>
          <label>当前所在地：</label><label style="width: 200px;"><b style="color: #000"><%=resume.getCurrentLocation()%></b></label>
        </li>
        <li>
          <label>户口所在地：</label><label style="width: 200px;"><b style="color: #000"><%=resume.getResidentLocation()%></b></label>
        </li>
        <li>
          <label>手机号：</label><label style="width: 200px;"><b style="color: #000"><%=resume.getPhone()%></b></label>
        </li>
        <li>
          <label>邮箱：</label><label style="width: 200px;"><b style="color: #000"><%=resume.getEmail()%></b></label>
        </li>
        <li>
          <label>求职意向：</label><label style="width: 200px;"><b style="color: #000"><%=resume.getIntention()%></b></label>
        </li>
        <li>
          <label>工作经验：</label><label style="width: 200px;"><b style="color: #000"><%=resume.getExperience()%></b></label>
        </li>
      </ul>
    </div>
  </div>
</div>
</body>
</html>

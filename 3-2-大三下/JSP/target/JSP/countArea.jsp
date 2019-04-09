<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>计算面积</title>
</head>
<body>
<%
    float a = Float.parseFloat(request.getParameter("a"));
    float b = Float.parseFloat(request.getParameter("b"));
%>
<%=a*b%>
</body>
</html>

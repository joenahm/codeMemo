<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="List.aspx.cs" Inherits="QC.List" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>青池-
    <%
        switch (Request["cat"]) {
          case "1":
            Response.Write("文学");
            break;
          case "2":
            Response.Write("思想");
            break;
          case "3":
            Response.Write("技术");
            break;
          case "4":
            Response.Write("发现");
            break;
        }
     %></title>
	<link rel="stylesheet" href="public/css/common.css">
	<link rel="stylesheet" href="public/css/list.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="shortcut icon" href="favicon.ico">
</head>
<body>
	<header>
		<div>
			<span>青池</span>
		</div>
		<nav>
			<a href="List.aspx?cat=1">文学</a>
			<a href="List.aspx?cat=2">思想</a>
			<a href="Index.aspx">首页</a>
			<a href="List.aspx?cat=3">技术</a>
			<a href="List.aspx?cat=4">发现</a>
		</nav>
	</header>
	<article>
    <%
        for (int i = 0; i < this.articles.Count; i++) {
          string[] artArr = (string[])(this.articles[i]);

          if (artArr[i].Length > 0) {
            Response.Write("<section id='stage'>" +
          "<a href='Article.aspx?id=" + artArr[0] + "'>" +
              "<div class='item'>" +
                  "<div class='item_img' style='background-image: url(\"" + artArr[4] + "\");'></div>" +
                  "<div class='item_title'>" + artArr[2] + "</div>" +
                  "<div class='item_date'>" + artArr[5] + "</div>" +
                  "<div class='item_content'>" + artArr[3] + "<div>" +
              "</div>" +
          "</a>" +
          "</section>");
          }
        }
    %>
</body>
<script src="public/js/common.js"></script>
<script>
	var am=0;
	if(window.innerWidth>500){
		am=210;
	}else{
		am=70;
	}
	for(var j=0;j<Qcclass("item_content").length;j++){
		if(Qcclass("item_content")[j].innerHTML.length>am){
			var restr="";
			var str=Qcclass("item_content")[j].innerHTML.split("",am);
			for(var i=0;i<am;i++){
				restr+=str[i];
			 }
			 restr+="...";
			Qcclass("item_content")[j].innerHTML=restr;
		}
	}
</script>
</html>

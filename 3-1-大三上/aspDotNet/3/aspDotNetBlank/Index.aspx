<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Index.aspx.cs" Inherits="QC.Index" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>青池-博客</title>
	<link rel="stylesheet" href="public/css/common.css">
	<link rel="stylesheet" href="public/css/index.css">
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
	<article id="sll">
		<section class="sal">
			<a href="Article.aspx?id=<%=this.wx[0] %>">
				<div class="sal_box">
					<div class="sal_img" style="background-image: url('<%=this.wx[4]%>');"></div>
					<div class="sal_txt"><%=this.wx[2]%></div>
					<div class="sal_date"><%=this.wx[5] %></div>
				</div>
			</a>
		</section>
		<section class="sal">
			<a href="Article.aspx?id=<%=this.sx[0] %>">
				<div class="sal_box">
					<div class="sal_img" style="background-image: url('<%=this.sx[4]%>');"></div>
					<div class="sal_txt"><%=this.sx[2]%></div>
					<div class="sal_date"><%=this.sx[5] %></div>
				</div>
			</a>
		</section>
    <section class="sal">
			<a href="Article.aspx?id=<%=this.js[0] %>">
				<div class="sal_box">
					<div class="sal_img" style="background-image: url('<%=this.js[4]%>');"></div>
					<div class="sal_txt"><%=this.js[2]%></div>
					<div class="sal_date"><%=this.js[5] %></div>
				</div>
			</a>
		</section>
    <section class="sal">
			<a href="Article.aspx?id=<%=this.fx[0] %>">
				<div class="sal_box">
					<div class="sal_img" style="background-image: url('<%=this.fx[4]%>');"></div>
					<div class="sal_txt"><%=this.fx[2]%></div>
					<div class="sal_date"><%=this.fx[5] %></div>
				</div>
			</a>
		</section>
	</article>
</body>
<script src="public/js/common.js"></script>
</html>

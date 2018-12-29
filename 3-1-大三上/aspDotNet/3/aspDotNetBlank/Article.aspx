<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Article.aspx.cs" Inherits="QC.Article" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><%=this.article[2] %>-青池</title>
	<link rel="stylesheet" href="public/css/common.css">
	<link rel="stylesheet" href="public/css/article.css">
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
		<section id="stage">
			<div id="title"><%=this.article[2] %></div>
			<div id="content">
				<div class="img" style="background-image: url('<%=this.article[4] %>');"></div><%=this.article[3] %></div>
			<div id="date"><%=this.article[5] %></div>
		</section>
	</article>
</body>
<script src="public/js/common.js"></script>
</html>
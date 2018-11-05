<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>文章列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="../font.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="hr">
		文章列表
		<hr />
	</div>
	<!-- 显示登录用户文章列表 -->
	<div>
		<table style="width:60%">
			<c:forEach items="${userArticles}" var="article">
				<tr>
					<td><a
						href="/BokeProject/articleDemoServlet.do?articleId=${article.articleId}">${article.articleName}</a>
					</td>
					<td><a
						href="/BokeProject/deleteArticleServlet.do?articleId=${article.articleId}">删除</a>
						<a
						href="/BokeProject/updateArticleServlet.do?articleId=${article.articleId}">编辑</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<!-- 显示登录用户文章列表 -->
</body>
</html>

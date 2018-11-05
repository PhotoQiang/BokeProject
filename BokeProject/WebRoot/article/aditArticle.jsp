<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'aditArticle.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="../font.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="ckeditorStandard/ckeditor.js"></script>
</head>

<body>
	<div id="hr">
		编辑文章
		<hr />
	</div>
	<!-- 编辑用户文章 -->
	<div>
		<form action="/BokeProject/editArticleServlet.do">
			标题：<input type="text" value="${article.articleName}"
				name="articleName"> <br />
			<textarea id="editor1" class="ckeditor" name="articleContent">${article.articleContent}</textarea>
			<script type="text/javascript">
			ckeditor.replace('editor1');
			</script>
			<input type="submit" value="确认发布">
		</form>
	</div>
	<!-- 编辑用户文章 -->
</body>
</html>

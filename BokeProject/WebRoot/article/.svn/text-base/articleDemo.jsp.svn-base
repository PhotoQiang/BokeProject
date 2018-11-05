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

<title>My JSP 'articleDemo.jsp' starting page</title>

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
		文章详情
		<hr />
	</div>
	<div>
		<div>标题：${article.articleName}</div>
		<hr/>
		${article.articleContent}
	</div>
	<!-- 显示文章评论 -->
	<br/><hr/>文章评论
	<div>
		<table style="width:60%">
				<tr>
					<td>用户名</td>
					<td>&nbsp;</td>
					<td>评论</td>
				</tr>
			<c:forEach items="${comments}" var="comment">
				<tr>
					<td>${comment.userName}</td>
					<td>&nbsp;</td>
					<td>${comment.commentContent}</td>
					<td><a
						href="/BokeProject/deleteCommentServlet.do?commentId=${comment.commentId}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<!-- 显示文章评论  -->
</body>
</html>

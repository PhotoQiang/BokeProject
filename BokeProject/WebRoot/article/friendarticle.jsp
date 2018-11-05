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

<title>My JSP 'friendarticle.jsp' starting page</title>

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
		查看好友文章
		<hr />
	</div>
	<form action="/BokeProject/AddArticleMess.do">
		<label>${article.articleName }</label><br> <label>${article.articleContent
			}</label><br> <input type="hidden" name="articleId"
			value="${article.articleId}" /> <input type="text" name="message"
			id="message" /> <input type="submit" name="sub" id="sub" value="评论" />
	</form>
	评论列表
	<!-- 评论查看 -->
	<c:forEach items="${Cot}" var="comment">
		<table style="width:60%">
			<tr>
				<td>${comment.userName }</td>
				<td>${comment.commentContent }</td>
			</tr>
		</table>
	</c:forEach>

</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>我的留言</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<style type="text/css">
#msg {
	width: 60%;
}
</style>
<link href="../font.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="hr">
		我的留言
		<hr />
	</div>
	<form action="">
		<table id="msg">
			<tr>
				<td>用户名</td>
				<td>留言信息</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${ms}" var="ms">
				<tr>
					<td>${ms.friendName}</td>
					<td>${ms.messageContent}</td>
					<td><a
						href="/BokeProject/tiaoServlet.do?messageId=${ms.messageId}&friendName=${ms.friendName}&messagecount=${ms.messageContent}">回复</a>&nbsp;
						<a
						href="/BokeProject/deleteMessageServlet.do?messageId=${ms.messageId}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>

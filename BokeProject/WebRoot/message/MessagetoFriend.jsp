<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>给我的朋友留言</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#msg {
	width: 60%;
}
</style>
<link href="../font.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="hr">
		给${friendName}留言
		<hr />
	</div>
	<form action="/BokeProject/addMessageServlet.do">

		<textarea rows="20" cols="50" name="messageText" style="height:200px"> 请输入给朋友留言的信息</textarea>

		<input type="submit" value="提交"> <input type="reset"
			value="重置">
	</form>
	好友留言列表:<br />
	<table><tr><td>用户名</td><td>&nbsp;</td><td>留言内容</td><td>&nbsp;</td>
			<c:forEach items="${mess}" var="mess">
			<tr>
			<td>${mess.friendName}</td><td>&nbsp;</td>
			<td>${mess.messageContent}</td><td>&nbsp;</td>
			<td><a href="/BokeProject/showReplyServlet.do?messageId=${mess.messageId}">查看回复</a></td>
			</tr>
			</c:forEach>
</table>

</body>
</html>

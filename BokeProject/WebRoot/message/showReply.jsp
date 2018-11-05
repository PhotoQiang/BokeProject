<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'showReply.jsp' starting page</title>
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
		显示留言回复
		<hr />
	</div>
	<form>
		留言内容:${messageContent}<br /> <br />

		<table style="width:60%">
			<tr>
				<td>用户名</td><td>&nbsp;</td>
				<td>回复内容</td>
			</tr>
			<c:forEach items="${Reply}" var="Reply">
				<tr>
					<td>${friendName}</td><td>&nbsp;</td>
					<td>${Reply.replyContent}</td>
				</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>

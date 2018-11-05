<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>好友列表</title>
<link href="../font.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="hr">
		我的好友
		<hr />
	</div>
	<div>
		<a href="/BokeProject/friend/addFriend.jsp"
			style="text-decoration:none">想添加新好友？点击这里</a><hr/>
		<table width="60%">
			<c:forEach items="${friendList}" var="fri">
				<tr>
					<td height="35"><a name="friendId"
						href="/BokeProject/comeFriendPage.do?friendId=${fri.friendId}">好友账号：${fri.friendName}
					</a> &nbsp;&nbsp;&nbsp;</td>
					<td height="35" align="center"><a name="friendId"
						href="/BokeProject/deleteFriendServlet.do?friendId=${fri.friendId}">删除</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td width="90%"><a name="currentPage"
					href="/BokeProject/firstPageFriendServlet.do?currentPage=${cpage.currentPage }">首页</a>
					<a name="currentPage"
					href="/BokeProject/upPageFriendServlet.do?currentPage=${cpage.currentPage }">上一页</a>
					<a name="currentPage"
					href="/BokeProject/downPageFriendServlet.do?currentPage=${cpage.currentPage }">下一页</a>
					<a href="/BokeProject/lastPageFriendServlet.do">末页</a></td>
				<td width="10%" align="left">
					<form method="post" action="/BokeProject/goPageFriendServlet.do">
						<input type="text" name="goPage" value="${cpage.currentPage}"
							style="width:30px;" /> <input type="submit" value="Go">

					</form></td>
			</tr>
		</table>
		<!-- 	<a name="currentPage" href="/BokeProject/goPageFriendServlet.do?currentPage=${cpage.currentPage }" >GO</a>
		 -->
	</div>

</body>
</html>

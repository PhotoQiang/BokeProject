<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>我的信息</title>
<link href="../font.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="hr">
		我的信息
		<hr/>
	</div>
	<form action="/BokeProject/myInfo2.do" method="get" name=”linkform”>

		<table>
			<c:forEach items="${userinfo}" var="info">


				<tr>
					<td>昵称：</td>
					<td>&nbsp;</td>
					<td><input type="text" name="tick" value="${info.tickName}" />
					</td>
				</tr>
				<tr>
					<td>联系方式：</td>
					<td>&nbsp;</td>
					<td><input type="text" name="tel" value="${info.telphone}" />
					</td>
				</tr>
				<tr>
					<td>个人爱好：</td>
					<td>&nbsp;</td>
					<td><input type="text" name="hobby" value="${info.hobby}" />
					</td>
				</tr>
			</c:forEach>
		</table>
		<br /> <input name="update" type="submit" value="更新" /> <input
			type="reset" value="重置" />
	</form>
</body>
</html>

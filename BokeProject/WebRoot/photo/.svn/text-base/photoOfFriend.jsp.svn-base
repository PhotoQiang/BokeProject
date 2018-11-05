<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>好友相册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">

#content {
	width: 90%;
	height: 85%;
	border: 0px solid red;
}

#photoDiv {
	float: left;
	width: 200px;
	height: 220px;
	margin: 10px;
	border: 0px solid red;
}

#photoDiv img {
	width: 200px;
	height: 200px;
	border: 0px solid red;
}

#photoDiv a:hover img {
	position: relative;
	z-index: 1;
	width: 400px;
	height: 400px;
}

#main {
	margin: 3%;
	border: 0px solid red;
}
hr {
	background-color: #134262;
}
</style>
<link href="../font.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="hr">
		${friendName}的相册
		<hr />
	</div>
	<div id="main">
		<!-- 根据数据库内数量决定 -->

		<!-- 显示好友相册每张照片 -->
		<div id="content">
			<c:forEach items="${friendPhotos}" var="photo">
				<div id="photoDiv">
					<a><img src="../photoLibrary/${photo.url}" id="photo" />
					</a>
				</div>
			</c:forEach>
		</div>
		<!-- 显示好友相册每张照片 -->
	</div>
</body>
</html>

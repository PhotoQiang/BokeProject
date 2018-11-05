<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>我的相册</title>
<style type="text/css">
a {
	text-decoration: none;
}

#upload {
	margin-left: 55%;
	
}

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

#title {
	font-family: 微软雅黑;
	border: 0px solid red;
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
		我的相册
		<hr />
	</div>
	<div id="main">
		<!-- 根据数据库内数量决定 -->
		<div id="title">
			<div id="upload">
				<form action="/BokeProject/addPhotoServlet.do/upload" method="post"
					enctype="multipart/form-data">
					<input type="submit" onclick="upLoad()" value="确认上传" />
					上传照片<input type="file" readonly="readonly" name="upFile" />					
				</form>
			</div>
		</div>
		<!-- 显示每张照片 -->
		<div id="content">
			<c:forEach items="${photos}" var="photo">
				<div id="photoDiv">
					<a><img src="../photoLibrary/${photo.url}" /> </a> <a
						href="/BokeProject/deletePhotoServlet.do?photoId=${photo.photoId}">删除</a>
				</div>
			</c:forEach>
		</div>
		<!-- 显示每张照片 -->
	</div>
	<script type="text/javascript">
		function Load() {
			var flag =
	<%=request.getSession().getAttribute("flag")%>
		;
			if (flag == null) {
				alert("请添加照片");
			}
			;
		};
	</script>
</body>
</html>

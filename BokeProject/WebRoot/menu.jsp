<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>菜单</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" language="javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {

				//slides the element with class "menu_body" when paragraph with class "menu_head" is clicked 
				$("#firstpane p.menu_head").click(
						function() {
							$(this).css({
								backgroundImage : "url(down.png)"
							}).next("div.menu_body").slideToggle(300).siblings(
									"div.menu_body").slideUp("slow");
							$(this).siblings().css({
								backgroundImage : "url(left.png)"
							});
						});
			});
</script>
<style type="text/css">
body {
	margin: 10px auto;
	font: 90%/120% Verdana, Arial, Helvetica, sans-serif;
	color: white;
	background-color: #dde1e5;
}

#div {
	float: left;
	margin: auto 20px;
	height: 100%;
	background-color: #b0cdee;
}

.menu_list {
	width: 200px;
}

.menu_head {
	padding: 5px 10px;
	cursor: pointer;
	position: relative;
	margin: 1px;
	font-weight: bold;
	background: #839baa url(left.png) center right no-repeat;
}

.menu_body {
	display: none;
}

.menu_body a {
	display: block;
	color: #006699;
	background-color: #ffffff;
	padding-left: 10px;
	font-weight: bold;
	text-decoration: none;
}

.menu_body a:hover {
	color: #000000;
	text-decoration: underline;
}
</style>
</head>

<body>

	<div id="div">
		<!--This is the first division of left-->
		<p>
			<strong><h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;博客</h1></strong>
		</p>
		<div id="firstpane" class="menu_list">
			<!--Code for menu starts here-->
			<p class="menu_head">文章</p>
			<div class="menu_body">
				<a href="/BokeProject/showUserArticle.do" target="iframe">我的文章</a>
				<a href="/BokeProject/article/createArticle.jsp" target="iframe">新建文章</a>
			</div>
			<p class="menu_head">相册</p>
			<div class="menu_body">
				<a href="/BokeProject/showPhotosServlet.do" target="iframe">我的相册</a>
			</div>
			<p class="menu_head">留言</p>
			<div class="menu_body">
				<a href="/BokeProject/myMessageServlet.do" target="iframe">留言版</a>
			</div>
			<p class="menu_head">好友</p>
			<div class="menu_body">
				<a href="/BokeProject/myFriendServlet.do" target="iframe">我的好友</a>
			</div>
			<p class="menu_head">个人信息</p>
			<div class="menu_body">
				<a href="/BokeProject/myInfo.do" target="iframe">修改个人信息</a> <a
					href="personInfo/updatePass.jsp" target="iframe">修改密码</a>
			</div>
		</div>
		<!--Code for menu ends here-->
	</div>

</body>
</html>

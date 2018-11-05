<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>主页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
body {
	background-color: #dde1e5;
}

#head {
	height: 20%;
}

#menu {
	float: left;
	width: 20%;
}

.content {
	float: left;
	width: 75%;
}
</style>
</head>

<frameset rows="15%,*,13%" border="0px" noresize="no">
	<frame src="head.jsp" scrolling="no"/>
    <frameset cols="16%,*" border="0px" noresize="no">
    <frame src="menu.jsp" scrolling="no"/>
    <frame src="transIframe.jsp" scrolling="no"/>
    </frameset>
    <frame src="foot.jsp" />
</frameset>

</html>

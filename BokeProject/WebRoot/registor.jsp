<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>

<title>注册</title>

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
	background-color: #bee1f5;
	text-align: center;
	font-family: 微软雅黑;
}

label {
	color: red;
}

#main {
	background-color: white;
	margin: 8% 8% 0 12%;
	width: 70%;
	height: 70%;
}

#content {
	float: left;
	margin: 20% 10% 0 10%;
	width: 30%;
	height: 70%;
}

#log {
	float: left;
	margin: 10% auto;
	width: 30%;
	font-size: 20px;
}

#sub {
	margin-top: 10px;
	width: 200px;
	height: 32px;
	font-family:微软雅黑;
	color:white;
	font-size:20px;
	background-color: #ffa71d;
}

#input {
	margin-top: 10px;
	width: 200px;
	height: 30px;
	background-color: #dbdfe3;
	border: 1px solid #144264;
	font-size: 20px;
	font-family: 微软雅黑;
}

#link {
	font-size: 12px;
}

span {
	color: red;
}
</style>
<script type="text/javascript">
	function check(obj, mes) {
		if (obj.value == '') {
			document.getElementById(mes).style.display = "";
		} else {
			var filter = "\w+([-+.']\w+)*@\w+([-.])*\.\w+([-.]\w+)*";
			if (filter.test(obj))
				return true;
			else {
				alert('您的电子邮件格式不正确');
				return false;
			}

		}

	}
	function checkpwd(obj, mes) {
		if (obj.value == '') {
			document.getElementById(mes).style.display = "";
		}

	}
</script>
</head>

<body>
	<div id="main">
		<div id="content">
			<img src="images/logo1.png" style="float:left" /> <img
				src="images/word1.png" /><br />
		</div>
		<div id="log">
			<br />
			<form action="/BokeProject/registerServlet.do" method="post">
				电子邮箱<input id="input" type="text" name="userName" value="请输入注册邮箱地址"
					onclick="javascript:this.value=''"
					onblur="check(this,'errmegoldmail')"  /><span id="errmegoldmail"
					style="display: none">邮箱不能为空！</span>
					<label>${repeat}</label><br />
				创建密码<input id="input" type="password" name="password" value=""
					onblur="checkpwd(this,'errmegoldpwd')" /><span id="errmegoldpwd"
					style="display: none">密码不能为空！</span><br /> <input type="checkbox"
					name="checked" value="1" />同意用户协议<br /> <label>${message}</label><br>
				<input id="sub" type="submit" value="注&nbsp;&nbsp;&nbsp;册" />
			</form>
			<div id="link">
				<br /> ©Blog©<br />
			</div>
		</div>
	</div>
</body>

</html>

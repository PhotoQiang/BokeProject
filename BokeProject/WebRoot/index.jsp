<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登陆</title>
<style>
body {
	background-color: #dbdfe3;
	text-align: center;
	font-family: 微软雅黑;
}

#reg {
	margin-left: 40%;
}

div a {
	text-decoration: none;
}

#content {
	float: left;
	margin: 20% 10% 0 15%;
	width: 30%;
	height: 70%;
}

#log {
	float: left;
	margin: 10% 12% 0 0;
	width: 30%;
	font-size: 20px;
}

#logImg {
	margin-top: 10px;
	width: 200px;
	height: 32px;
	font-family: 微软雅黑;
	
	color: white;
	font-size: 20px;
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
		}

	}
</script>
</head>

<body>
	<div id="main">

		<div id="content">
			<img src="images/blog.png"></img>
		</div>
		<div id="log">
			<img src="images/logo1.png" /> <img src="images/word1.png" /><br />
			<br />
			<form action="/BokeProject/loginServlet.do" method="post">
				账号<input id="input" type="text" name="userName" value="请输入登陆账号"
					onclick="javascript:this.value=''"
					onblur="check(this,'errmegoldmail')" /><span id="errmegoldmail"
					style="display: none">邮箱不能为空！</span><br /> 密码<input id="input"
					type="password" name="password" value=""
					onblur="check(this,'errmegoldpwd')" /><span id="errmegoldpwd"
					style="display: none">密码不能为空！</span><br />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="logImg"
					type="submit" value="登&nbsp;&nbsp;&nbsp;陆" />
			</form>
			<a href="personInfo/findPass.jsp">忘记密码？</a><br /> <a
				href="/BokeProject/registor.jsp">还没有账号？注册一个</a>
			<div id="link">
				<br /> ©blog©<br /> <img src="images/welcome.gif" />欢迎使用<img
					src="images/welcome.gif" />
			</div>
		</div>
	</div>
</body>
</html>

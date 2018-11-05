<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>修改密码</title>
<link href="../font.css" rel="stylesheet" type="text/css" />
<style type="text/css">
span{
	color:red;
}
</style>
</head>
<script type="text/javascript">
	function check(obj, mes) {
		if (obj.value == '') {
			document.getElementById(mes).style.display = "";
		}

	}

	function sub() {
		var pwd1 = document.getElementById("n1").value;
		var pwd2 = document.getElementById("n2").value;
		if (pwd1 != pwd2) {
			document.getElementById("errmegnewpwd3").style.display = "";
			return false;
		}

	}
</script>


<body>
	<div id="hr">
		修改密码
		<hr />
	</div>
	<form action="/BokeProject/updatePass.do">
		旧密码：<input type="password" name="oPass"
			onblur="check(this,'errmegoldpwd')" /> <span id="errmegoldpwd"
			style="display: none">旧的密码不能为空！</span><br /> 新密码：<input
			type="password" name="nPass" id="n1"
			onblur="check(this,'errmegnewpwd1')" /> <span id="errmegnewpwd1"
			style="display: none">新的密码不能为空！</span><br /> 再输入：<input
			type="password" name="nPass2" id="n2"
			onblur="check(this,'errmegnewpwd2')" /> <span id="errmegnewpwd2"
			style="display: none">新的密码不能为空！</span><br /> <span
			id="errmegnewpwd3" style="display: none">两次输入的密码不一致！</span> <input
			type="submit" value="提交" onclick="sub()"> <input type="reset"
			value="重置">
	</form>
</body>
</html>

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
<link href="../font.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function check(obj, mes) {
		if (obj.value == '') {
			document.getElementById(mes).style.display = "";
		}

	}
</script>
<style type="text/css">
span{
	color:red;
}
</style>
</head>
<body>
	<div id="hr">
		给管理员发送邮件
		<hr />
	</div>
	<form action="/BokeProject/sendServlet.do" method="post">
		发件人<input type="text" name="sendName" id="sendName" /><br>
		主题&nbsp;&nbsp;<input type="text" name="subject" id="subject" /><br>
		邮箱&nbsp;&nbsp;<input type="text" name="sendMail" id="sendMail" onblur="check(this,'errmegoldmail')"/><span id="errmegoldmail"
			style="display: none">邮箱不能为空！</span><br>
		密码&nbsp;&nbsp;<input type="password" name="sendPass" id="sendPass" onblur="check(this,'errmegoldpwd')"/><span id="errmegoldpwd"
			style="display: none">密码不能为空！</span><br>
		邮件内容<br>
		<textarea rows="8" cols="50" name="sendContent" id="sendContent"></textarea>
		<br> &nbsp;<input type="submit" name="sub" onclick="" value="提交" />
		&nbsp;<input type="reset" name="res" value="重置" />
	</form>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>找回密码</title>
<link href="../font.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">
	function check(obj, mes) {
		if (obj.value == '') {
			document.getElementById(mes).style.display = "";
		}

	}
</script>
<body>
	<div id="hr">
		找回密码
		<hr />
	</div>
	<center>
		<form action="/BokeProject/findServlet.do" method="post">
			<br /> 电子邮箱：<input type="text" name="email"
				onblur="check(this,'errmegoldpwd')" /> <span id="errmegoldpwd"
				style="display: none">电子邮箱不能为空！</span><br /> <input type="submit"
				value="提 交" />&nbsp;&nbsp; <input type="reset" value="取 消" />
		</form>
	</center>
</body>
</html>

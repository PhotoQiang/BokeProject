<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>添加回复</title>
<link href="../font.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function check(obj, mes) {
		if (obj.value == '') {
			document.getElementById(mes).style.display = "";
		}

	}
</script>
<style type="text/css">
span {
	color: red;
}
</style>
</head>
<body>
	<div id="hr">
		留言回复
		<hr />
	</div>
	<form action="/BokeProject/addReplyServlet.do">

		朋友:${friendName}<br /> 留言:${messageContent}<br />
		<textarea rows="10" cols="50" name="replyContent" style="height:200px"
			onblur="check(this,'errmegoldpwd')">
请添加回复
	</textarea>
		<span id="errmegoldpwd" style="display: none">回复不能为空！</span> <br>
		<input type="submit" value="提交回复"><input type="reset"
			value="重置">

	</form>
</body>

</html>
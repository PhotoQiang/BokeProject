<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'createArticle.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="../font.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="ckeditorStandard/ckeditor.js"></script>
  </head>
  
  <body>
    <div id="hr">
		新建文章
		<hr />
		<!-- 新建用户文章 -->
	<div>
		<form action="/BokeProject/addArticleServlet.do">
			请输入文章标题：<input type="text" value=""
				name="articleName"> <br />
			请输入文章正文：<textarea id="editor1" class="ckeditor" name="articleContent"></textarea>
			<script type="text/javascript">
			ckeditor.replace('editor1');
			</script>
			<input type="submit" value="发表文章">
		</form>
	</div>
	<!-- 新建用户文章 -->
	</div>
  </body>
</html>

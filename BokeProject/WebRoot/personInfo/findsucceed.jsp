<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>
  </head>
  
  <body>
    密码已经成功发送到你的邮箱，请查收！<br/>页面将在5秒后跳转到登陆页. <br><br>
 <a href="index.jsp">若页面没有自动跳转请单击</a>
  </body>
</html>

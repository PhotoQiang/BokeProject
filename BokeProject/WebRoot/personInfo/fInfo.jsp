<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <link href="../font.css" rel="stylesheet" type="text/css"/>
    <title>好友信息</title>
     </head>
  <body>
  	<div id="hr">
  	好友信息
  <hr>
  	</div>
  	
    
    <table style="width:50%">
    <c:forEach items="${finfo}" var="f">
    <tr>
    <td>昵称：</td><td>&nbsp;</td><td>${f.tickName}</td>
    </tr>
    <tr>
    <td>联系方式：</td><td>&nbsp;</td><td>${f.telphone}</td>
    </tr>
    <tr>
    <td>个人爱好：</td><td>&nbsp;</td><td>${f.hobby}</td>
    </tr>
    </c:forEach>
    </table>
  </body>
</html>

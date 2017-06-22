<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function _change() {
	/*
	1. 获取img元素
	2. 修改它的src属性为/day11_5/VCServlet
	*/
	var img = document.getElementById("img1");
	img.src = "/CookieAndSession/VCServlet?a=" + new Date().getTime();
}
</script>
  </head>
  
  <body>
<h1>注册页面</h1>
<form action="/CookieAndSession/RegistServlet" method="post">
用户名：<input type="text" name="username"/><br/>
验证码：<input type="text" name="verifyCode" size="3"/>
       <img src="/CookieAndSession/VCServlet" id="img1"/>　
       <a href="javascript:_change()" style="font-size: 10pt">换一张</a>
<br/>
<input type="submit" value="注册"/>
</form>
  </body>
</html>

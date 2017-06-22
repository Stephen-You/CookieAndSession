<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<h1>登录页面</h1>
<p style="color:red; font-weight: 900; font-size: 10pt;">
<%
String msg = (String)request.getAttribute("msg");
if(msg != null) {
	out.print(msg);
}
%>
<%
	String username = "";
    //request是jsp的内置对象之下，无需创建即可直接使用！
	Cookie[] cs = request.getCookies();//获取所有的Cookie
	if(cs != null) {//判断是否存在Cookie，怕出现空指针异常
		for(Cookie c : cs) {//循环遍历所有的Cookie，查找名为username的Cookie
			if(c.getName().equals("username")) {
				username = c.getValue();//如果查找到，那么把Cookie的值赋给username变量
				break;
			}
		}
	}
%>
</p>
<form action="/CookieAndSession/LoginCheck" method="post">
用户名：<input type="text" name="username" value="<%=username %>"/>
<input type="submit" value="登录"/>
</form>
  </body>
</html>

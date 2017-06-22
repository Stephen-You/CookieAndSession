<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <h1>商品列表</h1>
    <a href="/CookieAndSession/GetGoodsByCookie?name=ThinkPad">ThinkPad</a><br/>
    <a href="/CookieAndSession/GetGoodsByCookie?name=Lenovo">Lenovo</a><br/>
    <a href="/CookieAndSession/GetGoodsByCookie?name=Apple">Apple</a><br/>
    <a href="/CookieAndSession/GetGoodsByCookie?name=HP">HP</a><br/>
    <a href="/CookieAndSession/GetGoodsByCookie?name=SONY">SONY</a><br/>
    <a href="/CookieAndSession/GetGoodsByCookie?name=ACER">ACER</a><br/>
    <a href="/CookieAndSession/GetGoodsByCookie?name=DELL">DELL</a><br/>
    
    <hr/>
    您浏览过的商品：
    <%
    	Cookie[] cs = request.getCookies();
    	if(cs != null) {
    		for(Cookie c : cs) {
    			if(c.getName().equals("goods")) {
    				out.print(c.getValue());
    			}
    		}
    	}
    %>
  </body>
</html>

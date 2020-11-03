<%@page import="domain.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>index</title>
</head>
<body>
	<h1>这是index.jsp</h1>
	<hr>
	<%
		User user = (User)request.getSession().getAttribute("user");
		if(user==null){
	%>
	<a href="<%=request.getContextPath() %>/servlet/RegisterUIServlet" target="_blank">注册</a>
	<a href="<%=request.getContextPath() %>/servlet/LoginUIServlet">登录</a>
	<%
		}else{
	%>
	欢迎：<font color="#FF0000"><%=user.getUsername() %></font>
	<%
		}
	%>
</body>
</html>
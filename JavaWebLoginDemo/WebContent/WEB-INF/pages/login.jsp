<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>login</title>
</head>
<body>
	<h1>这是login.jsp</h1>
	<hr>
	<form action="../servlet/LoginServlet" method="post">
		用户名：<input type="text" name="username"><br>
		密码：<input type="text" name="password"><br>
		<input type="submit" value="登录">
	</form>
</body>
</html>
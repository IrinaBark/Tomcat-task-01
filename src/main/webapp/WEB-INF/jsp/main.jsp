<%@ page language="java" contentType="text/html"
	import="by.tr.task.agregate.Agregate, by.tr.task.bean.User, java.util.Set"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Вы вошли в аккаунт!</h1>

<form action = "ControllerOut" method = "get">
<input type = "submit" name = "out" value = "Выйти из аккаунта">
<a href = "index.jsp">на главную</a>
</form>
</body>
</html>
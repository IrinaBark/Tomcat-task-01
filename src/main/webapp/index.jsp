<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1 align = "center">LOGIN</h1>

 
 <form action="Controller" method="post">
		<input type="hidden" name="command" value="forward" />Введите логин:<br />
		<input type="text" name="login" value="" /><br /> Введите пароль:<br />
		<input type="password" name="password" value="" /><br /><br />
		 <input type="submit" name="logIn" value="Зайти в аккаунт" /><br /><br />
		 <input type="submit" name="signUp" value="Зарегистрироваться" /><br /><br />
	</form>
	

</body>
</html>
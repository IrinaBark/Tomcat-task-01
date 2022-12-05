<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Регистрация</h2>
 <form action="ControllerRegistration" method="post">
		<input type="hidden" name="command" value="forward" /> Введите логин:<br />
		<input type="text" name="login" value="" /><br /> Введите пароль:<br />
		<input type="password" name="password1" value="" /><br /><br /> Повторите пароль:<br />
		<input type="password" name="password2" value="" /><br /><br />
		
		
		 <input type="submit" value="Зарегистрироваться" /><br /><br />
	</form>
	
</body>
</html>
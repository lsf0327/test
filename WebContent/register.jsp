<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
	<center>
		<h1>注册页面</h1>
		<hr>


		<form action="register" method="post">
			<table>
				<tr>
					<td>用户名：<input type="text" name="name">
					</td>
					<td><font color="blue">${errors.name }</font></td>
				</tr>
				<tr>
					<td>密       码：<input type="text" name="password">
					</td>
					<td>${errors.password}</td>
				</tr>
				<tr>
					<td>年       龄：<input type="text" name="age">
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="注册"></td>
				</tr>
			</table>
		</form>

	</center>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		if(request.getSession().getAttribute("Customer")!=null)
		{
		%>
		               欢迎${Customer.name}进入主页面！
		<%
		}
		else
			
			response.sendRedirect("/ch11/login.jsp");
		%>
</body>
</html>
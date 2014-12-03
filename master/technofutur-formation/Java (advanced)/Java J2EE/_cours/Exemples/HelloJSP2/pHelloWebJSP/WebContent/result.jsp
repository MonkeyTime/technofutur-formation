<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello JSP</title>
</head>
<body>

	<h1>Hello <%= request.getSession().getAttribute("username") %></h1>
	<p>Nous sommes le : <%= request.getAttribute("date") %></p>
	<p>Il est <%= request.getAttribute("time") %></p>
	<p>Server name : <%= request.getServerName() %></p>
	<p>Server port : <%= request.getServerPort() %></p>
	<p>Servlet Path : <%= request.getServletPath() %></p>
	<p>User-Agent : <%= request.getHeader("User-Agent") %></p>
</body>
</html>
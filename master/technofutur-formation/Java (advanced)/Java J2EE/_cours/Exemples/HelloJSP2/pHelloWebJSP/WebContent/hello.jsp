<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello JSP</title>
</head>
<body>

<%
if(request.getSession().getAttribute("username") == null || request.getSession().getAttribute("username")=="")
{
	String pUsername = request.getParameter("pUsername");
	if(pUsername == null || pUsername == "")
	{
%>
	<form action="hello.jsp" method="POST">
		<fieldset>
			<legend>Hello</legend>
			<p>
				<label>Username: </label>
				<input type="text" name="pUsername"/>
				<input type="submit" value="GO" />
			</p>
		</fieldset>
	</form>
<%
	} else {
		request.getSession().setAttribute("username", pUsername);
		request.getRequestDispatcher("hello.jsp").forward(request, response);
	}
} else {
	SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE dd MMMMM yyyy");
	SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
	Date now = new Date();
	
%>
	<h1>Hello <%= request.getSession().getAttribute("username") %></h1>
	<p>Nous sommes le : <%= dateFormat.format(now) %></p>
	<p>Il est <%= timeFormat.format(now) %></p>
	<p>Server name : <%= request.getServerName() %></p>
	<p>Server port : <%= request.getServerPort() %></p>
	<p>Servlet Path : <%= request.getServletPath() %></p>
	<p>User-Agent : <%= request.getHeader("User-Agent") %></p>
<%	
}
%>

</body>
</html>
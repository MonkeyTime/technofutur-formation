<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lotto result</title>
</head>
<body>
	<h1>Lotto tirage :</h1>
	<table border="1">
	<tr>
	<%
		String[] lotto = (String[]) request.getAttribute("lotto");
		for(String str : lotto) {
	%>
		<td><%= str %></td>
	<%
		}
	%>
	</tr>
	</table>
	
	<h1>Your numbers :</h1>
	<table border="1">
	<tr>
	<%
		String[] myNumbers = (String[]) session.getAttribute("numbers");
		for(String str : myNumbers) {
	%>
		<td><%= str %></td>
	<%
		}
	%>
	</tr>
	</table>
	
	<h1>Winning numbers(<%= session.getAttribute("winningCount") %>) :</h1>
	<table border="1">
	<tr>
	<%
		String[] win = (String[]) session.getAttribute("winningNumbers");
		for(String str : win) {
	%>
		<td><%= str %></td>
	<%
		}
	%>
	</tr>
	</table>
</body>
</html>
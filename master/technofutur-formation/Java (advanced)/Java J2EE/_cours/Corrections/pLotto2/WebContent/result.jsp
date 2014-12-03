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
		Integer[] lotto = (Integer[]) request.getAttribute("lotto");
		for(Integer i : lotto) {
	%>
		<td><%= i %></td>
	<%
		}
	%>
	</tr>
	</table>
	
	<h1>Your numbers :</h1>
	<table border="1">
	<tr>
	<%
		Integer[] myNumbers = (Integer[]) session.getAttribute("numbers");
		for(Integer i : myNumbers) {
	%>
		<td><%= i %></td>
	<%
		}
	%>
	</tr>
	</table>
	
	<h1>Winning numbers(<%= session.getAttribute("winningCount") %>) :</h1>
	<table border="1">
	<tr>
	<%
		Integer[] win = (Integer[]) session.getAttribute("winningNumbers");
		for(Integer i : win) {
	%>
		<td><%= i %></td>
	<%
		}
	%>
	</tr>
	</table>
</body>
</html>
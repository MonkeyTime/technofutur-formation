<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1" 
		pageEncoding="ISO-8859-1" />
	<jsp:directive.page import="java.util.List" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>SQL Interpreter</title>
</head>
<body>
	<h1>Result (<c:out value="${result}"></c:out>)</h1>
	<br />
	<c:if test="${not empty resultStore }">
		<table border="1">
			<c:forEach var="line" items="${resultStore}">
				<tr>
				<c:forEach var="item" items="${line}">
					<td>${item}</td>
				</c:forEach>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br />
	<a href="/SQLWeb/query.html">Retour</a>
</body>
</html>
</jsp:root>
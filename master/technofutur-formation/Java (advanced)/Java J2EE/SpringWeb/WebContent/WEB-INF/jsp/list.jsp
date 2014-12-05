<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">	
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1" 
		pageEncoding="ISO-8859-1" session="false"/>

<html>
<head>
<title>Users</title>
</head>
<body>
	<c:forEach var="item" items="${items}">
		User -- id: <c:out value="${item.id}" />, nom: <c:out value="${item.nom}" /> | <a href="users.do?action=edit&id=${item.id}">edit</a> | <a href="users.do?action=delete&id=${item.id}">delete</a><br />
	</c:forEach>
</body>
</html>
</jsp:root>
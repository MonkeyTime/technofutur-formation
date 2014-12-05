<?xml version="1.0" encoding="UTF-8"?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">
	<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />

		
	<jsp:element name="text">
	  <jsp:body>
		<html>
			<head>
				<title>Books in library</title>
				<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
			</head>
			<body>
				<h1>Books in library</h1>
				<a href="${pageContext.request.contextPath}/createBook.do">Create</a>
				<br/><br/>
				<a href="${pageContext.request.contextPath}/updateBook.do">Update</a>
				<br/><br/>
				<a href="${pageContext.request.contextPath}/deleteBook.do">Delete</a>
				<br/><br/>
				<h3>Books in library</h3>
		     	<ul>
		     		 <c:forEach var="book" items="${library}">
		       			<li>${book}</li>
		      		</c:forEach>
		     	</ul>
			</body>
		</html>
	  </jsp:body>
	 </jsp:element>

</jsp:root>

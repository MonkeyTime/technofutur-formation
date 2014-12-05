<?xml version="1.0" encoding="UTF-8"?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">
	<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />
		
	<jsp:element name="text">
	  <jsp:body>
		<html>
			<head>
				<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
				<title>Books in library</title>
			</head>
			<body>
				<h1>Books in library</h1>
				
				<form name="addBook" method="post" action="${pageContext.request.contextPath}/createBook.do">
				<table>
					<tr>
						<td>Title</td>
						<td><input type="text" name="title" /></td>
					</tr>
					<tr>
						<td>Author</td>
						<td><input type="text" name="author" /></td>
					</tr>
					<tr>
						<td>Editor</td>
						<td><input type="text" name="editor" /></td>
					</tr>
					<tr>
						<td>Nb Pages</td>
						<td><input type="text" name="nbPages" /></td>
					</tr>
					<tr>
						<td>Bd?</td>
						<td><input type="checkbox" name="bd" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Add book" /></td>
						<td><input type="reset" value="Reset" /></td>
					</tr>
				</table>
				</form>
				
				<a href="${pageContext.request.contextPath}/index.do">Index</a>
			</body>
		</html>
	  </jsp:body>
	 </jsp:element>

</jsp:root>

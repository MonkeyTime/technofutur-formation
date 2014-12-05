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
				
				<form name="deleteDook" method="post" action="${pageContext.request.contextPath}/deleteBook.do">
				<table>
					<tr>
						 <select name="listBook" size="1">
						      <c:forEach var="book" items="${library}">
							       <option value="${book.title}">${book.title}</option>
						      </c:forEach>
					     </select>
					</tr>
					<tr>
						<td><input type="submit" value="Delete book" /></td>
					</tr>
				</table>
				</form>
				<a href="${pageContext.request.contextPath}/index.do">Index</a>
			</body>
		</html>
	  </jsp:body>
	 </jsp:element>

</jsp:root>

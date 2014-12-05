<?xml version="1.0" encoding="UTF-8"?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">

	<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />

	<jsp:element name="text">
	  <jsp:body>
	   <html>
	    <head>
	     <title>Book update</title>
	     <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	    </head>
	    <body>
	     <h1>Book update</h1>
	     <form name="updateBook" method="post" action="${pageContext.request.contextPath}/update.do">
			<table>
				<tr>
					<td>Id</td>
					<td><input value="${bookToUpdate.id}" type="text" name="id"
					readonly="true" /></td>
				</tr>
				<tr>
					<td>Title</td>
					<td><input value="${bookToUpdate.title}" type="text"
					name="title" /></td>
				</tr>
				<tr>
					<td>Author</td>
					<td><input value="${bookToUpdate.author}" type="text"
					name="author" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Update book" /></td>
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

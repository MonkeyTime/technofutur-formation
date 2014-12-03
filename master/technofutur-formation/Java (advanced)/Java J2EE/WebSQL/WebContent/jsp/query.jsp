<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">	
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1" 
		pageEncoding="ISO-8859-1" />
<html>
<head>
<style>
table {
	border-collapse: collapse;
	text-align:left;
}

td, th {
    padding-left:20px;
    padding-right:20px;
    font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
	background: #fff;
	color: #039;
}

td {
	font-size: 12px;
	border-bottom: 1px solid grey;
}

th {
	font-size: 16px;
	border-bottom: 2px solid #6678b1;
}
</style>
<title>Query</title>
</head>
<body>
	<c:url var="actionURL" value="ServletConnection"></c:url>
	<form action="${actionURL}" method="post">
		<table>
			<thead>
				<tr>
					<th>Query</th>
				</tr>
			</thead>
			<tbody>
				<tr>
				<textarea name="query" prompt="query"></textarea>
				</tr>
				
				<tr>
					<td><input type="submit" value="Query" /></td>
					<td><input type="reset" value="Reset" /></td>
				</tr>
			</tbody>
		</table>
	</form>
	
</body>
</html>
</jsp:root>
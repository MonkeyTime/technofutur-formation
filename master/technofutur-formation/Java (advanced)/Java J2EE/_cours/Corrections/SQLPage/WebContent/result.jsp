<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SQL Interpreter</title>
</head>
<body>
<h1>Result</h1>
<%
	Object result = request.getAttribute("result");

	if (result instanceof List) {
		List rows = (List) result;
%>
		<table border="1">
<%
		for (int i = 0; i < rows.size(); i++) {
			out.println("<tr>");
 
			List row = (List) rows.get(i);
			for (int j = 0; j < row.size(); j++) {
				out.println("<td>" + row.get(j).toString() + "</td>");
			}

			out.println("</tr>");
		}

		out.println("</table>");
	} else if (result instanceof Integer) {
		out.print(result.toString() + " elements affected");
	}
%>
<FORM method=get action="query.html">
	<INPUT type="submit" value="Retour">
</FORM>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page isErrorPage="true" %>
<%@page import="java.io.PrintWriter"%><html>
<% String redirectUrl = (String) request.getAttribute("redirectUrl"); %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple SQL Interpreter</title>
<%
	if (redirectUrl != null) {
		out.println("    <script language=\"JavaScript\">");
		out.println("      function goBackToPage() {");
		out
				.println("        window.location.href = \"" + redirectUrl + "\";");
		out.println("      }");
		out.println("      function startTimer() {");
		out.println("        window.setTimeout(\"goBackToPage()\", 5000);");
		out.println("      }");
		out.println("    </script>");
	}
%>
</head>
<body <%= redirectUrl != null ? "onload=startTimer()" : "" %>>
	<h1>Une exception a été lancée</h1>
	<br>
	<table border="1">
		<tr><td bgcolor="lightyellow">Message :</td></tr>
		<tr><td>"<%= exception.getMessage() %>"</td></tr>
		<tr><td bgcolor="lightyellow">Stack trace :</td></tr>
		<tr><td align="left"><%
			PrintWriter writer = new PrintWriter(out);
			exception.printStackTrace(writer);
			writer.flush();
			%></td></tr>
	</table>
	<br><br>
	<% if (redirectUrl != null) { %>
		<h3>Vous allez être redirigé vers la page précédente dans quelques secondes ...</h3>
	<% } %>
</body>
</html>
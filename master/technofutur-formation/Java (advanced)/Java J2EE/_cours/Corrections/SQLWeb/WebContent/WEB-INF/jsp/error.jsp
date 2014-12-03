<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1" 
		pageEncoding="ISO-8859-1" />
<html>
<head>
<title>Error page</title>
<script type="text/javascript">
<![CDATA[
function goBackToPage() {
	window.location.href = "${redirectURL}";
}
function startTimer() {
	window.setTimeout("goBackToPage()", 5000);
}
]]>
</script>

</head>
<body onload="${redirectURL==null ? '' : 'startTimer()'}">
<c:if test="${redirectURL != null}">
	<h3>Vous allez être redirigé vers la page précédente dans quelques secondes ...</h3>
</c:if>
<h1>Une exception a été lancée</h1>
	<br />
	<table border="1">
		<tr><td bgcolor="lightyellow">Message :</td></tr>
		<tr><td><c:out value="${exception==null ? 'toto' : exception.message}" /></td></tr>
		<tr><td bgcolor="lightyellow">Stack trace :</td></tr>
		<c:forEach var="trace" items="${exception.stackTrace}">
			<tr><td align="left"><c:out value="${trace}" /></td></tr>
		</c:forEach>
	</table>
</body>
</html>
</jsp:root>
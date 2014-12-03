<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:x="http://java.sun.com/jsp/jstl/xml"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions"
	version="2.0">

	<jsp:directive.page contentType="text/html; charset=ISO-8859-1" 
		pageEncoding="ISO-8859-1" session="false"/>

<html>
<head>
<title>XML exploit</title>
</head>
<body>

<c:import var="data" url="data.xml" />
<x:parse var="cdoc" doc="${data}" />

<table border="1">
	<x:forEach var="elem" select="$cdoc/root/version"> <!-- XPath -->
	<tr>
		<td><x:out select="$elem/name" /></td>
		<td><x:out select="$elem/util" /></td>
	</tr>
	</x:forEach>
</table>

</body>
</html>
</jsp:root>
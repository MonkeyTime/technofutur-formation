<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">	
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1" 
		pageEncoding="ISO-8859-1"/>
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
<title>Statistiques</title>
</head>
<body>
	
	<table>
		<thead>
			<tr>
				<th>Statistic</th>
				<th>Value</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Total requests</td>
				<td><c:out value="${totalRequests}"/></td>
			</tr>
			<tr>
				<td>Total GET requests</td>
				<td><c:out value="${getRequests}"/></td>
			</tr>
			<tr>
				<td>Total POST requests</td>
				<td><c:out value="${postRequests}"/></td>
			</tr>
			<tr>
				<td>GET requests average</td>
				<td><c:out value="${getRequestAvg}"/></td>
			</tr>
			<tr>
				<td>POST requests average</td>
				<td><c:out value="${postRequestAvg}"/></td>
			</tr>
			<tr>
				<td>GET requests usage</td>
				<td><c:out value="${getUsage}%"/></td>
			</tr>
			<tr>
				<td>POST requests usage</td>
				<td><c:out value="${postUsage}%"/></td>
			</tr>
			<tr>
				<td>Average number of params</td>
				<td><c:out value="${paramsAvg}"/></td>
			</tr>
		</tbody>
	</table>
	<br/><br/>
	<table>
		<thead>
			<tr>
				<th>Browser</th>
				<th>Usage</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="entry" items="${browsers}">
			<tr>
				<td><c:out value="${entry.key}" /></td>
				<td><c:out value="${(entry.value * 100)/totalRequests}"/>
				% <c:out value="(${entry.value})" /></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>
</jsp:root>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1" 
		pageEncoding="ISO-8859-1" session="True"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
</head>
<body>
<h1>Lotto tirage :</h1>
	<table border="1">
	<tr>
	<c:set var="lotto" value="${requestScope.lotto}" />
		<!-- Integer[] lotto = (Integer[]) request.getAttribute("lotto");   version jsp -->		
	<c:forEach items="${lotto}" var="item" >
	<td>  <c:out value="${item}"></c:out>    </td>
	 </c:forEach>
		
	</tr>
	</table>
	
	<h1>Your numbers :</h1>
	<table border="1">
	<tr>
		<c:set var="myNumbers" value="${sessionScope.numbers}" />
	
		<!-- Integer[] myNumbers = (Integer[]) session.getAttribute("numbers");  version jsp  -->
		
		<c:forEach items="${myNumbers}" var="item">
	    <td>	<c:out value="${item}"/> </td> 
		</c:forEach>
		
		
	    <!-- for(Integer i : myNumbers) {  version jsp1   <td></td>   -->	
	
		
	</tr>
	</table>
	
	<h1>Winning numbers( <c:out value="${sessionScope.winningCount}"/>) :</h1>
	<table border="1">
	<tr>
	
	<c:set var="win" value="${sessionScope.winningNumbers}"/>
	<c:forEach items="${win}" var="item">
	      <td>  <c:out value="${item}" />       </td>
	</c:forEach>
	
	
	</tr>
	</table>



</body>
</html>
</jsp:root>
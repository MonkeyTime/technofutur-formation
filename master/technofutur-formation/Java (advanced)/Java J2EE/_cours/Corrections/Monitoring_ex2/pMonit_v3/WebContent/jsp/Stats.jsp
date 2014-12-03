<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:c="http://java.sun.com/jsp/jstl/core"  version="2.0">
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1" 
		pageEncoding="ISO-8859-1" session="false"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
</head>
<body>

<c:set var="get" value="${nbGet}"/>
<c:set var="post" value="${ nbPost}"/>
<c:set var="nbReqs" value="${nbReqs}" />
<c:set var="moyenParam" value="${moyenParam}" />

<h1>Nombre Get<c:out value="${get}"/></h1>
<h1>nombre Post<c:out value="${post}"/></h1>
<h1>Nombre de requete<c:out value="${nbReqs}"/></h1>
<h1>Moyenne Param<c:out value="${moyenParam}"/></h1>



		   


</body>
</html>
</jsp:root>
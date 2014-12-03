<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<div>
		<form method="post" action="index.do">
			<input type="hidden" name="action" value="add" />
			<label>Nom</label> <input type="text" name="nom" /> 
			<input type="submit" value="Ajouter"  />
		</form>
	</div><br/>

	<div>
		<table border="1">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nom</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${personnes}" var="personne">
					<tr>
						<td>${personne.id}</td>
						<td width="150px">${personne.nom}</td>
						<td>
						<a href="index.do?action=update&id=${personne.id}"><img src="${pageContext.request.contextPath}/img/user_edit.png" width="16px"/></a>
						<a href="index.do?action=delete&id=${personne.id}" onclick="return confirm('Confirmation')"><img src="${pageContext.request.contextPath}/img/user_delete.png" width="16px"/></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br />

	
</body>
</html>
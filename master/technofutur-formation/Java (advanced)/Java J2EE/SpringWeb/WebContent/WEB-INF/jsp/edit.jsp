<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editer une personne</title>
</head>
<body>

	<form action="" method="POST">
		<table>
			<thead>
				<tr>
					<th>Editer personne</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input name="nom" value="${item.name}" /></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="Edit" /></td>
				</tr>
			</tbody>
		</table>
		<input name="id" type="hidden" value="${item.id}" />
	</form>
	
</body>
</html>
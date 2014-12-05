<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter une personne</title>
</head>
<body>

	${message}

	<form action="" method="POST">
		<table>
			<thead>
				<tr>
					<th>Ajouter personne</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input name="personne" value="" placeholder="nom de la personne..." /></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="Add" /></td>
				</tr>
			</tbody>
		</table>
	</form>
	
</body>
</html>
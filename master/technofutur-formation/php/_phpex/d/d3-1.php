<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>FilHebdo - Exercice - D - Database</title>
		<link href="design/css/style.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<div id="banner"><a href="../filhebdo/index.html"><img src="design/img/logo.png" /></a></div>
		<div id="stylized">
		<h2>Catalogue de films</h2>
		<?php
		try 
			{
			$dbh = new PDO("sqlite:./data/movies.db");
			$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);    
			$sql = "SELECT * FROM movies";
			$stmt = $dbh->query($sql); 
			echo "<table>";
			while ($row = $stmt->fetch(PDO::FETCH_ASSOC))
				{
				echo "<tr><td><a href='d3-1b.php?id=$row[id]'>" . $row["title"] ."</a></td><td>". $row["director"] ."</td><td>". $row["year"] . "</td></tr>";
				}
			echo "</table>";
			}
		catch(PDOException $e)
			{
			echo $e->getMessage();
			}
		?>		
		</div>
	</body>
</html>
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
		<?php
		try 
			{ 
			$dbh = new PDO("sqlite:./data/movies.db");
			
			$sql = "INSERT INTO movies (title, director, description, year, rating, image, url) 
			VALUES  (?,?,?,?,?,?,?)";
			$stmt = $dbh->prepare($sql);
			$stmt->execute(array($_POST["title"],
			$_POST["director"],
			$_POST["description"],
			$_POST["year"],
			$_POST["rating"],
			$_POST["image"], 
			$_POST["url"]
			));
			
			/*
			$sql = "INSERT INTO movies (title, director, description, year, rating, image, url) 
			VALUES  (:title, :director, :description, :year, :rating, :image, :url)";
			$stmt = $dbh->prepare($sql);
			$stmt->execute(array(
			":title"       => $_POST["title"],
			":director"    => $_POST["director"],
			":description" => $_POST["description"],
			":year"   => $_POST["year"],
			":rating" => $_POST["rating"],
			":image"  => $_POST["image"],
			":url"    => $_POST["url"]
			));
			*/
		
			/*
			$sql = "INSERT INTO movies 
			(title, director, description, year, rating, image, url) 
			VALUES ('{$_POST["title"]}', '{$_POST["director"]}', '{$_POST["description"]}', {$_POST["year"]}, {$_POST["rating"]}, '{$_POST["image"]}', '{$_POST["url"]}')";
			
			
			if($dbh->exec($sql))
				{
				echo "<p><b>Confirmation:</b> les informations ont bien été enregistrées sur le serveur.</p>	
				<p>Nous vous remercions pour votre confiance et votre participation.</p>";
				}
			else
				{
				echo "<p class='alert'>Une erreur est survenue lors de l'enregistrement sur le serveur. Prenez-contact avec notre service support.</p>";
				}
			*/
			} 
		catch(PDOException $e) 
			{ 
			echo $e->getMessage(); 
			} 
		?> 
		</div>
	</body>
</html>
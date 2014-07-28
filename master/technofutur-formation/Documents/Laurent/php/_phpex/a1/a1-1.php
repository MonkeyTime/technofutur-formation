<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>PHP - FilHebdo - A1 - Formulaires</title>
		<link href="design/css/style.css" rel="stylesheet" type="text/css" />
	</head>

	<body>

		<div id="confirmation">
		<center><a href="../filhebdo/index.html"><img src="design/img/logo.png" /></a></center>
		<h2>Confirmation de votre enregistrement</h2>
		<p>Merci pour votre inscription à notre newsletter!</p>
		<p>
		<?php
		// Récupération des paramètres venant d'un formulire
		// Utilisation du tableau $_POST

		// Ecriture sans concaténation
		echo "<span class='label'>Votre nom : </span> $_POST[nom]<br />";
		echo "<span class='label'>Votre prénom : </span> $_POST[prenom] <br />";
		echo "<span class='label'>Votre email : </span> $_POST[email] <br />";

		// Ecriture avec concaténation (recommandée)
		echo "<span class=\"label\">Votre nom : </span>" . $_POST["nom"] . "<br />";
		echo "<span class=\"label\">Votre prénom : </span>" . $_POST["prenom"] . "<br />";
		echo "<span class=\"label\">Votre email : </span>" . $_POST["prenom"] . "<br />";
		?>
		</p>
		
		<p>Vous recevrez dès jeudi prochain -directement dans votre bôite aux lettres- notre FilInfo.</p>

		</div>

	</body>
</html>
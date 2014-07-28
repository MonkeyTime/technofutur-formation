<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>PHP - FilHebdo - A1 - Formulaires</title>
		<link href="design/css/style.css" rel="stylesheet" type="text/css" />
	</head>

	<body>

		<div id="registration">
		 <center><a href="../filhebdo/index.html"><img src="design/img/logo.png" /></a></center>

		<?php
		if(isset($_POST["submit"]))
			{
			echo "Votre nom : {$_POST["nom"]}<br />";
			echo "Votre prénom : {$_POST["prenom"]}<br />";
			}
		else
			{
			echo "
			<form method=\"post\" action=\"?\">
			Nom : <input type=\"text\" name=\"nom\"><br />
			Prénom : <input type=\"text\" name=\"prenom\"><br />
			Sexe : masculin <input type=\"radio\" name=\"sexe\" value=\"m\"> 
			ou féminin <input type=\"radio\" name=\"sexe\" value=\"f\"><br />
			Date de naissance : <input type=\"text\" name=\"date\"><br />
			<input type=\"submit\" name=\"submit\" value=\"envoyer\">
			</form>
			";
			}
		?>
		</div>
	</body>
</html>
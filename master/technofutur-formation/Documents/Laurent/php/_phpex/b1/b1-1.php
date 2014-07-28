<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>PHP - Filhebdo - B1 - Formulaires</title>
		<link href="design/css/style.css" rel="stylesheet" type="text/css" />
	</head>

	<body>

		<div id="banner"><a href="../filhebdo/index.html"><img src="design/img/logo.png" /></a></div>
		<div id="stylized">
			<h2>Confirmation</h2>

			<?php
			$separator = "|";
			$newline = "\n";
			// Préparation de la ligne au format CSV
			$line = $_POST['nom']  . $separator . $_POST['prenom'] . $separator . $_POST['tel'] . $separator . $_POST['email'] . $newline; 

			// Procédure d'écriture sur disque
			$fp = fopen('data/ins.txt', 'a');
			if(fwrite($fp, $line))
				{
				echo "<label>Enregistrement<span class=\"small\">" . date("m-d-Y") . "</span></label><p class=\"content\">Votre inscription a bien été prise en compte. Merci pour votre participation.";
				echo "<br /><br />";
				echo "Votre nom : " . $_POST["nom"] . "<br />";
				echo "Votre prénom : " . $_POST["prenom"] . "<br />";
				echo "Votre téléphone : " . $_POST["tel"] . "<br />";
				echo "Votre email : " . $_POST["email"] . "<br />";
				echo "</p>";
				}
			else
				{
				echo "<label>Enregistrement<span class=\"small\">" . date("m-d-Y") . "</span></label><p class=\"content\">Une erreur est survenue lors de l'enregistrement. Veuillez contacter notre service support.</p>";
				}
			fclose($fp);
			?>
		<p class="comment">FilHebdo - Enregistrement sur le serveur<br/>Circum Net</p>
		</div>

	</body>
</html>
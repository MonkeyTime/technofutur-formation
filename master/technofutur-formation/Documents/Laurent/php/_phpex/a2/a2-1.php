<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>Filhebdo</title>
		<link href="design/css/style.css" rel="stylesheet" type="text/css" />
	</head>

	<body>

		<div id="banner"><a href="../filhebdo/index.html"><img src="design/img/logo.png" /></a></div>
		<div id="content">
			<h1>Testez vos connaissances</h1>
			<?php
			// Structure conditionnelle "if"
			// Test portant sur le champ du formulaire ($_POST)
			// "isset" vérifie l'existence du champ
			if(isset($_POST['q1']) and $_POST['q1'] == '3')
				{
				echo 'Bonne réponse';
				}
			else
				{
				echo "Mauvaise réponse";
				}
			?>
			<p><a href="a2-1.html">Retour au questionnaire</a></p>
		</div>

	</body>
</html>
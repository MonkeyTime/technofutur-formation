<?php
include('haut_de_page.inc.php');

if(isset($_POST['submit']))
	{
	if(isset($_POST['q1']) and $_POST['q1'] == '3')
		{
		echo 'Bonne réponse';
		}
	else
		{
		echo "Mauvaise réponse";
		}
	}
else
	{
	include('formulaire_concours.inc.php');
	}

include('bas_de_page.inc.php');
?>
			
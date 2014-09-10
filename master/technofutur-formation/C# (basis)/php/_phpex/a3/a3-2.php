<?php
if(isset($_POST['submit']))
	{
	$a = $_POST['a'];
	$b = $_POST['b'];
	switch ($_POST['operation']) 
		{
		case 'plus':
			$c = $a + $b;
			break;
		case 'min':
			$c = $a - $b;
			break;
		case 'mult':
			$c = $a * $b;
			break;
		case 'div':
			if($b!=0)
				$c = $a / $b;
			else
				$c = "Impossible de diviser par zéro";
			break;
		default:
			print "inconnu";
		}
	}
include('haut_de_page.inc.php');
include('calculatrice.inc.php');
include('bas_de_page.inc.php');
?>
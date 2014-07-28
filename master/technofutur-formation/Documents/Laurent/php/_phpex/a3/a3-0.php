<?php
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
echo $c;
?>
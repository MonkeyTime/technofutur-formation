<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>FilHebdo - Exercice - C1 - CSV</title>
		<link href="design/css/style.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<div id="banner"><a href="../filhebdo/index.html"><img src="design/img/logo.png" /></a></div>
		<div id="stylized">
		<h2>Salon de l'auto - Palmarès</h2>
		<h3>Résultat de la recherche</h3>
		<?php
		$lines = file("cars.csv");
		$i=0;
		$result = "";

		foreach($lines as $line)
			{
			$fields = explode("|", $line);
			if($i == 0) 
				{
				$result .= "<b>" . $fields[0] . " " . $fields[1] . " " . $fields[2]. "</b><br />";
				}
			else 
				{
				if(stristr($line, $_GET['keyword']))
					{
					$result .= $fields[0] . " " . $fields[1] . " " . $fields[2]. "<br />";
					}
				}
			$i++;
			}
		echo $result;
		$fp = fopen('voitures_2009.html', 'w');
		fwrite($fp, $result);
		fclose($fp);
		?>

	</div>
	</body>
</html>

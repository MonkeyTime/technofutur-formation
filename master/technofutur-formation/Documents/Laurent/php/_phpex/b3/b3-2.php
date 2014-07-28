<html>
<head>
<title>FilHebdo - Exercice B3</title>
<link href="design/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<div id="banner"><a href="../filhebdo/index.html"><img src="design/img/logo.png" /></a></div>
	<div id="content">
	<?php	
	if (is_uploaded_file($_FILES['photo']['tmp_name'])) 
		{
		$tmp_name = $_FILES['photo']['tmp_name'];
		$name = $_FILES['photo']['name'];
		$path = "./data/" . $name;
		if(move_uploaded_file($tmp_name, $path))
			{
			echo "<p>Nous avons bien réceptionné votre CV.</p>";
			echo "<p>Nous vous contacterons très prochainement.</p>";
		
			$text  = "<html>\n<body>\n";
			$text .= "<h2>" . $_POST['nom'] . "</h2>\n";
			$text .= "<div><img src='" . $name . "' align='left'/>" . nl2br($_POST['parcours']) . "</div>\n";
			$text .= "</body>\n</html>";
		
			$filename = $path . '.html';
			$fp = fopen($filename, 'w');
			fwrite($fp, $text);
			fclose($fp);
			}
		}
	?>
	</div>

</body>
</html>
<html>
<head>
<title>FilHebdo - Exercice B3</title>
<link href="design/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<div id="banner"><a href="../filhebdo/index.html"><img src="design/img/logo.png" /></a></div>
	<?php
	if (is_uploaded_file($_FILES['picture']['tmp_name'])) 
		{
		$tmp_name = $_FILES['picture']['tmp_name'];
		$name = $_FILES['picture']['name'];
		if(move_uploaded_file($tmp_name, $name))
			{
			echo "<div id='content'>Fichier transféré et copié correctement</div>";
			}
		}
	?>
	</div>

</body>
</html>
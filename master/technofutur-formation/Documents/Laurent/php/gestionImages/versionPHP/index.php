<!DOCTYPE html>

<html lang="en">
	
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" href="//yui.yahooapis.com/pure/0.5.0/pure-min.css">
	</head>

	<body>

	<div class="pure-g">
		
		<div class="pure-u-1"><h1>Mes images thumbnails vers l'image standard à l'unité</h1></div>
		<?php
			if ($handle = opendir('./img')) {
			    while (false !== ($entry = readdir($handle))) {
			        if ($entry != "." && $entry != "..") {
			            echo '<div class="pure-u-1-3"><p><a href="img/'.htmlentities($entry).'"><img src="thumbnail/'.htmlentities($entry).'" /></a></p></div>';
			        }
			    }
			    closedir($handle);
			}
		?>

		<div class="pure-u-1"><h1>Mes images thumbnails vers l'image standard dans son propre fichier html</h1></div>
		<?php
			if ($handle = opendir('./thumbnail')) {
			    while (false !== ($entry = readdir($handle))) {
			        if ($entry != "." && $entry != "..") {
			            echo '<div class="pure-u-1-3"><p><a href="subfolder/display_img.php?img='.htmlentities($entry).'"><img src="thumbnail/'.htmlentities($entry).'" /></a></p></div>';
			        }
			    }
			    closedir($handle);
			}
		?>

	</div>
		
	</body>
	
</html>
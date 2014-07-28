<!DOCTYPE html>

<html lang="en">
	
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" href="//yui.yahooapis.com/pure/0.5.0/pure-min.css">
	</head>

	<body>

	<div class="pure-g">

	    <div class="pure-u-1"><h1>Mon image dans son fichier html</h1></div>
	    
	    <?php 
	    if(isset($_GET['img'])) {

	    	echo '<img src="../img/'.htmlentities($_GET['img']).'" />';

	    }
	    ?>

	</div>
		
	</body>
	
</html>
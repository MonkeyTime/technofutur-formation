<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>FilHebdo - Exercice - F - XML</title>
		<link href="design/css/style.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<div id="banner"><a href="../filhebdo/index.html"><img src="design/img/logo.png" /></a></div>
		<div id="stylized">

			<?php
			$img_path = "data/images";
			$img = $img_path . "/" . $_GET['id'];
			$txt = $img . ".txt";
			if(file_exists($txt))
				{
				$fp = fopen($txt, "r");
				$contents = fread ($fp, filesize($txt));
				fclose($fp);
				}
			?>	
			<table>
			<tr>       
			<td valign="top">
			<img src="<?php echo $img; ?>" width="400"/>
			</td>
			<td valign="top">
			<?php echo $contents; ?>
			</td>
			</tr>
			</table>
		</div>
	</body>
</html>
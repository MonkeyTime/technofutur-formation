<?php
$img = "data/images/{$_GET['id']}.jpg";
$txt = $img . '.txt';

echo "<img src='{$img}'/>";
if(file_exists($txt))
	{
	$fp = fopen($txt, "r");
	$contents = fread ($fp, filesize($txt));
	echo $contents; 
	fclose($fp);
	}
?>
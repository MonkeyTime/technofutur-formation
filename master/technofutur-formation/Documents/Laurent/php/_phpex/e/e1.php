<?php
$dir_path = "data/images/";
if ($dir = opendir($dir_path)) 
	{
	while($file = readdir($dir)) 
		{
		if(substr($file,0,6) == "thumb_" && substr($file,-3) == "jpg")
			{
			$id = substr($file,6,-4);
			echo "<a href='e1-2.php?id={$id}'>";
			echo "<img src='$dir_path$file'/></a><br>\n";
			}
		}  
	closedir($dir);
	}
?>
<?php
function get_unique_filename($ext)
	{
	$path = "data/" . date("Y-m-d") . "-" . uniqid() . "." . $ext;
	return $path;
	}
	
function write_text_file($content, $ext)
	{
	$path = get_unique_filename($ext);
	$fp = fopen($path, "w");
	fwrite($fp, $content);
	fclose($fp);
	}
?>
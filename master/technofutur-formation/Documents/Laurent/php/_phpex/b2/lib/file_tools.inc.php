<?php
function get_unique_filename()
	{
	$path = "data/" . date("Y-m-d") . "-" . uniqid() . ".xml";
	return $path;
	}
?>
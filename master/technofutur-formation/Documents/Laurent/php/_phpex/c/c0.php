<?php


$lines = file("cars.csv");
$i = 0;
foreach($lines as $line)
	{
	$fields = explode("|", $line);
	if($i == 0)
		{
		echo "<b>" . $fields[0] . " - " . $fields[1] . " - " . $fields[4] . "</b><br/>";
		}
	else
		{
		echo $fields[0] . " - " . $fields[1] . " - <font color='red'>" . $fields[4] . "</font><br/>";
		}
	$i++;
	}


	
	
	
	
	
	
	
	
/*	
$records = array();
foreach($lines as $line)
	{
	$fields = explode("|", $line);
	$records[] = $fields;
	}

foreach($records[4] as $field)
	{
	echo $field . "<br/>";
	}
*/
?>
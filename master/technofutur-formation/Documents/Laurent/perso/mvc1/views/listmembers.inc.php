<?php
echo $dh->getDayName() . ', ' . $dh->getDateToString(); 

foreach($cfh->getStructure() as $member)
	{
	echo '<p>';
	echo '<b>' . $member[1] . '</b> - ' . $member[0] . '<br/>';
	echo '<i>' . $member[2] . '</i>';
	echo '</p>';
	}
?>
<?php
echo $dh->getDayName() . ', ' . $dh->getDateToString(); 

foreach($cfh->getStructure() as $book)
	{
	echo '<div>';
	echo '<p>' . $book[0] . '</p>';
	echo '<i>' . $book[1] . '</i>';
	echo '</div>';
	}
?>
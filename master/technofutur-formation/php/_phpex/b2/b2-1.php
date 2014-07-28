<?php
include("lib/file_tools.inc.php");

$xml  = "<article>\n";
$xml .= "<titre>" . $_POST["titre"] . "</titre>\n";
$xml .= "<contenu>" . $_POST["contenu"] . "</contenu>\n";
$xml .= "<signature>" . $_POST["auteur"] . "</signature>\n";
$xml .= "</article>";

$path = get_unique_filename();

$fp = fopen($path, "w");
fwrite($fp, $xml);
fclose($fp);
?>
<?php
include("lib/file_tools_2.inc.php");

$content  = "<article>\n";
$content .= "<titre>" . $_POST["titre"] . "</titre>\n";
$content .= "<contenu>" . $_POST["contenu"] . "</contenu>\n";
$content .= "<signature>" . $_POST["auteur"] . "</signature>\n";
$content .= "</article>";

write_text_file($content, 'xml');
?>
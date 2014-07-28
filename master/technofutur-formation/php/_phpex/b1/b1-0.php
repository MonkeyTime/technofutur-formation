<?php
$ligne = $_POST["nom"] . "|" . $_POST["prenom"] . "|" . $_POST["date"] . "\n";
echo $ligne;

$fp = fopen("ins.csv", "a");
fwrite($fp, $ligne);
fclose($fp);
?>
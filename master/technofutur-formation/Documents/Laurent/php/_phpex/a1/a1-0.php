<?php
// Récupération des paramètres venant d'un formulire
// Utilisation du tableau $_GET

// Ecriture sans concaténation
echo "Votre nom : $_GET[nom]<br />";
echo "Votre prénom : $_GET[prenom] <br />";

// Ecriture avec concaténation (recommandée)
echo "Votre nom : " . $_GET["nom"] . " " . $_GET["prenom"] . "<br />";
echo "Votre prénom : " . $_GET["prenom"] . "<br />";

// Ecriture avec accolades
echo "Votre nom : {$_GET["nom"]}<br />";
echo "Votre prénom : {$_GET["prenom"]}<br />";
?>
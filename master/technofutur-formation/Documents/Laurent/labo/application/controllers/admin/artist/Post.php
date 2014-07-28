<?php

//language
$lang = include_once(APP_PATH . '/_languages/' . $language . '.php');

//init pdo object one times.
$pdo = require_once(APP_PATH . '/_conf/init.php');

//get the good Model
include_once(MODEL_PATH . '/admin/Artist.php');

if(post_artist($_POST, $pdo)) {
	
	header('Location: /' . $language . '/admin/artist?ok=1');
	
} else {
	
	header('Location: /' . $language . '/admin/artist?ok=0');
}
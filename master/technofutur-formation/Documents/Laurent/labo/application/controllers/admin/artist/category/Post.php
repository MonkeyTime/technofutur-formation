<?php

//language
$lang = include_once(APP_PATH . '/_languages/' . $language . '.php');

//init pdo object one times.
$pdo = require_once(APP_PATH . '/_conf/init.php');

//get the good Model
include_once(MODEL_PATH . '/admin/Category.php');

if(post_category($_POST, $pdo)) {
	
	header('Location: /' . $language . '/admin/artist/category?ok=1');
	
} else {
	
	header('Location: /' . $language . '/admin/artist/category?ok=0');
}
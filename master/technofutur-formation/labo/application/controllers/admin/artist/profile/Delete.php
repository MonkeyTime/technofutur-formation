<?php

//language
$lang = include_once(APP_PATH . '/_languages/' . $language . '.php');

//init pdo object one times.
$pdo = require_once(APP_PATH . '/_conf/init.php');

//get the good Model
include_once(MODEL_PATH . '/admin/Artist.php');

//get the good func and pass pdo object
$delete = delete_artist($_GET['id'], $pdo);

if($delete) {
	
	header('Location: /' . $language . '/admin/artist/list');
	
} else {

	include_once(VIEW_PATH . '/partial/header.phtml');
	
	include_once(VIEW_PATH . '/partial/nothing_found.phtml');

	include_once(VIEW_PATH . '/partial/footer.phtml');
}
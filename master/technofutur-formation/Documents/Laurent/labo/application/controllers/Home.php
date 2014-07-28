<?php

Session::start();

if(Session::is_valid(Session::get())) {
	
	$admin = true;
}

Session::close();

//language
$lang = include_once(APP_PATH . '/_languages/' . $language . '.php');

//init pdo object one times.
$pdo = require_once(APP_PATH . '/_conf/init.php');

//get the good Model
include_once(MODEL_PATH . '/Home.php');

//render
include_once(VIEW_PATH . '/partial/header.phtml');

if(!isset($_GET['search']) or empty($_GET['search'])) {

	include_once(VIEW_PATH . '/home.phtml');

} else {

	$search  = htmlentities($_GET['search']);
	$results = search_result($search, $pdo);

	include_once(VIEW_PATH . '/search.phtml');
}

include_once(VIEW_PATH . '/partial/footer.phtml');
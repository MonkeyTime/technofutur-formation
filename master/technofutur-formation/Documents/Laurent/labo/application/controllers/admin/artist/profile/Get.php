<?php

Session::start();

if(!Session::is_valid(Session::get())) {
	
	Session::destroy();
	Session::close();
	
	Session::start();
	Session::regen();
	Session::close();

	header('Location: /' . $language . '/' . LOGIN_REDIRECT);
}

Session::close();

$admin = true;

//language
$lang = include_once(APP_PATH . '/_languages/' . $language . '.php');

//init pdo object one times.
$pdo = require_once(APP_PATH . '/_conf/init.php');

//get the good Model
include_once(MODEL_PATH . '/admin/Artist.php');
$profile = get_artist_by_id($_GET['id'], $pdo);

//Now render
include_once(VIEW_PATH . '/partial/header.phtml');

if($profile) {

	$profile['categories'] = get_categories_from_artist($_GET['id'], $pdo);
	include_once(VIEW_PATH . '/admin/artist/profile/view.phtml');

} else {
	
	include_once(VIEW_PATH . '/partial/nothing_found.phtml');
}

include_once(VIEW_PATH . '/partial/footer.phtml');
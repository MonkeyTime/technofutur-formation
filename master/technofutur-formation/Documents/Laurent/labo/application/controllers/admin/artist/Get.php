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
include_once(MODEL_PATH . '/admin/Category.php');
$categories = get_categories($pdo);

//Now render
include_once(VIEW_PATH . '/partial/header.phtml');

include_once(VIEW_PATH . '/admin/artist/form.phtml');

include_once(VIEW_PATH . '/partial/footer.phtml');
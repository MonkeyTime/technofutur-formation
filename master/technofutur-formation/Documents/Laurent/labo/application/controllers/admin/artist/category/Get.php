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

//Now render
include_once(VIEW_PATH . '/partial/header.phtml');

include_once(VIEW_PATH . '/admin/artist/category/form.phtml');

include_once(VIEW_PATH . '/partial/footer.phtml');
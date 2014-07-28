<?php

Session::start();

if(Session::is_valid(Session::get())) {
	
	Session::close();

	header('Location: /' . $language . '/admin/artist');
	
}

$token = Session::tokenize('loginForm', 300);

Session::close();

//language
$lang = include_once(APP_PATH . '/_languages/' . $language . '.php');

//Now render
include_once(VIEW_PATH . '/partial/header.phtml');

include_once(VIEW_PATH . '/login/form.phtml');

include_once(VIEW_PATH . '/partial/footer.phtml');
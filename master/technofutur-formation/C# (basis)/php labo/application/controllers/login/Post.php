<?php

if(!isset($_POST['login']) or !isset($_POST['pass'])) {

	header('Location: /' . $language . '/' . LOGIN_REDIRECT);

} else {
	
	Session::start();
	
	if(Session::tokenIsValid('loginForm', $_POST['loginForm'])) {
		
		//crypt with crypt (php 5.5)
		$config = require_once(APP_PATH . '/_conf/config.php');
	
		//$pwd = password_hash($_POST['pass'], PASSWORD_BCRYPT);
		//exit(var_dump($pwd));
		$pwd = new Password();
	
		if($_POST['login'] === $config['session']['credential']['login'] and $pwd->password_verify($_POST['pass'], $config['session']['credential']['pass'])) {
	
			unset($_POST);
			
			Session::regen(); //catchable session by hacker. Also we regenerate the id here.
			Session::close();
			
			Session::start();
			Session::set(); //must be only set here @ credential moment
	
			if(Session::is_valid($_SESSION['session'])) {
	
				Session::close();
	
				header('Location: /' . $language . '/admin/artist');
	
			} else {
				
				Session::destroy();
				Session::close();
				
				Session::start();
				Session::regen();
				Session::close();
	
				header('Location: /' . $language . '/' . LOGIN_REDIRECT);
			}
	
		} else {
	
			Session::destroy();
			Session::close();
			
			Session::start();
			Session::regen();
			Session::close();
	
			header('Location: /' . $language);
		}
		
	} else {
		
		Session::destroy();
		Session::close();
		
		Session::start();
		Session::regen();
		Session::close();
	
		header('Location: /' . $language);
	}
}
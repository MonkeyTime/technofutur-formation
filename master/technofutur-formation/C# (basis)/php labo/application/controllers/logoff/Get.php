<?php

Session::start();
Session::destroy();
Session::close();
		
Session::start();
Session::regen();
Session::close();
		
header('Location: /' . $language);
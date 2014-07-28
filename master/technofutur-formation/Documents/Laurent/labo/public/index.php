<?php

define('ROOT_PATH', realpath(dirname(__DIR__)));
define('APP_PATH', ROOT_PATH . '/application');
define('CONTROLLER_PATH', APP_PATH . '/controllers');
define('MODEL_PATH', APP_PATH . '/models');
define('VIEW_PATH', APP_PATH . '/views');
define('LOGIN_REDIRECT', 'login');

require_once(APP_PATH . '/autoload.php');
require_once(APP_PATH . '/dispatcher.php');
<?php
include('conf/config.inc.php');
include('lib/autoload.inc.php');

$model = new Model();
$controller = new Controller($model);
$view = new View($controller, $model);

$controller->filter($_GET['action']);
if($model->parseInput())
	{
	$model->handleData();
	}
$view->output();
?>
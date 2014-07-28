<?php
error_reporting(0);
include('conf/config.inc.php');
include('lib/autoload.inc.php');

$dh = new DateHandler();
$dh->setLanguage('fr');

if(!empty($_GET['action']))
	{
	switch($_GET['action'])
		{
		case 'listbooks':
			include('mods/books.inc.php');
			include('views/listbooks.inc.php');
			break;
		case 'insertbook':
			include('mods/books.inc.php');
			include('views/formbook.inc.php');
			break;
		case 'listmembers':
			include('mods/members.inc.php');
			include('views/listmembers.inc.php');
			break;
		default:
			$error = 'useraction';
			include('views/errors.inc.php');
		}
	}
else
	{
	include('views/home.inc.php');
	}
?>
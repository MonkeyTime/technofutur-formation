<?php
function loadClasses($class)
    {
    include_once('lib/classes/' . $class . '.inc.php');
    }
spl_autoload_register('loadClasses');
?>
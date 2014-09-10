<?php
include_once('_class/Router.php');

Router::route('/', function() {

    #std tpl
    include_once('_inc/header.tpl.php');
    include_once('_inc/menu.tpl.php');

    #dyn tpl
    include('_inc/index.tpl.php');

    #std tpl
    include_once('_inc/footer.tpl.php');
});

Router::route('/newsletter', function() {
    
    #std tpl
    include_once('_inc/header.tpl.php');
    include_once('_inc/menu.tpl.php');

    #dyn tpl
    if(!isset($_POST['newsletter'])) {
        include('_inc/newsletter.tpl.php');
    } else {
        include('_inc/newsletter.php');
    }

    #std tpl
    include_once('_inc/footer.tpl.php');
});

Router::route('/admin', function() {

    #std tpl
    include_once('_inc/header.tpl.php');
    include_once('_inc/menu.tpl.php');

    #dyn tpl
    if(!isset($_POST['article'])) {
        include('_inc/blog_post.tpl.php');
    } else {
        include('_inc/blog_post.php');
    }

    #std tpl
    include_once('_inc/footer.tpl.php');
});

Router::execute();

<?php

/*
 * Route class (Toro) become only the dispatcher and load the good controller.
 *
 */

class HomeHandler {

    function get($language = 'en') {
        //load controller (job of controller action is mixin model and its view for the current request)
    	include_once(CONTROLLER_PATH . '/Home.php');
    }
}

class LoginHandler {
    
    function get($language = 'en') {
        //load controller (job of controller action is mixin model and its view for the current request)
        include_once(CONTROLLER_PATH . '/login/Get.php');
    }

    function post($language = 'en') {
        //load controller (job of controller action is mixin model and its view for the current request)
        include_once(CONTROLLER_PATH . '/login/Post.php');
    }
}

class LogoffHandler {

    function get($language = 'en') {
		 //load controller (job of controller action is mixin model and its view for the current request)
        include_once(CONTROLLER_PATH . '/logoff/Get.php');
    }
}

class AdminArtistHandler {
    
    function get($language = 'en') {
        //load controller (job of controller action is mixin model and its view for the current request)
        include_once(CONTROLLER_PATH . '/admin/artist/Get.php');
    }

    function post($language = 'en') {
        //load controller (job of controller action is mixin model and its view for the current request)
        include_once(CONTROLLER_PATH . '/admin/artist/Post.php');
    }
}

class AdminArtistProfileHandler {
    
    function get($language = 'en') {
        //load controller (job of controller action is mixin model and its view for the current request)
        include_once(CONTROLLER_PATH . '/admin/artist/profile/Get.php');
    }
}

class AdminArtistProfileDeleteHandler {
    
    function get($language = 'en') {
        //load controller (job of controller action is mixin model and its view for the current request)
        include_once(CONTROLLER_PATH . '/admin/artist/profile/Delete.php');
    }
}

class AdminArtistListHandler {
    
    function get($language = 'en') {
        //load controller (job of controller action is mixin model and its view for the current request)
        include_once(CONTROLLER_PATH . '/admin/artist/List.php');
    }
}

class AdminArtistCategoryHandler {
    
    function get($language = 'en') {
        //load controller (job of controller action is mixin model and its view for the current request)
        include_once(CONTROLLER_PATH . '/admin/artist/category/Get.php');
    }

    function post($language = 'en') {
        //load controller (job of controller action is mixin model and its view for the current request)
        include_once(CONTROLLER_PATH . '/admin/artist/category/Post.php');
    }
}

class AdminArtistCategoryListHandler {
    
    function get($language = 'en') {
        //load controller (job of controller action is mixin model and its view for the current request)
        include_once(CONTROLLER_PATH . '/admin/artist/category/List.php');
    }
}

class AdminAlbumHandler {
    
    function get($language = 'en') {
        //load controller (job of controller action is mixin model and its view for the current request)
        include_once(CONTROLLER_PATH . '/admin/album/Get.php');
    }

    function post($language = 'en') {
        //load controller (job of controller action is mixin model and its view for the current request)
        include_once(CONTROLLER_PATH . '/admin/album/Post.php');
    }
}

class AdminAlbumEditHandler {
    
    function get($language = 'en') {
        //load controller (job of controller action is mixin model and its view for the current request)
        include_once(CONTROLLER_PATH . '/admin/album/Edit.php');
    }

    function post($language = 'en') {
        //load controller (job of controller action is mixin model and its view for the current request)
        include_once(CONTROLLER_PATH . '/admin/album/Update.php');
    }
}

class AdminAlbumListHandler {
    
    function get($language = 'en') {
        //load controller (job of controller action is mixin model and its view for the current request)
        include_once(CONTROLLER_PATH . '/admin/album/List.php');
    }
}

class AdminAlbumCategoryHandler {
    
    function get($language = 'en') {
        //load controller (job of controller action is mixin model and its view for the current request)
        include_once(CONTROLLER_PATH . '/admin/album/category/Get.php');
    }

    function post($language = 'en') {
        //load controller (job of controller action is mixin model and its view for the current request)
        include_once(CONTROLLER_PATH . '/admin/album/category/Post.php');
    }
}

class AdminAlbumCategoryListHandler {
    
    function get($language = 'en') {
        //load controller (job of controller action is mixin model and its view for the current request)
        include_once(CONTROLLER_PATH . '/admin/album/category/List.php');
    }
}

Route::serve(array(
    '/([a-z]{2,2})?' => 'HomeHandler',
    '/([a-z]{2,2})/login' => 'LoginHandler',
	'/([a-z]{2,2})/logoff' => 'LogoffHandler',
	
	'/([a-z]{2,2})/admin/artist/profile' => 'AdminArtistProfileHandler',
	'/([a-z]{2,2})/admin/artist/profile/delete' => 'AdminArtistProfileDeleteHandler',
    
	'/([a-z]{2,2})/admin/artist' => 'AdminArtistHandler',
    '/([a-z]{2,2})/admin/artist/list' => 'AdminArtistListHandler',
    '/([a-z]{2,2})/admin/artist/category' => 'AdminArtistCategoryHandler',
    '/([a-z]{2,2})/admin/artist/category/list' => 'AdminArtistCategoryListHandler',
    
	'/([a-z]{2,2})/admin/album' => 'AdminAlbumHandler',
    '/([a-z]{2,2})/admin/album/edit' => 'AdminAlbumEditHandler',
    '/([a-z]{2,2})/admin/album/list' => 'AdminAlbumListHandler',
    '/([a-z]{2,2})/admin/album/category' => 'AdminAlbumCategoryHandler',
    '/([a-z]{2,2})/admin/album/category/list' => 'AdminAlbumCategoryListHandler'
));
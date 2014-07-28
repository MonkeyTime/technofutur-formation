<?php
class View
	{
    private $model;
    private $controller;

    public function __construct($controller,$model) 
    	{
        $this->controller = $controller;
        $this->model = $model;
    	}
    	
    public function dumpRecords() 
    	{
        var_dump($this->model->getRecords());
    	}
    	
    public function output() 
    	{
		$this->checkErrors();
		$this->getTemplate('header'); 
		switch($this->model->getMode())
        	{
        	case 'listbooks':
        		foreach($this->model->getRecords() as $book)
					{
					echo '<p>';
					echo '<b>' . $book[0] . '</b><br/>';
					echo '<i>' . $book[1] . '</i>';
					echo '</p>';
					}
        		break;  
        	case 'listmembers':
        		$this->getTemplate('listmembers'); 
        		break; 
        	default:
        		$this->getTemplate('home');    	
        	} 
        $this->getTemplate('footer');      
    	}
    
    private function getTemplate($id)
    	{
    	$templatePath = 'views/' . $id . '.inc.php';
    	if(file_exists($templatePath)) include($templatePath);
    	}
    		
    private function checkErrors()
    	{
    	if(count($this->model->getErrors()) > 0)
        	{
        	var_dump($this->model->getErrors());
        	die();
        	}
    	}
	}
?>
<?php
class Controller
	{
    private $model;

    public function __construct($model)
    	{
        $this->model = $model;
    	}
    	
    public function filter($action)
    	{
        switch($action)
        	{
        	case 'listmembers':
        	case 'listbooks':
        		$this->model->setMode($action);
        		break;
        	}
    	}
	}
?>
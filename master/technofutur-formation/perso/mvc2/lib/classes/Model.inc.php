<?php
class Model
	{
	private $mode;
	private $records;
	private $errors = array();
	
    public function __construct()
    	{
    	}
    	
    public function setMode($mode)
    	{
    	$this->mode = $mode;
    	}
 
    public function getMode()
    	{
    	return $this->mode;
    	}
    	   	
    public function getRecords()
    	{
    	return $this->records;
    	}
    	
    public function getErrors()
    	{
    	return $this->errors;
    	}
    	
    public function parseInput()
    	{
    	$check = TRUE;
    	switch($this->mode)
        	{
        	case 'formbook':
        		if(empty($_GET['title']) || empty($_GET['author']))
					{
					$this->errors[] = 'Bad Arguments'; 
					$check = FALSE;
					}
        		break;
        	}
        return $check;
    	}
    	
    public function handleData()
    	{
    	global $conf;
    	switch($this->mode)
        	{
        	case 'listbooks':
 				$cfh = new CSVFileHandler($conf['booksdatafile']);
 				$this->records = $cfh->getStructure();
        		break;
        	case 'listmembers':
 				$cfh = new CSVFileHandler($conf['membersdatafile']);
 				$this->records = $cfh->getStructure();
        		break;
        	}
    	} 
	}
?>
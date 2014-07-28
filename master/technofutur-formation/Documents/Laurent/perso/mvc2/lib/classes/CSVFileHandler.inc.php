<?php
class CSVFileHandler extends TextFileHandler
    {
    private $structure;
    
    public function __construct($file)
        {
        parent::__construct($file);	
        $this->loadStructure();	
        }
    
    public function getStructure()
        {
        return $this->structure;
        }

    public function getFirstLine()
        {
        return $this->structure[0];
        }
        
   public function getLine($line, $lineAsString = true, $column = -1) 
    	{
        if ($line > 0 && $line <= count($this->structure))
            {
            if ($column >= 0 && $column < count($this->structure[$line])) return $this->structure[$line][$column];        
            if ($lineAsString) return implode(",",$this->structure[$line]);
            else return $this->structure[$line];
            }
    	}
        
    private function loadStructure()
	{
        $row = 1;
        $handle = fopen($this->filePath, "r");
        while ($data = fgetcsv($handle, 2000, "|", "\"")) 
            {
            $this->structure[$row] = $data;
            $row++;
            }
	}
    }
?>
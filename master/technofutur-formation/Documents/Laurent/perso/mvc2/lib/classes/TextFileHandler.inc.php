<?php
class TextFileHandler
    {
    protected $filePath;
    protected $filePathInfo;
    protected $size;
    protected $stream;
        
    public function __construct($file)
        {
        $this->filePath = $file;
        $this->filePathInfo = pathinfo($this->filePath);
        $this->size = $this->getFileSize();
        }
    
    public function getFilePath()
        {
        return $this->filePath;
        }
        
    public function getFilePathInfo()
        {
        return $this->filePathInfo;
        }

    public function getFileSize()
        {
        clearstatcache();
        $size = file_exists($this->filePath) ? filesize($this->filePath) : 0;
        return $size;
        }                
            
    public function getContent()
        {
        $this->openFile('r');
        return fread($this->stream, $this->getFileSize());
        }

    public function setContent($content)
        {
        $this->openFile('w');
        fwrite($this->stream, $content);
        }
        
    public function addContent($content)
        {
        $this->openFile('a');
        fwrite($this->stream, $this->parseContent($content));
        }

    private function openFile($mode)
        {
        if(isset($this->stream)) fclose($this->stream);
        $this->stream = fopen($this->filePath, $mode);
        }

    public function delete()
            {
            if(isset($this->stream)) fclose($this->stream);
            if(file_exists($this->filePath)) 
                unlink($this->filePath);
            }
                
    public function renameFile($name)
            {
            if(isset($this->stream)) fclose($this->stream);
            $cf = $this->checkFileName($name);
            if($cf == 'ok')
                {
                $newFileName = dirname(realpath($this->filePath)) . "/" . $name;
                if(file_exists($this->filePath) && !file_exists($newFileName)) 
                    {
                    rename($this->filePath, $newFileName);
                    return true;
                    }
                else
                    {
                    return false;
                    }
                }
            else
                {
                echo "Filename not valid. Try : " . $cf;
                }
            }
                
    private function parseContent($str)
        {
        $str = str_replace(chr(145), "'", $str);    // left single quote
        $str = str_replace(chr(146), "'", $str);    // right single quote
        $str = str_replace(chr(147), '"', $str);    // left double quote
        $str = str_replace(chr(148), '"', $str);    // right double quote
        $str = str_replace('|', '', $str); 
        return $str;
        }
    
    private function checkFileName($name)
        {
        $wellFormedName = preg_replace('/[\@\ \!\\\]/i', '', $name);
        if ($wellFormedName == $name)
            return 'ok';
        else 
            return $wellFormedName;
        }
    }
?>
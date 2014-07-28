<?php 
class DateHandler 
    { 
    private $day; 
    private $month; 
    private $year;
    private $weekDay;
    private $dayName;
    private $monthName;
    private $language;
    private $dateParts = array();
     
    public function DateHandler() 
        { 
        date_default_timezone_set('Europe/Brussels');
        $this->setDate(date('Y-m-d')); 
        } 
        
    public function setDate($dateString) 
        { 
        if($this->checkDate($dateString))
            {
            $date = strtotime($dateString);
            $this->day       = date('j', $date); 
            $this->month     = date('n', $date); 
            $this->year      = date('Y', $date); 
            $this->weekDay   = date('N', $date); 
            $this->dayName   = date('l', $date); 
            $this->monthName = date('F', $date); 
            } 
        else
            {
            die('Invalid Date Format');
            }
        }
                
    public function setLanguage($language) 
        { 
        $this->language = $language; 
        } 
         
    public function getDayName() 
        { 
        switch($this->language)
            {
            case 'fr':
                $frDays = array(1 => 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi', 'Dimanche'); 
                return $frDays[$this->weekDay]; 
                break;
            default: 
                return $this->dayName; 
            }          
        } 
        
    public function getMonthName() 
        { 
        switch($this->language)
            {
            case 'fr':
                $frMonths = array(1 => 'janvier', 'février', 'mars', 'avril', 'mai', 'juin', 'juillet', 'août', 'septembre', 'octobre', 'novembre', 'décembre'); 
                return $frMonths[$this->month]; 
                break;
            default: 
                return $this->monthName; 
            }     
        } 
        
    public function getDateToString() 
        { 
        $dateToString = $this->day . ' ' . $this->getMonthName() . ' ' . $this->year; 
        return $dateToString; 
        } 
        
    public function getDateParts() 
        { 
        $this->setDateParts();
        return $this->dateParts; 
        }
        
    private function setDateParts() 
        { 
        $this->dateParts = array('day' => $this->day, 'month' => $this->month, 'year' => $this->year); 
        return $dateParts; 
        } 
        
    private function checkDate($dateString)
        {
        if (date('Y-m-d', strtotime($dateString)) == $dateString) 
            {
            return true;
            }
        else 
            {
            return false;
            }
        }
    } 
?>
<?php
/**
  * Init some variables
  *
  */  
$questions = array
            (
                0 => 'Quel est le présidents de la France en 2014 ?', 
                1 => 'Quelle est la couleur du drapeau Européen ?'
            );

//currently only QCM possible.
$possibleResponses = array
                    (
                        0 => array('hollande' => true, 'sarkosy' => false, 'valls' => false), 
                        1 => array('bleu' => true, 'blanc' => false, 'orange' => false)
                    );
?>

<h1>Testez vos connaissances</h1>
                
<div class="questions">
    
    <form class="form" method="post" action="">
        
        <?php
        foreach($questions as $k => $question) {
            
            echo '<label>' . $question . '</label>';
            
            $responses = $possibleResponses[$k]; // I get the good array of responses with the index key ($k) of the previous foreach because the automated index of questions[] and possibleResponses[] have the same index.
            
            foreach($responses as $key => $response) {
				
                echo '<input type="radio" name="q' . $k . '" value="' . $key . '"> '. ucfirst($key); //weird, the key is the value to display but I have decided this personally for a more easy variable access in a near future in the script and to write less code or write more "generic" php code. Now its easy to add a new question and its possible responses from the two arrays $questions and $responses if the new question is also a QCM.
            }
        }
        ?>
        
        <label>&nbsp;</label>
        <input type="submit" name="submit" value="Verifier" />
        
    </form>
    
</div>
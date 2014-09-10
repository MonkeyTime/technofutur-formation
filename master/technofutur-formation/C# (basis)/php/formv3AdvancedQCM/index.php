<?php
/**
  * ~bad "coding style" compared to the best practices for "coding style" with PHP
  * @see https://github.com/php-fig/fig-standards/tree/master/accepted/fr
  * @see http://www.phptherightway.com/
  *
  * Only here for easy learning and builded with only things we have seen in the classroom courses
  *
  * All this file is listen and traveled (on request) by PHP core (installed on the server) because this file have the extention .php (a core is something like an executable directly installed on the server). In a development environment WAMP is the "simulated" server.
  *
  * Do not use itself without any changes for security reasons (only here for learning some courses)
  * 
  */

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
<!DOCTYPE html>
<html lang="en">

    <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    	<title>Form V3 questions - réponses</title>
        <link rel="stylesheet" type="text/css" href="css/main.css">
    </head>
    
    <body>
		
		<div class="row">
        
        	<?php 
			/**
			  * We display the form before anything or if nothing is POSTed to the server by a client (in facts by a web browser)
			  * <code>
			  * SI NON POST['submit']
			  * 	afficher (echo) formulaire
			  * SINON
			  * 	afficher (echo) traitement
			  * FIN SI
			  * </code>
			  *
			  * notice:
			  * SINON @line 92
			  * FIN SI @line 194
			  */
			if(!isset($_POST['submit'])) 
			{ 
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
            
            <?php 
			}
			else 
			{ 
			?>
                <h1>Correction de vos réponses</h1>
                
                <div class="responses">  
				
					<?php 
                    /**
                      * Traitment part 1
					  * 
					  * display html statistics part
                      *
                      */
                      $nbrGoodResponse = 0;
                      $nbrBadResponse = 0;
                      $nbrNoResponse = 0;
                      
					  foreach($questions as $k => $question) {
						  
						  if(isset($_POST['q'.$k]) and $_POST['q'.$k] == array_search(true, $possibleResponses[$k])) {
							  /**
							    * array_search
								*
								* Search the value (for me I have choosed the value true) in the array (for me the array is $possibleResponses[$k]) and this function return the key of this value when the value is matched else return false.
								*
								* @param mixed 	the param to search
								* @param array	the array where php must search
								*
							    * @see http://php.net//manual/fr/function.array-search.php
								*
								*/						  
							  $nbrGoodResponse++;
							  
						  } else if(isset($_POST['q'.$k]) and $_POST['q'.$k] != array_search(true, $possibleResponses[$k])) {
							  
							  $nbrBadResponse++;
							  
						  } else {
							  
							  $nbrNoResponse++;
						  }
					  }
					  
					  //display nbr of good-response
					  echo 'Vous avez ';
					  echo $nbrGoodResponse;
					  
					  if($nbrGoodResponse > 1) { //plurial tested...
						  echo ' bonnes réponses. ';
					  } else {
						  echo ' bonne réponse. ';
					  }
					  
					  //display nbr of bad-response
					  echo $nbrBadResponse;
					  
					  if($nbrBadResponse > 1) { //plurial tested...
						  echo ' mauvaises réponses. ';
					  } else {
						  echo ' mauvaise réponse. ';
					  }
					  
					  //display nbr of no-response
					  echo $nbrNoResponse;
					  
					  if($nbrNoResponse > 1) { //plurial tested...
						  echo ' sans réponses. ';
					  } else {
						  echo ' sans réponse. ';
					  }

					  /**
                      * Traitment part 2
					  *
					  * Now we need to display each question + the user response + good or bad color with css. Easy, it's the same loop and test of the previous "foreach".... Also it's possible to combine in one place the two tests "foreach" (refactoring this php code). It's only here for comprehensive reasons.
                      *
                      */
					  foreach($questions as $k => $question) {
						  
						  if(isset($_POST['q'.$k]) and $_POST['q'.$k] == array_search(true, $possibleResponses[$k])) {
							  
							  echo '<p class="question">' . $question . '</p>';
							  echo '<p class="response good">' . ucfirst($_POST['q'.$k]) . '</p>';
							  //@see http://php.net//manual/fr/function.ucfirst.php
							  
						  } else if(isset($_POST['q'.$k]) and $_POST['q'.$k] != array_search(true, $possibleResponses[$k])) {
							  
							  echo '<p class="question">' . $question . '</p>';
							  echo '<p class="response bad">' . ucfirst($_POST['q'.$k]) . '</p>';
							  
						  } else {
							  
							  echo '<p class="question">' . $question . '</p>';
							  echo '<p class="response no">Vous n\'avez pas répondu à cette question.</p>';
						  }
					  }
                    ?>
                
                </div>
                
            <?php
			} 
			?>
            
        </div>
        
    </body>
    
</html>
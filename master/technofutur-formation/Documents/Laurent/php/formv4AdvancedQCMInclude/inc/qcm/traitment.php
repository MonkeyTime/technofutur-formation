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
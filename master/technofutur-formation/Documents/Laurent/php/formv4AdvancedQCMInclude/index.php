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

include('inc/header.php');

?>
		<div class="row">
	    
	    	<?php 
			/**
			  * We display the form before anything or if nothing is POSTed to the server by a client (in facts by a web browser)
			  * <code>
			  * SI NON POST['submit']
			  * 	include formulaire
			  * SINON
			  * 	include traitement
			  * FIN SI
			  * </code>
			  *
			  */
			if(!isset($_POST['submit'])) 
			{
				include('inc/qcm/form.php');
			}
			else 
			{
				include('inc/qcm/traitment.php');
			} 

			?>
	        
	    </div>

<?php

include('inc/footer.php');
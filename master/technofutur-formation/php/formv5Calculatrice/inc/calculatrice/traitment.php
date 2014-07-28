<?php
if(isset($_POST['submit'])) {

	if($_POST['choice'] and $_POST['operator'] and $_POST['operand']) {
			
		switch($_POST['operator']) {
			
			case 'add':
				
				$result = $_POST['choice'] + $_POST['operand'];
				$operator = '+';

			break;

			case 'sou':
				
				$result = $_POST['choice'] - $_POST['operand'];
				$operator = '-';

			break;

			case 'mul':

				$result = $_POST['choice'] * $_POST['operand'];
				$operator = '*';

			break;

			case 'div':

				if($_POST['operand'] != 0) {
					
					$result = $_POST['choice'] / $_POST['operand'];
					$operator = '/';

				} else {
					
					$alerts[] = 'Impossible de diviser par zéro';
				}

			break;

			case 'mod':

				$result = $_POST['choice'] % $_POST['operand'];
				$operator = '%';

			break;
			
			default:
			break;

		}

	} else {

		$alerts[] = 'Merci de remplir tous les champs.';
	}

	if(isset($alerts)) {

		foreach($alerts as $alert) {

			echo '<p class="alert">' . $alert . '</p><a href="?"> retour </a>';
		}

	} else {

		echo '<p class="result">' . $_POST['choice'] . ' ' . $operator . ' ' . $_POST['operand'] . ' = ' . $result . '</p><a href="?"> retour </a>';
	}
}
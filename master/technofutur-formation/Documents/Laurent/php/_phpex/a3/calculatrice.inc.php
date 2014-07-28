	<div class="box calc">
	<div class="title">CalcX</div>
	<?php
	if(empty($_POST['submit'])) //attention ici c'est bien EMPTY, si le submit n'a PAS été fait, ALORS on affiche le formulaire
		{
		echo "
			<form action='?' method='post'>
			<fieldset class='boxBody'>
			  <input type='text' name='a' size='3' maxlength='3' placeholder='Premier chiffre'>
				<select name='operation'>
					<option value='plus'>addition</option>
					<option value='min'>soustraction</option>
					<option value='mult'>multiplication</option>
					<option value='div'>division</option>
				</select>
			  <input type='text' name='b' size='3' maxlength='3' placeholder='Second chiffre'>
			</fieldset>
			<footer>
			  <input type='submit' name='submit' class='btncalc' value='Calculer'>
			</footer>
			<p class='comment'>FilHebdo - Formulaires<br/>Circum Net</p>
			</form>
			";
		}
	else
		{
		echo '<p class="result">' . $c . '</p>';
		}
	?>
	</div>
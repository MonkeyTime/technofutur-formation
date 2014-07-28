<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">	
		<title>Loop + csv</title>
		<link rel="stylesheet" href="//yui.yahooapis.com/pure/0.5.0/pure-min.css">
	</head>

	<body>
	
		<table class="pure-table">

		<?php

		$i = 0; //flag

		$lines = file('./GeoLiteCity-Location.csv');

		foreach ($lines as $key => $line) {

			if($i == 1000) {
				
				break;
			}
			
			if($key == 0) {

				echo '<h1>' .$line . '</h1>';

			} else if($key == 1) {

				echo '<thead><tr>';

				$cols = explode(',', $line);

				foreach ($cols as $k => $col) {

					echo '<th><h2>' . $col . '</h2></th>';
				}

				echo '</thead></tr>';

			} else {
				
				echo '<tr>';

				$cases = explode(',', $line);

				//we can also access by reference without foreach and choose what displaying  e.g. echo $cases[0] - $cases[1] - $cases[5]
				foreach ($cases as $l => $case) {

					//var_dump($case);
					
					if($case == '""' or $case == '') {

						echo '<th style="font-weight: 300">undefined</th>';

					} else {
						
						echo '<th>' . str_replace('"', '', $case) . '</th>';
					}
				}

				echo '</tr>';

				$i++;
			}
		}
		?>
		</table>

	</body>

</html>
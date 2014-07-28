<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">	
        <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Loop + csv + display by 100 items</title>
		<link rel="stylesheet" href="//yui.yahooapis.com/pure/0.5.0/pure-min.css">
	</head>

	<body>
	<?php


		$lines = file('./GeoLiteCity-Location.csv');
		
		$result = '<table class="pure-table" style="width:100%">';


		if(isset($_GET['keyword'])) {

			$newLines = array();

			foreach($lines as $key => $line) {

				if($key == 0 or $key == 1) {

					$newLines[] = $line;

				} else {
				
					if(stristr($line, $_GET['keyword'])) {
						
						$newLines[] = $line; 
					}
				}
			}
		}

		if(isset($newLines)) {
			$lines = $newLines;
		}
		
		if(isset($_GET['from']) and isset($_GET['to'])) {
			
			$from    = $_GET['from'];
			$to      = $_GET['to'];
			$portion = array_slice($lines, $from + 1, ($to - $from) + 1); 
			//@see http://php.net/manual/en/function.array-slice.php
			
		} else {
			
			$from    = 1;
			$to      = 100;
			$portion = array_slice($lines, $from + 1, $to);
		}
		
		//big title
		$result .= '<h1>' .$lines[0] . '</h1>';
	
		//simple nav
		$result .= '<a href="./">Home</a>
				---
				<a href="?from='.( ($from - 10000) < 0 ? 1 : ($from - 10000) ).'&to='.( ($to - 10000 ) <= 1 ? 100 : ($to - 10000) ).'">prev10000</a> 
				--- 
				<a href="?from='.( ($from - 1000) < 0 ? 1 : ($from - 1000) ).'&to='.( ($to - 1000 ) <= 1 ? 100 : ($to - 1000) ).'">prev1000</a> 
				--- 
				<a href="?from='.( ($from - 100) < 0 ? 1 : ($from - 100) ).'&to='.( ($to - 100 ) <= 1 ? 100 : ($to - 100) ).'">prev100</a>
				<===> 
				
				<a href="?from='.($from + 100).'&to='.($to + 100).'">next100</a> 
				--- 
				<a href="?from='.($from + 1000).'&to='.($to + 1000).'">next1000</a> 
				--- 
				<a href="?from='.($from + 10000).'&to='.($to + 10000).'">next10000</a>

				<div style="position: absolute; right: 10px; top: 10px"><form class="pure-form" method="get" action=""><fieldset><input type="text" name="keyword" placeholder="Rechercher..."> <input type="submit" class="pure-button pure-button-primary" value="Search" /></fieldset></form></div>
				
				<div style="float:right">( '.$from. ' - '.$to.' )</div>
			
			';
		
		$result .= '<thead><tr>';

		$cols = explode(',', $lines[1]);
		
		//we can also access by key reference without the foreach and choose what displaying  e.g. $result .= $cols[0] - $cols[1] - $cols[5] (when we know the number of columns and if this numbrer stay stable in the life cycle)
		foreach ($cols as $k => $col) {
			
			//@see http://php.net//manual/en/function.preg-split.php
			$str = preg_split('#(?=[A-Z])#', $col, -1, PREG_SPLIT_NO_EMPTY);
			
			if(count($str) > 1) {
				
				$result .= '<th><h4>' . ucfirst($str[0]) . ' ' . strtolower($str[1]) . '</h4></th>';
				
			} else {
				
				$result .= '<th><h4>' . ucfirst($str[0]) . '</h4></th>';
			}
		}

		$result .= '</thead></tr>';
		
		
		foreach ($portion as $key => $line) {
	
			$result .= '<tr>';

			$cases = explode(',', $line);

			//we can also access by key reference without the foreach and choose what displaying  e.g. $result .= $cases[0] - $cases[1] - $cases[5] (when we know the number of columns and if this numbrer stay stable in the life cycle)
			foreach ($cases as $l => $case) {

				//var_dump($case);
				
				if($case == '""' or $case == '') {

					$result .= '<th style="font-weight: 300">undefined</th>';

				} else {
					
					$result .= '<th>' . str_replace('"', '', $case) . '</th>';
				}
			}

			$result .= '</tr>';

		}
		
		$result .= '</table>';

		echo $result;

		?>

	</body>

</html>
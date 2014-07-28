<?php

function search_result($search, $pdo) {
	
	/**
	  * UNION
	  *
	  * SELECT...UNION...SELECT rassemble les résultats sous les mêmes clés. 
	  * Ce sont les clés du premier select qui sont utilisées
	  *
	  */
	$query = "SELECT a.nickname AS title, a.biography AS description
			  FROM artistes AS a
			  WHERE a.nickname
			  LIKE CONCAT('%',:search,'%')
			  UNION ALL
			  SELECT al.name, al.description
			  FROM albums as al
			  WHERE al.name
			  LIKE CONCAT('%',:search,'%')";
	
	$req = $pdo->prepare($query);

	$req->bindParam(':search', $search, PDO::PARAM_STR, 255);
	
	if($req->execute()) {

		$arr = $req->fetchAll(PDO::FETCH_ASSOC);
		
		$req->closeCursor();
		
		return $arr;
	}

	return false;
}
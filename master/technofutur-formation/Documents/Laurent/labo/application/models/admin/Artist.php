<?php

function post_artist($post, $pdo) {

	//$pdo->beginTransaction();
	$query = 'INSERT INTO artistes(firstname, lastname, nickname, birthdate, birthplace, biography, website, image, nationality) 
			  VALUES (:firstname, :lastname, :nickname, :birthdate, :birthplace, :biography, :website, :image, :nationality)';
	
	$req = $pdo->prepare($query);

	$post['biography'] = nl2br($post['biography']);
	$req->bindParam(':firstname', $post['firstname'], PDO::PARAM_STR, 255);
	$req->bindParam(':lastname', $post['lastname'], PDO::PARAM_STR, 255);
	$req->bindParam(':nickname', $post['nickname'], PDO::PARAM_STR, 255);
	$req->bindParam(':birthdate', $post['birthdate'], PDO::PARAM_STR, 10);
	$req->bindParam(':birthplace', $post['birthplace'], PDO::PARAM_STR, 255);
	$req->bindParam(':biography', $post['biography'], PDO::PARAM_STR);
	$req->bindParam(':website', $post['website'], PDO::PARAM_STR, 255);
	$req->bindParam(':image', $post['image'], PDO::PARAM_STR, 255);
	$req->bindParam(':nationality', $post['nationality'], PDO::PARAM_STR, 255);
	
	if($req->execute()) {

		$query = 'INSERT INTO artiste_cats(category_id, artiste_id) 
			      VALUES (:category_id, :artiste_id)';

		$req = $pdo->prepare($query);
		
		$req->bindParam(':category_id', $post['category'], PDO::PARAM_INT);
		$req->bindParam(':artiste_id', $pdo->lastInsertId(), PDO::PARAM_INT);

		if($req->execute()) {

			$req->closeCursor();

			return true;
		}

		$req->closeCursor();

		return false;
	}

	return false;

}

function delete_artist($artist_id, $pdo) {
	
	$query = 'DELETE FROM artistes WHERE artistes.id = :artiste_id';
	
	$req = $pdo->prepare($query);
	
	$req->bindParam(':artiste_id', $artist_id, PDO::PARAM_INT);

			  
	if($req->execute()) {
		
		$req->closeCursor();

		return true;
	}
	
	return false;
}

function get_artists_by_category($cat_id, $pdo) {

	$query = 'SELECT a
			  FROM artistes AS a, artiste_cats AS ac
			  WHERE ac.category_id = :cat_id 
			  AND ac.artiste_id = a.id';
	
	$req = $pdo->prepare($query);

	$req->bindParam(':cat_id', $cat_id, PDO::PARAM_INT);
	
	if($req->execute()) {
		
		$arr = $req->fetchAll(PDO::FETCH_ASSOC);
		
		$req->closeCursor();
		
		return $arr;
	}

	return false;
}

function get_categories_from_artist($artist_id, $pdo) {

	$query = 'SELECT c.name
			  FROM categories AS c, artiste_cats AS ac 
			  WHERE ac.artiste_id = :artist_id 
			  AND c.id = ac.category_id
			  GROUP BY c.id';
	
	$req = $pdo->prepare($query);

	$req->bindParam(':artist_id', $artist_id, PDO::PARAM_INT);
	
	if($req->execute()) {
		
		$arr = $req->fetchAll(PDO::FETCH_ASSOC);

		$arr = array_shift($arr);
		
		$req->closeCursor();
		
		return $arr;
	}

	return false;
}

function get_artists($pdo) {
	
	$query = 'SELECT * 
			  FROM artistes';
	
	$req = $pdo->prepare($query);
	
	if($req->execute()) {
		
		$arr = $req->fetchAll(PDO::FETCH_ASSOC);
		
		$req->closeCursor();
		
		return $arr;
	}

	return false;
}

function get_artist_by_id($id, $pdo) {
	
	$query = 'SELECT * 
			  FROM artistes 
			  WHERE id = :id';
	
	$req = $pdo->prepare($query);

	$req->bindParam(':id', $id, PDO::PARAM_INT);
	
	if($req->execute()) {
		
		$arr = $req->fetch(PDO::FETCH_ASSOC);
		
		$req->closeCursor();
		
		return $arr;
	}

	return false;
}
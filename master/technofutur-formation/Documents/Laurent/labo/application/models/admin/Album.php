<?php

function post_album($post, $pdo) {
	
	$query = 'INSERT INTO albums(name, description, released, artiste_id)
			  VALUES (:name, :description, :released, :artiste_id)';
	
	$req = $pdo->prepare($query);

	$req->bindParam(':name', $post['name'], PDO::PARAM_STR, 255);
	$req->bindParam(':description', $post['description'], PDO::PARAM_STR);
	$req->bindParam(':released', $post['released'], PDO::PARAM_STR);
	$req->bindParam(':artiste_id', $post['artiste_id'], PDO::PARAM_INT);
	
	if($req->execute()) {

		$query = 'INSERT INTO album_cats(album_id, category_id) 
			      VALUES (:album_id, :category_id)';

		$req = $pdo->prepare($query);
		
		$req->bindParam(':album_id', $pdo->lastInsertId(), PDO::PARAM_INT);
		$req->bindParam(':category_id', $post['category'], PDO::PARAM_INT);

		if($req->execute()) {

			return true;
		}

		return false;
	}

	return false;
}

function artist_exist($id, $pdo) {
	
	$query = 'SELECT artistes.id
			  FROM artistes 
			  WHERE id = :id';
	
	$req = $pdo->prepare($query);

	$req->bindParam(':id', $id, PDO::PARAM_INT);
	
	if($req->execute()) {
		
		$arr = $req->fetchAll(PDO::FETCH_ASSOC);

		if(count($arr) > 0) {
			
			return true;
		}

		return false;
	}
}

function post_category($post, $pdo) {
	
	$query = 'INSERT INTO albums_categories(name, description)
			  VALUES (:name, :description)';
	
	$req = $pdo->prepare($query);

	$req->bindParam(':name', $post['name'], PDO::PARAM_STR, 255);
	$req->bindParam(':description', $post['description'], PDO::PARAM_STR);
	
	if($req->execute()) {

		return true;
	}

	return false;
}

function get_categories($pdo) {
	
	$query = 'SELECT * 
			  FROM albums_categories';
	
	$req = $pdo->prepare($query);

	if($req->execute()) {
		
		$arr = $req->fetchAll(PDO::FETCH_ASSOC);
		
		$req->closeCursor();
		
		return $arr;
	}

	return false;
}

function get_albums($pdo) {
	
	$query = 'SELECT * 
			  FROM albums';
	
	$req = $pdo->prepare($query);

	if($req->execute()) {
		
		$arr = $req->fetchAll(PDO::FETCH_ASSOC);
		
		$req->closeCursor();
		
		return $arr;
	}

	return false;
}

function get_album_by_id($id, $pdo) {
	
	$query = 'SELECT * 
			  FROM categories 
			  WHERE id = :id';
	
	$req = $pdo->prepare($query);

	$req->bindParam(':id', $id, PDO::PARAM_INT);

	if($req->execute()) {
		
		$arr = $req->fetchAll(PDO::FETCH_ASSOC);
		
		$req->closeCursor();
		
		return $arr;
	}

	return false;
}

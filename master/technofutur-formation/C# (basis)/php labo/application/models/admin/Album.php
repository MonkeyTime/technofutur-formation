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
			
			$req->closeCursor();

			return true;
		}
		
		$req->closeCursor();
		
		return false;
	}

	return false;
}

function update_album($post, $pdo) {
	
	$query = 'UPDATE albums, album_cats 
			  SET name = :name, description = :description, released = :released, artiste_id = :artiste_id, album_cats.category_id = :category
			  WHERE albums.id = :id';
	
	$req = $pdo->prepare($query);

	$req->bindParam(':name', $post['name'], PDO::PARAM_STR, 255);
	$req->bindParam(':description', $post['description'], PDO::PARAM_STR);
	$req->bindParam(':released', $post['released'], PDO::PARAM_STR);
	$req->bindParam(':artiste_id', $post['artiste_id'], PDO::PARAM_INT);
	$req->bindParam(':id', $post['id'], PDO::PARAM_INT);
	$req->bindParam(':category', $post['category'], PDO::PARAM_INT);
	
	if($req->execute()) {
		
		$req->closeCursor();

		return true;
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
			
			$req->closeCursor();
			
			return true;
		}
		
		$req->closeCursor();

		return false;
	}
}

function album_exist($id, $pdo) {
	
	$query = 'SELECT albums.id
			  FROM albums 
			  WHERE id = :id';
	
	$req = $pdo->prepare($query);

	$req->bindParam(':id', $id, PDO::PARAM_INT);
	
	if($req->execute()) {
		
		$arr = $req->fetchAll(PDO::FETCH_ASSOC);

		if(count($arr) > 0) {
			
			$req->closeCursor();
			
			return true;
		}

		return false;
	}
}

function get_album($id, $pdo) {
	
	$query = 'SELECT a.name, a.description, a.released, a.artiste_id, cat.id
			  FROM albums AS a, categories AS cat, album_cats AS al_cats
			  WHERE a.id = :id1
			  AND al_cats.album_id = :id2
			  AND al_cats.category_id = cat.id';
	
	$req = $pdo->prepare($query);

	$req->bindParam(':id1', $id, PDO::PARAM_INT);
	$req->bindParam(':id2', $id, PDO::PARAM_INT);
	
	if($req->execute()) {
		
		$arr = $req->fetchAll(PDO::FETCH_ASSOC);

		$arr = array_shift($arr);

		$req->closeCursor();

		return $arr;
	}

	return false;
}

function post_category($post, $pdo) {
	
	$query = 'INSERT INTO albums_categories(name, description)
			  VALUES (:name, :description)';
	
	$req = $pdo->prepare($query);

	$req->bindParam(':name', $post['name'], PDO::PARAM_STR, 255);
	$req->bindParam(':description', $post['description'], PDO::PARAM_STR);
	
	if($req->execute()) {
		
		$req->closeCursor();

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

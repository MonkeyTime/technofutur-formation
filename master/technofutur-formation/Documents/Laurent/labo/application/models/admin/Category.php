<?php

function post_category($post, $pdo) {
	
	$query = 'INSERT INTO categories(name, description) 
			  VALUES (:name, :description)';
	
	$req = $pdo->prepare($query);
	
	$post['description'] = nl2br($post['description']);
	$req->bindParam(':name', $post['name'], PDO::PARAM_STR, 255);
	$req->bindParam(':description', nl2br($post['description']), PDO::PARAM_STR);
	
	if($req->execute()) {
		
		return true;
	}

	return false;
}

function get_categories($pdo) {
	
	$query = 'SELECT * FROM categories';
	
	$req = $pdo->prepare($query);

	if($req->execute()) {
		
		$arr = $req->fetchAll(PDO::FETCH_ASSOC);
		
		$req->closeCursor();
		
		return $arr;
	}

	return false;
}

function get_category_by_id($id, $pdo) {
	
	$query = 'SELECT * FROM categories WHERE id = :id';
	
	$req = $pdo->prepare($query);

	$req->bindParam(':id', $id, PDO::PARAM_INT);

	if($req->execute()) {
		
		$arr = $req->fetchAll(PDO::FETCH_ASSOC);
		
		$req->closeCursor();
		
		return $arr;
	}

	return false;
}

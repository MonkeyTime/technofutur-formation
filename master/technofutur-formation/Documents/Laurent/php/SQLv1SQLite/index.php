<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">	
        <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Loop + csv + display by 100 items</title>
		<link rel="stylesheet" href="//yui.yahooapis.com/pure/0.5.0/pure-min.css">
		<style type="text/css">
		label {display: block; padding: 10px 0;}
		input {display: block; padding: 10px 0;}
		textarea {min-width: 400px; min-height: 120px;}
		form {margin-bottom: 50px}
		</style>
	</head>

	<body>

		<?php

		$films = array(
			array('title' => 'Titre 1', 'author' => 'Author 1', 'resume' => 'Resume lorem ipsum 1', 'pub' => '2012-07-12'),
			array('title' => 'Titre 2', 'author' => 'Author 2', 'resume' => 'Resume lorem ipsum 2', 'pub' => '2010-08-27'),
			array('title' => 'Titre 3', 'author' => 'Author 3', 'resume' => 'Resume lorem ipsum 3', 'pub' => '2014-01-25'),
			array('title' => 'Titre 4', 'author' => 'Author 2', 'resume' => 'Resume lorem ipsum 4', 'pub' => '2000-03-05'),
			array('title' => 'Titre 5', 'author' => 'Author 2', 'resume' => 'Resume lorem ipsum 5', 'pub' => '2008-09-18'),
			array('title' => 'Titre 6', 'author' => 'Author 4', 'resume' => 'Resume lorem ipsum 6', 'pub' => '2007-04-20'),
			array('title' => 'Titre 7', 'author' => 'Author 5', 'resume' => 'Resume lorem ipsum 7', 'pub' => '2004-12-27'),
			array('title' => 'Titre 8', 'author' => 'Author 4', 'resume' => 'Resume lorem ipsum 8', 'pub' => '2005-06-27'),
			array('title' => 'Titre 9', 'author' => 'Author 8', 'resume' => 'Resume lorem ipsum 9', 'pub' => '2014-07-17')
			); 

		try {
			$pdo = new PDO('sqlite:./datas/movies.db');
		}
		catch (PDOException $e) {
		    echo 'Connexion échouée : ' . $e->getMessage();
		}

		$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

		$pdo->exec('CREATE TABLE IF NOT EXISTS movies (
		                    id INTEGER PRIMARY KEY, 
		                    title VARCHAR(255),
		                    author VARCHAR(255),
		                    resume TEXT,
		                    publication DATE,
		                    lastupdate DATE)');

		/*foreach($films as $film) {
			
			$req = $pdo->prepare('INSERT INTO movies (title, author, resume, publication, lastupdate) VALUES (:title, :author, :resume, :pub, :up)');
			
			$currdate = date('Y-m-d H:i:s');
			$req->bindParam(':title', $film['title']);
			$req->bindParam(':author', $film['author']);
			$req->bindParam(':resume', $film['resume']);
			$req->bindParam(':pub', $film['pub']);
			$req->bindParam(':up', $currdate);

			$req->execute();
		}*/

		$req = $pdo->query('SELECT * FROM movies');

		if(isset($_GET['author'])) {

			echo '<h1>By author</h1>';

			$req = $pdo->prepare('SELECT * FROM movies WHERE author = :author');

			$req->bindParam(':author', $_GET['author']);

			$req->execute();

		} else if (isset($_GET['search'])) {

			$req = $pdo->query("SELECT * FROM movies WHERE title LIKE '%".$_GET['search']."%' OR resume LIKE '%".$_GET['search']."%' OR author LIKE '%".$_GET['search']."%'");

			$row = $req->fetch(PDO::FETCH_ASSOC);

			echo '<h1>'.$row['title'].'</h1>';

			$req = $pdo->query("SELECT * FROM movies WHERE title LIKE '%".$_GET['search']."%' OR resume LIKE '%".$_GET['search']."%' OR author LIKE '%".$_GET['search']."%'");


		} else if(isset($_POST['new_film'])) {

			echo '<h1>Film inserted successfully</h1>';
			
			$req = $pdo->prepare('INSERT INTO movies (title, author, resume, publication, lastupdate) VALUES (:title, :author, :resume, :pub, :up)');
			
			$currdate = date('Y-m-d H:i:s');
			$req->bindParam(':title', $_POST['title'], PDO::PARAM_STR, 255);
			$req->bindParam(':author', $_POST['author'], PDO::PARAM_STR, 255);
			$req->bindParam(':resume', $_POST['resume']);
			$req->bindParam(':pub', $_POST['pubdate']);
			$req->bindParam(':up', $currdate);

			$req->execute();

			$req = $pdo->query('SELECT * FROM movies');

		} else if (isset($_GET['delete'])) {

			echo '<h1>Film deleted successfully</h1>';

			//var_dump($_GET['delete']);

			$req = $pdo->prepare('DELETE FROM movies WHERE id = :id');
			
			$req->bindParam(':id', (int)$_GET['delete'], PDO::PARAM_INT);

			$req->execute();

			$req = $pdo->query('SELECT * FROM movies');

		} else { ?>

			<h1>Insert new film</h1>

			<form class="pure-form" method="post" action="">
			
			<label for="title">Titre</label>
			<input type="text" name="title" placeholder="Titre..." /><br />
			
			<label for="author">Auteur</label>
			<input type="text" name="author" placeholder="Auteur..." /><br />

			<label for="resume">Resumé</label>
			<textarea name="resume" placeholder="Résumé..."></textarea><br />

			<label for="pubdate">Date de sortie</label>
			<input type="date" name="pubdate" /><br />

			<label>&nbsp;</label>
			<input class="pure-button pure-button-primary" type="submit" name="new_film" value="Enregistrer" />

		</form>

		<?php }
			
		if(isset($req)) {

			while ($row = $req->fetch(PDO::FETCH_ASSOC)) {

				echo '<a href="?search=' . htmlentities($row['title']) . '">' . htmlentities($row['title']) . '</a> <a href="?author=' . htmlentities($row['author']) . '">' . htmlentities($row['author']) . '</a> ' . htmlentities($row['resume']) . ' ' . htmlentities($row['publication']) . ' ' . htmlentities($row['lastupdate']) . ' <a href=
				"?delete=' . $row['id'] . '">delete</a><br>&nbsp;<br>';
			}
		} ?>

	</body>

</html>
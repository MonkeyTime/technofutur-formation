<?php
try
    {
    $dbh = new PDO("sqlite:./data/movies.db");
    $sql = "SELECT * FROM movies WHERE id = {$_GET['bxid']}";
    $stmt = $dbh->query($sql);
    while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) 
        {
		echo "<h1>{$row["title"]}</h1>";
        echo "<p>{$row['description']}</p>";
		echo "<img src='data/images/{$row["image"]}'/>";
		}
    }
catch(PDOException $e)
    {
    echo $e->getMessage();
    }
?>
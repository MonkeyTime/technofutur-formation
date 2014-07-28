<?php
try
    {
    $dbh = new PDO("sqlite:./data/movies.db");
    $sql = "SELECT * FROM movies";
    $stmt = $dbh->query($sql);
    while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) 
        {
		echo "<a href='d3-0b.php?bxid={$row["id"]}'>";
        echo $row["title"];
		echo "</a>";
 		echo "-" . $row["year"] . "<br/>"; 
		}
    }
catch(PDOException $e)
    {
    echo $e->getMessage();
    }
?>
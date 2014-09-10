<?php
	$firstname = isset($_POST['firstname']) ? htmlentities($_POST['firstname'], ENT_QUOTES) : '';
	$lastname = isset($_POST['lastname']) ? htmlentities($_POST['lastname'], ENT_QUOTES) : '';
	$birthday = isset($_POST['birthday']) ? htmlentities($_POST['birthday'], ENT_QUOTES) : '';
	$gender = isset($_POST['gender']) ? htmlentities($_POST['gender'], ENT_QUOTES) == "M" ? "masculin" : "féminin" : '';

    //exit(var_dump($birthday));

    if(!$firstname or !$lastname or !$birthday or !$gender) {
        header('Location: ./index.php?alert=incomplete');
    }

    if(!preg_match('#^[0-9]{4}-[0-1][0-9]-[0-3][0-9]$#', $birthday)) {
        header('Location: ./index.php?alert=birthdate_format');
    }
?>

<!DOCTYPE html>
<html lang="en">
    
    <head>
        
        <meta charset="utf-8">
        <meta name="viewport" content="initial-scale=1.0">
        
        <title>some test</title>

        <meta name="description" content="form description">

        <link rel="stylesheet" type="text/css" href="css/main.css" media="all">
        
    </head>

     <body>

        <header id="header">
            
            <div class="row wrap30 txtc">

                <h1>FilHebdo confirmation</h1>

                <p><span>Votre nom:</span> <?php echo $lastname; ?></p>
                <p><span>Votre prénom:</span> <?php echo $firstname; ?></p>
                <p><span>Votre date de naissance:</span> <?php echo $birthday; ?></p>
                <p><span>Votre sexe:</span> <?php echo $gender; ?></p>

            </div>

        </header>

    </body>

</html>
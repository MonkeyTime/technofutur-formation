<?php
    if(isset($_POST['submit'])) {
        
        $firstname = isset($_POST['firstname']) ? htmlentities($_POST['firstname'], ENT_QUOTES) : '';
        $lastname = isset($_POST['lastname']) ? htmlentities($_POST['lastname'], ENT_QUOTES) : '';
        $birthday = isset($_POST['birthday']) ? htmlentities($_POST['birthday'], ENT_QUOTES) : '';
        $gender = isset($_POST['gender']) ? htmlentities($_POST['gender'], ENT_QUOTES) == "M" ? "masculin" : "féminin" : '';
        $email = isset($_POST['email']) ? htmlentities($_POST['email'], ENT_QUOTES) : '';

        //exit(var_dump($birthday));

        if(!$firstname or !$lastname or !$birthday or !$gender) {
            $alerts[] = '<p class="alert alert-error">Merci de remplir tous les champs du formulaire</p>';
        }

        if(!preg_match('#^[0-9]{4}-[0-1][0-9]-[0-3][0-9]$#', $birthday)) {
            $alerts[] = '<p class="alert alert-error">Le format de la date n\'est pas un format valide</p>';
        }
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

            <?php 

            if(!isset($_POST['submit']) or isset($alerts)) { ?>

                <h1>FilHebdo inscription V2</h1>

                <form class="form" method="post" action="">

                    <?php

                    if(isset($alerts)) {
                        foreach ($alerts as $key => $alert) {
                            echo $alert;
                        }
                    }
                    ?>
                            
                    <label>Prénom</label>
                    <input type="text" name="firstname" placeholder="Votre prénom..." />
                    <label>Nom</label>
                    <input type="text" name="lastname" placeholder="Votre nom..." />
                    <label>email</label>
                    <input type="email" name="email" placeholder="Votre email..." />
                    <label>Date de naissance</label>
                    <input type="date" name="birthday" />
                    <label>Sexe</label>
                    <input type="radio" name="gender" value="M" /> masculin
                    <input type="radio" name="gender" value="F" /> féminim
                    <label>&nbsp;</label>
                    <input type="submit" name="submit" value="Valider" />
                </form>

            <?php } else { ?>

                <h1>FilHebdo confirmation V2</h1>

                <p><span>Votre nom:</span> <?php echo $lastname; ?></p>
                <p><span>Votre prénom:</span> <?php echo $firstname; ?></p>
                <p><span>Votre date de naissance:</span> <?php echo $birthday; ?></p>
                <p><span>Votre sexe:</span> <?php echo $gender; ?></p>
                <p><span>Votre email:</span> <?php echo $email; ?></p>

            <?php } ?>

            </div>

        </header>

    </body>

</html>
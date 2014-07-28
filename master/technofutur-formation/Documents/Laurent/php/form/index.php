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

                <h1>FilHebdo inscription</h1>

                <form class="form" method="post" action="traitment.php">

                    <?php echo (isset($_GET['alert']) and $_GET['alert'] == 'incomplete') ? '<p class="alert alert-error">Merci de remplir tous les champs du formulaire</p>' : '' ?>
                    <?php echo (isset($_GET['alert']) and $_GET['alert'] == 'birthdate_format') ? '<p class="alert alert-error">Le format de la date n\'est pas un format valide</p>' : '' ?>
                    
                    <label>Prénom</label>
                    <input type="text" name="firstname" placeholder="Votre prénom..." />
                    <label>Nom</label>
                    <input type="text" name="lastname" placeholder="Votre nom..." />
                    <label>Date de naissance</label>
                    <input type="date" name="birthday" />
                    <label>Sexe</label>
                    <input type="radio" name="gender" value="M" /> masculin
                    <input type="radio" name="gender" value="F" /> féminim
                    <label>&nbsp;</label>
                    <input type="submit" value="Valider" />
                </form>

            </div>

        </header>

    </body>

</html>

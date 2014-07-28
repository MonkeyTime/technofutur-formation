		<section id="register" class="section">
                
            <div class="row wrap30">

                <?php

                	if(isset($_POST['firstname']) and isset($_POST['lastname']) and isset($_POST['email']) and isset($_POST['accept'])) {
                        
                        $sep = '|';
                    	$newline = "\n";
                    	$line = '';

                    	$line .= isset($_POST['firstname']) ? $_POST['firstname'] . $sep : $sep;
                    	$line .= isset($_POST['lastname']) ? $_POST['lastname'] . $sep : $sep;
                    	$line .= isset($_POST['email']) ? $_POST['email'] . $sep : $sep;
                    	$line .= isset($_POST['accept']) ? $_POST['accept'] : '';
                    	$line .= $newline;

                    	$fp = fopen('_datas/newsletter.txt', 'a');
                    	fwrite($fp, $line);
                    	fclose($fp);

                    	echo '<p class="alert alert-success">Merci, vous êtes bien inscrit à notre newslettre.</p>';

                    } else {

                        echo '<p class="alert alert-error">Merci de remplir tous les champs du formulaire. <a href="./newsletter">Retour</a></p>';
                    }
                ?>

            </div>

        </section>
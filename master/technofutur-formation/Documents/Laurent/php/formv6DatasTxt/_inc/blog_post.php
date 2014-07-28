		<section id="register" class="section">
                
            <div class="row wrap30">

                <?php

                	if($_POST['title'] and $_POST['content'] and $_POST['author']) {
                        
                    	$xml = '';
                        $xml .= '<article>';

                    	$xml .= isset($_POST['title']) ? '<title>' . $_POST['title'] . '</title>': '';
                    	$xml .= isset($_POST['content']) ? '<content>' . $_POST['content'] . '</content>' : '';
                    	$xml .= isset($_POST['author']) ? '<author>' . $_POST['author'] . '</author>' : '';

                        $xml .= '</article>';

                    	if(!file_exists('_datas/counter.txt')) {
                            file_put_contents('_datas/counter.txt', 0);
                        }
                        $fp = file_get_contents('_datas/counter.txt');
                        $fp = $fp + 1;
                    	file_put_contents('_datas/counter.txt', $fp);

                        $fp = fopen('_datas/articles/article-'.file_get_contents('_datas/counter.txt').'.xml', 'w');
                        fwrite($fp, $xml);
                        fclose($fp);

                    	echo '<p class="alert alert-success">Merci, vous avez bien posté votre article.</p>';

                    } else {

                        echo '<p class="alert alert-error">Merci de remplir tous les champs du formulaire. <a href="./admin">Retour</a></p>';
                    }
                ?>

            </div>

        </section>
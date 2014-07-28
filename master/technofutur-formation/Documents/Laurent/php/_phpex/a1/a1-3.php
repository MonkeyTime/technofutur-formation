<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<!-- Utilisation des paramètres de configuration (titre et feuille de style) -->
		<title>Filhebdo</title>
		<link rel="stylesheet" href="design/bootstrap/css/bootstrap.min.css"/>
		<!--<link rel="stylesheet" href="design/bootstrap/css/bootstrap-slate.min.css"/>-->
		<link rel="stylesheet" href="design/bootstrap/css/bootstrap-slate.min.css"/>
	</head>

	<body style="padding-top:70px;">
		<div class="navbar navbar-default navbar-fixed-top">
		  <div class="container">
			<div class="navbar-header">
			  <a href="../" class="navbar-brand">FilHebdo</a>
			  <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			  </button>
			</div>
			<div class="navbar-collapse collapse" id="navbar-main">
			  <ul class="nav navbar-nav">
				<li class="dropdown">
				  <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="themes">Menu principal <span class="caret"></span></a>
				  <ul class="dropdown-menu" aria-labelledby="menu-p">
					<li><a href="#">Page d'accueil</a></li>
					<li class="divider"></li>
					<li><a href="#">Historique</a></li>
					<li><a href="#">Articles</a></li>
					<li><a href="#">Boutique</a></li>
					<li><a href="#">Concours</a></li>
				  </ul>
				</li>
				<li>
				  <a href="#">Aide</a>
				</li>
				<li>
				  <a href="#">Blog</a>
				</li>
				<li class="dropdown">
				  <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="download">Contact / Support<span class="caret"></span></a>
				  <ul class="dropdown-menu" aria-labelledby="download">
					<li><a href="#">Rédaction Belgique</a></li>
					<li><a href="#">Rédaction France</a></li>
					<li class="divider"></li>
					<li><a href="#">Suggestions</a></li>
					<li><a href="#">Réclamations</a></li>
				  </ul>
				</li>
			  </ul>

			  <ul class="nav navbar-nav navbar-right">
				<li><a href="#" target="_blank">Groupe Presse Wallonie Bruxelles</a></li>
			  </ul>

			</div>
		  </div>
		</div>
		<div class="col-lg-6">
		<?php
		 if(isset($_POST["submit"]))
			{
			echo "<div class='alert alert-dismissable alert-success'>";
			echo "<p>Merci pour votre inscription à notre newsletter!</p>";
			echo "<p>";
			echo "Votre nom : " . $_POST["nom"] . "<br />";
			echo "Votre prénom : " . $_POST["prenom"] . "<br />";
			echo "Votre sexe : " . $_POST["tel"] . "<br />";
			echo "Votre email : " . $_POST["email"] . "<br />";
			echo "</p>";
			echo "<p>Vous recevrez dès jeudi prochain -directement dans votre bôite aux lettres- notre FilInfo.</p>";
			echo "</div>";
			}
		else
			{
			?>
			<form class="form-horizontal" method="post" action="?">
			  <fieldset>
				<legend>Inscription à la newsletter</legend>
				<div class="form-group">
				  <label for="inputNom" class="col-lg-2 control-label">Nom</label>
				  <div class="col-lg-10">
					<input class="form-control" id="inputNom" placeholder="Nom" type="text" name="nom">
				  </div>
				</div>
				<div class="form-group">
				  <label for="inputPrenom" class="col-lg-2 control-label">Prénom</label>
				  <div class="col-lg-10">
					<input class="form-control" id="inputPrenom" placeholder="Prénom" type="text" name="prenom">
				  </div>
				</div>
				<div class="form-group">
				  <label for="inputTel" class="col-lg-2 control-label">Téléphone</label>
				  <div class="col-lg-10">
					<input class="form-control" id="inputTel" placeholder="Téléphone" type="text" name="tel">
				  </div>
				</div>
				<div class="form-group">
				  <label for="inputEmail" class="col-lg-2 control-label">Email</label>
				  <div class="col-lg-10">
					<input class="form-control" id="inputEmail" placeholder="Email" type="text" name="email">
				  </div>
				</div>
				<div class="form-group">
				  <label class="col-lg-2 control-label">Sexe</label>
				  <div class="col-lg-10">
					<div class="radio">
					  <label>
						<input name="sexe" id="optionsRadios1" value="m" checked="" type="radio">
						masculin
					  </label>
					</div>
					<div class="radio">
					  <label>
						<input name="sexe" id="optionsRadios2" value="f" type="radio">
						féminin
					  </label>
					</div>
				  </div>
				</div>
				<div class="form-group">
				  <label for="inputTermes" class="col-lg-2 control-label">Termes</label>
				  <div class="col-lg-10">
					<div class="checkbox">
					  <label>
						<input type="checkbox" name="termes"> J'ai lu et j'accepte les <a href="">termes et conditions d'utilisation</a> de ce site.
					  </label>
					</div>
				  </div>
				</div>
				<div class="form-group">
				  <div class="col-lg-10 col-lg-offset-2">
					<button class="btn btn-default">Annuler</button>
					<button type="submit" name="submit" class="btn btn-primary">Envoyer</button>
				  </div>
				</div>
			  </fieldset>
			</form>
			<?php
			}
		?>
		</div>
		<script src="design/js/jquery.min.js"></script>
		<script src="design/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>
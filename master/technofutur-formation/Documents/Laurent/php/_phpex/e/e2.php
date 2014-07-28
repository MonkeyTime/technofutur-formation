<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>FilHebdo - Exercice - F - XML</title>
		<link rel="stylesheet" href="design/foundation/css/foundation.css">
		<script src="design/foundation/js/vendor/modernizr.js"></script>
		<style>body {background-color:#333; margin-top:60px; color:#ccc} h2{color:#ccc}</style>
	</head>

	<body>	
		<div class="row">
			<div class="small-3 columns">
				<h2>Images</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla posuere sapien non aliquam molestie. Pellentesque hendrerit, ante mattis faucibus sollicitudin, nulla dui hendrerit arcu, in aliquet sapien magna in magna. Nunc in urna consectetur lacus sodales condimentum. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Sed venenatis dignissim nisi, ut consectetur risus porttitor nec.</p>
			</div>
			<div class="small-9 columns">

				<div class="large-8 small-6 large-centered columns text-center">
				
				<ul class="example-orbit" data-orbit class="small-block-grid-3">
				<?php
				$img_path = "data/images";
				if ($dir = opendir($img_path))  
					{
					while($file = readdir($dir))  
						{
						if(substr($file, -3) == 'jpg' && substr($file, 0, 11) == 'thumb_large')
							{
							$id = substr($file, 12);          
							echo "<li>";
							echo "<a href='e2-b.php?id=$id'>";
							echo "<img src=\"" . $img_path . "/" . $file . "\">";
							echo "</a>";
							echo "</li>";           
							}
						}   
					closedir($dir);
					}
				?>
				</ul>
				</div>
		
			</div>
		</div>
	
		<script src="design/foundation/js/vendor/jquery.js"></script>
		<script src="design/foundation/js/foundation.min.js"></script>
		<script src="design/foundation/js/foundation/foundation.orbit.js"></script>
		<script>
			  $(document).foundation();
		</script>
	</body>
</html>		
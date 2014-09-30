<?xml version="1.0" encoding="utf-8" ?>
<xslt:stylesheet version="1.0" xmlns:xslt="http://www.w3.org/1999/XSL/Transform" xmlns:redir="http://xml.apache.org/xalan/redirect" extension-element-prefixes="redir">
	
	<xslt:output method="html" />

	<xslt:template match="/">

		<html lang="en">

			<head>
				<meta charset="utf-8" />
				<title>XML et les normes associées</title>
			</head>

			<body>

				<h1>Guild</h1>

				<h2>Players</h2>

				<xslt:for-each select="guild/players/player">
					
					<div id="{@id}">
						
						<p>
							<strong>
								<xslt:value-of select="firstname" />
								<xslt:text>, </xslt:text>
								<xslt:value-of select="lastname" />
								<xslt:text> </xslt:text>
							</strong>
								
							<xslt:text>(</xslt:text> 
								<xslt:value-of select="@role" /> 
							<xslt:text>)</xslt:text>
						</p>

						<xslt:for-each select="character">

							<p>
								<xslt:value-of select="@role" />
							</p>

							<ul>
								<li><a href="characters/{descendant::name}.html"><xslt:value-of select="name" /></a></li>
								<li><a href="classes/{class}.html"><xslt:value-of select="class" /></a></li>
								<li><xslt:value-of select="race" /></li>
								<li><xslt:value-of select="gender" /></li>
								<li><xslt:value-of select="level" /></li>
								<xslt:if test="role"><li><xslt:value-of select="role" /></li></xslt:if>

								<!--hack to generate subdirectories for each character html page-->
								<xslt:apply-templates select="." />

							</ul>

						</xslt:for-each>

					</div>

				</xslt:for-each>

				<xslt:apply-templates select="guild/players" />

			</body>

		</html>
		
	</xslt:template>

	<xslt:template match="character">
    
    <redir:write file="characters/{descendant::name}.html">

    <html lang="en">

    	<head>
    		<meta charset="utf-8" />
    		<title><xslt:value-of select="name" /></title>
    	</head>
       
    	<body>

    		<p>
    			<!--l'axe de recherche est indépendant de l'élément recherché donc 
    			il faut lui signaler quel parent même s'il y en a qu'un => parent::player/firstname ou ../firstname-->
				<h1>Owner: <xslt:value-of select="../firstname" /><xslt:text>, </xslt:text> <xslt:value-of select="../lastname" /></h1>
			</p>

	        <p>
				<xslt:value-of select="@role" />
			</p>

			<ul>
				<li><xslt:value-of select="name" /></li>
				<li><xslt:value-of select="class" /></li>
				<li><xslt:value-of select="race" /></li>
				<li><xslt:value-of select="gender" /></li>
				<li><xslt:value-of select="level" /></li>
				<xslt:if test="role"><li><xslt:value-of select="role" /></li></xslt:if>
			</ul>

    	</body>

    </html>

    </redir:write>

</xslt:template>


<xslt:template match="guild/players">

    <redir:write file="classes/Paladin.html">

	    <html lang="en">

		    <head>
		    	<meta charset="utf-8" />
		    	<title>Paladin</title>
		    </head>
		       
		    <body>

		    	<h1>Paladin list</h1>

		    	<xslt:for-each select="./player/character[class = 'Paladin']">

				    <xslt:if test="role"><p><xslt:value-of select="role" /></p></xslt:if>
				    <xslt:if test="not(role != '')"><p>No role selected</p></xslt:if>

					<ul>
						<li><xslt:value-of select="name" /></li>
						<li><xslt:value-of select="race" /></li>
						<li><xslt:value-of select="gender" /></li>
						<li><xslt:value-of select="level" /></li>
					</ul>

				</xslt:for-each>

			</body>

		</html>

    </redir:write>

    <redir:write file="classes/Chaman.html">

	    <html lang="en">

		    <head>
		    	<meta charset="utf-8" />
		    	<title>Chaman</title>
		    </head>
		       
		    <body>

		    	<h1>Chaman list</h1>

		    	<xslt:for-each select="./player/character[class = 'Chaman']">

				    <xslt:if test="role"><p><xslt:value-of select="role" /></p></xslt:if>
				    <xslt:if test="not(role != '')"><p>No role selected</p></xslt:if>

					<ul>
						<li><xslt:value-of select="name" /></li>
						<li><xslt:value-of select="race" /></li>
						<li><xslt:value-of select="gender" /></li>
						<li><xslt:value-of select="level" /></li>
					</ul>

				</xslt:for-each>

			</body>

		</html>

    </redir:write>

    <redir:write file="classes/Hunter.html">

	    <html lang="en">

		    <head>
		    	<meta charset="utf-8" />
		    	<title>Hunter</title>
		    </head>
		       
		    <body>

		    	<h1>Hunter list</h1>

		    	<xslt:for-each select="./player/character[class = 'Hunter']">

				    <xslt:if test="role"><p><xslt:value-of select="role" /></p></xslt:if>
				    <xslt:if test="not(role != '')"><p>No role selected</p></xslt:if>

					<ul>
						<li><xslt:value-of select="name" /></li>
						<li><xslt:value-of select="race" /></li>
						<li><xslt:value-of select="gender" /></li>
						<li><xslt:value-of select="level" /></li>
					</ul>

				</xslt:for-each>

			</body>

		</html>

    </redir:write>

    <redir:write file="classes/DK.html">

	    <html lang="en">

		    <head>
		    	<meta charset="utf-8" />
		    	<title>DK</title>
		    </head>
		       
		    <body>

		    	<h1>DK list</h1>

		    	<xslt:for-each select="./player/character[class = 'DK']">

				    <xslt:if test="role"><p><xslt:value-of select="role" /></p></xslt:if>
				    <xslt:if test="not(role != '')"><p>No role selected</p></xslt:if>

					<ul>
						<li><xslt:value-of select="name" /></li>
						<li><xslt:value-of select="race" /></li>
						<li><xslt:value-of select="gender" /></li>
						<li><xslt:value-of select="level" /></li>
					</ul>

				</xslt:for-each>

			</body>

		</html>

    </redir:write>

</xslt:template>

</xslt:stylesheet>
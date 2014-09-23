<?xml version="1.0" encoding="utf-8" ?>
<xslt:stylesheet version="1.0" xmlns:xslt="http://www.w3.org/1999/XSL/Transform">
	
	<xslt:output method="html" />

	<xslt:template match="/">
		
		<html>

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
								<li><xslt:value-of select="name" /></li>
								<li><xslt:value-of select="class" /></li>
								<li><xslt:value-of select="race" /></li>
								<li><xslt:value-of select="gender" /></li>
								<li><xslt:value-of select="level" /></li>
								<xslt:if test="role"><li><xslt:value-of select="role" /></li></xslt:if>
							</ul>

						</xslt:for-each>

					</div>

				</xslt:for-each>

			</body>

		</html>
		
	</xslt:template>

</xslt:stylesheet>
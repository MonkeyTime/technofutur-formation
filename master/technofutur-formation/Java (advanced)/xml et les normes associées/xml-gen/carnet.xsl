<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" 
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:redir="http://xml.apache.org/xalan/redirect"

                extension-element-prefixes="redir">

<xsl:output method="html" encoding="ISO-8859-1"/>

<xsl:template match="/">
  <html>
     <head>
       <title>Les communes</title>
     </head>
     <body>
       <h2>Les communes</h2>
       <hr/>
       <ul>
         <xsl:for-each select="/carnet/personne/adresse/commune[ not(. = preceding::commune) ]">
             <li><a href="{.}.html"><xsl:value-of select="."/></a></li>  
             <xsl:apply-templates select="."/> 
         </xsl:for-each>
        </ul>
     </body>
  </html>
</xsl:template>

<xsl:template match="commune">
    <redir:write file="{.}.html">
       <body>
         <h1>Liste des habitants de <xsl:value-of select="."/></h1>
         <hr/>
         <ul>
            <xsl:for-each select="/carnet/personne[adresse/commune = current()]">
               <li>
                  <xsl:value-of select="prenom"/>
                  <xsl:text> </xsl:text>
                  <xsl:value-of select="nom"/>
               </li>
            </xsl:for-each>
         </ul>     
       </body>
    </redir:write>

</xsl:template>

</xsl:stylesheet>
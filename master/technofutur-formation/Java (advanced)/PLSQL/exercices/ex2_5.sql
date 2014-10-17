DECLARE
--déclaration de variable
	ACCEPT nom_table CHAR PROMPT "Valeur de la variable ?";

BEGIN
--exécution du code

SELECT * FROM &nom_table;

END;
/

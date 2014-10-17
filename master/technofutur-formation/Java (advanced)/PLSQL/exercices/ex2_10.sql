DECLARE
--déclaration de variable
	SUBTYPE TYPE_COLONNE_CITY IS locations.city%TYPE;
	affichage_ville TYPE_COLONNE_CITY := 0;

BEGIN
--exécution du code
	SELECT city
	INTO affichage_ville 
	FROM locations
	WHERE location_id = 2800;

	dbms_output.put_line(affichage_ville);

END;
/
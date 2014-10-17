DECLARE

BEGIN
--exécution du code
	SELECT &&nom_employe FROM &nom_table WHERE employee_id = &&id_employe;

	define;

END;
/

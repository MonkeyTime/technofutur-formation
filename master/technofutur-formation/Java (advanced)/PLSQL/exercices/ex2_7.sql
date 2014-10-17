DECLARE
--déclaration de variable
	nombre_employes NUMBER;

BEGIN
--exécution du code
	SELECT COUNT(*) INTO nombre_employes FROM employees;

	dbms_output.put_line(nombre_employes);

END;
/
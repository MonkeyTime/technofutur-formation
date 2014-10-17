DECLARE
--déclaration de variable
	prenom_kumar employees.first_name%TYPE;

BEGIN
--exécution du code
SELECT first_name INTO prenom_kumar FROM employees WHERE last_name = 'Kumar';

dbms_output.put_line(prenom_kumar);

END;
/

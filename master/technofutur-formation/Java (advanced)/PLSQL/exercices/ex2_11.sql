DECLARE
--déclaration de variable

	message VARCHAR2(32767);

	last_name employees.last_name%TYPE;
	salary employees.salary%TYPE;

BEGIN
--exécution du code

SELECT last_name, CAST(salary AS NUMBER)
INTO last_name, salary
FROM employees 
WHERE last_name = 'Kumar';

message := 'M. ' 
			|| last_name 
			|| ' gagne '
			|| salary
			|| ' euros.';

	BEGIN

		dbms_output.put_line(message);

	END;

END;
/
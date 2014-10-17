DECLARE
--déclaration de variable

	message VARCHAR2(255);

	last_name employees.last_name%TYPE;
	first_name employees.first_name%TYPE;
	id employees.employee_id%TYPE;
	hre_date employees.hire_date%TYPE;
	salary employees.salary%TYPE;

BEGIN
--exécution du code

SELECT last_name, first_name, employee_id, hire_date, salary
INTO last_name, first_name, id, hre_date, salary
FROM employees 
WHERE employee_id = 100;

message := 'M. ' 
			|| last_name 
			|| ' ' 
			|| first_name 
			|| ' est l’employé numéro '
			|| id 
			|| ', a été engagé le '
			|| hre_date 
			|| ' et gagne actuellement '
			|| salary
			|| ' euros.';

	BEGIN

		dbms_output.put_line(message);

	END;

END;
/
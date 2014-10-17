DECLARE
	salary_smith employees.salary%TYPE;
	result VARCHAR2(255);

BEGIN

	SELECT salary
	INTO salary_smith
	FROM employees
	WHERE last_name = 'Smith'
	AND first_name = 'William';

	result := 	CASE

					WHEN (salary_smith > 0) THEN 

						'M. Smith est un employé actif'

					ELSE 

						NULL

				END;

	dbms_output.put_line(result);

END;
/
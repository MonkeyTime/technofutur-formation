DECLARE
	id_manager departments.manager_id%TYPE;
	id_department departments.department_id%TYPE;
	hartstein employees%ROWTYPE;

	result VARCHAR2(255);

BEGIN

	SELECT manager_id, department_id
	INTO id_manager, id_department
	FROM departments
	WHERE department_name = 'Marketing';

	SELECT * 
	INTO hartstein
	FROM employees
	WHERE last_name = 'Hartstein'
	AND first_name = 'Michael';

----------------------------------------------------

result := 	CASE

				WHEN (id_manager = hartstein.employee_id) THEN

					'M. Hartstein -> Director -> Marketing -> OK tel: ' || hartstein.phone_number

				WHEN ((id_department = hartstein.department_id) AND (id_manager != hartstein.employee_id)) THEN

					'M. Hartstein -> Marketing -> OK'

				ELSE 

					'M. Hartstein -> Marketing -> KO'

			END;

dbms_output.put_line(result);

END;
/
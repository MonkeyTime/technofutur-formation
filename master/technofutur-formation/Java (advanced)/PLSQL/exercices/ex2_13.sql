DECLARE
--déclaration de variable

	message VARCHAR(255);
	it_manager employees%ROWTYPE;


BEGIN
--exécution du code
	SELECT * 
	INTO it_manager
	FROM employees
	WHERE employee_id = (SELECT manager_id FROM departments WHERE department_name = 'IT');


	message := 'Le manager du département IT est '
				|| it_manager.first_name 
				|| ' '
				|| it_manager.last_name
				|| ' arrivé dans l’entreprise le '
				|| it_manager.hire_date;

	dbms_output.put_line(message);

END;
/
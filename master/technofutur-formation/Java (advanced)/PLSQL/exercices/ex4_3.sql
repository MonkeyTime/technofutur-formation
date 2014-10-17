DECLARE
	kumar employees%ROWTYPE;
	cain employees%ROWTYPE;

	result VARCHAR2(255);

BEGIN

	SELECT *
	INTO kumar
	FROM employees
	WHERE last_name = 'Kumar';

	SELECT *
	INTO cain
	FROM employees
	WHERE last_name = 'McCain';

	IF((kumar.salary > cain.salary) AND (kumar.hire_date < cain.hire_date)) THEN
		
		result := 'Il y a discrimination !';

	ELSIF((kumar.salary > cain.salary) AND (kumar.hire_date > cain.hire_date)) THEN

		result := 'M. King est un bon patron';

	ELSE

		result := 'R.A.S';

	END IF;

	dbms_output.put_line(result);

END;
/
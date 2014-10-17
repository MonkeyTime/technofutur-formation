DECLARE

	CURSOR CR_datas IS 
	SELECT e.employee_id
	FROM employees e, departments d
	WHERE d.department_name = 'IT'
	AND e.department_id = d.department_id;

	TYPE collection_datas IS TABLE OF employees.employee_id%TYPE;
	array COLLECTION_DATAS;

BEGIN

	OPEN CR_datas;

	FETCH CR_datas BULK COLLECT INTO array;

	CLOSE CR_datas;

	FORALL i IN array.FIRST .. array.LAST
		UPDATE employees SET hire_date = SYSDATE WHERE employee_id = array(i);


	dbms_output.put_line(
		SQL%ROWCOUNT 
		|| ' employes -> departement IT'
	);

END;
/
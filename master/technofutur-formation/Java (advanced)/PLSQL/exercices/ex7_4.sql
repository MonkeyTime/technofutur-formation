DECLARE
	deleted_line departments%ROWTYPE;

BEGIN

	DELETE FROM departments
	WHERE department_id = 150
	RETURNING department_id, department_name, manager_id, location_id INTO deleted_line;

	dbms_output.put_line(
		'Ligne supprimée: '
		|| ' '
		|| deleted_line.department_id
		|| ', '
		|| deleted_line.department_name
		|| ', '
		|| deleted_line.manager_id
		|| ', '
		|| deleted_line.location_id
	);

END;
/
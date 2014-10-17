DECLARE
--déclaration de variable

	TYPE id_list IS TABLE OF departments.department_id%TYPE;
	tableau_id_dep ID_LIST := ID_LIST();

BEGIN
--exécution du code


	tableau_id_dep.EXTEND;

	SELECT department_id
	INTO tableau_id_dep(1)
	FROM departments
	WHERE department_name = 'Administration';

	tableau_id_dep.EXTEND;

	SELECT department_id
	INTO tableau_id_dep(2)
	FROM departments
	WHERE department_name = 'Human Resources';

	tableau_id_dep.EXTEND;

	SELECT department_id
	INTO tableau_id_dep(3)
	FROM departments
	WHERE department_name = 'Treasury';

	tableau_id_dep.EXTEND;

	SELECT department_id
	INTO tableau_id_dep(4)
	FROM departments
	WHERE department_name = 'Contracting';


	dbms_output.put_line('departement Administration = id ' || tableau_id_dep(1));
	dbms_output.put_line('departement Human Resources = id ' || tableau_id_dep(2));
	dbms_output.put_line('departement Treasury = id ' || tableau_id_dep(3));
	dbms_output.put_line('departement Contracting = id ' || tableau_id_dep(4));

END;
/
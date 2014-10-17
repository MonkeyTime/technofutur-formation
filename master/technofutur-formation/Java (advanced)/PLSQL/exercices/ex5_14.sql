DECLARE
	
	CURSOR CR_datas IS SELECT e.*, d.department_name
	FROM employees e, departments d 
	WHERE e.employee_id = d.manager_id;
	
	row CR_datas%ROWTYPE;

BEGIN

	IF (NOT CR_datas%ISOPEN) THEN
		
		OPEN CR_datas;

	END IF;

	FETCH CR_datas INTO row;

	IF (CR_datas%FOUND) THEN
		
		WHILE(CR_datas%NOTFOUND = false)

			LOOP

				IF ((row.manager_id != 0) OR (row.manager_id IS NOT NULL)) THEN

					dbms_output.put_line(
						'Le manager du departement ' 
						|| row.department_name
						|| ' est M/Mme '
						|| row.first_name 
						|| ' '
						|| row.last_name
						|| ' Vous pouvez le/la joindre au '
						|| row.phone_number
					);

				END IF;

				FETCH CR_datas INTO row;

			END LOOP;

	END IF;

	IF (CR_datas%ISOPEN) THEN
		
		CLOSE CR_datas;

	END IF;

END;
/
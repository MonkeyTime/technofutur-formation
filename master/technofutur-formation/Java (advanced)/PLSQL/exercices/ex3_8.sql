DECLARE
--déclaration de variable
	
	message VARCHAR2(255);
	part1 VARCHAR2(50);
	part2 VARCHAR2(50);

BEGIN
--exécution du code

	part1 := 'J''aime';

	BEGIN

		part2 := ' Oracle 12c';

		dbms_output.put_line('partie 1 = ' || part1 || ', partie 2 = ' || part2);

	END;

	message := part1 || part2;

	dbms_output.put_line(message);

END;
/
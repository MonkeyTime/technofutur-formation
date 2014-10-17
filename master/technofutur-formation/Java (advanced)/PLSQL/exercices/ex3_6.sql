DECLARE
--déclaration de variable

	message VARCHAR2(50);

BEGIN
--exécution du code

	message := 'Je suis trop fan d''Oracle 12c';

	BEGIN

		dbms_output.put_line(message);

	END;

END;
/
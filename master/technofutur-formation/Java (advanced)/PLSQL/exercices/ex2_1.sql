DECLARE
--déclaration de variable
	aujourd_hui DATE;

BEGIN
--exécution du code
	
	aujourd_hui := SYSDATE;
	dbms_output.put_line(aujourd_hui);

END;
/
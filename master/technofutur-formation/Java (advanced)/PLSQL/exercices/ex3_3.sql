DECLARE
--déclaration de variable
message VARCHAR2(30) NOT NULL := 'J aime ORACLE 12c';

BEGIN
--exécution du code
dbms_output.put_line(message);

END;
/
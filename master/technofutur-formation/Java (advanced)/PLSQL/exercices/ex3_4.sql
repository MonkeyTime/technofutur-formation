DECLARE
--déclaration de variable
total INT;

BEGIN
--exécution du code

total := (SELECT COUNT(*) FROM employees);

dbms_output.put_line(total);

END;
/
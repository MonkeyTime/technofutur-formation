DECLARE
	pct_fripp employees.commission_pct%TYPE;
	pct_greene employees.commission_pct%TYPE;

	result1 VARCHAR2(255);
	result2 VARCHAR2(255);

BEGIN

	SELECT commission_pct
	INTO pct_fripp
	FROM employees
	WHERE last_name = 'Fripp';

	SELECT commission_pct
	INTO pct_greene
	FROM employees
	WHERE last_name = 'Greene';

----------------------------------------------------

result1 := 	CASE

				WHEN (pct_fripp IS NULL) THEN
					'valeur pct Fripp = NULL'

				WHEN (pct_fripp = 0) THEN
					'valeur pct Fripp = 0'

				WHEN (pct_fripp < 1) THEN
					'valeur pct Fripp > 0 et < 1'

				WHEN (pct_fripp = 1) THEN
					'valeur pct Fripp = 1'

				WHEN (pct_fripp > 1) THEN
					'valeur pct Fripp > 1'

				ELSE
					NULL


			END;

-----------------------------------------------------

IF(pct_greene IS NULL) THEN

	result2 := 'valeur pct Greene = NULL';

ELSIF(pct_greene = 0) THEN

	result2 := 'valeur pct Greene = 0';

ELSIF((pct_greene > 0) AND (pct_greene < 1)) THEN

	result2 := 'valeur pct Greene > 0 et < 1';

ELSIF(pct_greene = 1) THEN

	result2 := 'valeur pct Greene = 1';

ELSIF(pct_greene > 1) THEN

	result2 := 'valeur pct Greene > 1';

ELSE
	result2 := NULL;

END IF;

dbms_output.put_line(result1);
dbms_output.put_line(result2);

END;
/
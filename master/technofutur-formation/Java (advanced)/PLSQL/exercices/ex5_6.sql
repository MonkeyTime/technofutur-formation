DECLARE

	base NUMBER := 2;

BEGIN

	LOOP

		dbms_output.put_line(base);

		base := base + 5;

		EXIT WHEN (base > 100);

	END LOOP;

END;
/
DECLARE

	base NUMBER := 2;

BEGIN

	LOOP

		IF (base > 100) THEN
			
			EXIT;

		ELSE

			dbms_output.put_line(base);

			base := base + 5;

		END IF;

	END LOOP;

END;
/
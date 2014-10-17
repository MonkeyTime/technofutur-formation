DECLARE

	base NUMBER := 1;

BEGIN

	FOR base IN 1 .. 30

		LOOP

			IF (MOD(base, 3) = 0) THEN
				
				dbms_output.put_line(base || ' est divisible par 3');

			END IF;

		END LOOP;

END;
/
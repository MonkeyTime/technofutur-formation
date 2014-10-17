DECLARE

	base NUMBER := 2;

BEGIN

	WHILE(base <= 20)

		LOOP

			dbms_output.put_line(base || ' au carre = ' || base * base);

			base := base + 1;

		END LOOP;

END;
/
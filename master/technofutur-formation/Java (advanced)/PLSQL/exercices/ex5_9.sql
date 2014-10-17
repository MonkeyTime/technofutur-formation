DECLARE

	base NUMBER := 1;

BEGIN

	WHILE(base <= 50)

		LOOP

			IF ((base < 20) OR (base > 30)) THEN

				IF (MOD(base, 2) != 0) THEN
				
					dbms_output.put_line(base || ' au carre = ' || base * base);

				END IF;
			
			END IF;

			base := base + 1;

		END LOOP;

END;
/
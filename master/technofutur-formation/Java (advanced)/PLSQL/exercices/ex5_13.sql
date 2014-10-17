DECLARE
	CURSOR CR_countries IS SELECT * FROM countries
	row CR_countries%ROWTYPE;

BEGIN

	IF (NOT CR_countries%ISOPEN) THEN
		OPEN CR_countries;
	END IF;

	FETCH CR_countries INTO row;

	IF (CR_countries%FOUND) THEN
		
		FOR indice in 1 .. 10

		LOOP
			
			IF(row.region_id = 2)
				
				dbms_output.put_line(row.coutry_name);

			END IF;

			FETCH CR_countries INTO row;

		END LOOP;

	END IF;

	IF (CR_countries%ISOPEN) THEN
		CLOSE CR_countries;
	END IF;

END;
/
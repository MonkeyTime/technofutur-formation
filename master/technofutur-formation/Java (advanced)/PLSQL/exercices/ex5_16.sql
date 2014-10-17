DECLARE
	
	CURSOR CR_datas IS SELECT l.city, l.state_province, l.country_id
	FROM locations l, regions r, countries c
	WHERE r.region_name = 'Americas'
	AND r.region_id = c.region_id
	AND c.country_id = l.country_id;

BEGIN

	dbms_output.put_line('Inplementation de l''entreprise au USA');

	FOR row IN CR_datas

	LOOP

		IF(row.country_id = 'US') THEN

			dbms_output.put_line(row.city || ', ' || row.state_province);

		END IF;

	END LOOP;

END;
/
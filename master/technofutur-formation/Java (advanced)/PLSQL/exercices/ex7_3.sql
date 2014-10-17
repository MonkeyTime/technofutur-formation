DECLARE
	new_id regions.region_id%TYPE;
	new_region regions.region_name%TYPE;

BEGIN

	INSERT INTO regions VALUES(5, 'Atlantide')
	RETURNING region_id, region_name INTO new_id, new_region;

	dbms_output.put_line(
		'La nouvelle region ajoutee est'
		|| ' '
		|| new_region
		|| ' et a le numero '
		|| new_id
	);

END;
/
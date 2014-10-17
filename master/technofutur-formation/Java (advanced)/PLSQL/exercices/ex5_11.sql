DECLARE

	base NUMBER := 0;

BEGIN

	FOR i IN REVERSE 1983 .. 2008

		LOOP

			dbms_output.put_line(i || ': ' || base || ' années ont été décomptées depuis 2008');

			base := base + 1;

		END LOOP;

END;
/
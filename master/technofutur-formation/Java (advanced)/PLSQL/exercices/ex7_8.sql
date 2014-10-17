DECLARE
	CURSOR CR_employees
	IS SELECT DISTINCT department_id
		 FROM employees ;
		
	TYPE tabDepID IS TABLE OF employees.department_id%TYPE ;
	TYPE tabLastName IS TABLE OF employees.last_name%TYPE ;
	
	tableau_id tabDepID ;
	nouvelles_id tabDepID ;
	tableau_noms tabLastName ;
	
	affichage VARCHAR2(1000) := ' employés du département IT ont vu leur contrat renouvelé ce jour ! Voici leurs noms : ' ;
	compteur INT := 0 ;
	dep_IT INT ;

BEGIN
	SELECT department_id INTO dep_IT FROM departments WHERE department_name like 'IT' ;

	OPEN CR_employees ;
	FETCH CR_employees BULK COLLECT INTO tableau_id ;
	CLOSE CR_employees ;
	
	FORALL indice_forall IN tableau_id.FIRST .. tableau_id.LAST
		UPDATE employees SET hire_date = SYSDATE
		 WHERE department_id = tableau_id(indice_forall)
			   AND hire_date < to_date('01/01/1998')
		 RETURNING last_name, department_id
				   BULK COLLECT INTO tableau_noms, nouvelles_id ;
				   
	FOR indice_for IN nouvelles_id.FIRST .. nouvelles_id.LAST
	LOOP
		IF (nouvelles_id(indice_for) = dep_IT)
		THEN affichage := affichage || tableau_noms(indice_for) || ' ; ' ;
			 compteur := compteur + 1 ;
		END IF ;
	END LOOP ;

	DBMS_OUTPUT.PUT_LINE (CAST(compteur AS VARCHAR2) || affichage) ;
END ;
/
package packinterfaces;

import packexceptions.ExceptionEtatMalDefini;

public interface EtatSante {
	int A_DIAGNOSTIQUER = 0;
	int A_OPERER = 1;
	int EN_TRAITEMENT = 2;
	int DECEDE = 3;
	int RETABLI = 4;
	
	void setEtatSante(int etat) throws ExceptionEtatMalDefini;
}

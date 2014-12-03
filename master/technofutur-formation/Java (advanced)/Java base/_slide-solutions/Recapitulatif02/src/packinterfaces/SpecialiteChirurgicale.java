package packinterfaces;

import packexceptions.ExceptionCategorie;

public interface SpecialiteChirurgicale {
	int CARDIOLOGIE = 1;
	int NEUROLOGIE = 2;
	int PNEUMOLOGIE = 3;
	int STOMATOLOGIE = 4;
	int UROLOGIE = 5;
	
	void setSpecialites(int []specialite) throws ExceptionCategorie;
}

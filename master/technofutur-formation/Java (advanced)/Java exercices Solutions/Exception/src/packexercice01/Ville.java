package packexercice01;

import packexceptions.ExceptionNbHabitantsNegatif;
import packexceptions.ExceptionNbHabitantsNul;

public class Ville {

	private String nom;
	private int nbHabitants;
	
	public Ville(String nom) {		
		this.nom = nom;
		nbHabitants = 1000;
	}

	public Ville(String nom, int nbHabitants) throws ExceptionNbHabitantsNegatif, ExceptionNbHabitantsNul {
		this.nom = nom;
		setNbHabitants(nbHabitants);
	}
	
	public String toString() {
		return nom + ": " + nbHabitants + " habitants";
	}

	public void setNbHabitants(int nbHabitants) throws ExceptionNbHabitantsNegatif, ExceptionNbHabitantsNul {
		if (nbHabitants < 0) {
			this.nbHabitants = 1000;
			throw new ExceptionNbHabitantsNegatif(nom);
		} else if (nbHabitants == 0) {
			this.nbHabitants = 1000;
			throw new ExceptionNbHabitantsNul(nom);
		} else {
			this.nbHabitants = nbHabitants;
		}
	}
}

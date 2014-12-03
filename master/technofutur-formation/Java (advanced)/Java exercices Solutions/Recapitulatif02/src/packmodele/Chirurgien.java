package packmodele;

import packexceptions.ExceptionCategorie;
import packexceptions.ExceptionMedecinComplet;
import packexceptions.ExceptionPersonneDejaPresente;
import packexceptions.ExceptionPersonneNonOperable;
import packinterfaces.SpecialiteChirurgicale;

public class Chirurgien extends Medecin implements SpecialiteChirurgicale {
	private int[] specialites;

	public Chirurgien(String nom, String prenom, String dateNaissance,
			int[] specialites) throws ExceptionCategorie {
		super(nom, prenom, dateNaissance);
		setSpecialites(specialites);
	}

	public void setSpecialites(int[] sp) throws ExceptionCategorie {
		specialites = new int[sp.length];
		for (int i = 0 ; i < sp.length ; i++) {
			if (sp[i] < 1 || sp[i] > 5) {
				throw new ExceptionCategorie();
			}
			specialites[i] = sp[i];
		}
	}

	public int[] getSpecialites() {
		return specialites;
	}
	
	public String getSpecialitesString(int nb) {
		switch (nb) {
			case CARDIOLOGIE : return "Cardiologie";
			case NEUROLOGIE : return "Neurologie";
			case PNEUMOLOGIE : return "Pneumologie";
			case STOMATOLOGIE : return "Stomatologie";
			case UROLOGIE : return "urologie";
		default : return "Spécialité inconnue";
		}
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString() + "\nListe de spécialités:");
		for (int i = 0 ; i < specialites.length ; i++) {
			builder.append("\n" + getSpecialitesString(specialites[i]));
		}
		return builder.toString();
	}

	public void ajouterPatient(Patient p) throws ExceptionPersonneDejaPresente, ExceptionMedecinComplet, ExceptionPersonneNonOperable {
		if (p.getEtatSante() == Patient.A_OPERER) {
			super.ajouterPatient(p);
		} else {
			throw new ExceptionPersonneNonOperable(p.getNom(), p.getPrenom());
		}
	}
}

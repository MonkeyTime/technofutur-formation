package packmodele;

import packexceptions.ExceptionMedecinComplet;
import packexceptions.ExceptionPersonneDejaPresente;
import packexceptions.ExceptionPersonneNonOperable;

public class Medecin extends Personne {
	private Patient[] listePatients;
	private static final int NB_MAX_PATIENT = 100;
	private int nbPatients;
	
	public Medecin(String nom, String prenom, String dateNaissance) {
		super(nom, prenom, dateNaissance);
		listePatients = new Patient[100];
		nbPatients = 0;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString() + "\nListe de patients:");
		for (int i = 0 ; i < nbPatients ; i++) {
			builder.append("\n" + listePatients[i].toStringCourt());
		}
		return builder.toString();
	}
	
	public Patient[] getListePatients() {
		return listePatients;
	}

	public int getNbPatients() {
		return nbPatients;
	}
	
	public void ajouterPatient(Patient p) throws ExceptionPersonneDejaPresente, ExceptionMedecinComplet, ExceptionPersonneNonOperable {
		if (NB_MAX_PATIENT > nbPatients) {
			for (int i = 0 ; i < listePatients.length ; i++) {
				if (listePatients[i] == null) {
					listePatients[i] = p;
					nbPatients++;
					break;
				} else if (listePatients[i].equals(p)) {
					throw new ExceptionPersonneDejaPresente(p.getPrenom(), p.getNom());
				}
			}
		} else {
			throw new ExceptionMedecinComplet(getPrenom(), getNom());
		}
	}
	
	public int rechercher (Patient p) {
		for (int i = 0 ; i < nbPatients ; i++) {
			if (listePatients[i].equals(p)) {
				return i;
			}
		}
		return -1;
	}
}

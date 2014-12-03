package packmodele;

import packexceptions.ExceptionEtatMalDefini;
import packinterfaces.EtatSante;

public class Patient extends Personne implements EtatSante {
	private int etatSante;

	public Patient(String nom, String prenom, String dateNaissance,
			int etatSante) throws ExceptionEtatMalDefini {
		super(nom, prenom, dateNaissance);
		setEtatSante(etatSante);
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append("\nEtat de santé: " + getEtatSanteString() + "\n");
		return builder.toString();
	}
	
	public String getEtatSanteString() {
		switch(etatSante) {
			case A_DIAGNOSTIQUER : return "A diagnostiquer";
			case A_OPERER : return "A opérer";
			case EN_TRAITEMENT : return "En traitement";
			case DECEDE : return "Décédé";
			case RETABLI : return "Rétabli";
			default : return "Etat inconnu"; 
		}
	}

	public int getEtatSante() {
		return etatSante;
	}

	public void setEtatSante(int etatSante) throws ExceptionEtatMalDefini {
		if (etatSante >=0 && etatSante <= 4) {
			this.etatSante = etatSante;
		} else {
			throw new ExceptionEtatMalDefini(getPrenom(), getNom());
		}
	}
}

package packmodele;

import packexceptions.ExceptionHopitalComplet;
import packexceptions.ExceptionPersonneDejaPresente;

public class Hopital  {
	private Personne[] listePersonnes;
	private static final int NB_MAX_PERSONNES = 1000;
	private int nbPersonnes;
	
	public Hopital() {
		listePersonnes = new Personne[NB_MAX_PERSONNES];
		nbPersonnes = 0;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder("Hôpital:\n");
		for (int i = 0 ; i < nbPersonnes ; i++) {
			builder.append(listePersonnes[i].toString() + "\n");
		}
		return builder.toString();
	}
	
	public void ajouter(Personne p) throws ExceptionPersonneDejaPresente, ExceptionHopitalComplet {
		if (NB_MAX_PERSONNES > nbPersonnes) {
			for (int i = 0 ; i < listePersonnes.length ; i++) {
				if (listePersonnes[i] == null) {
					listePersonnes[i] = p;
					nbPersonnes++;
					break;
				} else if (listePersonnes[i].equals(p)) {
					throw new ExceptionPersonneDejaPresente(p.getPrenom(), p.getNom());
				}
			}
		} else {
			throw new ExceptionHopitalComplet();
		}
	}

	public Personne[] getListePersonnes() {
		return listePersonnes;
	}
	
	public Personne[] getListeMedecins() {
		Personne[] listeMedecins = new Personne[nbPersonnes];
		int j = 0;
		for (int i = 0 ; i < nbPersonnes ; i++) {
			if (listePersonnes[i] instanceof Medecin) {
				listeMedecins[j] = listePersonnes[i];
				j++;
			}
		}
		return listeMedecins;
	}
	
	public Personne[] getListePatients() {
		Personne[] listePatients = new Personne[nbPersonnes];
		int j = 0;
		for (int i = 0 ; i < nbPersonnes ; i++) {
			if (listePersonnes[i] instanceof Patient) {
				listePatients[j] = listePersonnes[i];
				j++;
			}
		}
		return listePatients;
	}
	
	public int rechercher(Personne p) {
		for (int i = 0 ; i < nbPersonnes ; i++) {
			if (listePersonnes[i].equals(p)) {
				return i;
			}
		}
		return -1;
	}
}

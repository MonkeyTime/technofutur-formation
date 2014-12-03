package packheritageinterface05;

public class Ouvrier extends Personne {
	
	private double salaireHoraire;
	private int []nbHeuresSemaine;
	private int []nbHeuresWE;
	private static final int NB_MOIS = 2;
	
	public Ouvrier(String nom, String prenom, String date, Adresse adresse, CompteCourant compte, double salaireHoraire) {
		super(nom, prenom, date, adresse, compte);
		this.salaireHoraire = salaireHoraire;
		nbHeuresSemaine = new int[NB_MOIS];
		nbHeuresWE = new int[NB_MOIS];
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder(super.toString());
		buffer.append("\nSalaire horaire: ");
		buffer.append(salaireHoraire);
		return buffer.toString();
	}
	
	public void setSalaireHoraire(double salaireHoraire) {
		this.salaireHoraire = salaireHoraire;
	}

	public void paiementSalaire() {
		int somme = 0;
		for (int i = 0 ; i < NB_MOIS ; i++) {
			somme += (nbHeuresSemaine[i] * salaireHoraire);
			somme += (nbHeuresWE[i] * salaireHoraire * 3);
		}
		
		getCompte().deposerArgent(somme);
	}

	public void setNbHeuresSemaine(int[] nbHeures) {
		this.nbHeuresSemaine = nbHeures;
	}

	public void setNbHeuresWE(int[] nbHeuresWE) {
		this.nbHeuresWE = nbHeuresWE;
	}
}

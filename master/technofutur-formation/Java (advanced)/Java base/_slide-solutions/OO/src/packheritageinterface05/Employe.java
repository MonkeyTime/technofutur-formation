package packheritageinterface05;

public class Employe extends Personne {

	private double salaireMensuel;
	private int []nbHeures;
	private int []nbHeuresFaites;
	private static final int NB_MOIS = 3;
	private static final int BONUS = 100;
	private static final int MALUS = 50;
	
	public Employe(String nom, String prenom, String date, Adresse adresse, CompteCourant compte, double salaireMensuel) {
		super(nom, prenom, date, adresse, compte);
		this.salaireMensuel = salaireMensuel;
		nbHeures = new int[NB_MOIS];
		nbHeuresFaites = new int[NB_MOIS];
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder(super.toString());
		buffer.append("\nSalaire mensuel: ");
		buffer.append(salaireMensuel);
		return buffer.toString();
	}

	public void setSalaireMensuel(double salaireMensuel) {
		this.salaireMensuel = salaireMensuel;
	}

	public void paiementSalaire() {
		double salaireTotal = 0;
		for (int i = 0 ; i < NB_MOIS ; i++) {
			int aFaire = nbHeures[i];
			int fait = nbHeuresFaites[i];
			
			int bonusMalus = (fait - aFaire);
			double somme = salaireMensuel;
			if (bonusMalus > 0) {
				bonusMalus /= 5;
				somme += bonusMalus * BONUS;
			} else {
				somme -= bonusMalus * MALUS;
			}
			
			salaireTotal += somme;
		}
		
		getCompte().deposerArgent(salaireTotal);
	}

	public void setNbHeures(int[] nbHeures) {
		this.nbHeures = nbHeures;
	}

	public void setNbHeuresFaites(int[] nbHeuresFaites) {
		this.nbHeuresFaites = nbHeuresFaites;
	}
}

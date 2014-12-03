package packheritageinterface01;

public abstract class Compte implements CompteInterface {
	
	private String num;
	private String titulaire;
	private double solde;
	
	public Compte(String num, String titulaire, double solde) {		
		this.num = num;
		this.titulaire = titulaire;
		this.setSolde(solde);
	}

	public String getNum() {
		return num;
	}
	
	public String getTitulaire() {
		return titulaire;
	}

	public double getSolde() {
		return solde;
	}
	
	public void setSolde(double solde) {
		if (solde > 0) {
			this.solde = solde;
		} else {
			this.solde = 0;
		}
	}
	
	public void deposerArgent(double somme) {
		if (somme > 0) {
			solde += somme;
		}
	}
	
	// Devra être redéfinie dans les sous-classes
	public abstract void retirerArgent(double somme);
	
	public String toString() {
		return "Numéro: " + num + "\nTitulaire: " + titulaire + "\nSolde: " + solde;
	}
	
	
}

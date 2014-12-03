package packheritageinterface01;

public class CompteEpargne extends Compte {

	private double tauxInteret;

	public CompteEpargne(String num, String titulaire, double solde,
			double tauxInteret) {
		// Appel au constructeur de Compte
		super(num, titulaire, solde);
		// Affectation du taux d'intérêt
		this.setTauxInteret(tauxInteret);
	}

	public void setTauxInteret(double tauxInteret) {
		if (tauxInteret > 0 && tauxInteret < 0.2) {
			this.tauxInteret = tauxInteret;
		} else {
			this.tauxInteret = 0.08;
		}
	}

	public double calculerInteret() {
		double interet = tauxInteret * this.getSolde();
		this.setSolde(this.getSolde() + interet);
		return interet;
	}

	public void retirerArgent(double somme) {
		if (somme > 0 && this.getSolde() - somme >= 0) {
			this.setSolde(this.getSolde() - somme);
		}
	}

	public String toString() {
		return "Compte Epargne\n" + super.toString() + "\nTaux d'intérêt: "
				+ this.tauxInteret;
	}

	public CompteEpargne clone() {
		return new CompteEpargne(getNum(), getTitulaire(), getSolde(),
				tauxInteret);
	}

	public boolean equals(Object o) {
		if (o instanceof CompteEpargne) {
			CompteEpargne ce = (CompteEpargne) o;
			if (!(this.getNum().equals(ce.getNum()))) {
				return false;
			}
			if (!(this.getTitulaire().equals(ce.getTitulaire()))) {
				return false;
			}
			if (!(this.getSolde() == ce.getSolde())) {
				return false;
			}
			if (!(this.tauxInteret == ce.tauxInteret)) {
				return false;
			}
			return true;
		}
		return false;
	}
}

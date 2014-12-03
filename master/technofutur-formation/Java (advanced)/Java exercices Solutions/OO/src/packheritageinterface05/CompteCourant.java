package packheritageinterface05;

public class CompteCourant extends Compte {

	private double decouvert;
	
	public CompteCourant(String num, String titulaire, double solde, double decouvert) {
		// Appel au constructeur de Compte
		super(num, titulaire, solde);
		// Affectation du découvert
		this.setDecouvert(decouvert);
	}
	
	public void setDecouvert(double decouvert) {
		if (decouvert > 0) {
			this.decouvert = decouvert;
		} else {
			this.decouvert = 0;
		}
	}

	public void retirerArgent(double somme) {
		if (somme > 0 && this.getSolde() - somme >= -decouvert) {
			this.setSolde(this.getSolde() - somme);
		}
	}
	
	public String toString() {
		return "Compte Courant\n" + super.toString() + "\nDécouvert: " + decouvert;
	}

	public CompteCourant clone() {
		return new CompteCourant(getNum(), getTitulaire(), getSolde(),
				decouvert);
	}

	public boolean equals(Object o) {
		if (o instanceof CompteCourant) {
			CompteCourant cc = (CompteCourant) o;
			if (!(this.getNum().equals(cc.getNum()))) {
				return false;
			}
			if (!(this.getTitulaire().equals(cc.getTitulaire()))) {
				return false;
			}
			if (!(this.getSolde() == cc.getSolde())) {
				return false;
			}
			if (!(this.decouvert == cc.decouvert)) {
				return false;
			}
			return true;
		}
		return false;
	}
}

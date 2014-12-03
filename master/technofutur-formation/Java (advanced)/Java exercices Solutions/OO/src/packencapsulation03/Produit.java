package packencapsulation03;

public class Produit {

	private String reference;
	private String libelle;
	private double prix;
	private int nb;
	private double tva;

	public Produit(String reference, String libelle, double prix, int nb,
			double tva) {
		this.reference = reference;
		this.libelle = libelle;
		this.prix = prix;
		this.nb = nb;
		this.tva = tva;
	}

	public Produit(String reference, String libelle, double prix, int nb) {
		// Syntaxe valable dans les constructeurs uniquement!!!!
		this(reference, libelle, prix, nb, 0.21);
	}

	public void augmenterStock(int quantite) {
		if (quantite > 0) {
			nb += quantite;
		}
	}
	
	public void diminuerStock(int quantite) {
		if (quantite > 0 && nb - quantite >= 0) {
			nb -= quantite;
		}
	}
	
	public double getFacture(int quantite) {
		double fact;
		if (quantite < nb) {
			fact = quantite * prix;
			fact += fact * tva;
			return fact;
		}
		return 0;
	}
	
	public String toString() {
		String tmp = "Informations sur le produit :";
		tmp += "\nReference : " + reference;
		tmp += "\nLibellé : " + libelle;
		tmp += "\nPrix unitaire : " + prix;
		tmp += "\nQuantité en stock : " + nb;
		tmp += "\nTVA : " + tva;
		return tmp;
	}
	
	public Produit clone() {
		Produit p1 = new Produit(this.libelle, this.reference, this.prix, this.nb, this.tva);
		return p1;
	}
}

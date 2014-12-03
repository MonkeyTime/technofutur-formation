package jeucarte;

public class Joueur {
	private String nom;
	private Paquet cartesJouees;
	private Paquet cartesNonJouees;
	
	public Joueur(String nom){
		this.nom = nom;		
		this.cartesJouees = new Paquet();
		this.cartesNonJouees = new Paquet();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Paquet getCartesJouees() {
		return cartesJouees;
	}

	public void setCartesJouees(Paquet cartesJouees) {
		this.cartesJouees = cartesJouees;
	}

	public Paquet getCartesNonJouees() {
		return cartesNonJouees;
	}

	public void setCartesNonJouees(Paquet cartesNonJouees) {
		this.cartesNonJouees = cartesNonJouees;
	}
	
	public Integer nombreCartesRestantes(){
		return this.cartesJouees.taille() + this.cartesNonJouees.taille();
	}
	
	public String toString(){
		return this.nom;
	}	
	
	public Carte jouerCarte(){
		if (getCartesNonJouees().estVide()){
			getCartesNonJouees().fusionerPaquet(getCartesJouees());
			getCartesJouees().viderPaquet();
			getCartesNonJouees().melanger();			
		}
		
		return getCartesNonJouees().jouerCarte();	
	}
}

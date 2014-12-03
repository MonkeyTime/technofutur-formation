package jeucarte;

public class Carte {
	private Couleur couleur;
	private Rang rang;
	
	public Carte(Couleur couleur, Rang rang){
		this.couleur = couleur;
		this.rang = rang;
	}
	
	public String toString(){
		return this.rang + " de " + this.couleur;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public Rang getRang() {
		return rang;
	}

	public void setRang(Rang rang) {
		this.rang = rang;
	}
	
	public boolean equals(Object o){
		if (o instanceof Carte){
			Carte c = (Carte) o;
			
			return (couleur.equals(c.couleur) && rang.equals(c.rang));
		}
		return false;
	}
}

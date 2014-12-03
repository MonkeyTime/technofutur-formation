package packexercice3;

public class Cours {
	private String libelle;
	private int annee;
	private int nbHeures;	
	
	public Cours(String libelle, int annee, int nbHeures) {		
		this.libelle = libelle;
		this.annee = annee;
		this.nbHeures = nbHeures;
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public int getNbHeures() {
		return nbHeures;
	}
	public void setNbHeures(int nbHeures) {
		this.nbHeures = nbHeures;
	}
	
	public boolean equals(Object o){
		if (o instanceof Cours){
			Cours cours = (Cours) o;
			if (!this.libelle.equals(cours.libelle)){
				return false;
			}
			if (this.annee != cours.annee){
				return false;
			}
			return true;
		}
		return false;
	}
	
}

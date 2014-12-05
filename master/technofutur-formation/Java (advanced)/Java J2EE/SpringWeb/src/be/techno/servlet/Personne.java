package be.techno.servlet;

public class Personne {

	private int id;
	private String nom;
	
	public Personne(){}
	
	public Personne(String nom){
		this.nom = nom;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + "]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}

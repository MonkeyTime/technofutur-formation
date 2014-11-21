package be.techno.servlet;

public class Personne {

	private String id;
	private String nom;
	
	public Personne() {}
	
	public void setId(String id) {
		
		this.id = id;
	}
	
	public void setNom(String nom) {
		
		this.nom = nom;
		
	}
	
	public String getId() {
		
		return this.id;
	}

	public String getNom() {
		
		return this.nom;
	}

	@Override
	public String toString() {
		return id + ": " + nom + "\r\n";
	}
}

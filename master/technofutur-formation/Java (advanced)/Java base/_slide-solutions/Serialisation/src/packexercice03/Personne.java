package packexercice03;

import java.io.Serializable;

public class Personne implements Comparable<Personne>, Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nom, prenom, dateNaissance;
	private static int compteur = 1020;
	
	public Personne(String nom, String prenom, String dateNaissance) {
		super();
		this.id = compteur;
		compteur += 10;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}
	
	public String toStringCourt() {
		StringBuilder builder = new StringBuilder("Détails d'un " + this.getClass().getSimpleName() + "\n");
		builder.append("Nom: " + nom + "\n");
		builder.append("Prénom: " + prenom + "\n");
		return builder.toString();
	}

	public String toString() {
		StringBuilder builder = new StringBuilder(this.toStringCourt());
		builder.append("Date de naissance: " + dateNaissance + "\n");
		builder.append("ID: " + id + "\n");
		return builder.toString();
	}
	
	public int compareTo (Personne p) {
		int valeurNom = this.nom.compareTo(p.nom);
		return (valeurNom  == 0) ? this.prenom.compareTo(p.prenom) : valeurNom;
	}
}

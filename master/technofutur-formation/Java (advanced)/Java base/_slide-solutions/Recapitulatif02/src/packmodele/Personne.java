package packmodele;


public class Personne  {
	private int id;
	private String nom, prenom, dateNaissance;
	private static int compteur = 1020;
	
	public Personne(String nom, String prenom, String dateNaissance) {		
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
		return prenom + " " + nom;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder("Détails d'un " + this.getClass().getSimpleName() + "\n");
		builder.append("Nom: " + nom + "\n");
		builder.append("Prénom: " + prenom + "\n");
		builder.append("Date de naissance: " + dateNaissance + "\n");
		builder.append("ID: " + id);
		return builder.toString();
	}
	
 
}

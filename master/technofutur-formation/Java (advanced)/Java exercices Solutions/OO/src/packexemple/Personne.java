package packexemple;

public class Personne {

	private String nom;
	private String prenom;
	private int age;
	private String sexe;
	private int vitesseDeDeplacement;
	
	private static int nbPersonnes = 0;
	
	public Personne(String nom, String prenom, int age, String sexe, int vitesseDeDeplacement) {
		this.nom = nom;
		this.prenom = prenom;
		setAge(age);
		this.sexe = sexe;
		this.vitesseDeDeplacement = vitesseDeDeplacement;
		nbPersonnes++;
	}
	
	public Personne(String nom, String prenom, String sexe, int vitesseDeDeplacement) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = 5;
		this.sexe = sexe;
		this.vitesseDeDeplacement = vitesseDeDeplacement;
		nbPersonnes++;
	}
	
	public static int getNbPersonnes() {
		return nbPersonnes;
	}
	
	int bonAnniversaire() {
		age++;
		return age;
	}
	
	public void marcher() {
		vitesseDeDeplacement = 5;
	}
	
	public void courrir() {
		vitesseDeDeplacement = 15;
	}
	
	public void dormir() {
		vitesseDeDeplacement = 0;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		if (age <= 100) {
			this.age = age;
		} else {
			this.age = 5;
		}
	}
}

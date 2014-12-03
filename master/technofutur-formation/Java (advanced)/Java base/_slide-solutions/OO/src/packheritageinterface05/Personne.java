package packheritageinterface05;

import java.util.Calendar;

public abstract class Personne {

	private String nom;
	private String prenom;
	private String dateNaissance;
	private Adresse adresse;
	private CompteCourant compte;
	
	public Personne(String nom, String prenom, String date, Adresse adresse, CompteCourant compte) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = date;
		this.adresse = adresse;
		this.compte = compte;
	}
	
	public String toString() {
		StringBuilder buffer = new StringBuilder(this.getClass().getSimpleName()); // Récupération du nom de la classe
		buffer.append(" ");
		buffer.append(nom);
		buffer.append(" ");
		buffer.append(prenom);
		buffer.append("\nDate de naissance: ");
		buffer.append(dateNaissance);
		buffer.append("\nAdresse: ");
		buffer.append(adresse);
		buffer.append("\nSolde du compte: ");
		buffer.append(compte.getSolde());
		return buffer.toString();
	}
	
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public int getAge() {
		int anneeActuelle = Calendar.getInstance().get(Calendar.YEAR);
		int moisActuel = Calendar.getInstance().get(Calendar.MONTH);
		int jourActuel = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		
		// Date format => dd/MM/yyyy
		int anneeNaissance = Integer.parseInt(dateNaissance.substring(6, 10));
		int moisNaissance = Integer.parseInt(dateNaissance.substring(3,5));
		int jourNaissance = Integer.parseInt(dateNaissance.substring(0,2));
		
		int age = anneeActuelle - anneeNaissance;
		
		if (moisActuel < moisNaissance) {
			age--;
		} else if (moisActuel == moisNaissance) {
			if (jourActuel < jourNaissance) {
				age--;
			}
		}
		return age;
	}
	
	public void depenserArgent(double somme) {
		compte.retirerArgent(somme);
	}
	
	public abstract void paiementSalaire();

	public CompteCourant getCompte() {
		return compte;
	}
}

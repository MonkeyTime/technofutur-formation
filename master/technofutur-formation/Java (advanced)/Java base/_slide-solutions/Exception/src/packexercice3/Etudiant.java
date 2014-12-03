package packexercice3;

public class Etudiant {

	private String nom;
	private String prenom;
	private Cours[] cours;
	private int nbCours;
	
	public Etudiant(String nom, String prenom){
		this.setNom(nom);
		this.setPrenom(prenom);
		this.cours = new Cours[10];
		this.nbCours = 0;
	}
	
	public void ajouterCours(Cours cours) throws Exception{
		if (nbCours > 9){
			throw new Exception("Nombre de cours maximal atteint");			
		} 
		if (contient(this.cours,cours)){
			throw new Exception(cours.getLibelle() + " est déjà présent");			
		}
		
		System.out.println("Ajout du cours " + cours.getLibelle() + " à l'indice " + nbCours);
		this.cours[nbCours] = cours;
		this.nbCours++;		 
	}
	
	private boolean contient(Cours[] cours, Cours c){
		for (int i = 0 ; i < 10 ; i++){
			if (cours[i] != null && cours[i].equals(c)){
				return true;
			}
		}
		
		return false;
	}
	
	public String getCours(int indice) throws Exception{
		if (indice < 0){
			throw new Exception("Indice négatif");
		} 
		if (indice >= 10){
			throw new Exception("Indice trop grand");
		}		
		if (cours[indice] == null){
			throw new Exception("Pas de cours à cet indice");
		}		
		
		return cours[indice].getLibelle();
	}

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
}

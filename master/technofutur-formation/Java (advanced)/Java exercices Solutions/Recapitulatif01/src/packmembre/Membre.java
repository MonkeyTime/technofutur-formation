package packmembre;

import packmedia.Media;

public class Membre {
	
	private String nom, prenom;
	private int numeroMembre;
	private static int nbMembres = 1000;
	private Location[] listeLocations;
	
	public Membre(String nom, String prenom) {		
		this.nom = nom;
		this.prenom = prenom;
		nbMembres++;
		this.numeroMembre = nbMembres;
		listeLocations = new Location[5];
	}
	
	public boolean equals(Object o) {
		if (o instanceof Membre) {
			Membre m = (Membre) o;
			return (this.nom.equals(m.nom) && this.prenom.equals(m.prenom));
		}
		return false;
	}
	
	public boolean ajouterLocation(Media m, String date, int nbJours) {
		if (m.isDisponible()) {
			for (int i = 0 ; i < listeLocations.length ; i++) {
				if (listeLocations[i] == null) {
					Location l = new Location(m, date, nbJours);
					listeLocations[i] = l;
					return true;
				}
			}
			//Nombre maximal de locations atteint
			return false;
		} else {
			//Média déjà loué
			return false;
		}
	}
	
	public String infoMin() {
		return nom + " " + prenom + " " + numeroMembre;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder(this.getClass().getSimpleName());
		builder.append(": ");
		builder.append(nom);
		builder.append(" ");
		builder.append(prenom);
		builder.append("\n");
		
		for (int i = 0 ; i < listeLocations.length && listeLocations[i] != null ; i++) {
			builder.append(listeLocations[i].toString());
			builder.append("\n");
		}
		return builder.toString();
	}
	
	public double calculerPrixLocations() {
		double prix = 0;
		 
		for (int i = 0 ; i < listeLocations.length && listeLocations[i] != null ; i++) {
			prix += listeLocations[i].calculerPrix();
		}
		return prix;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}
}

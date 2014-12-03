package packarraylist;

public class Cycliste implements Comparable<Cycliste> {

	private int classement;
	private String nom;
	
	public Cycliste(int classement, String nom) {		
		this.classement = classement;
		this.nom = nom;
	}

	public int getClassement() {
		return classement;
	}

	public String getNom() {
		return nom;
	}

	public String toString() {
		return classement + " " + nom;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Cycliste) {
			Cycliste c = (Cycliste) o;
			return c.classement == this.classement;
		}
		return false;
	}

	public int compareTo(Cycliste c) {
		return this.classement - c.classement;
	}
}

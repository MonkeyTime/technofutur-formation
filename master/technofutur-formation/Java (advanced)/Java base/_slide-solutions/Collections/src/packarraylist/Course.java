package packarraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course {

	private String nom;
	private List<Cycliste> classement;
	
	public Course(String nom) {	
		this.nom = nom;
		this.classement = new ArrayList<Cycliste>();
	}
	
	public void ajouterCycliste(Cycliste c) throws DoublonException {
		if (classement.contains(c)) {
			throw new DoublonException("Cette place est déjà attribuée: " + c.getClassement());
		}
		classement.add(c);
	}
	
	public void suppression(Cycliste c) {
		classement.remove(c);
	}
	
	public void remplacer(int place, String nom) {
		Cycliste c = new Cycliste(place, nom);
		int indice = classement.indexOf(c);
		if (indice >= 0) {
			classement.set(indice, c);
		}
	}
	
	public Cycliste premier() {
		return Collections.min(classement);
	}
	
	public Cycliste dernier() {
		return Collections.max(classement);
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder("Nom de la course: " + nom + "\nClassement:\n");
		ArrayList<Cycliste> classe = new ArrayList<Cycliste>(classement);
		Collections.sort(classe);		
		for (Cycliste c : classe) {
			builder.append(c.toString() + "\n");
		}
		return builder.toString();
	}
}

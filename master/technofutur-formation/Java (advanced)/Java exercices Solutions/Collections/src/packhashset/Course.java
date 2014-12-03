package packhashset;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Course {

	private String nom;
	private HashSet<Cycliste> classement;
	
	public Course(String nom) {
		this.nom = nom;
		classement = new HashSet<Cycliste>();
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
		HashSet<Cycliste> tmp = new HashSet<Cycliste>(classement);
		for (Cycliste c : tmp) {
			if (c.getClassement() == place) {
				classement.remove(c);
				classement.add(new Cycliste(place, nom));
				return;
			}
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
		TreeSet<Cycliste> classe = new TreeSet<Cycliste>(classement);
		Iterator<Cycliste> it = classe.iterator();
		while(it.hasNext()) {
			builder.append(it.next().toString() + "\n");
		}
		return builder.toString();
	}
}

package packtreeset;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class Course {

	private String nom;
	private TreeSet<Cycliste> classement;
	
	public Course(String nom) {
		super();
		this.nom = nom;
		classement = new TreeSet<Cycliste>();
	}
	
	public void ajouterCycliste(Cycliste c) throws DoublonException {
		if (classement.add(c) == false) {
			throw new DoublonException("Cette place est déjà attribuée: " + c.getClassement());
		}
	}
	
	public void suppression(Cycliste c) {
		classement.remove(c);
	}
	
	public void remplacer(int place, String nom) {
		Iterator<Cycliste> it = classement.iterator();
		Cycliste c;
		while (it.hasNext()) {
			c = it.next();
			if (c.getClassement() == place) {
				classement.remove(c);
				classement.add(new Cycliste(place, nom));
				return;
			} else if (c.getClassement() > place) {
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
		Iterator<Cycliste> it = classement.iterator();
		while(it.hasNext()) {
			builder.append(it.next().toString() + "\n");
		}
		return builder.toString();
	}
}

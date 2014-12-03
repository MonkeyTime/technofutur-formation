package packtreemap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Course {

	private String nom;
	private TreeMap<Integer,Cycliste> classement;
	
	public Course(String nom) {
		super();
		this.nom = nom;
		classement = new TreeMap<Integer,Cycliste>();
	}
	
	public void ajouterCycliste(Cycliste c) throws DoublonException {
		if (classement.containsKey(c.getKey())) {
			throw new DoublonException("Cette place est déjà attribuée: " + c.getClassement());
		}
		classement.put(c.getKey(), c);
	}
	
	public void suppression(Cycliste c) {
		classement.remove(c.getKey());
	}
	
	public void remplacer(int place, String nom) {
		Cycliste c = new Cycliste(place, nom);
		classement.remove(c.getKey());
		classement.put(c.getKey(), c);
	}
	
	public Cycliste premier() {
		return classement.get(1);
	}
	
	public Cycliste dernier() {
		return classement.get(classement.size());
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder("Nom de la course: " + nom + "\nClassement:\n");
		Set<Map.Entry<Integer, Cycliste>> entrees = classement.entrySet();
		Iterator<Map.Entry<Integer, Cycliste>> it = entrees.iterator();
		while (it.hasNext()) {
			builder.append(it.next().toString() + "\n");
		}
		return builder.toString();
	}
}

package packhashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Course {

	private String nom;
	private HashMap<Integer,Cycliste> classement;
	
	public Course(String nom) {
		this.nom = nom;
		classement = new HashMap<Integer,Cycliste>();
	}
	
	public void ajouterCycliste(Cycliste c) throws DoublonException {
		if (classement.containsKey(c.getClassement())) {
			throw new DoublonException("Cette place est déjà attribuée: " + c.getClassement());
		}
		classement.put(c.getClassement(), c);
	}
	
	public void suppression(Cycliste c) {
		classement.remove(c.getClassement());
	}
	
	public void remplacer(int place, String nom) {
		Cycliste c = new Cycliste(place, nom);
		if (classement.containsKey(c.getClassement())) {
			classement.remove(c.getClassement());
			classement.put(c.getClassement(), c);
		}
	}
	
	public Cycliste premier() {
		return classement.get(1);
	}
	
	public Cycliste dernier() {
		return classement.get(classement.size());
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder("Nom de la course: " + nom + "\nClassement:\n");
		TreeMap<Integer, Cycliste> tmp = new TreeMap<Integer, Cycliste>(classement);
		Set<Map.Entry<Integer, Cycliste>> entrees = tmp.entrySet();
		Iterator<Map.Entry<Integer, Cycliste>> it = entrees.iterator();
		while (it.hasNext()) {
			builder.append(it.next().toString() + "\n");
		}
		return builder.toString();		
	}
}

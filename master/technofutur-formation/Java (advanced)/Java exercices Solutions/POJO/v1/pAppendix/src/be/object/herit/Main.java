package be.object.herit;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		Person p1 = new Person("Lanyster Tywin", true, 50);
		Person p2 = new Person("Stark Rob", true, 55 );
		Person p3 = new Person("Lanyster Tywin", true, 50);
		
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(null));
		System.out.println(p1.equals(p1));
		System.out.println(p1.equals(p3));
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p3.hashCode());
		
		System.out.println(p1.compareTo(p2));
		System.out.println(p1.compareTo(p3));
		System.out.println(p2.compareTo(p1));
		
		ArrayList<Person> liste1 = new ArrayList<Person>();
		liste1.add(p2);
		liste1.add(p1);
		
		System.out.println(liste1);
		Collections.sort(liste1);
		System.out.println(liste1);
		
		Collections.sort(liste1, new AgePersonComparator());
		System.out.println(liste1);
		
	}

}

package be.object.herit_apache;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		Person p1 = new Person("Lannister Tywin", true, 50, 2, "", "", "");
		Person p2 = new Person("Stark Robb", true, 55, 2, "", "", "");
		Person p3 = new Person("Lannister Tywin", true, 50, 2, "", "", "");
		
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(null));
		System.out.println(p1.equals(p1));
		System.out.println(p1.equals(p3));
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p3.hashCode());

		System.out.println(p1);
	}

}

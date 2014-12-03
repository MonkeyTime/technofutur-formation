package be.object.herit;

import java.util.Comparator;

public class AgePersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		/*if(p1.getAge()<p2.getAge())
			return -1;
		else if(p1.getAge()==p2.getAge())
			return 0;
		else
			return 1;*/
		Integer age1 = p1.getAge();
		Integer age2 = p2.getAge();
		return age1.compareTo(age2);
	}

}

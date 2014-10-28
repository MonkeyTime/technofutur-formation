package be.technofutur.oopexternalinternal;

public class Main {

	public static void main(String[] args) {


		Person person = new Person("John", 30);
		Person.Address address = person.new Address("Mermoz's street");

	}

}

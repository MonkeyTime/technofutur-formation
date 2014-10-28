package be.technofutur.oopexternalinternal;

/**
 * external public class
 * 
 * @author forma1311
 *
 */
public class Person {

	private int age;
	private String name;
	
	private Contact contact;
	
	/**
	 * Constructor
	 */
	public Person() {}
	
	/**
	 * Constructor
	 * 
	 * @param name
	 * @param age
	 */
	public Person(String name, int age) {

		this.name = name;
		this.age = age;
		this.contact = new Contact();
	}
	
	/**
	 * Constructor
	 * 
	 * @param name
	 * @param age
	 * @param email
	 */
	public Person(String name, int age, String email) {

		this(name, age);
		this.contact = new Contact(email);
	}
	
	/**
	 * public internal class
	 *
	 */
	public class Address {
		
		private String street;
		
		public Address (String street) {
			
			this.street = street;
			//Person.this.
		}
	}
	
	/**
	 * private internal class
	 * 
	 */
	private class Contact {
		
		private String email;
		
		public Contact() {}
		
		public Contact(String email) {
			
			this.email = email;
		}
	}

}

package be.technofutur.hospital;
import java.util.LinkedList;

public final class Hospital {
	
	static LinkedList<Person> persons = new LinkedList<Person>();
	
	/**
	 * Constructor
	 * 
	 */
	protected Hospital() {}
	
	public static void addPerson(Person person) throws Exception {
		
		for(int i = 0; i < persons.size(); i++) {
			
			if(persons.get(i).equals(person)) {
				
				throw new Exception("This person " + person.firstName + " " + person.lastName + " already exist.");
			}
		}
		
		persons.add(person);
	}
	
	public static Doctor getDoctorsList() {
		
		return null;
	}
	
	public static Patient getPatientsList() {
			
		return null;
	}
}

package be.technofutur.social;

import java.util.Arrays;

public class Registry {

	protected Person [] registry;
	protected static int count = 0;
	protected static int i = 0;
	
	/**
	 * Constructor
	 * 
	 * @param tabsize
	 * 
	 */
	public Registry(int tabsize) {
		
		this.registry = new Person[tabsize];
		
	}
	
	/**
	 * countPersons
	 * 
	 * @return count 	the total of Person in the current array of Person
	 */
	public int countPersons() {
		
		count = 0;
		
		for(int i = 0; i < this.registry.length; i++) {
			
			if (this.registry[i] != null) {
				
				count++;
			}
		}
		
		return count;
	}
	
	/**
	 * addPerson
	 * 
	 * add Person to the array
	 * 
	 * @param person
	 */
	public void addPerson(Person person) {
		
		if(i < this.registry.length) {
			
			this.registry[i] = person;
			
			i++;
			
		} else {
			
			System.out.println("Array size full. Please create a new array.");
		}
	}
	
	/**
	 * toString
	 * 
	 * @override
	 * 
	 */
	public String toString() {
		
		return "Registry [registry=" + Arrays.toString(registry) + "]";
	}
}

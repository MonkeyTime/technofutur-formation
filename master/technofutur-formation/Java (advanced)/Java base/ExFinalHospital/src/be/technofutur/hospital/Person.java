package be.technofutur.hospital;

public abstract class Person {

	protected int id;
	protected int index = 0;
	protected String firstName; 
	protected String lastName;
	protected String birthDate;
	
	/**
	 * Constructor 
	 * 
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * 
	 */
	public Person(String firstName, String lastName, String birthDate) {
		
		this.id = ++index;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	/**
	 * toString
	 * 
	 * @Override
	 */
	public String toString() {
		
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", birthDate=" + birthDate + "]";
	}

	/**
	 * getFirstName
	 * 
	 * @return String 
	 */
	public String getFirstName() {
		
		return firstName;
	}

	/**
	 * setFirstName
	 * 
	 * @param String
	 */
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
	}

	/**
	 * getLastName
	 * 
	 * @return String
	 */
	public String getLastName() {
		
		return lastName;
	}

	/**
	 * setLastName
	 * 
	 * @param String
	 */
	public void setLastName(String lastName) {
		
		this.lastName = lastName;
	}

	/**
	 * getBirthDate
	 * 
	 * @return String
	 */
	public String getBirthDate() {
		
		return birthDate;
	}

	/**
	 * setBirthDate
	 * 
	 * @param String 	Date of birth
	 */
	public void setBirthDate(String birthDate) {
		
		this.birthDate = birthDate;
	}
	
	

}

package be.technofutur.social;

public class Person implements ISocialStatus {

	protected String nationalNumber;
	protected String lastname;
	
	/**
	 * Constructor
	 * 
	 * @param nationalNumber
	 * @param lastname
	 * 
	 */
	public Person(String nationalNumber, String lastname) {
		
		this.lastname = lastname;
		this.nationalNumber = nationalNumber;
	}
	
	/**
	 * getNationalNumber
	 * 
	 * @return mixed national number with prefix
	 * 
	 */
	public String getNationalNumber() {
		
		return PREFIX + this.nationalNumber;
	}
	
	/**
	 * toString
	 * 
	 * @override
	 * 
	 */
	public String toString() {
		
		return "Person [nationalNumber = " + nationalNumber + ", lastname = " + lastname + "]";
	}

	/**
	 * equals
	 * 
	 * @override
	 * 
	 * @return boolean	true on success, false on failure
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (nationalNumber == null) {
			if (other.nationalNumber != null)
				return false;
		} else if (!nationalNumber.equals(other.nationalNumber))
			return false;
		return true;
	}
	
	

}

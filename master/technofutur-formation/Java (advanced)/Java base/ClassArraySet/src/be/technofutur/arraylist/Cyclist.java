package be.technofutur.arraylist;

public class Cyclist implements Comparable<Cyclist> {

	protected int ranking;
	protected String firstName;
	protected String lastName;
	
	public Cyclist() {}
	
	/**
	 * Constructor
	 * 
	 * @param firstName
	 * @param lastName
	 * @param ranking
	 */
	public Cyclist(String firstName, String lastName, int ranking) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.ranking = ranking;
	}

	/**
	 * 
	 * compareTo
	 * 
	 * @Override
	 * 
	 * @param o
	 * 
	 * @return
	 */
	public int compareTo(Cyclist o) {

		return this.ranking - o.ranking;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ranking;
		return result;
	}
	
	public int getHashCode(String firstName, String lastName, int ranking) {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ranking;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Cyclist other = (Cyclist) obj;
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (ranking != other.ranking) {
			return false;
		}
		return true;
	}
	
	

}

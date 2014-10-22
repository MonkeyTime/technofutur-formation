package be.technofutur.arraylist;

public class Cyclist implements Comparable<Cyclist> {

	protected int ranking;
	protected String firstName;
	protected String lastName;
	
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
	
	

}

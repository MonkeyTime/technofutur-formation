package be.technofutur.arraylist;
import java.util.HashSet;
import java.util.Set;

public class Race {

	protected String raceName;
	protected Set<Cyclist> ranking = new HashSet<Cyclist>();
	
	/**
	 * Constructor
	 * 
	 * @param raceName
	 */
	public Race(String raceName) {
	
		this.raceName = raceName;
	}
	
	/**
	 * addRacer
	 * 
	 * @param cyclist
	 * 
	 * @throws Exception 
	 */
	public void addRacer(Cyclist cyclist) throws Exception {
		
		if(ranking.contains(cyclist)) {
			
			throw new Exception("This rank is already in use.");
		}
		
		ranking.add(cyclist);
	}
	
	/**
	 * deleteRacer
	 * 
	 * @param cyclist
	 */
	public void deleteRacer(Cyclist cyclist) {
		
		ranking.remove(cyclist);
	}
	

	/**
	 * replaceRacer
	 * 
	 * @param rank
	 * @param firstName
	 * @param lastName
	 */
	public void replaceRacer(int rank, String firstName, String lastName) {
		
	}
	
	/**
	 * getFirst
	 * 
	 * @return
	 */
	public Cyclist getFirst() {
		
		return null;
	}
	
	/**
	 * getLast
	 * 
	 * @return
	 */
	public Cyclist getLast() {
	
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((raceName == null) ? 0 : raceName.hashCode());
		result = prime * result + ((ranking == null) ? 0 : ranking.hashCode());
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
		Race other = (Race) obj;
		if (raceName == null) {
			if (other.raceName != null) {
				return false;
			}
		} else if (!raceName.equals(other.raceName)) {
			return false;
		}
		if (ranking == null) {
			if (other.ranking != null) {
				return false;
			}
		} else if (!ranking.equals(other.ranking)) {
			return false;
		}
		return true;
	}
	
	
}

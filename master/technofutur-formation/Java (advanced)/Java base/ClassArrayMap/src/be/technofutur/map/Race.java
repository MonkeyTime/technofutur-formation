package be.technofutur.map;
import java.util.HashMap;
import java.util.Map;

public class Race {

	protected String raceName;
	protected Map<Integer, Cyclist> ranking = new HashMap<Integer, Cyclist>();
	
	/**-------------------
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
	public void addRacer(Cyclist cyclist, Integer rank) throws Exception {
		
		if(ranking.containsKey(rank)) {
			
			throw new Exception("This rank is already in use for the cyclist " + ranking.get(rank).firstName + " " +  ranking.get(rank).lastName + ". Use replace method or choose another rank index.");
		}
		
		ranking.put(rank, cyclist);
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
		
		Cyclist tmp = ranking.get(rank);
		tmp.firstName = firstName;
		tmp.lastName = lastName;
		
		ranking.put(rank, tmp);
	}
	
	/**
	 * getFirst
	 * 
	 * @return
	 */
	public Cyclist getFirst() {
		
		return ranking.get(1);
		
	}
	
	/**
	 * getLast
	 * 
	 * @return
	 */
	public Cyclist getLast() {
		
		return ranking.get(ranking.size() - 1);
		
	}
}

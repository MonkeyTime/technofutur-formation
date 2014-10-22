package be.technofutur.arraylist;
import java.util.ArrayList;

public class Race {

	protected String raceName;
	protected ArrayList<Cyclist> ranking = new ArrayList<Cyclist>();
	
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
	public void addRacer(Cyclist cyclist, int rank) throws Exception {
		
		if(ranking.indexOf(rank) != -1) {
			
			throw new Exception("This rank is already in use for the cyclist " + ranking.get(rank).firstName + " " +  ranking.get(rank).lastName + ". Use replace method or choose another rank index.");
		}
		
		ranking.add(rank, cyclist);
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
		
		Cyclist tmpIn = ranking.get(rank);
		
		for(int i = 0; i < ranking.size(); i++) {
			
			Cyclist tmpOut = ranking.get(i);
			
			if(firstName == tmpOut.firstName && lastName == tmpOut.lastName) {
				
				ranking.set(rank, tmpOut);
				
				ranking.set(i, tmpIn);
				
				break;
			}
		}
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

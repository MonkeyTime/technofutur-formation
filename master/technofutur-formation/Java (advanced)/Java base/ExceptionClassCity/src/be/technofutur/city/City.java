package be.technofutur.city;

import java.util.Scanner;

/**
 * 
 * @author forma1311
 *
 */
public class City {

	protected String name;
	protected int totalResident;
	
	/**
	 * Constructor
	 * 
	 * @param name
	 * 
	 */
	public City(String name) {
		
		this.name = name;
		this.totalResident = 1000;
	}

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param totalResident 	Can't be negative and can't be null
	 * 
	 * @throws Exception
	 * 
	 */
	public City(String name, int totalResident) throws Exception {
		
		try {
			
			if(totalResident < 0) {			
				
				throw new Exception("Total resident can't be negative.");
			}
			
			if((Integer)totalResident == null) {
				
				throw new Exception("Total resident can't be null and must be defined.");
			}
			
		} catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		} finally {
			
			this.name = name;
			
			this.totalResident = (totalResident  < 0 || (Integer)totalResident == null) ? 1000 : totalResident;
		}
	}
	
	/**
	 * 
	 * setTotalResident
	 * 
	 * @return int 	Total resident
	 * 
	 * @throws Exception
	 */
	public int setTotalResident() throws Exception {
		
		Scanner Scan = new Scanner(System.in);
		this.totalResident = 0;
			
		try {
			
			while(this.totalResident == 0) {
				
				System.out.println("Choisissez le nombre d'habitant\n");
				this.totalResident = Scan.nextInt();
			
				if((Integer)this.totalResident == null) {
					
					throw new Exception("Total resident must be a number/digit.");
				}
			}
			
		} catch(Exception e) {
			
			System.out.println(e.getMessage());	
			
		} finally {
			
			Scan.close();
		}
		
		return this.totalResident;
	
	}
}

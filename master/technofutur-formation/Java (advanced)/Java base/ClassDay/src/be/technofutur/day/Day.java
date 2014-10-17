package be.technofutur.day;

public class Day {


	protected String day = "";
	
	protected String [] days = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
	
	protected static int i = 0;
	
	/**
	 * Constructor
	 * 
	 * @param day
	 */
	public Day(String day) {
		
		switch(day) {
			
			case("Lundi"):
				i = 0;
			break;
			
			case("Mardi"):
				i = 1;
			break;
			
			case("Mercredi"):
				i = 2;
			break;
			
			case("Jeudi"):
				i = 3;
			break;
			
			case("Vendredi"):
				i = 4;
			break;
			
			case("Samedi"):
				i = 5;
			break;
			
			case("Dimanche"):
				i = 6;
			break;
			
			default:
			break;
		
		}
		
		this.getCurrentDay(i);
	}
	
	
	protected String getCurrentDay(int i) {
		
		return this.days[i];
		
	}
	
	public String getNextDay() {
		
		i++;
		
		if(i > 7) {
			i = 0;
		}
		
		return this.days[i];
	}

	public String getPreviousDay() {
		
		i--;
		
		if(i < 0) {
			i = 7;
		}
		
		return this.days[i];
	}

}

package be.technofutur.mediacenter;

public class Location {

	protected Media media;
	protected String date;
	protected int totalDays;
	protected double price;
	
	/**
	 * Constructor
	 * 
	 * @throws Exception 
	 * 
	 */
	public Location(Media media, String date, int totalDays) throws Exception {
	
		if(media.available) {
			
			this.media = media;
			this.date = date;
			this.totalDays = totalDays;
			this.price = media.dayPrice * totalDays;
			
			return;
		}
		
		throw new Exception("This media " + media.title + " is already in rent.");
	}

}

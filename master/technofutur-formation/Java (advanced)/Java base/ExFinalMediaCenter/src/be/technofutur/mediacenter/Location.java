package be.technofutur.mediacenter;

public class Location {

	protected Media media;
	protected String date;
	protected int totalDays;
	protected double price;
	protected boolean isAvailable;
	
	/**
	 * Constructor
	 * 
	 */
	public Location(Media media, String date, int totalDays) {
	
		this.media = media;
		this.date = date;
		this.totalDays = totalDays;
		this.price = media.dayPrice * totalDays;
	}

}

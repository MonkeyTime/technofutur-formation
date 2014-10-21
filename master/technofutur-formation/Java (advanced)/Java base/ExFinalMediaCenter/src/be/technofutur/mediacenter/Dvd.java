package be.technofutur.mediacenter;

public final class Dvd extends Media {

	public int DOCUMENTARY = 0;
	public int FILM = 1;
	public int SERIE = 2;
	
	protected int gender;
	
	/**
	 * Constructor
	 * @throws Exception 
	 */
	public Dvd(String title, int gender) throws Exception {
		
		super(title);
		this.dayPrice = 0.40;
		this.gender = gender;
	}

}

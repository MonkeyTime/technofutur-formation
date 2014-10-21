package be.technofutur.mediacenter;

public final class Dvd extends Media {

	public final int DOCUMENTARY = 0;
	public final int FILM = 1;
	public final int SERIE = 2;
	
	protected int gender;
	
	/**
	 * Constructor
	 * @throws Exception 
	 */
	public Dvd(String title, int gender) throws Exception {
		
		super(title);
		
		if(gender < 0 || gender > 3) {
			
			throw new Exception("Use only DOCUMENTARY, FILM or SERIE constant for gender.");
		}
		
		this.dayPrice = 0.40;
		this.gender = gender;
	}

}

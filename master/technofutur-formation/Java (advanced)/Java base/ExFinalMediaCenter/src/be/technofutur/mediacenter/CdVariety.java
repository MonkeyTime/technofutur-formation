package be.technofutur.mediacenter;

public final class CdVariety extends CdMusical {

	protected boolean isGoldDisk;

	/**
	 * Constructor
	 * @throws Exception 
	 * 
	 */
	public CdVariety(String title, String author, int totalSong, boolean isGoldDisk) throws Exception {
		
		super(title, author, totalSong);
		this.dayPrice = 0.30;
		this.isGoldDisk = isGoldDisk;
	}
	
	/**
	 * isGoldDisk
	 * 
	 * @return boolean
	 */
	public boolean isGoldDisk() {
		
		return isGoldDisk;
	}

	/**
	 * setGoldDisk
	 * 
	 * @param boolean 	Is Gold disk ?
	 */
	public void setGoldDisk(boolean isGoldDisk) {
		
		this.isGoldDisk = isGoldDisk;
	}

}

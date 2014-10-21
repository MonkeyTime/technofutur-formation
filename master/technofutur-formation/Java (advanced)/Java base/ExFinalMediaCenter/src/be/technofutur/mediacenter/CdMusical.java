package be.technofutur.mediacenter;

public class CdMusical extends Media {

	protected String author;
	protected int totalSong;
	
	/**
	 * Constructor
	 * 
	 * @param title
	 * @param author
	 * @param isGoldDisk
	 * @throws Exception 
	 */
	public CdMusical(String title, String author, int totalSong) throws Exception {
		
		super(title);
		this.dayPrice = 0.34;
		this.author = author;
		this.totalSong = totalSong;
	}

	/**
	 * getAuthor
	 * 
	 * @return String 	 The author
	 */
	public String getAuthor() {
		
		return author;
	}

	/**
	 * setAuthor
	 * 
	 * @param String 	The author
	 */
	public void setAuthor(String author) {
		
		this.author = author;
	}

	/**
	 * getTotalSong
	 * 
	 * @return int 	
	 */
	public int getTotalSong() {
		
		return totalSong;
	}

	/**
	 * setTotalSong
	 * 
	 * @param int
	 */
	public void setTotalSong(int totalSong) {
		
		this.totalSong = totalSong;
	}

}

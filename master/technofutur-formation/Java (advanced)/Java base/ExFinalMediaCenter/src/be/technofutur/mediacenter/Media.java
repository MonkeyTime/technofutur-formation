package be.technofutur.mediacenter;

public abstract class Media {

	protected int id = 0;
	protected static int index = 0;
	protected String title;
	protected double dayPrice;
	protected boolean available;
	
	/**
	 * Constructor
	 * 
	 * @param title
	 * @param dayPrice
	 * 
	 * @throws Exception 
	 */
	public Media(String title, double dayPrice) throws Exception {
		
		this.title = title;
		this.id = ++index;
		this.dayPrice = dayPrice;
		this.available = true;
		
		Library.push(this);
	}
	
	public Media(String title) throws Exception {
		
		this.title = title;
		this.id = ++index;
		this.available = true;
		
		Library.push(this);
	}

	/**
	 * getTitle
	 * 
	 * @return String 	The title
	 */
	public String getTitle() {
		
		return title;
	}

	/**
	 * setTitle
	 * 
	 * @param String 	The title
	 */
	public void setTitle(String title) {
		
		this.title = title;
	}

	/**
	 * getDayPrice
	 * 
	 * @return double 	The price for one day rent
	 */
	public double getDayPrice() {
		
		return dayPrice;
	}

	/**
	 * 
	 * @param double 	The price for one day rent
	 */
	public void setDayPrice(double dayPrice) {
		
		this.dayPrice = dayPrice;
	}

	/**
	 * isAvailable
	 * 
	 * @return boolean
	 */
	public boolean isAvailable() {
		
		return available;
	}

	/**
	 * setAvailable
	 * 
	 * @param boolean
	 */
	public void setAvailable(boolean available) {
		
		this.available = available;
	}
	
	/**
	 * toString
	 * 
	 * @override
	 */
	public String toString() {
		return "Media [id=" + id + ", title=" + title + ", dayPrice="
				+ dayPrice + ", available=" + available + "]";
	}

	/**
	 * equals
	 * 
	 * @Override
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Media other = (Media) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}

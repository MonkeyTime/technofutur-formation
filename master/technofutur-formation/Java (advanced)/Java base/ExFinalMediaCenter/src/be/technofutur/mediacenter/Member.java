package be.technofutur.mediacenter;

public final class Member {

	protected String firstName;
	protected String lastName;
	protected int num;
	protected static int index = 0;
	protected static int i = 0;
	protected Location [] rentTable = new Location [5];
	
	/**
	 * Constructor
	 * 
	 */
	public Member(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.num = ++index;
	}
	
	/**
	 * addRent
	 * 
	 * add one current location media for this client
	 * 
	 * @param media
	 * 
	 * @throws Exception
	 */
	public void addRent(Location media) throws Exception {
		
		if(i >= 0 && i < 5 && media.totalDays < 7) {
			
			media.media.available = false;
			
			Library.updateAvailability(media.media);
			
			rentTable[i] = media;
			
			i++;
			
			return;
		}
		
		if(i >= 0 && i < 5 && media.totalDays >= 7) {
			
			media.media.available = false;
			
			Library.updateAvailability(media.media);
			
			media.price -= media.price * 0.20;
			
			rentTable[i] = media;
			
			i++;
			
			return;
		}
		
		throw new Exception("Maximum media rent reached for this user.");
	}

	/**
	 * toString
	 * 
	 * @Override
	 */
	public String toString() {
		
		return "Member [firstName=" + firstName + ", lastName=" + lastName
				+ ", num=" + num + "]";
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
		Member other = (Member) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	

}

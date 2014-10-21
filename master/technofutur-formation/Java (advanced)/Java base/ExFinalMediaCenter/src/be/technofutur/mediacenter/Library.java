package be.technofutur.mediacenter;

public final class Library {

	protected static String name = "super-location.com";
	protected static int MAX_MEMBERS = 100;
	protected static int MAX_MEDIAS = 5000;
	protected static int indexMembers = 0;
	protected static int indexMedias = 0;
	protected static Member [] members = new Member [MAX_MEMBERS];
	protected static Media [] medias = new Media [MAX_MEDIAS];
	protected static double total = 0;
	

	/**
	 * Constructor
	 * 
	 * @protected
	 * 
	 */
	protected Library() {}
	
	public Library getInstance() {
		
		return new Library();
	}
	
	/**
	 * getName
	 * 
	 * @return String 	The business name
	 */
	public static String getName() {
		
		return Library.name;
	}

	/**
	 * setName
	 * 
	 * @param String 	 Eventually the new name
	 */
	public static void setName(String name) {
		
		Library.name = name;
	}
	
	/**
	 * addMember
	 * 
	 * @param Member 	 The object member to add
	 * 
	 * @return boolean
	 * 
	 * @throws Exception
	 */
	public static boolean addMember(Member member) throws Exception {
		
		if(indexMembers >= MAX_MEMBERS) {
			
			return false;
		}
		
		for(int i = 0; i < MAX_MEMBERS; i++) {
			
			if(member.firstName == members[i].firstName && member.lastName == members[i].lastName) {
				
				return false;
			}
		}
		
		members[++indexMembers] = member;
		
		return true;
	}
	
	/**
	 * push
	 * 
	 * method to push a media directly from its Media instance in the library list
	 * 
	 * @param media
	 * 
	 * @throws Exception
	 */
	public static void push(Media media) throws Exception {
		
		if(indexMedias >= MAX_MEDIAS) {
			
			throw new Exception("MAX medias in library reached.");
		}
		
		for(int i = 0; i < MAX_MEDIAS; i++) {
			
			if(media.title == medias[i].title) {
				
				throw new Exception("This medias " + media.title  + " already exist in library.");
			}
		}
		
		medias[++indexMedias] = media;
	}
	
	/**
	 * getMedias
	 * 
	 * get all medias from the library
	 * 
	 * @return String
	 */
	public static String getMedias() {
		
		StringBuilder str = new StringBuilder();
		
		for(int i = 0; i < MAX_MEDIAS; i++) {
				
			str.append(medias[i].id + ": " + medias[i].title + " " + "(availability: " + medias[i].available + ")");
		}
		
		return str.toString();
	}
	
	/**
	 * getMediasAvailable
	 * 
	 * get all available medias from the library
	 * 
	 * @return String
	 */
	public static String getMediasAvailable() {
		
		StringBuilder str = new StringBuilder();
		
		for(int i = 0; i < MAX_MEDIAS; i++) {
			
			if(medias[i].available) {
				
				str.append(medias[i].id + ": " + medias[i].title + "(available)");
			}
		}
		
		return str.toString();
	}
	
	/**
	 * calculateRentFromMember
	 * 
	 * @param Member
	 * 
	 * @return double 	The total sum from current rent(s) of this user
	 * 
	 */
	public static double calculateRentFromMember(Member member) {
		
		for(int i = 0; i < member.rentTable.length; i++) {
			
			total += member.rentTable[i].price;
		}
		
		return total;
	}
	
	/**
	 * updateAvailability
	 * 
	 * @param Media 	The media to update availability
	 */
	public static void updateAvailability(Media media) {
		
		for(int i = 0; i < MAX_MEDIAS; i++) {
			
			if(medias[i].equals(media)) {
				
				medias[i].available = media.available;
				
				break;
			}
		}
		
	}
}

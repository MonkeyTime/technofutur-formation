package be.technofutur.gamecard;

public class Player {

	protected String nickname;
	protected CardDeck cards;
	
	/**
	 * Constructor
	 * 
	 * @param nickname
	 * 
	 */
	public Player(String nickname) {
		
		this.nickname = nickname;
	}
	
	/**
	 * Constructor
	 * 
	 * @param nickname
	 * @param cards
	 * 
	 */
	public Player(String nickname, CardDeck cards) {
		
		this.nickname = nickname;
		this.cards = cards;
	}

}

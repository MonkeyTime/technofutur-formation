package be.technofutur.gamecard;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.BiConsumer;

public class CardDeck {
	
	Map<Integer, String> cardsDeck = new HashMap<Integer, String>();
	protected Integer i = 1;
	protected static int MAX_CARDS = 52;

	/**
	 * Constructor
	 * 
	 * @throws Exception
	 * 
	 */
	public CardDeck() throws Exception {
			
		if(i <= 10) {
			
			this.cardsDeck.put(i, i.toString() +  " de COEUR");
			this.cardsDeck.put(i+1, i.toString() +  " de PIQUE");
			this.cardsDeck.put(i+2, i.toString() +  " de TREFLE");
			this.cardsDeck.put(i+3, i.toString() +  " de CARREAU");
			
			i++;
		}
		
		if(i <= 13) {
			
			switch(i) {
				
				case(11):
					this.cardsDeck.put(i+4, "Valet de COEUR");
					this.cardsDeck.put(i+5, "Valet de PIQUE");
					this.cardsDeck.put(i+6, "Valet de TREFLE");
					this.cardsDeck.put(i+7, "Valet de CARREAU");
				break;
				
				case(12):
					this.cardsDeck.put(i+8, "Dame de COEUR");
					this.cardsDeck.put(i+9, "Dame de PIQUE");
					this.cardsDeck.put(i+10, "Dame de TREFLE");
					this.cardsDeck.put(i+11, "Dame de CARREAU");
				break;
				
				case(13):
					this.cardsDeck.put(i+12, "Roi de COEUR");
					this.cardsDeck.put(i+13, "Roi de PIQUE");
					this.cardsDeck.put(i+14, "Roi de TREFLE");
					this.cardsDeck.put(i+15, "Roi de CARREAU");
				break;
				
				default:
				break;
			}
		}
		
		if(cardsDeck.size() != MAX_CARDS) {
			
			throw new Exception("cards deck size > MAX_CARDS. Verify the constructor CardDeck.");
		}
		
		this.cardsDeck.forEach(randomize());
	}
	
	/**
	 * getCardsDeck
	 * 
	 * @return card
	 */
	public Map<Integer, String> getCardsDeck() {
		
		return this.cardsDeck;
		
	}
	
	/**
	 * randomize
	 * 
	 * @private
	 * 
	 * @return null
	 */
	private BiConsumer<? super Integer, ? super String> randomize() {
		
		Integer x = null, y = null;
		
		Random rand = new Random();
		
		while (x == y) {
			
			x = rand.nextInt(52) + 1;
			y = rand.nextInt(52) + 1;
		}
		
		cardsDeck.put(x, cardsDeck.get(y));
		cardsDeck.put(y, cardsDeck.get(x));
		
		return null;
	}
	
	public int getKey(int i) {
		
		return 0;
		
	}
}

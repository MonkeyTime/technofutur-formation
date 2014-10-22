package be.technofutur.gamecard;

import java.util.Random;

public class Fight {

	protected Player player1, player2, firstPlayer, secondPlayer, currentPlayer;
	
	/**
	 * Constructor
	 * 
	 * @param player1
	 * @param player2
	 */
	public Fight(Player player1, Player player2) {
		
		this.player1 = player1;
		this.player2 = player2;
		
		this.init();
		
		this.game();
	}
	
	/**
	 * init
	 * 
	 */
	protected void init() {
		
		Random rand = new Random();
		int first = rand.nextInt(2) + 1;
		
		if(first == 1) {
			this.firstPlayer = this.player1;
			this.secondPlayer = this.player2;
			this.currentPlayer = this.player1;
					
		} else {
			this.firstPlayer = this.player2;
			this.secondPlayer = this.player1;
			this.currentPlayer = this.player2;
		}
	}
	
	/**
	 * switchPlayer
	 * 
	 * @param player
	 */
	protected void switchPlayer(Player player) {
		
		if(player.nickname != this.player1.nickname) {
			
			this.currentPlayer = this.player1;
			
		} else {
			
			this.currentPlayer = this.player2;
		}
	}
	
	/**
	 * game
	 * 
	 * start automated game
	 */
	protected void game() {
		
		int i = 1;
		int j = 1;
		
		while(!this.currentPlayer.cards.cardsDeck.isEmpty()) {
			
			System.out.println("Tour " + i + "\n");
			System.out.println(this.firstPlayer.nickname + ": " + this.firstPlayer.cards.cardsDeck.get(j));
			System.out.println(this.secondPlayer.nickname + ": " + this.secondPlayer.cards.cardsDeck.get(j));
			
			if(this.firstPlayer.cards.cardsDeck.get(j) == this.secondPlayer.cards.cardsDeck.get(j)) {
				
				int count = 1;
				
				System.out.println("Bataille !!! \n");
				
				j++;
				
				while(this.firstPlayer.cards.cardsDeck.get(j) == this.secondPlayer.cards.cardsDeck.get(j)) {
					
					j++;
					count++;
				}
				
				if(this.firstPlayer.cards.cardsDeck.getKey(j) > this.secondPlayer.cards.cardsDeck.getKey(j)) {
					
					System.out.println(this.firstPlayer.nickname + ": a gagné le tours.\n");
					
					for(int k = count; k > j; k--)
						this.secondPlayer.cards.cardsDeck.remove(k);
					
					System.out.println(this.firstPlayer.nickname + " carte restante: " + this.firstPlayer.cards.cardsDeck.size() + "\n");
					System.out.println(this.secondPlayer.nickname + " carte restante: " + this.secondPlayer.cards.cardsDeck.size() + "\n");
					
				} else {
					
					System.out.println(this.secondPlayer.nickname + ": a gagné le tours.\n");
					
					for(int k = count; k > j; k--)
						this.firstPlayer.cards.cardsDeck.remove(k);
					
					System.out.println(this.firstPlayer.nickname + " carte restante: " + this.firstPlayer.cards.cardsDeck.size() + "\n");
					System.out.println(this.secondPlayer.nickname + " carte restante: " + this.secondPlayer.cards.cardsDeck.size() + "\n");
				}
				
				
				
			} else if(this.firstPlayer.cards.cardsDeck.getKey(j) > this.secondPlayer.cards.cardsDeck.getKey(j)) {
				
				System.out.println(this.firstPlayer.nickname + ": a gagné le tours.\n");
				
				this.secondPlayer.cards.cardsDeck.remove(j);
				
				System.out.println(this.firstPlayer.nickname + " carte restante: " + this.firstPlayer.cards.cardsDeck.size() + "\n");
				System.out.println(this.secondPlayer.nickname + " carte restante: " + this.secondPlayer.cards.cardsDeck.size() + "\n");
				
				j++;
				
			} else {
				
				System.out.println(this.secondPlayer.nickname + ": a gagné le tours.\n");
				
				this.firstPlayer.cards.cardsDeck.remove(j);
				
				System.out.println(this.firstPlayer.nickname + " carte restante: " + this.firstPlayer.cards.cardsDeck.size() + "\n");
				System.out.println(this.secondPlayer.nickname + " carte restante: " + this.secondPlayer.cards.cardsDeck.size() + "\n");
				
				j++;
			}
			
			i++;
			
			this.switchPlayer(this.currentPlayer);
		}
	}

}

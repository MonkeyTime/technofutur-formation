package be.technofutur.wallet;

public class Wallet {

	protected static double total = 0;	
	protected static double entier = 0;
	protected static double fraction = 0;
	protected static double rest = 0;
	
	protected static int [] arrMoney = {0, 0, 0, 0, 0, 0, 0};
									  //1  5 10 20 50  1  2 numbers of each piece
									  //0  1  2  3  4  5  6 array keys of each piece
		
	/**
	 * Constructor
	 * 
	 */
	private Wallet() {}
	
	/**
	 * getTotal
	 * 
	 * @return double
	 */
	public static double getTotal() {
		
		return total;
	}
	
	/**
	 * addMoney
	 * 
	 * add money to your wallet
	 * 
	 * @param double (the money to add)
	 */
	public static void addMoney(double money) {
		
		addMoneyToWallet(money);
		
		total += money;
	}
	
	/**
	 * 
	 * @return
	 */
	private static void resetWallet() {
		
		for(int i = 0; i < 7; i++) {
				arrMoney[i] = 0;
		}
	}
	
	/**
	 * decompileMoney
	 * 
	 * add money to the array arrMoney filtered by Euro pieces
	 * 
	 * @param double
	 */
	private static void addMoneyToWallet(double money) {
		
		fraction = money % 1;
		entier = money - fraction;
		
		rest = entier;
				
		while(rest != 0) {
			
			if(entier % 2 == 0) {
			
				arrMoney[6] += (int)entier / 2;
				rest = 0;
				
			} else {

				arrMoney[6] += ((int)(entier - 1) / 2);
				arrMoney[5] += 1;
				rest = 0;
			}
		}
		
		rest = fraction;
		
		while(rest != 0) {
				
			if(rest >= 50) {
				
				arrMoney[4] += 1;
				rest -= 50;
				
			}
				
			if(rest >= 40) {
				
				arrMoney[3] += 2;
				rest -= 40;
				
			}
			
			if(rest >= 20 && rest < 40) {
				
				arrMoney[3] += 1;
				rest -= 20;
			}
			
			if(rest >= 10 && rest < 20) {
				
				arrMoney[2] += 1;
				rest -= 10;
			}
			
			if(rest >= 5 && rest < 10) {
				
				arrMoney[1] += 1;
				rest -= 5;
			}
			
			if(rest >= 1 && rest < 5) {
				
				arrMoney[0] += 1;
				rest -= 1;
			}
		}
	}
	
	
	/**
	 * removeMoney
	 * 
	 * remove money to your wallet
	 * 
	 * @param double (the money to remove)
	 */
	public static void removeMoney(double money) {
		
		total -= money;
		
		resetWallet();
		
		addMoneyToWallet(total);
	}
	
	/**
	 * flushWallet
	 * 
	 * Wallet become again empty
	 * 
	 */
	public static void flushWallet() {
		
		total = 0;
	}
}

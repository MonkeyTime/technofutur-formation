package be.technofutur.bankaccount;

public final class SavingAccount extends Account {

	private double percentage = 0;
	
	/**
	 * Constructor 
	 * 
	 * @param accountNumber
	 * 
	 */
	public SavingAccount(String accountNumber, String holderName, double percentage) {
		
		super(accountNumber, holderName);
		
		this.percentage = percentage;
	}
	
	/**
	 * withdraw
	 * 
	 * method to withdraw
	 * 
	 * @param money  The sum to remove from the amount
	 * 
	 */
	public void withdraw(double money) {
		
		if(money > 0) {
			
			if((this.sold -= money) >= 0) {
				
				this.sold -= money;
				
			} else {
				
				System.out.println("Insuficient sold.");
			}
			
		} else {
			
			System.out.println("THe withdraw can't be a negative sum.");
		}
	}
	
	/**
	 * calculateInterest
	 * 
	 * method to calculate interest and add it to the sold
	 * 
	 */
	public void calculateInterest() {
		
		this.sold *= (1 + (this.percentage / 100));
	}
}


package be.technofutur.bankaccount;

public final class ChekingAccount extends Account {

	private double overdraft = 0; 
	
	/**
	 * Constructor 
	 * 
	 * @param accountNumber
	 * 
	 */
	public ChekingAccount(String accountNumber, String holderName) {
		
		super(accountNumber, holderName);
	}

	/**
	 * Constructor
	 * 
	 * @param accountNumber
	 * @param overdraft
	 * 
	 */
	public ChekingAccount(String accountNumber, String holderName, double overdraft) {
		
		super(accountNumber, holderName);
		this.overdraft = (overdraft >= 0) ? (0 - overdraft) : overdraft;
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
			
			if(this.overdraft >= (this.sold -= money)) {
				
				this.sold -= money;
				
			} else {
				
				System.out.println("Insuficient sold.");
			}
			
		} else {
			
			System.out.println("THe withdraw can't be a negative sum.");
		}
	}
}

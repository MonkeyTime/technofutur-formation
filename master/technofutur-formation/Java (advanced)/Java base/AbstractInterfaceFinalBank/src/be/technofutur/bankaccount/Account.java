package be.technofutur.bankaccount;

public abstract class Account implements IBankAccount {
	
	protected String accountNumber, holderName;
	protected double sold;
	
	/**
	 * Constructor
	 * 
	 * Can't be instantiated directly (abstract class) but can be used by the constructor from child class
	 * 
	 * @param accountNumber
	 * 
	 */
	public Account(String accountNumber, String holderName) {
		
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.sold = 0;
	}
	
	/**
	 * deposit
	 * 
	 * method to deposit
	 * 
	 * @param money  The sum to add to the amount
	 * 
	 */
	public void deposit(double money) {
		
		if(money > 0) {
			
			this.sold += money;
			
		} else {
			
			System.out.println("The deposit can't be a negative sum.");
		}
	}
	
	/**
	 * getSold
	 * 
	 * @return sold		The current sold
	 * 
	 */
	public double getSold() {
		
		return this.sold;
	}
	
	public abstract void withdraw(double money);
}

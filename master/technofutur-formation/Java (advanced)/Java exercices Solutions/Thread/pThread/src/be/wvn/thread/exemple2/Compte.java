package be.wvn.thread.exemple2;

public class Compte {

	private double amount;
	
	public Compte(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void deposer(double amount) {
		this.amount +=amount;
	}
	
	public void retirer(double amount) {
		this.amount -=amount;
	}
}

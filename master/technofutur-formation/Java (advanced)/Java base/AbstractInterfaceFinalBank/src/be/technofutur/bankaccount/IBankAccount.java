package be.technofutur.bankaccount;

public interface IBankAccount {
	
	public void withdraw(double money);
	public void deposit(double money);
	public double getSold();
}

package be.wvn.thread.exemple2;

public class CompteThreadSafe extends Compte {

	public CompteThreadSafe(double amount) {
		super(amount);
		
	}
	
	@Override
	public synchronized void retirer(double amount) {
		super.retirer(amount);
	}
	
	@Override
	public synchronized void deposer(double amount) {
		super.deposer(amount);
	}
	
	@Override
	public synchronized void setAmount(double amount) {
		super.setAmount(amount);
	}

}

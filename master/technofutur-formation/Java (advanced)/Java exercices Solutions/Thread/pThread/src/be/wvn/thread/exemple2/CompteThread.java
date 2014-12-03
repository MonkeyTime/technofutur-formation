package be.wvn.thread.exemple2;

public class CompteThread extends Thread {

	private Compte c;
	private int id;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setC(Compte c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		if(this.c!=null) {
			if(this.id%2==0) {
				System.out.println("1/ Thread " + this.id + " : " + this.c.getAmount());
				this.c.deposer(100);
				System.out.println("2/ Thread " + this.id + " : " + this.c.getAmount());
			}
			else {
				System.out.println("1/ Thread " + this.id + " : " + this.c.getAmount());
				this.c.retirer(50);
				System.out.println("2/ Thread " + this.id + " : " + this.c.getAmount());
			}
			
		}
	}
}

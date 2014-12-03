package be.wvn.thread;

public class Main {

	public static void main(String[] args) {
		
		MyThread mt = new MyThread();
		
		mt.start();
		
		MyRunnable mr = new MyRunnable();
		Thread tr = new Thread(mr);
		
		tr.start();
		
	}

}

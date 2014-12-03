package be.wvn.thread.exemple3;

public class Queue {

	public static void main(String[] args) {
		Queue q = new Queue();
		new Producer(q);
		new Consumer(q);
	}
	
	private int n;
	private boolean valueset = false;
	
	public synchronized void put(int value) {
		while(valueset) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.n = value;
		valueset = true;
		System.out.println("Value set to " + value);
		notify();
	}
	
	public synchronized int get() {
		while(!valueset) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Got value : " + n);
		valueset = false;
		notify();
		return n;
	}
}

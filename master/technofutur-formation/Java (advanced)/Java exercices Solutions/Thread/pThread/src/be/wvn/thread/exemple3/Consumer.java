package be.wvn.thread.exemple3;

public class Consumer extends Thread {

	private Queue q;
	public Consumer(Queue q) {
		this.q=q;
		this.start();
	}
	
	@Override
	public void run() {
		while(true) {
			q.get();
		}
	}
	
}

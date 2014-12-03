package be.wvn.thread.exemple3;

public class Producer extends Thread {

	private Queue q;
	public Producer(Queue q) {
		this.q=q;
		this.start();
	}
	
	@Override
	public void run() {
		int i=0;
		while(true) {
			q.put(i++);
		}
	}
}

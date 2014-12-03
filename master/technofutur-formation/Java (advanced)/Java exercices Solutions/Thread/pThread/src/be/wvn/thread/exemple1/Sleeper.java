package be.wvn.thread.exemple1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sleeper extends Thread {

	@Override
	public void run() {
		try {
			Thread.sleep( (long) (Math.random()*1000) );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		List<Sleeper> sleepers = new ArrayList<Sleeper>();
		for(int i=0 ; i<=9 ; i++) {
			sleepers.add(new Sleeper());
			sleepers.get(i).start();
		}
		System.out.println("Attente !");
		
		int i =0;
		for(Sleeper s : sleepers) {
			try {
				System.out.println("Attente " + i);
				s.join(1000);
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Finish!");
		
	}
}

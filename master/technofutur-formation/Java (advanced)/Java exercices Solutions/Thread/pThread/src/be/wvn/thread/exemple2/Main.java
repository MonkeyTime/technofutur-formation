package be.wvn.thread.exemple2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		int nbThread = 10000;
		
		double amount = 100;
		for(int i=0 ; i<nbThread ; i++) {
			if(i%2==0)
				amount+=100;
			else
				amount-=50;
		}
		System.out.println("Expected : " + amount);
		
		Compte compte = new Compte(100);

		List<CompteThread> liste = new ArrayList<CompteThread>();
		
		for(int i=0 ; i<nbThread ; i++) {
			CompteThread ct = new CompteThread();
			ct.setC(compte);
			ct.setId(i);
			ct.start();
			liste.add(ct);
		}
		
		for(int i=0 ; i<nbThread ; i++) {
			try {
				liste.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Expected : " + amount);
		System.out.println("Fin : " + compte.getAmount());
		
	}
	
}

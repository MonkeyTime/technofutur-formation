package packexercice01;

import packexceptions.ExceptionNbHabitantsNegatif;
import packexceptions.ExceptionNbHabitantsNul;

public class Main {

	public static void main(String[] args) {

		Ville v1 = new Ville("Default");
		System.out.println(v1);
		
		try {
			v1 = new Ville("Négatif", -50);
		} catch (ExceptionNbHabitantsNegatif e) {
			System.err.println(e.getMessage());
		} catch (ExceptionNbHabitantsNul e) {
			e.printStackTrace();
		}
		
		System.out.println(v1);
		
		try {
			v1 = new Ville("Nul", 0);
		} catch (ExceptionNbHabitantsNegatif e) {
			System.err.println(e.getMessage());
		} catch (ExceptionNbHabitantsNul e) {
			e.printStackTrace();
		}
		
		System.out.println(v1);
		
		try {
			v1 = new Ville("Gosselies", 1500);
		} catch (ExceptionNbHabitantsNegatif e) {
			System.err.println(e.getMessage());
		} catch (ExceptionNbHabitantsNul e) {
			e.printStackTrace();
		}
		
		System.out.println(v1);
	}

}

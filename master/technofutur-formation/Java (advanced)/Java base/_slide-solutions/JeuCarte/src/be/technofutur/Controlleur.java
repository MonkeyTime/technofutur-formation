package jeucarte;


public class Controlleur {

	public static void main(String[] args){
		Bataille b = new Bataille("Toto", "Titi");
		
		int nombreTours = 1;
		while (b.joueurVainqueur() == null){
			System.out.println("Tour " + nombreTours);
			b.jouerTour();	
			nombreTours++;
		}
		
		System.out.println(b.joueurVainqueur() + " a gagné la partie");		
		
	}
}

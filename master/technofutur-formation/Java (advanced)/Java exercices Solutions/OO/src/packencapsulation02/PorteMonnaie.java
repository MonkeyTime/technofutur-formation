package packencapsulation02;

public class PorteMonnaie {

//	private int nbC1;
//	private int nbC2;
//	private int nbC5;
//	private int nbC10;
//	private int nbC20;
//	private int nbC50;
//	private int nbE1;
//	private int nbE2;
	private int[] nbPieces;
	private static int[] VALEURS = {200,100,50,20,10,5,2,1};
	
	public PorteMonnaie (double montant) {
		nbPieces = new int[VALEURS.length];
		repartition((int) (montant * 100));
		
		
	}
	
	public void repartition (int somme) {
		for (int i = 0 ; i < nbPieces.length ; i++) {
			nbPieces[i] = somme / VALEURS[i];
			somme -= nbPieces[i] * VALEURS[i];
		}
	}
	
	public String toString() {
		String tmp = "Montant total : " + getMontant();
		for (int i = 0 ; i < nbPieces.length ; i++) {
			tmp += "\nNombre de pièces de " + VALEURS[i]/(double) 100 + "€ : " + nbPieces[i];
		}
		return tmp;
	}
	
	public double getMontant() {
		double montant = 0;
		for (int i = 0 ; i < nbPieces.length ; i++) {
			montant += nbPieces[i] * VALEURS[i];
		}
		montant /= 100;
		return montant;
	}
	
	public void ajouterMontant (double somme) {
		int s = (int) ((somme + getMontant()) * 100);
		repartition(s);
	}
	
	public void retirerMontant (double somme) {
		if (getMontant() - somme >= 0) {
			int s = (int) ((getMontant() - somme) * 100);
			repartition(s);
		}
	}
	
	public void vider() {
		for (int i = 0 ; i < nbPieces.length ; i++) {
			nbPieces[i] = 0;
		}
	}
}

package jeucarte;

public class Bataille {
	private Joueur joueur1;
	private Joueur joueur2;
	
	public Bataille(String nomJoueur1, String nomJoueur2){
		this.joueur1 = new Joueur(nomJoueur1);
		this.joueur2 = new Joueur(nomJoueur2);
		
		Paquet paquetDepart = new Paquet();
		paquetDepart.remplirPaquet();
		
		while(!paquetDepart.estVide()){
			this.joueur1.getCartesNonJouees().ajouterCarte(paquetDepart.jouerCarte());
			this.joueur2.getCartesNonJouees().ajouterCarte(paquetDepart.jouerCarte());
		}
	}
	
	public void jouerTour(){
		Joueur joueurGagnant = null;
		Paquet paquetTourCartesjouees = new Paquet();
		while (joueurGagnant == null){
			Carte carteJoueur1 = joueur1.jouerCarte();
			Carte carteJoueur2 = joueur2.jouerCarte();
			
			//gestion bataille derniere carte
			if (carteJoueur1 != null && carteJoueur2 != null){
				paquetTourCartesjouees.ajouterCarte(carteJoueur1);
				paquetTourCartesjouees.ajouterCarte(carteJoueur2);
				
				System.out.println(joueur1 + " : " + carteJoueur1);
				System.out.println(joueur2 + " : " + carteJoueur2);
				
				switch (carteJoueur1.getRang().getValeur().compareTo(carteJoueur2.getRang().getValeur())){
					case 0 : System.out.println("Bataille !!!"); break;
					case 1 : joueurGagnant = joueur1; break;
					case -1 : joueurGagnant = joueur2; break;
				}
			} else {
				System.out.println("Plus assez de cartes !!!");
				joueurGagnant = (carteJoueur1 == null) ? joueur2 : joueur1; 
			}
		}
		joueurGagnant.getCartesJouees().fusionerPaquet(paquetTourCartesjouees);
		
		System.out.println(joueurGagnant + " à gagné le tour");
		System.out.println(joueur1 + " cartes restantes : " + joueur1.nombreCartesRestantes());
		System.out.println(joueur2 + " cartes restantes : " + joueur2.nombreCartesRestantes());
		System.out.println("==================================");
		
	}
	
	private boolean estPartieTerminer(){
		if (joueur1.nombreCartesRestantes() == 0 
				|| joueur2.nombreCartesRestantes() == 0)
			return true;
		else
			return false;
	}
	
	public Joueur joueurVainqueur(){
		if (!estPartieTerminer()){
			return null;
		}else{
			return (joueur1.nombreCartesRestantes() == 0) ? joueur2 : joueur1; 
		}
	}
}

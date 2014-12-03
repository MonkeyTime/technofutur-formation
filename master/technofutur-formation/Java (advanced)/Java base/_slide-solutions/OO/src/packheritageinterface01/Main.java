package packheritageinterface01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Compte[] tabCompte = new Compte[5];
		int nbComptes = 0;
		
		Scanner scan = new Scanner(System.in);
		int choix = 0;
		
		do {
			System.out.println("Quel type de compte voulez-vous gérer?");
			System.out.println("1: Afficher les comptes existants");
			System.out.println("2: Créer un compte");
			System.out.println("3: Déposer de l'argent");
			System.out.println("4: Retirer de l'argent");
			System.out.println("5: Calcul d'intérêt");
			System.out.println("0: Quitter");
			choix = scan.nextInt();
			
			switch (choix) {
				case 0:
					break;
					
				case 1:
					for (int i = 0 ; i < nbComptes ; i++) {
						System.out.println(tabCompte[i]);
						System.out.println();
					}
					System.out.println();
					break;
					
				case 2:
					System.out.println("1: Compte Epargne");
					System.out.println("2: Compte Courant");
					System.out.println("0: Annuler");
					int type = scan.nextInt();
					
					switch (type) {
						case 0:
							break;
						case 1:
						case 2:
							Compte c;
							System.out.println("Numéro?");
							String numero = scan.next();
							System.out.println("Titulaire?");
							String titulaire = scan.next();
							System.out.println("Solde?");
							double solde = scan.nextDouble();
							
							if (type == 1) {
								System.out.println("Taux d'intérêt?");
								double tauxInteret = scan.nextDouble();
								c = new CompteEpargne(numero, numero, solde, tauxInteret);
							} else {
								System.out.println("Découvert?");
								double decouvert = scan.nextDouble();
								c = new CompteCourant(numero, titulaire, solde, decouvert);
							}
							tabCompte[nbComptes] = c;
							nbComptes++;
							break;
							
						default:
							System.err.println("Choix incorrect!");
					}
					System.out.println();
					break;
					
				case 3:
				case 4:
				case 5:
					System.out.println("Numéro du compte?");
					int num = scan.nextInt();
					double somme;
					if (num >= nbComptes) {
						System.err.println("Compte inexistant!");
						break;
					} else {
						if (choix == 5) {
							if (tabCompte[num] instanceof CompteEpargne) {
								CompteEpargne ce = (CompteEpargne) tabCompte[num];
								System.out.println("Taux d'intérêt: " + ce.calculerInteret());
							} else {
								System.err.println("Ce n'est pas un compte épargne!");
							}
						} else {
							System.out.println("Somme?");
							somme = scan.nextDouble();
							
							if (choix == 3) {
								tabCompte[num].deposerArgent(somme);
							} else {
								tabCompte[num].retirerArgent(somme);
							}
						}
					}
					System.out.println();
					break;
				
				default:
					System.err.println("Choix incorrect!");
			}
			
		} while (choix != 0);
		
		scan.close();
	}

}

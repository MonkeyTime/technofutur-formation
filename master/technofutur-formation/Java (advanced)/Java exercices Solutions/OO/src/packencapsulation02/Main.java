package packencapsulation02;

public class Main {

	public static void main(String[] args) {

		PorteMonnaie pM1 = new PorteMonnaie(0);
		
		pM1.ajouterMontant(3.88);
		System.out.println(pM1);
		System.out.println();
		
		pM1.ajouterMontant(1);
		System.out.println(pM1);
		System.out.println();
		
		pM1.retirerMontant(1.88);
		System.out.println(pM1);
		System.out.println();
		
		pM1.vider();
		System.out.println(pM1);
		System.out.println();
	}

}

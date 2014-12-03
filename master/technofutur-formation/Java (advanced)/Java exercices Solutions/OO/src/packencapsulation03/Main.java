package packencapsulation03;

public class Main {

	public static void main(String[] args) {

		Produit p1 = new Produit("BE012345", "Ordinateur", 539.99, 16);
		Produit p2 = new Produit("BE012347", "Transat Coca-Cola", 9.99, 4, 0.16);
		
		System.out.println(p1);
		System.out.println();
		
		p1.augmenterStock(50);
		System.out.println(p1);
		System.out.println();
		
		p1.diminuerStock(10);
		System.out.println(p1);
		System.out.println();
		
		p1.diminuerStock(100000000);
		System.out.println(p1);
		System.out.println();
		
		System.out.println("Prix de 5 ordinateurs : " + ((p1.getFacture(5) == 0) ? "Pas assez en stock" : p1.getFacture(5)));
		System.out.println("Prix de 5 transats : " + ((p2.getFacture(5) == 0) ? "Pas assez en stock" : p2.getFacture(5)));
	}

}

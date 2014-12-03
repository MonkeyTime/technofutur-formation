package packencapsulation01;

public class Main {

	public static void main(String[] args) {
		Point p1 = new Point(3,0);
		Point p2 = new Point();
		Point p3 = p2.clone();
		
		System.out.println("Nombre de points: " + Point.getNbPoints());
		
		System.out.println("\n\"p2 == p3\" : " + (p2 == p3));
		
		System.out.println("\n\"p2.equals(p3)\" : " + p2.equals(p3));
		
		System.out.println("\nEtat de p1 : \n" + p1);
		System.out.println("\nAbscisse de p2 : " + p2.getX());
		System.out.println("Ordonnée de p2 : " + p2.getY());
		System.out.println("\nDistance entre p1 et p2: " + p1.calculerDistance(p2));
		System.out.println("\nDistance entre p2 et p3: " + p2.calculerDistance(p3));
		
		p2.translation(-4,-3);
		System.out.println("\nAbscisse de p2 après translation : " + p2.getX());
		System.out.println("Ordonnée de p2 après translation : " + p2.getY());
		
		p1.symOrthogonaleX();
		System.out.println("\nEtat de p1 après symétrie orthogonale (axe des X) :\n" + p1);
		p1.symOrthogonaleY();
		System.out.println("\nEtat de p1 après symétrie orthogonale (axe des Y) :\n" + p1);
		
		p1.symCentrale();
		System.out.println("\nEtat de p1 après symétrie centrale :\n" + p1);
	}

}

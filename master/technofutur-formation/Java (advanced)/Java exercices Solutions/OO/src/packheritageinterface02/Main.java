package packheritageinterface02;

public class Main {

	public static void main(String[] args) {

		Cercle c1 = new Cercle(2, 2, 3);
		Cercle c2 = new Cercle(5);
		
		c2.translation(2,2);
		c2.setRayon(3);
		
		System.out.println(c1.equals(c2));
	}

}

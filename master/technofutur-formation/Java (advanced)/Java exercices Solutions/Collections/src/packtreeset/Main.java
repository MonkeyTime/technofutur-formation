package packtreeset;

public class Main {

	public static void main(String[] args) {

		Course c = new Course("Tour de France");
		Cycliste c1 = new Cycliste(2, "Valverde");
		Cycliste c2 = new Cycliste(3, "Rodriguez");
		Cycliste c3 = new Cycliste(5, "Monfort");
		Cycliste c4 = new Cycliste(4, "Evans");
		Cycliste c5 = new Cycliste(1, "Gilbert");
		Cycliste c6 = new Cycliste(4, "Nibali");
		
		try {
			c.ajouterCycliste(c1);
		} catch (DoublonException e) {
			System.err.println(e.getMessage());
		}
		try {
			c.ajouterCycliste(c2);
		} catch (DoublonException e) {
			System.err.println(e.getMessage());
		}
		try {
			c.ajouterCycliste(c3);
		} catch (DoublonException e) {
			System.err.println(e.getMessage());
		}
		try {
			c.ajouterCycliste(c4);
		} catch (DoublonException e) {
			System.err.println(e.getMessage());
		}
		try {
			c.ajouterCycliste(c5);
		} catch (DoublonException e) {
			System.err.println(e.getMessage());
		}
		try {
			c.ajouterCycliste(c6);
		} catch (DoublonException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("Après les ajouts: \n" + c.toString());
		System.out.println("Le premier: " + c.premier());
		System.out.println("Le dernier: " + c.dernier());
		c.remplacer(4, "Boonen");
		System.out.println("Après le remplacement: " + c.toString());
		c.suppression(new Cycliste(1, "Gilbert"));
		System.out.println("Après la suppression: " + c.toString());
	}

}

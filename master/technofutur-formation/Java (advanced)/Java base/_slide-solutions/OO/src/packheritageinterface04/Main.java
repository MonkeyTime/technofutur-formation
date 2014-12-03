package packheritageinterface04;

import packassociations.Point;

public class Main {

	public static void main(String[] args) {

		Form tab[] = new Form[3];
		tab[0] = new Carre(5);
		tab[1] = new Cercle(7);
		tab[2] = new Triangle(new Point(), new Point(1,1), new Point(2,2));
		
		for (int i = 0 ; i < tab.length ; i++) {
			System.out.println(tab[i]);
			System.out.println("Perimètre: " + tab[i].perimetre());
			System.out.println("Aire: " + tab[i].aire());
			System.out.println();
		}
	}

}

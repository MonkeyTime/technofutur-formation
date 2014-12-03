package packassociations;

public class Main {

	public static void main(String[] args) {

		Segment s1 = new Segment(1,2,5,2);
		System.out.println(s1);
		
		System.out.println();
		
		System.out.println("Longueur du segment : " + s1.calculLongueur());
		
		System.out.println();
		
		Segment s2 = s1.symetrieCentrale();
		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println();
		s1.deplaceOrigine(2,-1);
		s1.deplaceExtremite(2,-1);
		System.out.println(s1);
		
		System.out.println();
		System.out.println();
		
		Point a = new Point(1,1);
		Point b = new Point(1,4);
		Point c = new Point(4,1);
		Triangle t1 = new Triangle(a,b,c);
		System.out.println(t1);
		
		System.out.println();
		
		Segment []seg = t1.cotes();
		for (int i = 0 ; i < seg.length ; i++) {
			System.out.println(seg[i]);
		}
		
		System.out.println();

		System.out.println("Périmètre : " + t1.calculPerimetre());
		System.out.println("Aire : " + t1.calculAire());
		System.out.println("Rectangle ? : " + t1.estRectangle());
		
		System.out.println();
		
		Triangle t2 = t1.symetrieCentrale();
		System.out.println(t1);
		System.out.println(t2);
			
	}

}

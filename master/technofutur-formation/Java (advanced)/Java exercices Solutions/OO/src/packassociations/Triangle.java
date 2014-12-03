package packassociations;

public class Triangle {

	private Point a;
	private Point b;
	private Point c;
	
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public String toString() {
		return "Etat du triangle : " + "\nA:" + a + "\nB:" + b + "\nC:" + c;
	}
	
	public Segment[] cotes() {
		Segment[] cotes = new Segment[3];
		cotes[0] = new Segment(a, b);
		cotes[1] = new Segment(b, c);
		cotes[2] = new Segment(c, a);
		return cotes;
	}
	
	public double calculPerimetre() {
		return a.calculerDistance(b) + b.calculerDistance(c) + c.calculerDistance(a);
	}
	
	public double calculAire() {
		double demiPerimetre = calculPerimetre() / 2;
		double tmp = Math.sqrt(demiPerimetre * (demiPerimetre - a.calculerDistance(b)) * (demiPerimetre - b.calculerDistance(c)) * (demiPerimetre - c.calculerDistance(a)));
		tmp *= 100;
		tmp = Math.round(tmp);
		tmp /= 100;
		
		return tmp;
	}
	
	public boolean estRectangle() {
		double a2 = Math.pow(a.calculerDistance(b), 2);
		double b2 = Math.pow(b.calculerDistance(c), 2);
		double c2 = Math.pow(c.calculerDistance(a), 2);
		
//		boolean estCarre = false;
		if (a2 == b2 + c2) {
//			estCarre = true;
			return true;
		} else if (b2 == a2 + c2) {
//			estCarre = true;
			return true;
		} else if (c2 == a2 + b2) {
//			estCarre = true;
			return true;
		}
//		return estCarre;
		return false;
	}
	
	public Triangle symetrieCentrale() {
		Point d = a.clone();
		Point e = b.clone();
		Point f = c.clone();
		d.symCentrale();
		e.symCentrale();
		f.symCentrale();
		return new Triangle(d, e, f);
	}
}

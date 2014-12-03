package packheritageinterface04;

import packencapsulation01.Point;

public class Cercle extends Point implements Form {

	private double r;
	
	public Cercle(double x, double y, double r) {
		super(x, y);
		setRayon(r);
	}
	
	public Cercle(double r) {
//		super();
		setRayon(r);
	}
	
	public double perimetre() {
		return 2 * PI * r;
	}

	public double aire() {
		return PI * r * r;
	}
	
	public void setRayon(double rayon) {
		if (rayon > 0) {
			r = rayon;
		} else {
			r = 1;
		}
	}
	
	public Point getCentre() {
		return new Point(getX(), getY());
	}
	
	public String toString() {
		return "Centre: " + super.toString() + "\nRayon: " + r;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Cercle) {
			Cercle c = (Cercle) o;
//			return getX() == c.getX() && getY() == c.getY() && r == c.r;
			return super.equals(o) && r == c.r;
		}
		return false;
	}
	
	public Cercle clone() {
		return new Cercle(getX(), getY(), r);
	}
	
//	public void deplacerCentre(double dx, double dy) {
//		translation(dx, dy);
//	}
	
	
}

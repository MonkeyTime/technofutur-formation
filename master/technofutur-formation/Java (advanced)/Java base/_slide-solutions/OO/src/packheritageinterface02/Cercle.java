package packheritageinterface02;

import packencapsulation01.Point;

public class Cercle extends Point {

	private double r;
	
	public Cercle(double x, double y, double r) {
		super(x, y);
		setRayon(r);
	}
	
	public Cercle(double r) {
//		super();
		setRayon(r);
	}
	
	public void setRayon(double rayon) {
		if (rayon > 0) {
			r = rayon;
		} else {
			r = 1;
		}
	}
	
	public Point getCentre() {
		return super.clone();
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
	
	public void deplacerCentre(double dx, double dy) {
		super.translation(dx, dy);
	}
}

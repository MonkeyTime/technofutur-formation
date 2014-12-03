package packassociations;

public class Segment {

	private Point or;
	private Point ext;
	
	public Segment(Point or, Point ext) {
		this.or = or;
		this.ext = ext;
	}
	
	public Segment(double xOr, double yOr, double xExt, double yExt) {
		this.or = new Point(xOr, yOr);
		this.ext = new Point(xExt, yExt);
	}
	
	public String toString() {
		return "Etat du segment:" + "\nOr: " + or + "\nExt: " + ext;
	}
	
	public double calculLongueur() {
//		return or.calculerDistance(ext);
		return Point.calculerDistance(or, ext);
	}
	
	public void deplaceOrigine(double dx, double dy) {
//		or.setX(or.getX() + dx);
//		or.setY(or.getY() + dy);
		or.translation(dx, dy);
	}
	
	public void deplaceExtremite(double dx, double dy) {
//		ext.setX(ext.getX() + dx);
//		ext.setY(ext.getY() + dy);
		ext.translation(dx, dy);
	}
	
	public Segment symetrieCentrale() {
		// Copie des points pour éviter de modifier le segment original
		Point o = or.clone();
		Point e = ext.clone();
		o.symCentrale();
		e.symCentrale();
		return new Segment(o, e);
	}
}

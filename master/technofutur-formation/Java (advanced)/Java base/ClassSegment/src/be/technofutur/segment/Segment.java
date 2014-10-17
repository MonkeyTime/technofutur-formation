package be.technofutur.segment;

public class Segment {
	
	protected Point a, b;
	protected double aX, aY, bX, bY;
	protected double segment;
	protected Point obj;

	/**
	 * Constructor
	 * 
	 * @param a
	 * @param b
	 */
	public Segment(Point a, Point b) {

		this.a = a;
		this.b = b;
		
		this.obj = new Point();
	}
	
	/**
	 * Constructor 
	 * 
	 * @param aX
	 * @param aY
	 * @param bX
	 * @param bY
	 */
	public Segment(double ax, double ay, double bx, double by) {

		this.a = new Point(ax, ay);
		this.b = new Point(bx, by);
		
		this.obj = new Point();
	}
	
	/**
	 * Calculate length
	 * 
	 */
	public double calculateLength() {
		
		return this.obj.getDistanceXY(this.a, this.b);
		
	}
	
	/**
	 * moveOrigine
	 * 
	 * @param x
	 * @param y
	 */
	public void moveOrigine(double x, double y) {
		
		this.obj.translateXY(this.a.x += x, this.a.y += y);
	}
	
	/**
	 * moveExtremite
	 * 
	 * @param x
	 * @param y
	 */
	public void moveExtremite(double x, double y) {
		
		this.obj.translateXY(this.b.x += x, this.b.y += y);
	}
	
	/**
	 * centrySymetry
	 * 
	 * @return void
	 */
	public void centrySymmetry() {
		
		this.aX = -this.aX;
		this.bX = -this.bX;
		this.aY = -this.aY;
		this.bY = -this.bY;
	}
}

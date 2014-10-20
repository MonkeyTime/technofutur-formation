package be.technofutur.vector;

public final class Circle extends Point {

	protected double [] coord = new double[2];
	protected double radius = 0;
	protected Point center;
	
	/**
	 * Constructor
	 * 
	 * @param center
	 * @param radius
	 */
	public Circle(Point center, double radius) {
		
		super(center.x, center.y);
		this.radius = radius;
		this.center = center;	
	}

	/**
	 * Constructor
	 * 
	 * @param coordXY
	 * @param radius
	 * 
	 */
	public Circle( double [] coordXY, double radius) {
		
		this.x = coordXY[0];
		this.y = coordXY[1];
		
		this.radius = radius;
		this.center = new Point(this.x, this.x);
	}
	
	/**
	 * moveCenter
	 * 
	 * Translation of the center point of the circle
	 * 
	 * @param x
	 * @param y
	 * 
	 */
	public void moveCenter(double x, double y) {
		
		this.center.translateXY(x, y);
	}
	
	/**
	 * getCenter
	 * 
	 * @return Point	The center point of the circle
	 * 
	 */
	public Point getCenter() {
		
		return this.center;
	}

}

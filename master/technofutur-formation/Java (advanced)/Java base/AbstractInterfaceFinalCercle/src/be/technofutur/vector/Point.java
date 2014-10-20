package be.technofutur.vector;

public class Point {
	
	protected double x;
	protected double y;
	protected String str;
	protected static int count = 0;
	protected double distance = 0;
	
	/**
	 * constructor
	 * 
	 */
	public Point() {
		
		this.x = 0.0;
		this.y = 0.0;
		
		count++;
		
	}
	
	/**
	 * Constructor
	 * 
	 * @param x axe x
	 * @param y axe y
	 */
	public Point(double x, double y) {
		
		this.x = x;
		this.y = y;
		
		count++;
	}
	
	/**
	 * getX
	 * 
	 * @return double
	 */
	public double getX() {
		
		return this.x;
	}
	
	/**
	 * getY
	 * 
	 * @return double
	 */
	public double getY() {
		
		return this.y;
	}
	
	/**
	 * toString
	 * 
	 * @return 	String 	x and y position
	 */
	public String toString() {
		
		str = "x value: " + this.x + ", y value: " + this.y;
		
		return str;
	}
	
	/**
	 * translateXY
	 * 
	 * translation plan
	 * 
	 * @param double
	 * @param double
	 */
	public void translateXY(double x, double y) {
		
		this.x += x;
		this.y += y;
	}
	
	/**
	 * static total
	 * 
	 * @return total of point instances
	 */
	public static int total() {
		
		return count;
	}
	
	/**
	 * getDistanceFromXPoints
	 * 
	 * @param Point
	 * @param Point
	 * 
	 * @return double
	 */
	public double getDistanceFromXPoints(Point A, Point B) {
		
		return B.x - A.x;
	}
	
	/**
	 * getDistanceFromYPoints
	 * 
	 * @param Point
	 * @param Point
	 * 
	 * @return double
	 */
	public double getDistanceFromYPoints(Point A, Point B) {
		
		return A.y - B.y;
	}
	
	/**
	 * getDistanceXY
	 * 
	 * @param Point
	 * @param Point
	 * 
	 * @return double
	 */
	public double getDistanceXY(Point A, Point B) {

		distance = Math.pow(A.y - B.y, 2) + Math.pow(A.x - B.x, 2);
		
		return (distance * distance);
	}
	
	/**
	 * axiallySymmetry
	 * 
	 * @param p1
	 * @param p2
	 * 
	 * @return double
	 */
	public double axiallySymmetry(Point p1, Point p2) {
		
		return (this.getDistanceXY(p1, p2) / 2);
	}
	
	/**
	 * clone
	 * 
	 * clone the current Point
	 * 
	 */
	public Point clone() {
		
		return new Point(this.x, this.y);
	}
}

